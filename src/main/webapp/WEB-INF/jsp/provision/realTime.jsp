<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/pre/realTime.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<body>
<div class="pre1-layout">
	<div class="mytitle">
	<h4>Provisioning-Real Time Service Order Handling</h4>
	<span class="ticket-time"></span>
	</div>
	<div class="mycontent">
	<div class="item">
		<div class="left" id="echart1"></div>
		<div class="right">
			<h5>Today’s Status WO on FFM</h5>
			<div class="pie-layout">
				<div id="echart21"></div>
				<div id="echart22"></div>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="left" id="echart3"></div>
		<div class="right" id="echart4"></div>
	</div>
	<div class="clearfix"></div>
	</div>
</div>
</body>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/pre/pre1.js"></script>
</html>