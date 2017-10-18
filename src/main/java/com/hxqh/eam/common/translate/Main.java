package com.hxqh.eam.common.translate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;


public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170424000045536";
    private static final String SECURITY_KEY = "ofbQGG9Go6qXUFXRMtQT";


    public String translate(String input, String langfrom, String languageRu, String languageEn) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

//        System.out.println(api.getTransResult(input, "zh", "en"));
//        System.out.println(api.getTransResult(input, "zh", "ru"));
        String strlang1;
        try {
            strlang1 = api.getTransResult(input, langfrom, languageRu);
            String strlang2 = api.getTransResult(input, langfrom, languageEn);
            return returnString(strlang1) + "/" + returnString(strlang2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "error";
    }


    private String returnString(String strlang2) {
        Gson gs = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, ArrayList<Object>> map = gs.fromJson(strlang2, Map.class);
        //System.out.println(map.get("trans_result"));
        String string = map.get("trans_result").toString();
        string = string.substring(2, string.length() - 2);
        //System.out.println(string);
        String[] split = string.split(",");
        String[] lang = split[1].split("=");

        return lang[1];
    }


    public static void main(String[] args) throws UnsupportedEncodingException {


    }


}
