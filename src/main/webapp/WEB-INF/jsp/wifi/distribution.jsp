<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<meta http-equiv="refresh" content="300">
	<link rel="stylesheet" href="${ctx}/css/ticket.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/script/vue.js"></script>
	<script src="${ctx}/js/wifi/distribution.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" style="padding-bottom: 100px;">
	<h4>Distribution AP Status Report</h4>
	<table class="distribution">
		<thead>
			<tr>
				<td rowspan="3" width="8%">TREG</td>
				<td colspan="10">STATUS AP</td>
			</tr>
			<tr>
				<td rowspan="2" width="6%">UP</td>
				<td rowspan="2">AVAILABILITY</td>
				<td colspan="2">DOWN</td>
				<td rowspan="2" width="6%">UV</td>
				<td rowspan="2">DISMANTLE</td>
				<td rowspan="2">RUSAK</td>
				<td rowspan="2">HILANG</td>
				<td rowspan="2">TEMPORER</td>
				<!--<td rowspan="2" class="dis-td">DISPEND<br>ORDER</td>-->
			</tr>
			<tr>
				<td class="dis-td">REAL<br>DOWN</td>
				<td class="dis-td">DOWN SITE<br>OWNER</td>
			</tr>
		</thead>
		<tbody id="distribution-data"></tbody>
	</table>
</div>
</body>
</html>