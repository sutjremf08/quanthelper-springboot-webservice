package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.ValueData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueDataRequestDto {

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

    public ValueData toEntity(){
        return ValueData.builder()
                .code(code)
                .pbr(pbr)
                .psr(psr)
                .pcr(pcr)
                .rank(rank)
                .name(name)
                .price(price)
                .sector(sector)
                .per(per)
                .description(description)
                .build();
    }
}
