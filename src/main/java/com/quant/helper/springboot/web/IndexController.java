package com.quant.helper.springboot.web;

import com.quant.helper.springboot.service.FScoreDataService;
import com.quant.helper.springboot.service.MagicDataService;
import com.quant.helper.springboot.service.ValueDataService;
import com.quant.helper.springboot.web.dto.FScoreDataResponseDto;
import com.quant.helper.springboot.web.dto.MagicDataResponseDto;
import com.quant.helper.springboot.web.dto.ValueDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final FScoreDataService fScoreDataService;
    private final ValueDataService valueDataService;
    private final MagicDataService magicDataService;

    @GetMapping("/")
    public String Index(Model model){

        model.addAttribute("fscore", fScoreDataService.findFScoreDesc());
        model.addAttribute("value", valueDataService.findValueAsc());
        model.addAttribute("magic", magicDataService.findMagicAsc());

        return "index";
    }

    @GetMapping("/api/posts/info")
    public String Info(){

        return "info";
    }

    @GetMapping("/api/posts/fscore/{id}/{code}")
    public String PostsFscore(@PathVariable Long id,@PathVariable String code, Model model){
        FScoreDataResponseDto fscoreDto = fScoreDataService.findById(id);
        System.out.println(code + " CODE  ");
        model.addAttribute("post",fscoreDto);
        return "company";
    }

    @GetMapping("/api/posts/value/{id}/{code}")
    public String PostsValue(@PathVariable Long id, @PathVariable String code,Model model){
        ValueDataResponseDto valueDto = valueDataService.findById(id);
        System.out.println(code + " CODE  ");
        model.addAttribute("post",valueDto);
        return "company";
    }

    @GetMapping("/api/posts/magic/{id}/{code}")
    public String PostMagic(@PathVariable Long id,@PathVariable String code, Model model){
        MagicDataResponseDto magicDto = magicDataService.findById(id);
        System.out.println(code + " CODE  ");
        model.addAttribute("post",magicDto);
        return "company";
    }
}
