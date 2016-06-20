<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改用户名</title>
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
		<a href="center!info.action" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
		<div class="head-tit">修改用户名</div>
		<a href="#" class="head-right">确定</a>
	</header>

	<div class="content">
		<ul class="alter-box">
			<li>
				<input type="text" placeholder="请输入用户名" id="name" value="${username}">
			</li>
		</ul>
	</div>
</body>
<script>

$(document).on('click','.head-right',function(){
    var username = $("#name").val();
    $.ajax({
        url:'json/user!altername.action',
        type:'post',
        dataType:'json',
        data:{username: username},
        success:function(json){
        
           if(json.success){
              location.href = 'center!info.action';
           }
        }
    
    })
})

</script>



</html>