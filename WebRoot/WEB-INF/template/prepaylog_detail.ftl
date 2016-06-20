<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>预付明细</title>
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
			<div class="head-tit">预付明细</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
			<dd>
				<a href="#">
					<div class="seller-box-1">
						<div class="seller-img">
							<img src="<#if shop.cover??>${shop.cover}<#else>${base}/static/images/nopic.png</#if>">
						</div>
						<div class="seller-mess">
							<h3 class="seller-name">${shop.name}</h3>
							<p class="sller-m-1">
								我的消费折扣&nbsp;:&nbsp;<span class="sller-lr"><#if shop.discount??>${shop.discount*10}折<#else>无</#if></span>
							</p>
							<p class="sller-m-1">
								我的分享奖金&nbsp;:&nbsp;<br>&nbsp&nbsp<span class="sller-lr"><#if shop.lowestback1??&&shop.highestback1??>一级${shop.lowestback1*100}%-${shop.highestback1*100}%<#else>一级无返佣</#if>,<br>
								                                  &nbsp;&nbsp;<#if shop.lowestback2??&&shop.highestback2??>二级${shop.lowestback2*100}%-${shop.highestback2*100}%<#else>二级无返佣</#if>,<br>
								                                  &nbsp;&nbsp;<#if shop.lowestback3??&&shop.highestback3??>三级${shop.lowestback3*100}%-${shop.highestback3*100}%<#else>三级无返佣</#if>
								                        </span>
							</p>
							<p class="sller-m-1">
								<#if shop.lastbackbegin1??&&shop.lastbackend1??>${shop.lastbackbegin1?number_to_datetime?string("yyyy-MM-dd ")} 至 ${shop.lastbackend1?number_to_datetime?string("yyyy-MM-dd ")}</#if>
							</p>
							<!--<p class="sller-m-2">${(shop.cuisine)!} </p>-->
						</div>
					</div>
					<div class="seller-box-3">
						<div class="s-b-2-cont1">
							<!--<div class="seller-grade">
								<div class="grade" data-grade="${(shop.point)!}"></div>
								<span>人均：&yen;${(shop.consumption)!}</span>
							</div>-->
							<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${shop.address}</p>
						</div>
					</div>
				</a>
				<div class="seller-box-4">
					<#if shopvip??><p class="yufu">余额&nbsp;:&nbsp;<span>&yen;${shopvip.money!0.0}</span></p></#if>
					<a href="recharge.action?shopid=${shop.id!}">充值</a><!--<#if shopvip??><a href="deposit.action?shopid=${shop.id!}">提现</a></#if>-->
				</div>
				<#if shopvip??>
				<#if prepayList?? && prepayList?size gt 0>
				<div class="seller-box-4">
					<#list prepayList as prepay>
					<div class="yfyh">${prepay.createdate?number_to_datetime?string("yyyy-MM-dd")}充值享受${prepay.discount*10}折 <p>剩余&nbsp;:&nbsp;<span>&yen;${prepay.money}</span></p></div>
					</#list>
				</div>
				</#if>
				</#if>
			</dd>
		</dl>
		<#if shopvip?? && list?size gt 0>
		<table class="yfd-info">
			<tbody>
				<tr>
					<th>时间</th>
					<th>金额</th>
					<th>说明</th>
				</tr>
				
				<#list list as prepaylog>
					<tr>
						<td>${prepaylog.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}</td>
						<td><#if prepaylog.isin==1><span class="yfd-add">+<#elseif prepaylog.isin==0><span class="yfd-sub">-</#if>${prepaylog.money}</span></td>
						<td><#if prepaylog.tt==0>充值享${prepaylog.discount*10}折<#elseif prepaylog.tt==-1>消费<#elseif prepaylog.tt==1>返佣
						<#elseif prepaylog.tt==2>申请提现<#elseif prepaylog.tt==3>提现成功<#elseif prepaylog.tt==4>提现失败</#if></td>
					</tr>
				</#list>
			</tbody>				
		</table>
		</#if>
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