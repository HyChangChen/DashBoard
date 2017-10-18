<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/map.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/script/openStreetMap.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
   <div class="tit">
	   <p style="">Network Surveillance</p>
   </div>
   <div class="top-table-div">
	   <table class="top-table" style="width: 100%; height: 100%;text-align:center;" border="0" cellpadding="2" cellspacing="0">
		   <thead class="Maptthead">
			   <tr style="height : 60px">
				   <td>No</td>
				   <td>Date</td>
				   <td>Ruas</td>
				   <td>Node ID</td>
				   <td>Interface</td>
			   </tr>
		   </thead>
		   <tbody id="top-table" style="overflow: auto;">
		   </tbody>
	   </table>
   </div>
    <div class="bottom-table-div">
        <table class="bottom-table" style="width: 100%; height: 100%; text-align:center;color:black" border="0" cellpadding="2" cellspacing="0">
            <thead class="Maptthead">
                <tr style="height : 60px">
                    <td></td>
                    <td><span style="font-size:20px;">TREG-1</span></td>
                    <td><span style="font-size:20px;">TREG-2</span></td>
                    <td><span style="font-size:20px;">TREG-3</span></td>
                    <td><span style="font-size:20px;">TREG-4</span></td>
                    <td><span style="font-size:20px;">TREG-5</span></td>
                    <td><span style="font-size:20px;">TREG-6</span></td>
                    <td><span style="font-size:20px;">TREG-7</span></td>
                    <td><span style="font-size:20px;">Total</span></td>
                </tr>
            </thead>
            <tbody id="bottom-table"></tbody>
        </table>
    </div>
   <div id="Map" style="width: 100%; height: 100%;"></div>
   <div id="toolip"></div>
</body>
<script type="text/javascript" src="${ctx}/js/centerMap/map.js"></script>
</html>