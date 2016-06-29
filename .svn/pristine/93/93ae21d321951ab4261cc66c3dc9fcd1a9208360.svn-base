<!doctype html>
<html>
<head>
	<title>首页</title>
	<meta charset="utf-8">
	<meta name="keywords" content=""> <!-- seo网站关键字 -->
	<meta name="description" content=""> <!-- seo对网站的文字描述 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<!-- IE使用最新渲染模式，chrome框架使用webkit内核 -->
	<meta name='renderer' content="webkit">
	<!-- 让360浏览器使用webkit内核 -->
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<!-- 让屏幕1：1缩放，并且在移动设备上禁止放大缩小 -->

	<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
	<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->    
    <link rel="stylesheet" type="text/css" href="${base}/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/css/agency.css">

    <script type="text/javascript" src="${base}/static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
    document.onkeydown = function(e){
	if($(".bac").length==0)
	{
		if(!e) e = window.event;
		if((e.keyCode || e.which) == 13){
			var obtnLogin=document.getElementById("submit-btn");
			obtnLogin.focus();
		}
	}
}

jQuery(document).ready(function(){

	// login验证
	$('#submit-btn').click(function(){
		user();
		pass();
		if(user()==true && pass()==true){
			var submitData = {};
			submitData["phone"] = $("#username").val();
			submitData["password"] = $("#password").val();
			$.ajax({
				type:'post',
				url:'json/login!in.action',
				data:submitData,
				async:false,
				success:function(data){
					json = eval("("+data+")");
					if(json.success){
						window.location.href='shop!list.action';
					}else{
						$('#username').parent().addClass("has-error");
           				$('.user-error').html("用户名或密码错误！");
					}
				},
				error:function(data){
					console.log(data)
					$('#username').parent().addClass("has-error");
       				$('.user-error').html("数据错误，请联系管理员！");
				}
			})
		}
	})

	// register验证
	$('#register-btn').click(function(){
		user();
		pass();
		repass();
		identifyingcode();
		check();
		if(user()==true && pass()==true && repass()==true && identifyingcode()==true&& check()==true){
			alert("ok");
			var submitData = {};

			submitData["userName"] = $("#username").val();
			submitData["password"] = $("#password").val();

			$.ajax({
				type:'post',
				url:'',
				dataType:'json',
				data:submitData,
				async:false,
				success:function(data){
					if(data.success){
						window.location.href='';
					}else{
						$('#username').parent().addClass("has-error");
           				$('.user-error').html("用户名或密码错误！");
					}
				},
				error:function(data){
					$('#username').parent().addClass("has-error");
       				$('.user-error').html("数据错误，请联系管理员！");
				}
			})
		}
	})

	$('#username').blur(function(){
		user();
	})
	$('#password').blur(function(){
		pass();
		repass();
	})

	$('#repassword').blur(function(){
		repass();
	})

	$('#identifyingcode').blur(function(){
		identifyingcode();
	})

	$('#check').blur(function(){
		check();
	})

	function user(){
		var username = $('#username').val();
		var myReg = /^(13[\d]{9}|15[\d]{9}|18[\d]{9})$/; //邮件正则
		if(username==''){
			$('#username').parent().addClass("has-error");
           	$('.user-error').html("请输入手机号码！");
           	return false;
        }else{
        	$('#username').parent().removeClass("has-error");
           	$('.user-error').html("");
           	return true;
        }
	}
	function pass(){
		var password = $('#password').val();
		if(password==''){
			$('#password').parent().addClass("has-error");
           	$('.pass-error').html("请输入密码！");
           	return false;
        }else{
        	$('#password').parent().removeClass("has-error");
           	$('.pass-error').html("");
           	return true;
        }
	}

	function repass(){
		var password = $('#password').val();
		var repassword = $('#repassword').val();
		if(repassword!=password){
			$('#repassword').parent().addClass("has-error");
           	$('.repass-error').html("两次密码输入不一至！");
           	return false;
        }else{
        	$('#repassword').parent().removeClass("has-error");
           	$('.repass-error').html("");
           	return true;
        }
	}

	function identifyingcode(){
		var identicode = $('#identifyingcode').val();
		if(identicode==''){
			$('#identifyingcode').parent().addClass("has-error");
           	$('.ident-error').html("请输入验证码！");
           	return false;
        }else{
        	$('#identifyingcode').parent().removeClass("has-error");
           	$('.ident-error').html("");
           	return true;
        }
	}

	function check(){
		var check=$('#check');
		if(check.is(':checked')){
			$('#check').parent().removeClass("has-error");
           	$('.check-error').html("");
           	return true;
        }else{        	
           	$('#check').parent().addClass("has-error");
           	$('.check-error').html("请阅读并同意协议！");           	
           	return false;
        }
	}

})
    
    
    
    </script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class='logo-area'>
			</div>
		</div>
		<div class="row login-area" style="background:url('${base}/static/images/bck.jpg'); background-size:cover;">
			<div class='col-md-5 col-md-offset-7'>
				<div class="login-box">
					<form>
						<h5>代理商登录</h5>
						<div class="form-group">
						    <label for="username" class="sr-only">手机号</label>
						    <input type="text" class="form-control" autocomplete="off" id="username" placeholder="手机号">
						    <span class="errors user-error"></span>
					  	</div>
					  	<div class="form-group">
					    	<label for="password" class="sr-only">密码</label>
					    	<input type="password" class="form-control" id="password" placeholder="密码">
					    	<span class="errors pass-error"></span>
					  	</div>
					  	<button type="button" id="submit-btn" class="btn-zdy">登&nbsp;&nbsp;录</button>
					  	<div class="other">
					  		<a href="login!forgetpass.action" class="pull-left">忘记密码</a>
					  	</div>
					</form>
				</div>
			</div>
		</div>

		<h5 class='sign'>红猫分享</h5>
	</div>

	<script type="text/javascript" src="${base}/static/js/bootstrap.min.js"></script>
</body>
</html>
