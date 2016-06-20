<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的消费</title>
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
			<a href="javascript:history.go(-1);" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的消费</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
			<#if list ??><!--判断有没完成的单-->
				<#list list as order>
					<dd>
						<div class="csm-1">
							<a href="#">${order.shopname}</a>
							<div class="csm-grd grade" data-grade="${order.shopstar}"></div>
						</div>
						<div class="seller-box-1">
							<div class="seller-img">
								<img src="images/shopd.png">
							</div>
							<div class="seller-mess">
								<p class="csm-p1">${order.paydate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}</p>
								<p class="csm-p1">原价&nbsp;:&nbsp;&yen;${order.sourcemoney}</p>
								<p class="csm-p1">实付金额&nbsp;:&nbsp;<span>&yen;${order.money}</span></p>
								<#if order.stat==1><a href="order!comment.action?id=${order.id}" class="csm-pj">去评价</a></#if>
							</div>
						</div>
						<div class="seller-box-3">
							<div class="s-b-2-cont1">
								<p class="csm-p2">商铺预存消耗&nbsp;:&nbsp;<strong>&yen;${order.shopmoney}&nbsp;</strong><s>(原价&nbsp;:&nbsp;&yen;${order.sourcemoney})</s></p>
							</div>
						</div>
					</dd>
				</#list>
			<#else><!--如果没有完成的订单则显示-->
				<dd>
					暂无完成订单
			</#if>
		
		</dl>
	</div>

	<script type="text/javascript" src="${base}/static/js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript">
		$(function(){
			//评分
			$(".grade").grade({'show':false});
		})
	</script>
</body>
</html>