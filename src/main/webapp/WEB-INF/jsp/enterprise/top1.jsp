<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ent.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/top.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/ent/entUtil.js"></script>
	<script>
		var _ctx = "${ctx}";
		var _type = "${page}";
		var _show = "${show}";
	</script>
</head>
<body>
<div class="ent-layout" style="padding-bottom:100px;">
	<div class="ent-header">
		<h4>JAK INTER TRADE</h4>
		<div class="span-layout">
			<span class="lable-span sla">SLA</span>
			<span class="lable-span red"></span>
			<span class="lable-span yellow"></span>
			<span class="lable-span green"></span>
		</div>
	</div>
	<div class="top1">
         <div class="item1" id="echart1"></div>
         <div class="item2" id="echart2"></div>
         <div class="item2" id="echart3"></div>
		 <div class="item1" id="echart4"></div>
		 <div class="item2" id="echart5"></div>
		 <div class="item2" id="echart6"></div>
		 <div class="top1-log">
			 <p>Subscribed Service</p>
			 <img class="ASTINET" src="${ctx}/imgs/blue/ASTINET.png" alt="">
			 <img class="IPTRANSIT" src="${ctx}/imgs/blue/IPTRANSIT.png" alt="">
			 <img class="TRANSIT" src="${ctx}/imgs/blue/TRANSIT.png" alt="">
			 <img class="VPNIP" src="${ctx}/imgs/blue/VPNIP.png" alt="">
		 </div>
		 <div class="top1-event" style="display: none;">
			 <table>
				 <thead>
				     <tr><td>Event</td></tr>
				 </thead>
			 </table>
		 </div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ent/top1.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>