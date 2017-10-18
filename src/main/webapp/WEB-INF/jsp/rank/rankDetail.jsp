<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/1
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/rank/rankDetail.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/script/vue.js"></script>
    <script src="${ctx}/js/rank/rankDetail.js"></script>
    <script>
        var _ctx = "${ctx}";
        var custid = "${custid}";
    </script>
</head>
<body>
<div class="detail-layout" id="detail-data">
    <p class="item" style="position: relative;padding-left: 2%;">
        <label for="custid">Customer Num</label>
        <input type="text"  :value="custid" v-model="custid" name="custid">
        <div class="search-name"></div>
    </p>
    <p class="item">
        <label>Customer Name</label>
        <input type="text" :value="custname" readonly>
    </p>
    <p class="item">
        <label for="">Type</label>
        <input type="text" :value="custtype" readonly>
    </p>
    <p class="item" style="margin-bottom: 50px;padding-left: 2%;">
        <label for="">Rank</label>
        <input type="text" :value="custrank" readonly>
    </p>
    <p class="item">
        <label>Short Name</label>
        <input type="text" :value="shortName" v-model="shortName">
    </p>
    <p class="btn-item">
        <button class="update" @click='update'>update</button>
    </p>
    <div class="box" style="background: #fff;">
        <i class="close"></i>
        <h4>字典列表</h4>
        <table cellspacing="0">
            <thead>
                <tr>
                    <td width="3%"></td>
                    <td width="12%">CUSTNAME</td>
                    <td width="12%">CUSTTYPE</td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="text" id="custName">
                    </td>
                    <td>
                        <input type="text" id="type">
                    </td>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>
</body>
</html>
