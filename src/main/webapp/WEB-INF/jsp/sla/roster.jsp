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
    <link rel="stylesheet" href="${ctx}/css/peformance/roster.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="team-roster">
    <h3 class="ticket-time"></h3>
    <ul>
        <li>HSI</li>
        <li>TELEPHONY</li>
        <li>IMES</li>
        <li>DATIN</li>
        <li>SURVEILLANCE</li>
        <li>WIFI</li>
    </ul>
    <div class="table-layout">
        <table class="table1">
            <thead>
            <tr>
                <td>No</td>
                <td>ID</td>
                <td>NAME</td>
                <td>Group</td>
                <td>DUTY TIME</td>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table class="table2">
            <thead>
            <tr>
                <td>No</td>
                <td>ID</td>
                <td>NAME</td>
                <td>Group</td>
                <td>DUTY TIME</td>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table class="table3">
            <thead>
            <tr>
                <td>No</td>
                <td>ID</td>
                <td>NAME</td>
                <td>Group</td>
                <td>DUTY TIME</td>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/peformance/roster.js"></script>
</html>
