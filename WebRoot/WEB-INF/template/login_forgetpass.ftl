<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改密码</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<!-- 避免IE使用兼容模式，IE 运行最新的渲染模式,用 Chrome 框架的页面用webkit 内核-->
	<meta name="renderer" content="webkit">
	<!-- 启用360浏览器的极速模式(webkit) -->
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
	<!-- 初始化移动浏览显示,移动端必须使用 -->
	<meta name="format-detection" content="telephone=no" />
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	
	<!-- 危险勿动 -->
    <script type="text/javascript">
	!function(n){var e=n.document,t=e.documentElement,i=1080,d=i/150,o="orientationchange"in n?"orientationchange":"resize",a=function(){var n=t.clientWidth||320;n>1080&&(n=1080),t.style.fontSize=n/d+"px"};e.addEventListener&&(n.addEventListener(o,a,!1),e.addEventListener("DOMContentLoaded",a,!1))}(window);
	</script>

	<link rel="stylesheet" type="text/css" href="${base}/static/fonts/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base}/static/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${base}/static/mycompass/stylesheets/screen.css">
</head>
<body class="header-padd">
	<header class="default-head">
		<a href="javascript:history.go(-1);" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
		<div class="head-tit">修改密码</div>
		<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
	</header>

	<div class="content">
		<div class="login-box">
			<div class="C-list">
				<input type="text" id="phone" maxlength="20" placeholder="手机号码">
				<input type="button" class="send-btn" id="identifying-btn" value="获取验证码">
			</div>
			<div class="C-list">
				<input type="text" id="phoneCode" maxlength="8" placeholder="请输入收到的手机验证码">
			</div>
			<div class="C-list">
				<input type="text" id="passWord" minlength="6" maxlength="16" placeholder="设置6-16位字母数字组合新密码">
			</div>
			<!--
			<div class="C-list">
				<input type="text" id="passWord2" class="vcodeval" maxlength="8" placeholder="请填写右图中的验证码">
				<div class="vcode-area">
					<div id="vcode-box"></div>
				</div>
			</div>
           -->
		</div>

		<div class='default-btn'>
			<a href="#">修改密码</a>
		</div>
	</div>
	
	<script type="text/javascript" src="${base}/static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${base}/static/js/send-identifyingcode.js"></script>
	<script type="text/javascript" src="${base}/static/js/vCode.js"></script>
	
	<script type="text/javascript">
	
	    //发送验证码
    $(function(){
    	$(document).on('click','#identifying-btn',function(){
    		var phone=$("#phone").val();
    		if (!phone.match(/^(((13[0-9]{1})|1[0-9][0-9])+\d{8})$/)){ 
			alert("手机号码格式不正确！");return;
		    }
		
			$.ajax({
				url:"json/login!checkPhone.action",
                data:{phone:phone},
				success:function(html){
					var json = eval("("+html+")");
					if(json.success){
					   sendMessage();
					}else{
						alert("用户不存在!");
					}
				}, 
				error:function(html){
					alert('未知错误!');
				}
				
			 })
    	  })
       })
       
       //确认修改密码
       $(document).on('click','.default-btn',function(){
    		var phone=$("#phone").val();
    		var phoneCode = $("#phoneCode").val();
    		var passWord = $("#passWord").val();
    		if (!phone.match(/^(((13[0-9]{1})|1[0-9][0-9])+\d{8})$/)){
	    		alert("手机号码格式不正确！");
				return;
			}
		
			$.ajax({
				url:"json/login!changePass.action",
                data:{
                    phone:phone,
                    phoneCode:phoneCode,
                    pwd:passWord,
                              },
				success:function(html){
					var json = eval("("+html+")");
					if(json.success){
					   alert("密码修改成功");
					   location.href="login.action";
					}else{
						alert(json.msg);
					}
				}, 
				error:function(html){
					alert('未知错误!');
				}
				
			 })
    	  })
	
		

			
		
	</script>
</body>
</html>