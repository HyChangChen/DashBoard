package com.hxqh.eam.common.util;

import net.sf.json.xml.XMLSerializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  JsonUtil.java                             §
 * §┇File Path: com.hxqh.eam.common.util.JsonUtil           §
 * §Descrption:    json工具类                                      §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
public class JsonUtil {
    private static XMLSerializer xmlserializer = new XMLSerializer();
    private static CharacterIterator it;
    private static char c;
    private static int col;

    /***
     * List 转为 JSON
     * @param list
     * @return
     */
    public static <T> String list2Json(List<T> list) {
        if (null != list && list.size() > 0) {
            JSONArray jsonArray = JSONArray.fromObject(list);
            return jsonArray.toString();
        }
        return "";
    }


    /***
     * JSON 转换为 List
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1},{...}]
     * @param objectClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> json2List(String jsonStr, Class<T> objectClass) {
        if (StringUtils.isNotBlank(jsonStr)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonStr);
            List<T> list = (List<T>) JSONArray.toCollection(jsonArray, objectClass);
            return list;
        }
        return null;
    }


    /***
     * Object 转为  JSON
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        if (null != object) {
            JSONArray jsonArray = JSONArray.fromObject(object);
            return jsonArray.toString();
        }
        return "";
    }

    /***
     *
     * JSON 转 Object
     *
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1}]
     * @param objectClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2Ojbect(String jsonStr, Class<T> objectClass) {
        if (null != jsonStr) {
            String leftStr = jsonStr.substring(0, 2);
            String rightStr = jsonStr.substring(jsonStr.length() - 2, jsonStr.length());
            if (leftStr.equals("[{")) {
                jsonStr = jsonStr.substring(1, jsonStr.length());
            }
            if (rightStr.equals("}]")) {
                jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
            }
            JSONObject jsonStu = JSONObject.fromObject(jsonStr);
            return (T) JSONObject.toBean(jsonStu, objectClass);
        }
        return null;
    }

    /***
     * JsonArray 转为 JSON
     * @param jsonArray
     * @return
     */
    public static String jsonArrayToJSONString(JSONArray jsonArray) {
        if (null != jsonArray) {
            return jsonArray.toString();
        }
        return "";
    }

    /***
     * JsonObject 转为  JSON
     * @param jsonObject
     * @return
     */
    public static String jsonObjectToJSONString(JSONObject jsonObject) {
        if (null != jsonObject) {
            return jsonObject.toString();
        }
        return "";
    }

    /***
     * 将Object转换为JsonObject
     * @param object
     * @return
     */
    public static JSONObject object2JsonObject(Object object) {
        if (null != object) {
            return JSONObject.fromObject(object);
        }
        return null;
    }


    /***
     * XML 转为 JSON
     * @param xmlString
     *             XML字符串  例如：
     * xml version='1.0' encoding='utf-8'?><cities><province name='北京'><item>东城区</item><item>西城区</item><item>崇文区</item><item>宣武区</item><item>朝阳区</item><item>丰台区</item><item>石景山区</item><item>海淀区</item><item>门头沟区</item><item>房山区</item><item>通州区</item><item>顺义区</item><item>昌平区</item><item>大兴区</item><item>怀柔区</item><item>平谷区</item><item>密云县</item><item>延庆县</item></province></cities>
     * @return
     *
     */
    public static String xml2json(String xmlString) {
        if (StringUtils.isNotBlank(xmlString)) {
            try {
                return xmlserializer.read(xmlString).toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /***
     * JSON 转为      XML
     * @param jsonStr
     *             XML字符串  例如：
     *                     [{'province':{'@name':'北京','item':['东城区','西城区','崇文区','宣武区','朝阳区','丰台区','石景山区','海淀区','门头沟区','房山区','通州区','顺义区','昌平区','大兴区','怀柔区','平谷区','密云县','延庆县']}}]
     *                  或者：
     *                  {'province':{'@name':'北京','item':['东城区','西城区','崇文区','宣武区','朝阳区','丰台区','石景山区','海淀区','门头沟区','房山区','通州区','顺义区','昌平区','大兴区','怀柔区','平谷区','密云县','延庆县']}}
     * @return
     *
     */
    public static String json2xml(String jsonStr) {
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                if (jsonStr.contains("[{") && jsonStr.contains("}]")) {
                    JSONArray jobj = JSONArray.fromObject(jsonStr);
                    return xmlserializer.write(jobj);
                }
                JSONObject jobj = JSONObject.fromObject(jsonStr);
                return xmlserializer.write(jobj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }


    /***
     * XML/JSON 互转
     *
     * @param sourceFilePath
     *                 要解析的文件路径
     * @param directFilePath
     *              生成文件存放的路径
     * @param flag
     *             true:JSON 转为 XML
     *             false:XML转为 JSON
     * @return
     */
    public static String xml2JsonOrjson2Xml(String sourceFilePath, String directFilePath, boolean flag) {
        if (StringUtils.isBlank(sourceFilePath) || StringUtils.isBlank(directFilePath)) {
            return null;
        }
        FileInputStream in = null;
        BufferedReader br = null;
        FileWriter fw = null;
        String rs = null;
        try {
            File jsonFile = new File(sourceFilePath);
            in = new FileInputStream(jsonFile);
            StringBuffer sbuf = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(in));
            String temp = null;

            while ((temp = br.readLine()) != null) {
                sbuf.append(temp);
            }
            if (flag) {
                rs = json2xml(sbuf.toString());
            } else {
                rs = xml2json(sbuf.toString());
            }
            File test = new File(directFilePath);
            if (!test.exists()) {
                test.createNewFile();
            }
            fw = new FileWriter(test);
            fw.write(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                br.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
