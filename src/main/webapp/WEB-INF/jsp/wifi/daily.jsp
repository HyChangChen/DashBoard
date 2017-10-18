<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<meta http-equiv="refresh" content="300">
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
	<style>
		.daily-layout{
			width: 100%;
			height: 100%;
			background: #03071D;
		}
	</style>
</head>
<body>
	<div class="daily-layout">
		<div id="echart1" style="height: 80%;width: 100%;"></div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/daily.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>