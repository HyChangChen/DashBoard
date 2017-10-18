<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/ticket.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" style="padding-top: 6%;">
	<h4>
		<span class="ticket-tit">Number of Access Point</span>
		<span class="ticket-time"></span>
	</h4>
	<table class="num">
		<thead>
			<tr>
				<td rowspan="2" style="width: 6%;">TREG</td>
				<td colspan="4">Kategori</td>
				<td colspan="4">Vendor</td>
				<td colspan="4">Status</td>
				<td colspan="2">Skema Bisnis</td>
				<td rowspan="2">Total</td>
			</tr>
			<tr>
				<td>POI Platinum</td>
				<td>Gold</td>
				<td>Regular</td>
				<td>Others</td>
				<td>AUTELAN</td>
				<td>CISCO</td>
				<td>HUAWEI</td>
				<td>TP_LINK</td>
				<td>Up</td>
				<td>Down</td>
				<td>Under Verify</td>
				<td>No status </td>
				<td>Basic</td>
				<td>Manage Service</td>
			</tr>
		</thead>
		<tbody id="num-data"></tbody>
	</table>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/num.js"></script>
</html>