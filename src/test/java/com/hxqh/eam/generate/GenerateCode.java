package com.hxqh.eam.generate;

import com.hxqh.eam.common.FileUtil;
import com.hxqh.eam.common.LetterUtil;

import java.io.File;
import java.io.IOException;

/**
 * 生成字段类
 *
 * @author lh
 */
public class GenerateCode {


    public static void main(String[] args) throws IOException {

        findAllAndResource("", "");
    }


    /**
     * 生成res and findall
     */
    private static void findAllAndResource(String model, String view) {
        File res = new File("src/test/resources/resource.property");
        File find = new File("src/test/resources/findAll.property");
        File listDto = new File("src/test/resources/listDto.property");

        //功能列表
        File func = new File("src/test/resources/table.list");
        String s = FileUtil.txt2String(func);

        String[] functionAll = s.split("\r\n");

        int i = 0;
        for (String fun : functionAll) {
            if (i == 0) {
                i++;
                continue;
            }
            String firstLetterSubString = LetterUtil.firstLetterSubStringAndToLowercase(fun);

            outResource(model, res, fun, firstLetterSubString);
//           outFind(model, find, fun, firstLetterSubString);
//            outlistDto(model, listDto, fun, firstLetterSubString);
        }
    }


    private static void outlistDto(String model, File find, String fun, String firstLetterSubString) {
        StringBuilder l = new StringBuilder(1024);
        //Method
        String findAll = FileUtil.txt2String(find).
                replaceAll("_m_", firstLetterSubString).
                replaceAll("_M_", fun);

        l.append(findAll);

//        System.out.println(l.toString());
    }

    private static void outFind(String model, File find, String fun, String firstLetterSubString) {
        StringBuilder f = new StringBuilder(1024);
        //Method
        String findAll = FileUtil.txt2String(find).
                replaceAll("_m_", firstLetterSubString).
                replaceAll("_M_", fun);

        f.append(findAll);

//        System.out.println(f.toString());
    }

    private static String outResource(String model, File res, String fun, String firstLetterSubString) {
        StringBuilder r = new StringBuilder(1024);

        //Method
        String method = FileUtil.txt2String(res).
                replaceAll("_m_", firstLetterSubString).
                replaceAll("_M_", fun);

        r.append(method);
//        System.out.println(r.toString());
        return firstLetterSubString;
    }


}
