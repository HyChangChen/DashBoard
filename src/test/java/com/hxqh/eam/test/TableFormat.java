package com.hxqh.eam.test;

import com.hxqh.eam.common.FileUtil;
import com.hxqh.eam.common.util.StaticUtils;
import org.junit.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ocean Lin on 2017/6/8.
 */
public class TableFormat {


    @Test
    public void testDate() {
//        String monthFormat = StaticUtils.getYearMonthFormat(new Date());
//        String monthddFormat = StaticUtils.getYearMonthDayFormat(new Date());
//        String yearMonthFormat = StaticUtils.getYearMonthFormat(new Date());
//        System.out.println(yearMonthFormat);


//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat ("MMM-dd-yyyy HH:mm:ss", Locale.UK);
//
//        String sDate = sdf.format(date);
//        System.out.println(sDate);

    }


    @Test
    public void test() {
        File file = new File("src/test/resources/0410.log");
        String s = FileUtil.txt2String(file);
        //System.out.println(s);
        String[] split = s.split("\r\n");
        for (int i = 1; i < split.length; i++) {
            String[] rows = split[i].split("导出了");
            String[] split1 = rows[0].split("表");
//            System.out.println(split1[1].trim());
            //System.out.println(rows[1]);
        }
    }


    @Test
    public void testDouble() {
        double number = 12;

//        System.out.println(number);                         //12.0
//        System.out.println(Double.toString(number));        //12.0

        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
//        System.out.println(decimalFormat.format(number));   //12
    }

    @Test
    public void testMbo() {
        File file = new File("src/test/resources/table.list");
        String s = FileUtil.txt2String(file);
//        System.out.println(s);
        String[] split = s.split("\r\n");
        for (int i = 1; i < split.length; i++) {
//            System.out.println(split[i]);
        }
    }


}
