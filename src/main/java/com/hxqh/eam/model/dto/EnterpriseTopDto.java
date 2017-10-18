package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEnterpriseTicket;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/11.
 */

public class EnterpriseTopDto {

    private List<VEnterpriseTicket> rightnowList;
    private List<VEnterpriseTicket> proactiveList;

    private List<String> nameList;

    private Map<String, List<Integer>> rightnowTicketM;

    private Map<String, List<Integer>> proactiveTicketM;

    private EnterpriseThreeColor threeColor;

    private String name;

    private List<EnterpriseIconDto> iconList;

    private List<EnterpriseEventDto> eventList;

    private Map<String, List<Double>> enterpriseRegionMap;

    private List<String> regionNameList;

    private Map<String, List<Double>> enterpriseProductMap;


    private List<String> productNameList;

    public EnterpriseTopDto() {
    }

    public EnterpriseTopDto(List<VEnterpriseTicket> rightnowList, List<VEnterpriseTicket> proactiveList, List<String> nameList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, EnterpriseThreeColor threeColor, String name, List<EnterpriseIconDto> iconList, List<EnterpriseEventDto> eventList, Map<String, List<Double>> enterpriseRegionMap, List<String> regionNameList, Map<String, List<Double>> enterpriseProductMap, List<String> productNameList) {
        this.rightnowList = rightnowList;
        this.proactiveList = proactiveList;
        this.nameList = nameList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.threeColor = threeColor;
        this.name = name;
        this.iconList = iconList;
        this.eventList = eventList;
        this.enterpriseRegionMap = enterpriseRegionMap;
        this.regionNameList = regionNameList;
        this.enterpriseProductMap = enterpriseProductMap;
        this.productNameList = productNameList;
    }

    public List<String> getRegionNameList() {
        return regionNameList;
    }

    public void setRegionNameList(List<String> regionNameList) {
        this.regionNameList = regionNameList;
    }

    public List<String> getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(List<String> productNameList) {
        this.productNameList = productNameList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VEnterpriseTicket> getRightnowList() {
        return rightnowList;
    }

    public void setRightnowList(List<VEnterpriseTicket> rightnowList) {
        this.rightnowList = rightnowList;
    }

    public List<VEnterpriseTicket> getProactiveList() {
        return proactiveList;
    }

    public void setProactiveList(List<VEnterpriseTicket> proactiveList) {
        this.proactiveList = proactiveList;
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

    public EnterpriseThreeColor getThreeColor() {
        return threeColor;
    }

    public void setThreeColor(EnterpriseThreeColor threeColor) {
        this.threeColor = threeColor;
    }

    public List<EnterpriseIconDto> getIconList() {
        return iconList;
    }

    public void setIconList(List<EnterpriseIconDto> iconList) {
        this.iconList = iconList;
    }

    public List<EnterpriseEventDto> getEventList() {
        return eventList;
    }

    public void setEventList(List<EnterpriseEventDto> eventList) {
        this.eventList = eventList;
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

    public Map<String, List<Double>> getEnterpriseProductMap() {
        return enterpriseProductMap;
    }

    public void setEnterpriseProductMap(Map<String, List<Double>> enterpriseProductMap) {
        this.enterpriseProductMap = enterpriseProductMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnterpriseTopDto{");
        sb.append("rightnowList=").append(rightnowList);
        sb.append(", proactiveList=").append(proactiveList);
        sb.append(", nameList=").append(nameList);
        sb.append(", rightnowTicketM=").append(rightnowTicketM);
        sb.append(", proactiveTicketM=").append(proactiveTicketM);
        sb.append(", threeColor=").append(threeColor);
        sb.append(", name='").append(name).append('\'');
        sb.append(", iconList=").append(iconList);
        sb.append(", eventList=").append(eventList);
        sb.append(", enterpriseRegionMap=").append(enterpriseRegionMap);
        sb.append(", regionNameList=").append(regionNameList);
        sb.append(", enterpriseProductMap=").append(enterpriseProductMap);
        sb.append(", productNameList=").append(productNameList);
        sb.append('}');
        return sb.toString();
    }
}
