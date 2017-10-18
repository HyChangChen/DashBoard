<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob88.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div>
	<div class="mob-layout" id="mob88">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4" style=" padding-top: 65px; padding-left: 0px;">
				<h4>Performance</h4>
				<table class="table table-bordered" id="mob88-data">
					<thead>
						<tr>
							<td width="200px;"></td>
							<td style=" width: 100px;background: #015E8A;" >SCR</td>
							<td style=" width: 145px;background: #015E8A;">PDP-SR</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<span class="ticket-tit">Threshold Target = 95%</span>
			</div>
			<div class="col-sm-7" style="padding-top: 80px;">
				<div id="echart1" class="row" style="height:300px;"></div>
				<div id="echart2" class="row" style="height:300px;"></div>
			</div>
		</div>
	</div>
</div>
<div  class="data-tip"></div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob88.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>