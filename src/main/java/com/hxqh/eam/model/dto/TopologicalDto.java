package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocMobileBackhaulTtc;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/19.
 */
public class TopologicalDto {

    private Map<String, List<TbIocMobileBackhaulTtc>> linkMap;

    private Map<String, List<TbIocMobileBackhaulTtc>> nodeMap;

    public TopologicalDto(Map<String, List<TbIocMobileBackhaulTtc>> linkMap, Map<String, List<TbIocMobileBackhaulTtc>> nodeMap) {
        this.linkMap = linkMap;
        this.nodeMap = nodeMap;
    }

    public Map<String, List<TbIocMobileBackhaulTtc>> getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(Map<String, List<TbIocMobileBackhaulTtc>> linkMap) {
        this.linkMap = linkMap;
    }

    public Map<String, List<TbIocMobileBackhaulTtc>> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, List<TbIocMobileBackhaulTtc>> nodeMap) {
        this.nodeMap = nodeMap;
    }
}
