<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>解除绑定</title>
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
		<div class="head-tit">解除绑定</div>
		<a href="#" class="head-right"></a>
	</header>

	<div class="content">
		<ul class="alter-box">
			<li>
				<input type="text" placeholder="请输入电话号码" value="${(phoneOld)!}">
			</li>
			<li>
				<input type="text" id="vcode" placeholder="请输入右边的验证码">
				<div id="vcode-area"></div>
			</li>
		</ul>

		<div class="default-btn">
			<a href="javascript:void(0);" class='tx-btn' id="tx-btn">下一步</a>
		</div>
	</div>

	<script type="text/javascript" src="${base}/static/js/model.js"></script>
	<script type="text/javascript" src="${base}/static/js/vCode.js"></script>
	<script type="text/javascript">
	
		onload = function () {
            var vcode = document.getElementById("vcode-area");
            var code1 = new vCode(vcode);

            document.getElementById("tx-btn").addEventListener("click", function () {
            	var val=document.getElementById("vcode").value;
            	val=val.toLowerCase();
                var codeval=code1.verify(val);

                if(codeval==true){
                	location.href = "center!alterphone2.action";
                }else{
                	$.alert("验证码错误")
                }
            }, false);
        };
     
	</script>
</body>
</html>