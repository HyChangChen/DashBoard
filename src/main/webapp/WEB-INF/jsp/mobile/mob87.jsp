<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob87.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="mob" style="padding-top:60px;">
	<div class="mob-layout">
		<div class="row">
			<div class="col-sm-2" style="padding-left: 130px; width: 100%; padding-top: 30px;">
				<h3>Nasional</h3>
				<span class="ticket-time"></span>

			</div>
		</div>
		<div class="row" id="mob87" style="margin-left: 100px;padding-top: 30px;">

			<div class="col-sm-2" style="padding-top: 35px">
				<ul>
					<li><a href="javascript:void(0);"  style=" background: #005E8A;font-size: 24px;color: #fff;  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif ">View</a></li>
					<li  style="background: #8D93A8;"><a href="javascript:void(0);" v-on:click="navClick('0')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">NAS</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('1')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-1</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('2')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-2</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('3')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-3</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('4')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-4</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('5')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-5</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('6')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-6</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('7')" style="font-size: 24px;color: #fff;font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif">TREG-7</a></li>
				</ul>
			</div>
			<div class="col-sm-6">
				<div id="echart1" style="height: 300px;width: 100%; padding-top: 30px;"></div>
			</div>
			<div class="col-sm-3"  style="padding-right: 15px; padding-top: 30px;">

				<table>
					<tr>
						<td style="text-align: left;width:230px;"><div id="SLD"></div>SL_D</td>
						<td class="SL_D"></td>
					</tr>
					<tr>
						<td style="text-align: left;width:230px;"><div id="FOAccess"></div>FO Access</td>
						<td class="FOAccess"></td>
					</tr>
					<tr>
						<td style="text-align: left;width:230px;"><div id="RadioAccess"></div>Radio Access</td>
						<td class="RadioAccess"></td>
					</tr>
					<tr>
						<td style="text-align: left;width:230px;"><div id="OTHERS"></div>OTHERS</td>
						<td class="OTHERS"></td>
					</tr>
				</table>
				<p>*Jumlah Active with Severity(<span class="txt-first">Critical,</span><span class="txt-sec">Major,</span><span class="txt-third">Minor</span>)</p>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob87.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>