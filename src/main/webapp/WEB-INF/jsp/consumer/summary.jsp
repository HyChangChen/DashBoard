<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/summary.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ind-layout">
	<table class="summary">
		<thead>
			<tr>
				<td colspan="39">Open Ticket Daily for Non-GAMAS</td>
			</tr>
			<tr>
				<td rowspan="3">Region</td>
				<td colspan="7">ENTERPRISE</td>
				<td colspan="7">BUSINESS</td>
				<td colspan="12">CONSUMER TOP 20</td>
				<td colspan="6">CONSUMER TOP 20</td>
				<td rowspan="3">TOTAL</td>
				<td rowspan="3">SMS<br>OPEN</td>
				<td rowspan="3">SMS<br>BACKEND</td>
				<td rowspan="3">E-MAIL<br> OPEN</td>
				<td rowspan="3">E-MAIL<br>BACKEND</td>
				<td rowspan="3">SMS<br>REOPEN</td>
			</tr>
			<tr>
				<td colspan="7">CL(61AM)</td>
				<td colspan="7">BL(12JAM)</td>
				<td colspan="6">PL(PLATINUM 24 JAM)</td>
				<td colspan="6">PL(TITANIUM & GOLD 48JAM)</td>
				<td colspan="6">PL(SILVER 72JAM)</td>
			</tr>
			<tr>
				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>E</td>
				<td>F</td>
				<td class="bolder-boder">TTL</td>

				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>E</td>
				<td>F</td>
				<td class="bolder-boder">TTL</td>

				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>E</td>
				<td class="bolder-boder">TTL</td>

				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>E</td>
				<td class="bolder-boder">TTL</td>

				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>E</td>
				<td class="bolder-boder">TTL</td>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div style=" height: 120px; font-size: 16px; color: #fff;
    font-weight: bold;
    line-height: 40px;
    display: block;
    float: left;">Ket :<br />
		ENTERPRISE: A : 0 - 6 jam B : 6 - 24 jam C : 24 - 48 jam D : 48 - 72 jam E : 72 jam - 7 hari F : > 7 hari<br />
		BUSINESS: A : 0 - 12 jam B : 12 - 24 jam C : 24 - 48 jam D : 48 - 72 jam E : 72 jam - 7 Hari F : > 7 hari<br />
		CONSUMER: A : 0 - 12 jam B : 12 - 24 jam C : 24 - 48 jam D : 48 jam - 72 jam E : >= 72 jam<br />
		Status Tiket : OPEN<br />
		<span class="ticket-time"></span>
	</div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/consumer/summary.js"></script>
</html>