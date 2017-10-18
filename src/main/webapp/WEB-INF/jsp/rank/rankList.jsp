<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/1
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/rank/rank.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/script/vue.js"></script>
    <script src="${ctx}/js/rank/rankList.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <table cellspacing="0">
        <thead>
        <tr>
            <td width="7%">Customer Num</td>
            <td width="7%">Rank</td>
            <td width="7%">Type</td>
            <td width="7%">Operation</td>
        </tr>
        </thead>
        <tbody>
            <tr class="select">
                <td><input type="text"></td>
                <td><input type="text"></td>
                <td><input type="text"></td>
            </tr>
            <tr v-for="item in customer">
                <td>{{item.custid}}</td>
                <td>{{item.custrank}}</td>
                <td>{{item.custtype}}</td>
                <td>
                    <a href="javascript:void(0);" @click="goto(item)"><i class="del-icon"></i></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
