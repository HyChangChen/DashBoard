<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta charset='utf-8'>
	<title>TelKom Dashboard</title>
	<meta name="keywords" content="">
	<link rel="stylesheet" href="${ctx}/css/reset.css">
	<link rel="stylesheet" href="${ctx}/css/login.css">
	<script src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/js/login.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="login-layout">
	<div class="login-div">
		<div class="login-left-bg"></div>
		<div style="position:relative; width:100%; margin:0px auto;">
			<div class="fan_clouds clouds_animate "></div>
			<div class="fan_clouds2 clouds_animate "></div>
		</div>
		<div class="login-form">
			<div class="form-layout">
				<h4>TelKom Dashboard</h4>
				<form>
					<div class="login-item">
						<label>UserName:</label>
						<input type="text" id="userName" name="name"/>
					</div>
					<p class="msg-user"></p>
					<div class="login-item">
						<label>Passsword:</label>
						<input type="password" id="pwd" name="password"/>
					</div>
					<p class="msg-pwd"></p>
					<div class="login-item">
						<label>Language:</label>
						<select name="_Language">
							<option value="en">EN</option>
							<option value="zh_CN">CH</option>
						</select>
					</div>
					<div style="padding-top: 20px;">
						<input type="checkbox" name=""/>Remember
						<a href="javasript:;" class="forgot">Forgot Password</a>
					</div>
					<div class="login-btn">
						<a href="javasript:;" id="login">Sign in</a>
					</div>
				</form>
			</div>
		</div>
		<div class="login-footer">© Copyright Telkom 2017. All rights reserved. Please refer to the product license for details</div>
	</div>

</div>
<div class="mask">
</div>
<div class="forget-box" style="background: #fff">
	<h4>Get PassWord</h4>
	<i class="close" style="margin-top: 10px;"></i>
     <p class="item" style="background: #EEEECC;">
		 <lable>User Name</lable>
		 <input type="text" placeholder="User Name" class="user-name">
	 </p>
	<p  class="item" style="margin-top: 20px;background: #EEEEEE;">
		<lable>Please enter your registered email address</lable>
		<input type="text" placeholder="Please enter your registered email address" class="user-email">
	</p>
	<p class="forget-tip"></p>
	<button class="getPwd">Get PassWord</button>
</div>
</body>
</html>
