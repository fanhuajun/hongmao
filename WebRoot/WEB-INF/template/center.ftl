<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的</title>
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
	<div class="content">
		<header class="default-head">
			<a href="javascript:location.href='shop.action'" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<div class="cent-box1">
			<div class="cent-img">
				<img src='<#if user.pic??>${(user.pic)!}<#else>${base}/static/images/3.png</#if>'>
			</div>
			<div class="cent-cont">
			<a style="height:100%	;display:block" href="center!info.action">
				<h3 class="usr-name"><#if user.name??>${user.name}<#else>红猫用户${user.id}</#if></h3>
			</a>
				<div class="ct-1">
					可提现金额&nbsp;:&nbsp;&yen;&nbsp;<#if shopvip??>#{shopvip.backmoney;m2M2}<#else>0.00</#if>&nbsp;&nbsp;<a style="text-decoration: none" href="recharge.action">充值</a>
				</div>
			</div>
		</div>
		<ul class="cent-list">
			<li>
				<a href="user!member.action">
					<i class="iconfont icon-wodedailishang iconlist"></i>
					<div class="list-cont">我的会员<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
			<!--
			<li>
				<a href="user!seller.action">
					<i class="iconfont icon-wodedailishang iconlist"></i>
					<div class="list-cont">我的商家<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
			-->
			<li>
				<a href="order!list.action">
					<i class="iconfont icon-xiaofeimingxi iconlist"></i>
					<div class="list-cont">我的消费<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
			<li>
				<a href="income.action">
					<i class="iconfont icon-shouyi iconlist"></i>
					<div class="list-cont">我的收益<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
		</ul>
		<ul class="cent-list">
		<!--
			<li>
				<a href="user!wallet.action">
					<i class="iconfont icon-qianbao5 iconlist"></i>
					<div class="list-cont">红猫钱包<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
		-->
			<li>
				<a href="${base}/prepaylog!detail.action">
					<i class="iconfont icon-dayin1 iconlist"></i>
					<div class="list-cont">我的预付<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
			<li>
				<a href="deposit.action">
					<i class="iconfont icon-tixian1 iconlist"></i>
					<div class="list-cont">返佣提现<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
		</ul>
		<ul class="cent-list">
			<li>
				<a href="center!info.action">
					<i class="iconfont icon-yonghuziliao iconlist"></i>
					<div class="list-cont">我的资料<i class='iconfont icon-xiangyou'></i></div>
				</a>
			</li>
		</ul>
		<!--
		<#include "/WEB-INF/template/footer.ftl" />
		-->
	</div>
</body>
</html>