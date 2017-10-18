<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob86.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div id="mob86" style="padding-bottom: 120px;">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10" >
			<div style="width: 100%;" class="mytitle">
				<h3>KPI COMPLIANCE</h3>
				<span class="ticket-time"></span>
			</div>

			<div class="row">
				<div class="col-md-4 md2">
					<h4 style="color: #03091A;">Packet</h4>
					<table class="table table-bordered sites-table">
						<thead>
							<tr>
								<td style="font-size: 30px;color: #03091A;background: #03091A;">NAS</td>
								<td style="background: #015E8A;">Total Sites</td>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				<div class="col-md-4 md5">
					<h4>Packet Loss</h4>
					<table class="table table-bordered week-table1">
						<thead>
							<tr>
								<td width="33%" class="week1"></td>
								<td width="33%" class="week2"></td>
								<td width="33%">Gap</td>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				<div class="col-md-4 md5">
					<h4>Latency</h4>
					<table class="table table-bordered week-table2">
						<thead>
							<tr>
								<td width="33%" class="week1"></td>
								<td width="33%" class="week2"></td>
								<td width="33%">Gap</td>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
			<span class="ticket-tit">Threshold Target Compliance = 95%</span>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob86.js"></script>
</html>