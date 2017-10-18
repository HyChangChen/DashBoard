package com.hxqh.eam.model.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/13.
 */
public class EntDto {

    private List<EnterprisePieDto> pieRightnowList;
    private List<EnterprisePieDto> pieProactiveList;

    private Map<String, List<Integer>> rightnowTicketM;
    private Map<String, List<Integer>> proactiveTicketM;

    private List<String> nameList;

    private Map<String, List<Double>> enterpriseRegionMap;

    private List<String> regionNameList;

    private Map<String, List<Double>> enterpriseProductMap;

    private List<String> productNameList;

    private EnterpriseThreeColor threeColor;

    public EntDto(List<EnterprisePieDto> pieRightnowList, List<EnterprisePieDto> pieProactiveList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, List<String> nameList, Map<String, List<Double>> enterpriseRegionMap, List<String> regionNameList, Map<String, List<Double>> enterpriseProductMap, List<String> productNameList, EnterpriseThreeColor threeColor) {
        this.pieRightnowList = pieRightnowList;
        this.pieProactiveList = pieProactiveList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.nameList = nameList;
        this.enterpriseRegionMap = enterpriseRegionMap;
        this.regionNameList = regionNameList;
        this.enterpriseProductMap = enterpriseProductMap;
        this.productNameList = productNameList;
        this.threeColor = threeColor;
    }


    public List<EnterprisePieDto> getPieRightnowList() {
        return pieRightnowList;
    }

    public void setPieRightnowList(List<EnterprisePieDto> pieRightnowList) {
        this.pieRightnowList = pieRightnowList;
    }

    public List<EnterprisePieDto> getPieProactiveList() {
        return pieProactiveList;
    }

    public void setPieProactiveList(List<EnterprisePieDto> pieProactiveList) {
        this.pieProactiveList = pieProactiveList;
    }

    public Map<String, List<Integer>> getRightnowTicketM() {
        return rightnowTicketM;
    }

    public void setRightnowTicketM(Map<String, List<Integer>> rightnowTicketM) {
        this.rightnowTicketM = rightnowTicketM;
    }

    public Map<String, List<Integer>> getProactiveTicketM() {
        return proactiveTicketM;
    }

    public void setProactiveTicketM(Map<String, List<Integer>> proactiveTicketM) {
        this.proactiveTicketM = proactiveTicketM;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public Map<String, List<Double>> getEnterpriseRegionMap() {
        return enterpriseRegionMap;
    }

    public void setEnterpriseRegionMap(Map<String, List<Double>> enterpriseRegionMap) {
        this.enterpriseRegionMap = enterpriseRegionMap;
    }

    public List<String> getRegionNameList() {
        return regionNameList;
    }

    public void setRegionNameList(List<String> regionNameList) {
        this.regionNameList = regionNameList;
    }

    public Map<String, List<Double>> getEnterpriseProductMap() {
        return enterpriseProductMap;
    }

    public void setEnterpriseProductMap(Map<String, List<Double>> enterpriseProductMap) {
        this.enterpriseProductMap = enterpriseProductMap;
    }

    public List<String> getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(List<String> productNameList) {
        this.productNameList = productNameList;
    }

    public EnterpriseThreeColor getThreeColor() {
        return threeColor;
    }

    public void setThreeColor(EnterpriseThreeColor threeColor) {
        this.threeColor = threeColor;
    }
}
