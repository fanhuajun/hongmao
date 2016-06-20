<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>钱包充值</title>
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
			<div class="head-tit">钱包充值</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>
		<#if shop??>
		<dl class="sellerbox seller-mtp">
			<dd>
				<a href="#">
					<div class="seller-box-1">
						<div class="seller-img">
							<img src="${shop.cover!}">
						</div>
						<div class="seller-mess">
							<h3 class="seller-name">${shop.name!} </h3>
							<div class="s-b-2-cont1">
								<div class="seller-grade">
									<div class="grade" data-grade="${shop.point!}"></div>
									<span>人均：&yen;${shop.cpi!}</span>
								</div>
								<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${shop.address!}</p>
							</div>
						</div>
					</div>
				</a>
			</dd>
		</dl>
		</#if>
		<div class="yhd-1">
			<#if shop??><p class="rcg-tit">充值后使用预付款可享受${shop.discount*10}折优惠</p></#if>
			<label class="lb1">
				<span class="tit">充值金额:</span>
				<input type="number" id="money" placeholder="请输入充值金额">
			</label>
		</div>
		
		<div class="default-btn">
			<a href="#" id="rechargeBtn">充值</a>
		</div>
	</div>

	<script type="text/javascript" src="js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript">
		$(function(){
			//评分
			$(".grade").grade({'show':false});
		})
		
		$(document).on('click','#rechargeBtn',function(){
			var shopid = "";
			<#if shop??>shopid = "${shop.id!}";</#if>
			var money = $('#money').val();
			window.location.href = "recharge!pay.action?money="+ money +"&shopid=" + shopid
		});
	</script>
</body>
</html>