<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/throughput.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div id="throughput-layout">
	<div class="throughput-box">
		<h4 style="color: #fff;">Mobile-Throughput</h4>
		<ul class="nav">
			<li>JAKARTA</li>
			<li>SURABAYA</li>
			<li>MAKASAR</li>
			<li>PEKANBARU</li>
		</ul>
		<ul class="sec-nav">
			<li><span class="radius"></span></li>
			<li><span class="radius"></span></li>
			<li><span class="radius"></span></li>
			<li><span class="radius"></span></li>
		</ul>
		<div id="echart1"></div>
	</div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/mobile/throughput.js"></script>
</html>