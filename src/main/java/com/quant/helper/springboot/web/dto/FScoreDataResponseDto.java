package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.FScoreData;
import lombok.Getter;

@Getter
public class FScoreDataResponseDto {
    //f_score
    private Long id;
    private String code;
    private String roa;
    private String cfo;
    private String accurual;
    private String lev;
    private String liq;
    private String fscore;
    private String margin;
    private String turn;
    private String name;
    private String price;
    private String sector;
    private String pbr;
    private String pcr;
    private String psr;
    private String per;
    private String description;



    public FScoreDataResponseDto(FScoreData entity){
        this.id = entity.getId();
        this.code = entity.getCode();
        this.roa = entity.getRoa();
        this.cfo = entity.getCfo();
        this.accurual = entity.getAccurual();
        this.lev = entity.getLev();
        this.liq = entity.getLiq();
        this.fscore = entity.getFscore();
        this.margin = entity.getMargin();
        this.turn = entity.getTurn();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.sector = entity.getSector();
        this.pbr = entity.getPbr();
        this.pcr = entity.getPcr();
        this.psr = entity.getPsr();
        this.per = entity.getPer();
        this.description = entity.getDescription();
    }
}
