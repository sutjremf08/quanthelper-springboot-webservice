package com.quant.helper.springboot.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quant.helper.springboot.service.BaseDataService;
import com.quant.helper.springboot.service.FScoreDataService;
import com.quant.helper.springboot.service.MagicDataService;
import com.quant.helper.springboot.service.ValueDataService;
import com.quant.helper.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


import javax.persistence.NamedStoredProcedureQueries;
import java.io.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final FScoreDataService FScoreDataService;
    private final MagicDataService magicDataService;
    private final ValueDataService valueDataService;
    private final BaseDataService baseDataService;

    @PostMapping("/api/vi/posts/graph/{value}/{code}")
    public String findGrowthByGraph(@PathVariable String code, @PathVariable String value) throws IOException, ParseException {

        System.out.println(code);
        //종목별 그래프 호출용
        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "graph-file/"+value+"/result_"+code+".json";

        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/graph/"+value;
        //String filePath = absolutePath +"/result_"+code+".json";


        FileInputStream ins = new FileInputStream(filePath);   // ex) "c:\\\\data.json"
        InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
        BufferedReader br = new BufferedReader(inr);
        String strJson = br.readLine();


        return strJson;
    }

    @PostMapping("/api/vi/posts/code/{value}/{code}")
    public String findNameByGraph(@PathVariable String code, @PathVariable String value) throws IOException, ParseException {

        System.out.println(code + " :: " + value);
        //연도별 그래프 호출용
        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "strategy_result_json/"+value+"_"+code+".json";

        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/growth";
       // String filePath = absolutePath + "/"+value+"_"+code+".json";


        FileInputStream ins = new FileInputStream(filePath);   // ex) "c:\\\\data.json"
        InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
        BufferedReader br = new BufferedReader(inr);
        String strJson = br.readLine();


        return strJson;
    }



    @GetMapping("/api/vi/posts/fscore/{id}")
    public FScoreDataResponseDto findFScoreById(@PathVariable Long id) {
        return FScoreDataService.findById(id);
    }

    @PostMapping("/api/vi/posts/fscore/{code}")
    public String findFScoreByGraph(@PathVariable String code) throws IOException, ParseException {

        //그래프 회사별로 호출용
        System.out.println(code);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();


        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "json-result-chart/fscore/"+datePath.getPath()+"/"+code+".json";
        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/fscore/";
       // String filePath = absolutePath + "/"+datePath.getPath()+"/"+code+".json";


        FileInputStream ins = new FileInputStream(filePath);   // ex) "c:\\\\data.json"
        InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
        BufferedReader br = new BufferedReader(inr);
        String strJson = br.readLine();


        return strJson;
    }

    @GetMapping("/api/vi/posts/fscore/list")
    public List<FScoreDataListResponseDto> findFScoreAll() {
        return FScoreDataService.findFScoreDesc();
    }


    @Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Seoul")
    public ResponseEntity<String> bulkFSCoreUpdate()
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectFScoreMapper = new ObjectMapper();
        objectFScoreMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "/json-file/fscore_"+datePath.getPath()+".json";
        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/growth/";
        //String filePath = absolutePath + "/fscore_2020.json";

        List<FScoreDataRequestDto> fScoreDataRequestList = objectFScoreMapper.readValue(new File(filePath),
                new TypeReference<List<FScoreDataRequestDto>>() {
                });


        FScoreDataService.bulkUpdate(fScoreDataRequestList);
        return ResponseEntity.ok("Update All Success");
    }

    @GetMapping("/api/vi/posts/magic/{id}")
    public MagicDataResponseDto findMagicById(@PathVariable Long id) {
        return magicDataService.findById(id);
    }

    @GetMapping("/api/vi/posts/magic/list")
    public List<MagicDataResponseDto> findMagicAll() {
        return magicDataService.findMagicAsc();
    }

    @PostMapping("/api/vi/posts/magic/{code}")
    public String findMagicByGraph(@PathVariable String code) throws IOException, ParseException {

        //그래프 회사별로 호출용
        System.out.println(code);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();
        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "json-result-chart/magic/"+datePath.getPath()+"/"+code+".json";
        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/magic";
        //String filePath = absolutePath + "/"+datePath.getPath()+"/"+code+".json";


        FileInputStream ins = new FileInputStream(filePath);   // ex) "c:\\\\data.json"
        InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
        BufferedReader br = new BufferedReader(inr);
        String strJson = br.readLine();


        return strJson;
    }


    @Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Seoul")
    public ResponseEntity<String> bulkMagicUpdate()
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMagicMapper = new ObjectMapper();
        objectMagicMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "/json-file/magic_"+datePath.getPath()+".json";
        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/growth";
        //String filePath = absolutePath + "/magic_2020.json";

        List<MagicDataRequestDto> magicDataRequestList = objectMagicMapper.readValue(new File(filePath),
                new TypeReference<List<MagicDataRequestDto>>() {
                });

        magicDataService.bulkUpdate(magicDataRequestList);
        return ResponseEntity.ok("Update All Success");
    }

    @GetMapping("/api/vi/posts/value/{id}")
    public ValueDataResponseDto findValueById(@PathVariable Long id) {
        return valueDataService.findById(id);
    }

    @GetMapping("/api/vi/posts/value/list")
    public List<ValueDataResponseDto> findValueAll() {
        return valueDataService.findValueAsc();
    }

    @PostMapping("/api/vi/posts/value/{code}")
    public String findValueByGraph(@PathVariable String code) throws IOException, ParseException {

        //그래프 회사별로 호출용
        System.out.println(code);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "json-result-chart/value/"+datePath.getPath()+"/"+code+".json";
       //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/value";
        //String filePath = absolutePath + "/"+datePath.getPath()+"/"+code+".json";


        FileInputStream ins = new FileInputStream(filePath);   // ex) "c:\\\\data.json"
        InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
        BufferedReader br = new BufferedReader(inr);
        String strJson = br.readLine();


        return strJson;
    }

    @Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Seoul")
    public ResponseEntity<String> bulkValueUpdate()
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectValueMapper = new ObjectMapper();
        objectValueMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        String absolutePath = "/home/ec2-user/";
        String filePath = absolutePath + "/json-file/value_"+datePath.getPath()+".json";
        //String absolutePath = "/Users/donghokim/Downloads/json-result-chart/growth";
        //String filePath = absolutePath + "/value_2020.json";

        List<ValueDataRequestDto> valueDataRequestList = objectValueMapper.readValue(new File(filePath),
                new TypeReference<List<ValueDataRequestDto>>() {
                });

        valueDataService.bulkUpdate(valueDataRequestList);
        return ResponseEntity.ok("Update All Success");
    }


    //@Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Seoul")
    public ResponseEntity<String> bulkGraphUpdate()
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectValueMapper = new ObjectMapper();
        objectValueMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        //String absolutePath = "/home/ec2-user/app/diq";
        //String filePath = absolutePath + "/data/" + datePath.getPath() + "/value.json";
        String absolutePath = "/Users/donghokim/Downloads";
        String filePath = absolutePath + "/value.json";

        List<ValueDataRequestDto> valueDataRequestList = objectValueMapper.readValue(new File(filePath),
                new TypeReference<List<ValueDataRequestDto>>() {
                });

        valueDataService.bulkUpdate(valueDataRequestList);
        return ResponseEntity.ok("Update All Success");
    }


   //@Scheduled(cron = "0 0/1 * * * ?", zone = "Asia/Seoul")
    public ResponseEntity<String> bulkBaseUpdate()
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectBaseMapper = new ObjectMapper();
        objectBaseMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        DatePath datePath = new DatePath();
        datePath.setQuarterPath();

        //String absolutePath = "/home/ec2-user/app/diq";
        //String filePath = absolutePath + "/data/" + datePath.getPath() + "/fscore.json";
        String absolutePath = "/Users/donghokim/Downloads";
        String filePath = absolutePath + "/report_all_english.json";

        List<BaseDataRequestDto> baseDataRequestList = objectBaseMapper.readValue(new File(filePath),
                new TypeReference<List<BaseDataRequestDto>>() {
                });

        baseDataService.bulkUpdate(baseDataRequestList);
        return ResponseEntity.ok("Update All Success");
    }


}
