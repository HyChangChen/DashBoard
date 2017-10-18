package com.hxqh.eam.common;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class LetterUtil {

    //首字母大写
    public static String firstLetterToUpper(String str) {
        char[] array = str.toCharArray();
        array[0] -= 32;
        return String.valueOf(array);
    }

    //首字母小写
    public static String firstLetterToLowercase(String str) {
        char[] array = str.toCharArray();
        array[0] += 32;
        return String.valueOf(array);
    }

    //去掉首字母
    public static String firstLetterSubString(String str) {
        String string = str.substring(1, str.length());
        return string;
    }

    //去掉首字母并将首字母小写
    public static String firstLetterSubStringAndToLowercase(String str) {
        String string = str.substring(1, str.length());
        return firstLetterToLowercase(string);
    }
}
