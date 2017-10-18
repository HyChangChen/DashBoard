<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="ent-layout">
    <form id="formid" method="POST" action="http://10.40.9.78/noc/monita/controller/login/login_script.php">
        <input type="text" name="username" value="admin">
        <input type="password" name="password"  value="telkom">
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
