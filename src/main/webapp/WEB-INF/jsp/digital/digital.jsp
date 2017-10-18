<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta charset='utf-8'>
	<title></title>
	<meta name="keywords" content="">
	<link rel="stylesheet" href="${ctx}/css/reset.css">
	<link rel="stylesheet" href="${ctx}/css/digital.css">
	<script src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/script/vue.js"></script>
	<script src="${ctx}/js/digital/digital.js"></script>
	<script>
		var _ctx = "${ctx}";
		var urlNum = "${page}";
	</script>
</head>
<body>
<div class="digital">
	<div class="dig-layout" style="padding-top: 40px;">
		<table class="dig-13" id="digital-data">
			<thead>
				<tr>
					<td rowspan="3">OPERATIONAL</td>
					<td rowspan="3">UNIT</td>
					<td colspan="6">{{month}}</td>
					<td rowspan="3">MOM</td>
					<td colspan="5">YtD&nbsp;{{year}}</td>
					<td rowspan="3">YOY</td>
				</tr>
				<tr>
					<td rowspan="2">TARGET</td>
					<td colspan="3">MtD</td>
					<td colspan="2">OUTLOOK</td>
					<td rowspan="2">TARGET</td>
					<td rowspan="2">REAL</td>
					<td rowspan="2">ACH</td>
					<td colspan="2">OUTLOOK</td>
				</tr>
				<tr>
					<td>REAL</td>
					<td colspan="2">ACH</td>
					<td>AMOUNT</td>
					<td>ACH</td>
					<td>REAL</td>
					<td>ACH</td>
				</tr>
			</thead>
			<tbody v-if="!isShow">
				<tr style="text-align: left;background-color: #1F3E50;font-size: 26px;height: 46px;">
					<td colspan="15" style="padding-left:20px;">{{tit}}</td>
				</tr>
				<tr v-for="(item,index) of digList">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
					<td>{{item.ioc3}}</td>
					<td style="width: 120px;">{{item.ioc4}}</td>
					<td :id="item.id" style="width: 100px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc5)<100}">{{item.ioc5}}</td>
					<td>{{item.ioc6}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc7)<100,'text-blue':parseInt(item.ioc7)>=100}">{{item.ioc7}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc8)<100,'text-blue':parseInt(item.ioc8)>=100}">{{item.ioc8}}</td>
					<td>{{item.ioc9}}</td>
					<td :id="item.id1" style="width: 150px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc11)<100,'text-blue':parseInt(item.ioc11)>=100}">{{item.ioc11}}</td>
					<td>{{item.ioc12}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc13)<100,'text-blue':parseInt(item.ioc13)>=100}">{{item.ioc13}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc14)<100,'text-blue':parseInt(item.ioc14)>=100}">{{item.ioc14}}</td>
				</tr>
			</tbody>
			<tbody v-if="isShow">
				<tr style="text-align: left;background-color: #1F3E50;font-size: 26px;height: 46px;padding-left:20px;">
					<td colspan="15" style="padding-left:20px;">{{dig13Dto.name}}</td>
				</tr>
				<tr v-for="(item,index) of dig13Dto.vDig13List">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
					<td>{{item.ioc3}}</td>
					<td style="width: 120px;">{{item.ioc4}}</td>
					<td :id="item.id" style="width: 100px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc5)<100}">{{item.ioc5}}</td>
					<td>{{item.ioc6}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc7)<100}">{{item.ioc7}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc8)<100}">{{item.ioc8}}</td>
					<td>{{item.ioc9}}</td>
					<td :id="item.id1" style="width: 150px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc11)<100}">{{item.ioc11}}</td>
					<td>{{item.ioc12}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc13)<100}">{{item.ioc13}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc14)<100}">{{item.ioc14}}</td>
				</tr>

				<tr style="text-align: left;background-color: #1F3E50;font-size: 26px;height: 46px;padding-left:20px;">
					<td colspan="15" style="padding-left:20px;">{{dig14Dto.name}}</td>
				</tr>
				<tr v-for="(item,index) of dig14Dto.dig14List">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
					<td>{{item.ioc3}}</td>
					<td style="width: 120px;">{{item.ioc4}}</td>
					<td :id="item.id" style="width: 100px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc5)<100}">{{item.ioc5}}</td>
					<td>{{item.ioc6}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc7)<100}">{{item.ioc7}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc8)<100}">{{item.ioc8}}</td>
					<td>{{item.ioc9}}</td>
					<td :id="item.id1" style="width: 150px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc11)<100}">{{item.ioc11}}</td>
					<td>{{item.ioc12}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc13)<100}">{{item.ioc13}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc14)<100}">{{item.ioc14}}</td>
				</tr>

				<tr style="text-align: left;background-color: #1F3E50;font-size: 26px;height: 46px;padding-left:20px;">
					<td colspan="15" style="padding-left:20px;">{{dig17Dto.name}}</td>
				</tr>
				<tr v-for="(item,index) of dig17Dto.dig17List">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
					<td>{{item.ioc3}}</td>
					<td style="width: 120px;">{{item.ioc4}}</td>
					<td :id="item.id" style="width: 100px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc5)<100}">{{item.ioc5}}</td>
					<td>{{item.ioc6}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc7)<100}">{{item.ioc7}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc8)<100}">{{item.ioc8}}</td>
					<td>{{item.ioc9}}</td>
					<td :id="item.id1" style="width: 150px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc11)<100}">{{item.ioc11}}</td>
					<td>{{item.ioc12}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc13)<100}">{{item.ioc13}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc14)<100}">{{item.ioc14}}</td>
				</tr>

				<tr style="text-align: left;background-color: #1F3E50;font-size: 26px;height: 46px;padding-left:20px;">
					<td colspan="15" style="padding-left:20px;">{{dig18Dto.name}}</td>
				</tr>
				<tr v-for="(item,index) of dig18Dto.dig18List">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
					<td>{{item.ioc3}}</td>
					<td style="width: 120px;">{{item.ioc4}}</td>
					<td :id="item.id" style="width: 100px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc5)<100}">{{item.ioc5}}</td>
					<td>{{item.ioc6}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc7)<100}">{{item.ioc7}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc8)<100}">{{item.ioc8}}</td>
					<td>{{item.ioc9}}</td>
					<td :id="item.id1" style="width: 150px;height: 75px;"></td>
					<td v-bind:class="{'text-red':parseInt(item.ioc11)<100}">{{item.ioc11}}</td>
					<td>{{item.ioc12}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc13)<100}">{{item.ioc13}}</td>
					<td v-bind:class="{'text-red':parseInt(item.ioc14)<100}">{{item.ioc14}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
</html>
