<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ano.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ano-layout">
	<%--<div class="padding-layout" style="width: 96%;padding-left: 2%;padding-right: 2%;">--%>
		<div class="vimid">
			<h4>Gamas Node Metro & Access</h4>
			<table class="ano82" cellpadding="2" id="ano82-data">
				<thead>
				<tr style="height: 50px;">
					<td>Priority</td>
					<td>Incident</td>
					<td>Date</td>
					<td>Alarm Summary</td>
					<td>Status</td>
					<td>Symptom</td>
					<td>Solution</td>
				</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	<%--</div>--%>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ano/ano82.js"></script>
</html>