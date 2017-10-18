<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ticket.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" style="padding-bottom: 120px;" id="moni-data">
	<div class="padding-layout" style="width: 96%;">
		<h4 class="titTime"></h4>
		<table class="monitoring-table" cellpadding="2">
			<thead>
			<tr>
				<td rowspan="3">TREG</td>
				<td rowspan="2" colspan="4">Bulan lalu Realisasi(Jam)</td>
				<td colspan="12">Bulan Ini</td>
				<td colspan="8">TREG</td>
			</tr>
			<tr>
				<td colspan="4">H-2 Realisasi(Jam)</td>
				<td colspan="4">H-1 Realisasi(Jam)</td>
				<td colspan="4">1 S/d H-1 Realisasi(Jam)</td>
				<td colspan="4" width="7%">Bulan lalu vs 1 s/d H-1</td>
				<td colspan="4" width="7%">H-2 vs H-1</td>
			</tr>
			<tr>
				<td width="4%">P</td>
				<td width="4%">G</td>
				<td width="4%">R</td>
				<td width="4%">T</td>

				<td width="4%">P</td>
				<td width="4%">G</td>
				<td width="4%">R</td>
				<td width="4%">T</td>

				<td width="4%">P</td>
				<td width="4%">G</td>
				<td width="4%">R</td>
				<td width="4%">T</td>

				<td width="4%">P</td>
				<td width="4%">G</td>
				<td width="4%">R</td>
				<td width="4%">T</td>

				<td width="3%">P</td>
				<td width="3%">G</td>
				<td width="3%">R</td>
				<td width="3%">T</td>

				<td width="3%">P</td>
				<td width="3%">G</td>
				<td width="3%">R</td>
				<td width="3%">T</td>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
		<div class="table-legend">
			<div class="legend-item">
				<span class="img-bg bg1"></span>
				<span class="txt">Green= Positive Growth</span>
			</div>
			<div class="legend-item">
				<span class="img-bg bg2"></span>
				<span class="txt">Yellow=No Growth</span>
			</div>
			<div class="legend-item">
				<span class="img-bg bg3"></span>
				<span class="txt">Red=Negative Growth</span>
			</div>
			<div class="legend-item" style="float: right; font-size: 16px; ">
				<span class="txt">P=12  G=48  R=48  T=48</span>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/monitoring.js"></script>
</html>