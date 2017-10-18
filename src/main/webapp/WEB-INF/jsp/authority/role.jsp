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
    <link rel="stylesheet" href="${ctx}/css/showBo.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/script/vue.js"></script>
    <script type="text/javascript" src="${ctx}/script/alertCss/showBo.js"></script>
    <script type="text/javascript" src="${ctx}/js/authority/role.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <div class="router">
        <span class="router-txt">My portal</span>
        <span class="btn" @click="add">+ add</span>
    </div>
    <table cellspacing="0">
        <thead>
            <tr>
                <td width="7%">Role Name</td>
                <td width="7%">Description</td>
                <td width="7%">Operation</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in roleList">
                <td>{{item.rolename}}</td>
                <td>{{item.roledesc}}</td>
                <td>
                    <button class="btn" @click="edit(item)">edit</button>
                    <button class="btn" @click="del(item)">del</button>
                    <button class="btn" @click="authorization(item)" style="width: 120px;">authorization</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="mask"></div>
    <div class="box" style="background: #fff;height: 260px;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <div class="user-info">
            <p class="item">
                <lable style="width: 70px;">Name</lable>
                <input type="text" style="width: 190px;" v-model="roleName">
            </p>
            <p class="item">
                <lable style="width: 70px;">Description</lable>
                <input type="text" style="width: 190px;"  v-model="roleDesc">
            </p>
            <p>
                <button @click="save">Save</button>
                <button @click="close">Cancle</button>
            </p>
        </div>
    </div>
    <div class="auth-box" style="background: #fff;height: 410px;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <label v-for="item in modelNoList"><input  type="checkbox" value="{{item.modelid}}" v-model="item.checked"/>{{item.modelname}} </label>
        <label v-for="item in modelHaveList"><input  type="checkbox" value="{{item.modelid}}" v-model="item.checked"/>{{item.modelname}} </label>
        <p style="width: 300px; margin: 0 auto; clear: both;">
            <button @click="saveModule">Save</button>
            <button @click="close">Cancle</button>
        </p>
    </div>
</div>
</body>
</html>
