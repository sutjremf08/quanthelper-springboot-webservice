package com.quant.helper.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class FScoreData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 45)
    private String roa;

    @Column(length = 45)
    private String cfo;

    @Column(length = 45)
    private String accurual;

    @Column(length = 45)
    private String lev;

    @Column(length = 45)
    private String liq;

    @Column(length = 45)
    private String fscore;

    @Column(length = 45)
    private String margin;

    @Column(length = 45)
    private String turn;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String sector;

    @Column(length = 45)
    private String price;

    @Column(length = 45)
    private String pbr;

    @Column(length = 45)
    private String pcr;

    @Column(length = 45)
    private String psr;

    @Column(length = 45)
    private String per;

    @Column(columnDefinition = "TEXT")
    private String description;

    //빌더
    @Builder
    public FScoreData(String code, String roa, String cfo, String accurual, String lev, String liq, String fscore, String margin, String turn, String name,
                      String sector,String price, String pbr, String pcr, String psr, String per,String description){
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
        this.sector= sector;
        this.price = price;
        this.pbr = pbr;
        this.pcr = pcr;
        this.per = per;
        this.psr = psr;
        this.description = description;
    }
    //업데이트


}
