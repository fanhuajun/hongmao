<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>红猫钱包</title>
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
			<a href="center.action" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">红猫钱包</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>
		
		<div class="wlt-box">
			<h3 class="total">
				金额<p>${totalmoney}<small>元</small></p>
			</h3>
			<div class="wlt-nav">
				<a href="recharge.action">充值</a>
				<a href="deposit.action">提现</a>
			</div>
		</div>
		<table class="yfd-info">
			<tbody>
				<tr>
					<th>时间</th>
					<th>金额</th>
					<th>说明</th>
				</tr>
		  <#if list??&&list?size gt 0>
		      <#list list as item>		
				<tr>
					<td>${item.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}</td>
					<td>
					    <#if item.isin==0>
					    <span class="yfd-sub"> -
					    <#elseif item.isin==1>
					     <span class="yfd-add"> +
					    </#if>
					           ${item.money}
					    </span>
					</td>
					<td><#if item.tt==0>
					               充值
					    <#elseif item.tt==-1>
					              消费
					    <#elseif item.tt==1>
					             返佣
					    <#elseif item.tt==2>
					            提现
					    </#if>
					</td>
				</tr>
			   </#list>
		  </#if>
			</tbody>				
		</table>
	</div>
</body>
</html>