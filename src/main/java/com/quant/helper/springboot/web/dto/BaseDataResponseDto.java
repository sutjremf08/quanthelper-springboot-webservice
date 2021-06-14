package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.BaseData;
import lombok.Getter;

@Getter
public class BaseDataResponseDto {

    private Long id;
    private String code;
    private String date;
    private String title;
    private String target;
    private String opinion;
    private String writer;
    private String source;
    private String link;

    public BaseDataResponseDto(BaseData entity){
        this.id = entity.getId();
        this.code = entity.getCode();
        this.date = entity.getDate();
        this.title = entity.getTitle();
        this.target = entity.getTitle();
        this.opinion = entity.getOpinion();
        this.writer = entity.getWriter();
        this.source = entity.getSource();
        this.link = entity.getLink();
    }
}
