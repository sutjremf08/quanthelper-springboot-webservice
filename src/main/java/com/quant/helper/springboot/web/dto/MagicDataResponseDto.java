package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.MagicData;
import lombok.Getter;

@Getter
public class MagicDataResponseDto {

    private Long id;
    private String code;
    private String per;
    private String pcr;
    private String roa;
    private String name;
    private String rank;
    private String sector;
    private String price;
    private String pbr;
    private String psr;
    private String description;

    public MagicDataResponseDto(MagicData entity){
        this.id = entity.getId();
        this.code = entity.getCode();
        this.per = entity.getPer();
        this.pcr = entity.getPcr();
        this.roa = entity.getRoa();
        this.name = entity.getName();
        this.rank = entity.getRank();
        this.sector = entity.getSector();
        this.price = entity.getPrice();
        this.pbr = entity.getPbr();
        this.psr = entity.getPsr();
        this.description = entity.getDescription();
    }
}
