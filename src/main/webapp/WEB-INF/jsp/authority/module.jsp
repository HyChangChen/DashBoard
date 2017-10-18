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
    <script type="text/javascript" src="${ctx}/js/authority/module.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <table cellspacing="0">
        <thead>
        <tr>
            <td width="7%">Name</td>
            <td width="7%">Description</td>
            <td width="7%">ModuleId</td>
            <td width="7%">sortNum</td>
            <td width="7%">Parent</td>
            <td width="7%">Operation</td>
        </tr>
        </thead>
        <tbody>
            <tr v-for="item in parentList">
                <td>{{item.modelname}}</td>
                <td>{{item.modeldesc}}</td>
                <td>{{item.modelid}}</td>
                <td>{{item.sortnum}}</td>
                <td>{{item.parentid}}</td>
                <td>
                    <button class="btn" @click="edit(item)">edit</button>
                </td>
            </tr>
            <tr v-for="item in sonList">
                <td>{{item.modelname}}</td>
                <td>{{item.modeldesc}}</td>
                <td>{{item.modelid}}</td>
                <td>{{item.sortnum}}</td>
                <td>{{item.parentid}}</td>
                <td>
                    <button class="btn" @click="edit(item)">edit</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="mask"></div>
    <div class="box" style="background: #fff;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <div class="user-info">
            <p class="item">
                <lable style="width: 70px;">Name</lable>
                <input type="text"  style="width: 190px;" v-model="modelname">
            </p>
            <p class="item">
                <lable style="width: 70px;">Description</lable>
                <input type="text" style="width: 190px;"  v-model="modeldesc">
            </p>
            <p class="item">
                <lable style="width: 70px;">parentId</lable>
                <input type="text" style="width: 190px;"  v-model="parentid">
            </p>
            <p class="item">
                <lable style="width: 70px;">sortNum</lable>
                <input type="text" style="width: 190px;"  v-model="parentid">
            </p>
            <p style="margin-top: 30px;">
                <button @click="save">Save</button>
                <button @click="close">Cancle</button>
            </p>
        </div>
    </div>
</div>
</body>
</html>
