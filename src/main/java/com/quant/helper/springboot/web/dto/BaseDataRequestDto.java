package com.quant.helper.springboot.web.dto;

import com.quant.helper.springboot.domain.BaseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseDataRequestDto {

    private String code;
    private String date;
    private String title;
    private String target;
    private String opinion;
    private String writer;
    private String source;
    private String link;

    public BaseData toEntity(){
        return BaseData.builder()
                .code(code)
                .date(date)
                .title(title)
                .target(target)
                .opinion(opinion)
                .writer(writer)
                .source(source)
                .link(link)
                .build();
    }
}


