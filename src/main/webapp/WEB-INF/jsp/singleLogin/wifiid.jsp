<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/digital.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="digital">
    <form id="formid" method="POST" action="https://app.brandfibres.com/dashboards/591965d788c9ffdd1fd3a6a3">
        <input type="text" name="_username" size="40" style="width: 295px;" value="dashboardioc@gmail.com">
        <input type="password" name="_password" size="40" style="width: 295px;" value="Telkom3s">
        <input type="submit" value="Login">
    </form>
</div>
<script>
    $(function(){
        document.getElementById("formid").submit();
    }());
</script>
</body>
</html>
