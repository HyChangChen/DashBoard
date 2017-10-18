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
	<script type="text/javascript" src="${ctx}/js/wifi/mttr.js"></script>
	<script src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" id="mttr-data">
	<h4>
		<span class="ticket-tit">MTTR Targets - Proactive Ticket (AP Down)</span>
		<span class="ticket-time">{{time}}</span>
	</h4>
	<div  style="background: #0C0E26;">
		<div class="item-layout">
			<table class="MTTR">
				<thead>
					<tr>
						<td rowspan="2">TREG</td>
						<td rowspan="2">Kategori</td>
						<td rowspan="2">Target(Jam)</td>
						<td colspan="3">{{nowTime}}</td>
					</tr>
					<tr>
						<td>Jumlah Gangguan <br> CLOSE</td>
						<td>Realisasi<br>(Jam)</td>
						<td>Pencapaian</td>
					</tr>
				</thead>
				<tbody>
					<template v-for="item in mttrLeft">
						<tr>
							<td rowspan="3">{{item[0].ioc1}}</td>
							<td>{{item[0].ioc2}}</td>
							<td>{{item[0].ioc3}}</td>
							<td>{{item[0].ioc4}}</td>
							<td>{{item[0].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[0].ioc6)<75,'bg-yellow':parseFloat(item[0].ioc6)>=75&&parseFloat(item[0].ioc6)<=90,'bg-blue':parseFloat(item[0].ioc6)>90}">{{item[0].ioc6}}</td>
						</tr>
						<tr>
							<td>{{item[1].ioc2}}</td>
							<td>{{item[1].ioc3}}</td>
							<td>{{item[1].ioc4}}</td>
							<td>{{item[1].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[1].ioc6)<75,'bg-yellow':parseFloat(item[1].ioc6)>=75&&parseFloat(item[1].ioc6)<=90,'bg-blue':parseFloat(item[1].ioc6)>90}">{{item[1].ioc6}}</td>
						</tr>
						<tr>
							<td>{{item[2].ioc2}}</td>
							<td>{{item[2].ioc3}}</td>
							<td>{{item[2].ioc4}}</td>
							<td>{{item[2].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[2].ioc6)<75,'bg-yellow':parseFloat(item[2].ioc6)>=75&&parseFloat(item[2].ioc6)<=90,'bg-blue':parseFloat(item[2].ioc6)>90}">{{item[2].ioc6}}</td>
						</tr>
					</template>
				</tbody>
			</table>
		</div>
		<div class="item-layout" style="background: #0C0E26;">
			<table class="MTTR">
				<thead>
					<tr>
						<td rowspan="2">TREG</td>
						<td rowspan="2">Kategori</td>
						<td rowspan="2">Target(Jam)</td>
						<td colspan="3">{{nowTime}}</td>
					</tr>
					<tr>
						<td>Jumlah Gangguan <br> CLOSE</td>
						<td>Realisasi<br>(Jam)</td>
						<td>Pencapaian</td>
					</tr>
				</thead>
				<tbody>
					<template v-for="item in mttrRight">
						<tr>
							<td rowspan="3">{{item[0].ioc1}}</td>
							<td>{{item[0].ioc2}}</td>
							<td>{{item[0].ioc3}}</td>
							<td>{{item[0].ioc4}}</td>
							<td>{{item[0].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[0].ioc6)<75,'bg-yellow':parseFloat(item[0].ioc6)>=75&&parseFloat(item[0].ioc6)<=90,'bg-blue':parseFloat(item[0].ioc6)>90}">{{item[0].ioc6}}</td>
						</tr>
						<tr>
							<td>{{item[1].ioc2}}</td>
							<td>{{item[1].ioc3}}</td>
							<td>{{item[1].ioc4}}</td>
							<td>{{item[1].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[1].ioc6)<75,'bg-yellow':parseFloat(item[1].ioc6)>=75&&parseFloat(item[1].ioc6)<=90,'bg-blue':parseFloat(item[1].ioc6)>90}">{{item[1].ioc6}}</td>
						</tr>
						<tr>
							<td>{{item[2].ioc2}}</td>
							<td>{{item[2].ioc3}}</td>
							<td>{{item[2].ioc4}}</td>
							<td>{{item[2].ioc5}}</td>
							<td v-bind:class="{'bg-red':parseFloat(item[2].ioc6)<75,'bg-yellow':parseFloat(item[2].ioc6)>=75&&parseFloat(item[2].ioc6)<=90,'bg-blue':parseFloat(item[2].ioc6)>90}">{{item[2].ioc6}}</td>
						</tr>
					</template>
				</tbody>
			</table>
		</div>
	</div>
	<div  id="echart1" style="background: #0C0E26;height: 400px;padding-bottom: 100px;"></div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
</html>