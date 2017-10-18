<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<iframe id="menuFrame" name="menuFrame" style="overflow:visible;"
		width="100%" height="100%"  src="http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=820dbfe0d4fb021e42d9" onresize="alert('You have changed the size of the window')"></iframe>
</body>
<script type="text/javascript" src="${ctx}/js/ent/urls.js"></script>
</html>