<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>绑定手机号</title>
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

	<script type="text/javascript" src="${base}/static/js/jquery-1.8.2.min.js"></script>
</head>
<body class="center-padd">
	<header class="default-head">
		<a href="javascript:history.go(-1)" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
		<div class="head-tit">绑定手机号</div>
		<a href="#" class="head-right"></a>
	</header>

	<div class="content">
		<ul class="alter-box">
			<li>
				<input type="text" id="phone" class="teltext" placeholder="输入新手机号码">
				<input type="button" id="identifying-btn" value="获取验证码">
			</li>
			<li>
				<input type="text" id="phonecode" placeholder="请输入验证码">
			</li>
		</ul>

		<div class="default-btn">
			<a href="javascript:;" class='tx-btn' onclick="update()" id="tx-btn">提交</a>
		</div>
	</div>

	<script type="text/javascript" src="${base}/static/js/model.js"></script>
	<script type="text/javascript" src="${base}/static/js/send-identifyingcode.js"></script>
	<script type="text/javascript">
	   //发送验证码
    $(function(){
    	$(document).on('click','#identifying-btn',function(){
    		var phone=$.trim($("#phone").val());
    		if(!phone.match(/^1[0-9]{2}\d{8}$/)){
    		     $.alert("电话号码格式错误"); return;
    		}
    		
			$.ajax({
				url:"json/user!checkPhone.action",
                data:{phoneNew: phone},
				success:function(html){
					var json = eval("("+html+")");
				    if(json.success){
						sendMessage();
						flag = false;		
					}else{
					   $.alert(json.msg);
					   return;
					}
				}, 
				error:function(html){
					$.alert('未知错误!');
				}
				
			})
    	})
    })
    
    //改变手机
        function update(){
		var phone=$.trim($("#phone").val());
		var phonecode=$("#phonecode").val();
		
		if(!phone.match(/^1[0-9]{2}\d{8}$/)){
    		 $.alert("电话号码格式错误"); return;
    		}
        if(!phonecode.match(/^\d{4}$/)){
             $.alert("验证码错误");return;
        }
        
		$.ajax({
			url:"json/user!changephone.action",
			type:"post",
			data:{"phoneNew":phone,"code":phonecode},
			dataType:'json',
			success:function(data){
				if(data.success){
					window.location.href = 'center!info.action'
				}else{
					alert(data.msg);
				}
			}
		})
	}
		
	</script>
</body>
</html>