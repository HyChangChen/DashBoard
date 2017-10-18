<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/2
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
    <link rel="stylesheet" href="${ctx}/css/peformance/variousUnit.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="sla-layout">
    <div class="top-item">
        <div class="left">
            <p>
                <span>MTTR-GGN</span>
                <span class="t_standard"></span>
                <span class="t_closeYear"></span>
            </p>
            <div class="show-pic">
                <div class="radius" id="echart"></div>
                <p class="t_num">6411 tiket close</p>
            </div>
            <ul>
                <li class="class_name">DES</li>
                <span></span>
                <li>T:<span class="t_standard"></span>jam</li>
                <li class="tip-icon">R:<span class="r_mtt"></span>jam</li>
            </ul>
            <div class="clearfix"></div>
        </div>
        <div class="right" id="echart1"></div>
    </div>
    <div class="bottom-item" style="border-left: 1px solid #000;">
        <h6>Top 20</h6>
        <ul>
            <li>
                <span>Ach(100%)</span>
                <span class="ach-left"></span>
            </li>
            <li>
                <span>R(Jam)</span>
                <span class="r-left"></span>
            </li>
            <li>
                <span>Closed</span>
                <span id="echart2"></span>
            </li>
        </ul>
    </div>
    <div class="bottom-item">
        <h6>Top 200</h6>
        <ul>
            <li>
                <span>Ach(100%)</span>
                <span class="ach-center"></span>
            </li>
            <li>
                <span>R(Jam)</span>
                <span class="r-center"></span>
            </li>
            <li>
                <span>Closed</span>
                <span id="echart3"></span>
            </li>
        </ul>
    </div>
    <div class="bottom-item">
        <h6>Other Top</h6>
        <ul>
            <li>
                <span>Ach(100%)</span>
                <span class="ach-right"></span>
            </li>
            <li>
                <span>R(Jam)</span>
                <span class="r-right"></span>
            </li>
            <li>
                <span>Closed</span>
                <span id="echart4"></span>
            </li>
        </ul>
    </div>
    <div class="clearfix"></div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/peformance/variousUnit.js"></script>
</html>
