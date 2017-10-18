<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/pre/per7xs.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="pre-layout">
	<h4>Provisioning-7 x  regions INDIHOME Comply Order</h4>
	<div class="item">
		<table class="treg14-table">
			<thead>
				<tr>
					<td width="197px">TREG</td>
					<td width="210px">STATUS_IN</td>
					<td width="265px">APP</td>
					<td width="175px">COMPLY PS_DONE</td>
					<td width="228px">NOT COMPLY PS_DONE</td>
					<td width="216px">GRAND TOTAL PS_DONE</td>
					<td width="220px">MYINDIHOME<br />COMPLIANCE</td>
					<td width="210px">OTHERS<br />COMPLIANCE</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td rowspan="3" class="my-TregDown">1</td>
					<td rowspan="3">INDIHOME</td>
					<td>MYINDIHOME</td>
					<td class="my-cPsDown">222</td>
					<td class="my-notPsDown">41</td>
					<td class="my-totalPsDown">263</td>
					<td rowspan="3">
						<span id="echart1" style="display: block;width: 300px;height: 100%;margin:0 auto;"></span>
					</td>
					<td rowspan="3">
						<span id="echart2" style="display: block;width: 300px;height: 100%;margin:0 auto;"></span>
					</td>
				</tr>
				<tr>
					<td>OTHERS</td>
					<td class="others-cPsDown">32</td>
					<td class="others-notPsDown">455</td>
					<td class="others-totalPsDown">423</td>
				</tr>
				<tr>
					<td>TOTAL</td>
					<td class="total-cPsDown">32</td>
					<td class="total-notPsDown">455</td>
					<td class="total-totalPsDown">423</td>
				</tr>
			</tbody>
		</table>
		<ul class="treg14">
			<li><</li>
			<li>TREG-1</li>
			<li>TREG-2</li>
			<li>TREG-3</li>
			<li>TREG-4</li>
			<li>></li>
		</ul>
	</div>
	<div class="item">
		<table class="treg57-table">
			<thead>
				<tr>
					<td width="197px">TREG</td>
					<td width="210px">STATUS_IN</td>
					<td width="265px">APP</td>
					<td width="175px">COMPLY PS_DONE</td>
					<td width="228px">NOT COMPLY PS_DONE</td>
					<td width="216px">GRAND TOTAL PS_DONE</td>
					<td width="220px">MYINDIHOME<br />COMPLIANCE</td>
					<td width="210px">OTHERS<br />COMPLIANCE</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td rowspan="3" class="my-TregDown">1</td>
					<td rowspan="3">INDIHOME</td>
					<td>MYINDIHOME</td>
					<td class="my-cPsDown">222</td>
					<td class="my-notPsDown">41</td>
					<td class="my-totalPsDown">263</td>
					<td rowspan="3">
						<span id="echart3" style="display: block;width: 300px;height: 100%;margin:0 auto;"></span>
					</td>
					<td rowspan="3">
						<span id="echart4" style="display: block;width: 300px;height: 100%;margin:0 auto;"></span>
					</td>
				</tr>
				<tr>
					<td>OTHERS</td>
					<td class="others-cPsDown">32</td>
					<td class="others-notPsDown">455</td>
					<td class="others-totalPsDown">423</td>
				</tr>
				<tr>
					<td>TOTAL</td>
					<td class="total-cPsDown">32</td>
					<td class="total-notPsDown">455</td>
					<td class="total-totalPsDown">423</td>
				</tr>
			</tbody>
		</table>
		<ul class="treg57" style="width: 750px;">
			<li><</li>
			<li>TREG-5</li>
			<li>TREG-6</li>
			<li>TREG-7</li>
			<li>></li>
		</ul>
	</div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/pre/pre.js"></script>
</html>