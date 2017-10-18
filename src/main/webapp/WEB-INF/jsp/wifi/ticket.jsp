<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ticket.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/script/vue.js"></script>
	<script src="${ctx}/js/wifi/ticket.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" style="padding-bottom: 120px;"  id="ticket-data">
	<h4><span class="ticket-tit">WIFI PROACTIVE TICKET MONITORING</span>
		<span class="ticket-time"></span>
	</h4>
	<table class="ticket">
		<thead>
			<tr>
				<td rowspan="3">TREG</td>
				<td colspan="6">Gangguan H-1</td>
				<td colspan="7">Gangguan HI</td>
			</tr>
			<tr>
				<td colspan="2">OPEN</td>
				<td colspan="2">CLOSE</td>
				<td colspan="2">OPEN H-1</td>
				<td colspan="2">CREATED</td>
				<td colspan="2">CLOSE</td>
				<td colspan="2">OPEN</td>
				<td rowspan="2">STATUS</td>
			</tr>
			<tr>
				<td>Tiket</td>
				<td>AP</td>
				<td>Tiket</td>
				<td>AP</td>
				<td>Tiket</td>
				<td>AP</td>
				<td>Tiket</td>
				<td>AP</td>
				<td>Tiket</td>
				<td>AP</td>
				<td>Tiket</td>
				<td>AP</td>
			</tr>
		</thead>
		<tbody></tbody>

	</table>
	<span class="ticket-tit2">Menang = Create > Close Ticket Today</span>&nbsp;&nbsp;
	<span class="ticket-tit2">KALAH = Create < Close Ticket Today</span>&nbsp;&nbsp;
	<span class="ticket-tit2">SERI = Create = Close Ticket Today</span>
</div>
</body>
</html>