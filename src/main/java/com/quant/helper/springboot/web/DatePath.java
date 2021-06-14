package com.quant.helper.springboot.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatePath {

    private String path;

    public void setDailyDatePath() {

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");

        path = sdf.format(cal.getTime());
    }

    public void setQuarterPath() {

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR)-1;
        int month = cal.get(Calendar.MONTH);

        String tmpMonth = null;

        if(month > 3 && month <= 12) tmpMonth = "03";
        else tmpMonth = "12";

        path = String.valueOf(year);
    }


}
