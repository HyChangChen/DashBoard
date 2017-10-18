<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ent.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bussiness.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/ent/entUtil.js"></script>
	<script>
		var _ctx = "${ctx}";
		var _type = "${type}";
	</script>
</head>
<body>
<div class="ent-layout" style="padding-bottom:120px;">
	<div class="ent-header">
		<h4 class="pageTit"></h4>
		<div class="span-layout">
			<span class="lable-span sla">SLA</span>
			<span class="lable-span red"></span>
			<span class="lable-span yellow"></span>
			<span class="lable-span green"></span>
		</div>
	</div>
	<div class="first-page">
		<div class="item">
			<div class="left" id="echart1"></div>
			<div class="right" id="echart2"></div>
		</div>
		<div class="item">
			<div class="left" id="echart3"></div>
			<div class="right" id="echart4"></div>
		</div>
	</div>
	<div class="sec-page">
         <div id="echart5"></div>
	</div>
	<div class="third-page">
		<div id="echart6"></div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ent/business.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>