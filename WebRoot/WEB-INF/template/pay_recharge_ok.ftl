<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>支付成功</title>
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
<body class="header-padd">
	<div class="content">
		<header class="default-head">
			<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">充值成功</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<div class="pay-ok">
			<h2 class="p-o-tit"><i class="iconfont icon-dui1"></i>充值成功</h2>
			<div class="pay-o-info">
				<h3>充值信息</h3>
				<div class="p-o-i-cont">
					<p><span class='p-o-i-tit'>流水号&nbsp;:&nbsp;</span>${prepay.id!}</p>
					<p><span class='p-o-i-tit'>充值金额&nbsp;:&nbsp;</span>&yen;${prepay.money!}</p>
					<p><span class='p-o-i-tit'>充值时间&nbsp;:&nbsp;</span>${prepay.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</p>
				</div>
			</div>
		</div>

		<div class="default-btn">
			<#if prepay.shopid??>
			<a href="prepaylog!detail.action?shopid=${prepay.shopid!}">返回</a>
			<#else>
			<a href="user!wallet.action">返回</a>
			</#if>
		</div>
	</div>
</body>
</html>