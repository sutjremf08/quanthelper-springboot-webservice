package com.quant.helper.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ValueData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 45)
    private String pbr;

    @Column(length = 45)
    private String psr;

    @Column(length = 45)
    private String pcr;

    @Column(length = 45)
    private String rank;

    @Column(length = 45)
    private String name;

    @Column(length = 100)
    private String sector;

    @Column(length = 45)
    private String price;

    @Column(length = 45)
    private String per;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Builder
    public ValueData(String code, String pbr, String psr, String pcr, String rank, String name,String sector,String price,
                     String per, String description){
        this.code = code;
        this.pbr = pbr;
        this.psr = psr;
        this.pcr = pcr;
        this.name = name;
        this.rank = rank;
        this.sector = sector;
        this.price = price;
        this.per = per;
        this.description = description;
    }
}

