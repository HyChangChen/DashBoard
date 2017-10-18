<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/20
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/css/pre/complaint.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="wifiId-layout">
    <h3>SLA - MTTR Monthly (Hours)</h3>
    <div class="left" id="echart1"></div>
    <div class="right">
        <div class="scoll-nav">
            <ul class="sec-nav">
                <li style="margin-left: 60px;"><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
            </ul>
            <ul class="first-nav">
                <li style="margin-left: 60px;">TREG1</li>
                <li>TREG2</li>
                <li>TREG3</li>
                <li>TREG4</li>
                <li>TREG5</li>
                <li>TREG6</li>
                <li>TREG7</li>
            </ul>
        </div>
        <div class="item" id="echart2"></div>
    </div>
    <div class="clearfix"></div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/peformance/perRegion.js"></script>
</html>
