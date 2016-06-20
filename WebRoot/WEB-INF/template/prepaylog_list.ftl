<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的预付</title>
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
			<a href="javascript:history.go(-1)" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的预付</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
		
			<#list list as shopvip>
				<dd>
					<a href="#">
							<div class="seller-box-1">
								<#list shoplist as shop>
								<#if shopvip.shopid==shop.id><!--判断-->
									<div class="seller-img">
										<img src="<#if shopvip.shoppic??>${shopvip.shoppic}<#else>${base}/static/images/nopic.png</#if>">
									</div>
									<div class="seller-mess">
										<h3 class="seller-name">${(shopvip.shopname)!} <span class="seller-range">66.5km</span></h3>
										<p class="sller-m-1">
											我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">${(shop.discount)!}折</span>
										</p>
										<p class="sller-m-1">
											我的分享奖金&nbsp;:&nbsp;<span class="sller-lr">一级${shop.lowestback1}%~${shop.highestback1}%, 二级${shop.lowestback2}%~${shop.highestback2}%, <br>三级${shop.lowestback3}%~${shop.highestback3}%</span>
										</p>
										<p class="sller-m-1">
											(${(shop.lastbackbegin1?number_to_datetime?string("yyyy/MM/dd "))!} 至 ${(shop.lastbackend1?number_to_datetime?string("yyyy/MM/dd "))!})
										</p>
									<p class="sller-m-2">${(shop.cuisine)!} <!--<span class="seller-sq">${shop.circlename}</span>--></p>
								</div>
							</div>
							<div class="seller-box-3">
								<div class="s-b-2-cont1">
									<div class="seller-grade">
										<div class="grade" data-grade="${(shop.point)!}"></div>
										<span>人均：&yen;${(shop.consumption)!}</span>
									</div>
									<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${shop.address}</p>
								</div>
							</div>
						</#if>
						</#list><!--shoplist 结束-->
					</a>
					<div class="seller-box-4">
						<p class="yufu">预付&nbsp;:&nbsp;<span>&yen;${shopvip.money}</span></p>
						<a href="${base}/prepaylog!detail.action?shopid=${shopvip.shopid}&&shopvipid=${shopvip.id}">预付明细</a>
					</div>
					<div class="seller-box-4">
						<#list prelist as pre>
						<#if shopvip.shopid==pre.shopid>
						<div class="yfyh">${pre.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}充值享受${(pre.discount)!}折 <p>剩余&nbsp;:&nbsp;<span>&yen;${pre.restmoney}</span></p></div>
						</#if>
						</#list>
					</div>
				</dd>
			</#list>
			
			
			
		</dl>
	</div>

	<script type="text/javascript" src="${base}/static/js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript">
		$(function(){
			//评分
			$(".grade").grade({'show':true});
		})
	</script>
</body>
</html>