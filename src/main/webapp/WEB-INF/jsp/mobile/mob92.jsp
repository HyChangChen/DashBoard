<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
	<style>
		#mob91{
			width: 100%;
			min-height: 100%;
			background: #03071D;
		}
		#mob91 h3{
			font-size: 26px;
			font-weight: bolder;
			color: #fff;
			margin: 0px;
			padding-top: 60px;
			padding-left: 30px;
		}
		p{
			color: #fff;
			font-size: 20px;
			text-align: right;
			padding-right: 30px;
		}
	</style>
</head>
<body>
	<div id="mob91">
		<h3>Quality CNOP</h3>
		<div id="echart1" style="width: 100%;height: 80%;padding-top:80px;padding-left: 30px;padding-right: 30px;"></div>
		<p>BAD >= 5ms > GOOD</p>
	</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/mobile/mob92.js"></script>
</html>