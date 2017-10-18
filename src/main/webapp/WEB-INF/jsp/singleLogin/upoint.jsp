<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="digital">
    <form id="formid" method="POST" action="https://rafi.upoint.co.id/login">
        <input type="text" name="username" size="40" style="width: 295px;" value="cfuds">
        <input type="password" name="password" size="40" style="width: 295px;" value="cfuds">
        <input type="submit" value="Sign In">
    </form>
</div>
<script>
    $(function(){
        document.getElementById("formid").submit();
    }());
</script>
</body>
</html>
