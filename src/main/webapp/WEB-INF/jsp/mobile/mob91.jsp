<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob91.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<div id="mob91" style="padding-bottom: 120px;padding-top: 20px;">
	<h3>SQUAT</h3>
	<div class="row" id="mob91-data">
		<div class="col-sm-6">
			<table class="mobLeft">
				<thead>
					<tr>
						<td colspan="7">ALPHA</td>
					</tr>
					<tr>
						<td rowspan="2">TREG</td>
						<td colspan="2">TICKETS</td>
						<td colspan="2">PICKUP</td>
						<td colspan="2">COMPLY</td>
					</tr>
					<tr>
						<td>TOTAL</td>
						<td>ASSIGNED</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>TOTAL</td>
						<td>%</td>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<table class="mobRight">
				<thead>
					<tr>
						<td colspan="7">ROMEO</td>
					</tr>
					<tr>
						<td rowspan="2">TREG</td>
						<td colspan="2">TICKETS</td>
						<td colspan="2">PICKUP</td>
						<td colspan="2">COMPLY</td>
					</tr>
					<tr>
						<td>TOTAL</td>
						<td>ASSIGNED</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>TOTAL</td>
						<td>%</td>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<div class="table-legend">
			<div class="legend-layout">
				<div class="legend-item">
					<span class="txt" style="width:120px;">Target Pickup:</span>
					<span class="bg bg-red"></span>
					<span class="txt"><=99%<</span>
					<span class="bg bg-green"></span>
				</div>
				<div class="legend-item">
					<span class="txt" style="width:120px;">Target Comply:</span>
					<span class="bg bg-red"></span>
					<span class="txt"><=85%<</span>
					<span class="bg bg-green"></span>
				</div>
			</div>
			<div class="legend-layout">
				<div class="legend-item">
					<span class="txt" style="width:120px;">Target Pickup:</span>
					<span class="bg bg-red"></span>
					<span class="txt"><=99%<</span>
					<span class="bg bg-green"></span>
				</div>
				<div class="legend-item">
					<span class="txt" style="width:120px;">Target Comply:</span>
					<span class="bg bg-red"></span>
					<span class="txt"><=40%<</span>
					<span class="bg bg-green"></span>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob91.js"></script>
</html>