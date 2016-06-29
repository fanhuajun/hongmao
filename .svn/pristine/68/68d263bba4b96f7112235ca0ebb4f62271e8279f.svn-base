<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>投诉建议</title>
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

	<link rel="stylesheet" type="text/css" href="${base}/fonts/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${base}/mycompass/stylesheets/screen.css">

	<script type="text/javascript" src="${base}/js/jquery-1.8.2.min.js"></script>
</head>
<body class="header-padd">
	<div class="content" data-uid="${userid}" data-uname="${username}" data-sid="${shopid}" data-sname="${shopname}">
		<header class="default-head">
			<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">投诉建议</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<div class="jy-box" >
			<textarea class="jy-text" placeholder="请输入建议内容"  id="acontent" name="acontent" value=""></textarea>
		</div>
		<div class="default-btn">
			<a href="#"  class="dia_btn dialog_ok">提交</a>
		</div>
	</div>
	
	
	<script type="text/javascript">
	 $(function(){
	 	
	 	
	 	$(".dialog_ok").bind("click",function(){
	 		var parent = $(this).parent().parent();
	 		var userid = $(parent).attr("data-uid");
	 		var username =  $(parent).attr("data-uname");
	 		var shopis =  $(parent).attr("data-sid");
		 	var shopname =  $(parent).attr("data-sname");
			var content =  $("#acontent").val();
		 	$.ajax({
		 		url:"json/complain!complainsave.action",
	 			type:"post",
	 			data:{content:content,userid:userid,uesename:username,,shopid:shopid,shopname:shopname}
		 		success:function(html){
	 				var dat = eval("("+html+")");
	 				if(dat.success){
						$.alert("感谢您宝贵的建议！");
						window.location.href="";
					}
				}
		 	})
	 	});
	 	
	 	
	 	
	 	
	 })
    </script>
	
	
</body>
</html>