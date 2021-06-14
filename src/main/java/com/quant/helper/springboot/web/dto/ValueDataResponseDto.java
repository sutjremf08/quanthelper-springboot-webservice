package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.ValueData;

public class ValueDataResponseDto {

    private Long id;
    private String code;
    private String pbr;
    private String psr;
    private String pcr;
    private String rank;
    private String name;
    private String price;
    private String sector;
    private String per;
    private String description;

    public ValueDataResponseDto(ValueData entity){
        this.id = entity.getId();
        this.code = entity.getCode();
        this.pbr = entity.getPbr();
        this.psr = entity.getPsr();
        this.pcr = entity.getPcr();
        this.name = entity.getName();
        this.rank = entity.getRank();
        this.price = entity.getPrice();
        this.sector = entity.getSector();
        this.per = entity.getPer();
        this.description = entity.getDescription();
    }
}
