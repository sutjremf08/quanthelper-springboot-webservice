package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.MagicData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagicDataRequestDto {

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

    public MagicData toEntity(){
        return MagicData.builder()
                .code(code)
                .per(per)
                .pcr(pcr)
                .roa(roa)
                .name(name)
                .rank(rank)
                .sector(sector)
                .price(price)
                .pbr(pbr)
                .psr(psr)
                .description(description)
                .build();
    }

}
