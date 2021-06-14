package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.FScoreData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FScoreDataRequestDto {

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

/*    @Builder
    public FScoreDataRequestDto(String code, String roa, String cfo, String accurual, String lev, String liq, String fscore, String margin, String turn, String name){
        this.code = code;
        this.roa = roa;
        this.cfo = cfo;
        this.accurual = accurual;
        this.lev = lev;
        this.liq = liq;
        this.fscore = fscore;
        this.margin = margin;
        this.turn = turn;
        this.name = name;
    }*/

    public FScoreData toEntity(){
        return FScoreData.builder()
                .code(code)
                .roa(roa)
                .cfo(cfo)
                .accurual(accurual)
                .lev(lev)
                .liq(roa)
                .fscore(fscore)
                .margin(margin)
                .turn(turn)
                .name(name)
                .price(price)
                .sector(sector)
                .pbr(pbr)
                .pcr(pcr)
                .per(per)
                .psr(psr)
                .description(description)
                .build();
    }
}
