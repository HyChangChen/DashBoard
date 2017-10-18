<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title>TelKom Dashboard</title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/main.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/index.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/tendina.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/AL-index.js"></script>
	<script>
		var _ctx = ${ctx};
	</script>
</head>
<body>
<!--顶部-->
<span id="small" style=""></span>
<div class="header">
	<div class="admin">
		<a href="#">
			<i class="icon-down"></i>
			<span>${loginname}</span>
			<img src="${ctx}/imgs/none_user.gif" class="admin-img" />
		</a>
		<ul class="admin-down-ul" style="display: none;">
			<li>
				<a href="${ctx}/system/logoutnonesession">
					<i class="icon-logout icon-user"></i>
					LogOut
				</a>
			</li>
		</ul>
	</div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="left-menu">
	<ul id="menu">
			<c:forEach items="${modelIndexDto.modelList}" var="item">
			<li class="menu-list">
				<a style="border-top: none;" target="menuFrame" class="firsta" ><i  class="first-a-icon"></i>${item.modelname}<i class="first-a-down"></i></a>
				<ul>
					<c:forEach items="${item.childList}" var="child">
						<c:if test="${child.isurl == 0}">
							<li class="menu-list"><a  href=${ctx}/${child.murl} target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz"></span></a></li>
						</c:if>
						<c:if test="${child.isurl == 1 && child.murl=='https://dashboard.telkom.co.id/idwifi/prabagen/index/page/390'}">
							<li class="menu-list"><a  href=${child.murl} target="_blank" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz"></span></a></li>
						</c:if>
						<c:if test="${child.isurl == 1 && child.murl!='https://dashboard.telkom.co.id/idwifi/prabagen/index/page/390'}">
							<li class="menu-list"><a  href=${child.murl} target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz"></span></a></li>
						</c:if>
					</c:forEach>
				</ul>
		    </li>
			</c:forEach>
		<%--<li class="menu-list"><a  href="${ctx}/system/upoint" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">upoint</span></a></li>
        <li class="menu-list"><a  href="${ctx}/system/enterprrisegovement" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">enterprrisegovement</span></a></li>
        <li class="menu-list"><a  href="${ctx}/system/summary" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">summary</span></a></li>
      	<li class="menu-list"><a  href="${ctx}/system/indihome" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">indihome</span></a></li>
       	<li class="menu-list"><a  href="${ctx}/system/wifiid" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">wifiid</span></a></li>
        <li class="menu-list"><a  href="${ctx}/system/telkomsolution" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>${child.modelname}<span class="sz">telkomsolution</span></a></li>--%>
    </ul>
</div>
<!--菜单右边的iframe页面-->

</ul>
</div>
<!--菜单右边的iframe页面-->
<div id="right-content" class="right-content">
	<div class="content">
		<div class="right-header">
			<a href="#"><i class="home-icon"></i>My portal</a>
			<span class="header-router"></span>
			<span id="all" style=""></span>
		</div>
		<%--<div class="router">
			<span class="router-txt">My portal</span>
		</div>--%>
		<div id="page_content">
			<iframe id="menuFrame" name="menuFrame" style="overflow:visible;"
					width="100%" height="100%"  src="${ctx}/ano/map" onresize="alert('You have changed the size of the window')"></iframe>
		</div>
	</div>
</div>
</body>
<script>
	$(function(){
		var contentH = document.body.clientHeight-$(".header").height();
		var iframeH = document.body.clientHeight-$(".header").height()-$(".right-header").height()-$(".router").height();
		$(".right-content").height(contentH);
		$(".content").height(contentH);
        $("#page_content").height(iframeH);
        $(".left-menu").height(contentH);
	});
</script>
</html>