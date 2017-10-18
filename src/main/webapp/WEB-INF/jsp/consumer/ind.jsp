<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/consumer/ind.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ind-layout" id="ind-data">
	<div class="ver-align">
		<div class="ind-header">
			<img src="${ctx}/imgs/logo_01.png">
			<span class="ind-time"></span>
		</div>
		<div class="table-layout">
			<!--左table-->
			<table class="new-table">
				<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Total Tiket</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>SaldoH-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
				</thead>
				<tbody id="total-table"></tbody>
			</table>

			<!--中间table-->
			<table class="new-table" style="margin-right: 50px;margin-left: 50px;">
				<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Regular</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>Saldo H-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
				</thead>
				<tbody id="regular-table"></tbody>
			</table>

			<!--右table-->
			<table class="new-table">
				<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Impact Gamas</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>Saldo H-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
				</thead>
				<tbody id="impact-table"></tbody>
			</table>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/consumer/ind.js"></script>
</html>