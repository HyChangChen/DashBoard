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
    <link rel="stylesheet" href="${ctx}/css/peformance/persevice.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="layout">
    <div class="box">
        <h4>Monthly SLA Report</h4>
        <div id="echart1"></div>
        <table class="perservice">
            <thead>
                <tr>
                    <td width="3%" class="no-bg"></td>
                    <td width="3%" class="no-bg"></td>
                    <td width="7%">Jan</td>
                    <td width="7%">Feb</td>
                    <td width="7%">Mar</td>
                    <td width="7%">Apr</td>
                    <td width="7%">May</td>
                    <td width="7%">Jun</td>
                    <td width="7%">Jul</td>
                    <td width="7%">Aug</td>
                    <td width="7%">Sept</td>
                    <td width="7%">Oct</td>
                    <td width="7%">Nov</td>
                    <td width="7%">Dec</td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/peformance/perService.js"></script>
</html>
