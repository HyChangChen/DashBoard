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
    <script type="text/javascript" src="${ctx}/js/authority/user.js"></script>
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
            <td width="7%">Login Name</td>
            <td width="7%">Role</td>
            <td width="7%">Operation</td>
        </tr>
        </thead>
        <tbody>
            <tr v-for="item in userList">
                <td>{{item.name}}</td>
                <td>{{item.rolename}}</td>
                <td>
                    <button class="btn" @click="edit(item)">edit</button>
                    <button class="btn" @click="del(item)">del</button>
                    <button class="btn" v-show="!!!item.userstatus" @click="reset(item)">reset</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="mask"></div>
    <div class="box" style="background: #fff;height: 500px;margin-top: -280px;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <div class="user-info">
            <p class="item">
                <lable>LoginName</lable>
                <input type="text" id="loginName" v-model="userName">
            </p>
            <p class="item">
                <lable>E-mail:</lable>
                <input type="text"  id="email" v-model="email">
            </p>
            <p class="item">
                <lable>Role</lable>
                <select v-model="selected">
                    <option v-bind:value="item.roleid" v-for="item in roleList">{{item.rolename}}</option>
                </select>
            </p>
            <p class="item">
                <lable>StuffId:</lable>
                <input type="text"  id="userNum" v-model="userNum">
            </p>
            <p class="item">
                <lable>Department:</lable>
                <input type="text"  id="department"v-model="department">
            </p>
            <p class="item">
                <lable>Contact:</lable>
                <input type="text"  id="mobile"v-model="mobile">
            </p>
            <p class="btn">
                <button @click="save">Save</button>
                <button @click="close">Cancle</button>
            </p>
        </div>
    </div>
</div>

</body>
</html>
