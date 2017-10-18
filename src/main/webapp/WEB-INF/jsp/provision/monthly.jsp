<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/20
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/css/pre/monthly.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/pre/monthly.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="mtd-layout">
    <table class="monthly">
        <thead>
            <tr>
                <td colspan="3" style="text-align: left;padding-left: 80px;"> Provisioning-MtD MTTI monitoring per 7 regions (DATIN)</td>
                <td colspan="2"><span class="ticket-time"></span></td>
            </tr>
            <tr>
                <td>Sasaran Mutu</td>
                <td colspan="2">MTTI(5HK)</td>
                <td colspan="2">TTI Comply(90%)</td>
            </tr>
            <tr>
                <td>Target</td>
                <td >Realsasi</td>
                <td >Pencapaian</td>
                <td >Realisasi</td>
                <td >Pencapaian</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td width="20%">TREG-1</td>
                <td width="20%">111</td>
                <td width="20%">111</td>
                <td width="20%">111</td>
                <td width="20%">111</td>
            </tr>
            <tr>
                <td>TREG-1</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
