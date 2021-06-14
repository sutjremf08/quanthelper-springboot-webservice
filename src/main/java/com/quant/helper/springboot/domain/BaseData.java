package com.quant.helper.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class BaseData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 10, nullable = false)
    private String date;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(length = 45)
    private String target;

    @Column(columnDefinition = "TEXT")
    private String opinion;

    @Column(length = 1000)
    private String writer;

    @Column(length = 1000)
    private String source;

    @Column(length = 4000)
    private String link;


    @Builder
    public BaseData(String code, String date, String title, String target, String opinion, String writer, String source, String link){
        this.code = code;
        this.date = date;
        this.title = title;
        this.target = target;
        this.opinion = opinion;
        this.writer = writer;
        this.source = source;
        this.link = link;
    }

}
