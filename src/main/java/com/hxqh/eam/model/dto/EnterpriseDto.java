package com.hxqh.eam.model.dto;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/13.
 */
public class EnterpriseDto {

    private Map<String, EnterpriseTopDto> enterpriseMap;

    public EnterpriseDto(Map<String, EnterpriseTopDto> enterpriseMap) {
        this.enterpriseMap = enterpriseMap;
    }

    public Map<String, EnterpriseTopDto> getEnterpriseMap() {
        return enterpriseMap;
    }

    public void setEnterpriseMap(Map<String, EnterpriseTopDto> enterpriseMap) {
        this.enterpriseMap = enterpriseMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnterpriseDto{");
        sb.append("enterpriseMap=").append(enterpriseMap);
        sb.append('}');
        return sb.toString();
    }
}
