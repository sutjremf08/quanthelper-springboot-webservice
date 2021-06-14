package com.quant.helper.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MagicData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 45)
    private String per;

    @Column(length = 45)
    private String pcr;

    @Column(length = 45)
    private String roa;

    @Column(length = 100)
    private String name;

    @Column(length = 45)
    private String rank;

    @Column(length = 100)
    private String sector;

    @Column(length = 45)
    private String price;

    @Column(length = 45)
    private String pbr;

    @Column(length = 45)
    private String psr;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Builder
    public MagicData(String code, String per, String pcr, String roa, String name, String rank, String sector,
                     String price, String pbr, String psr, String description){
        this.code = code;
        this.roa = roa;
        this.per = per;
        this.pcr = pcr;
        this.roa = roa;
        this.name = name;
        this.rank = rank;
        this.sector = sector;
        this.price = price;
        this.pbr = pbr;
        this.psr = psr;
        this.description = description;
    }
}
