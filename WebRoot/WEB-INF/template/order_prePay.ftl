<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>支付</title>
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
	<style>
	#note{
	       background-color: #ebebe4;
	   border: 0;
	   outline: none;
	   font-size: 0.24rem;
	   width:7rem;
	   height:1rem;
	}
	</style>

	<script type="text/javascript" src="${base}/static/js/jquery-1.8.2.min.js"></script>
</head>
<body class="header-padd">
	<div class="content">
		<header class="default-head">
			<a href="javascript:history.go(-1);" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">支付</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>
	<form action="order!create.action" method="post">
		<div class="yhd-1">
			<label class="lb1">
				<span class="tit">参与活动金额:</span>
				<input id="total_1" type="number" name="dicountmoney" placeholder="询问商家后输入">
			</label>
			<label class='lb2'>
				<input type="checkbox" class="bcy">
				<i class="iconfont icon-dui1"></i>不参与活动金额
			</label>
			<label class="lb1 bcytext">
				<span class="tit">不参与活动金额:</span>
				<input id="total_2" type="number" name="paymoney" placeholder="询问商家后输入" disabled="disabled">
			</label>
		</div>
		
		<dl class="yhd-2">
			<!--<dd>红猫钱包 <span>剩余&nbsp;&yen;${user.money}</span></dd>-->
			<dd>
				<p>预付款<span>剩余&nbsp;&yen;${total!0}</span></p>
				<#if list?? && list?size gt 0>
				<#list list as prePay>
				<p class="p2 prepay" data-id="${prePay.id}" data-money="${prePay.money}" data-discount="${prePay.discount}">${prePay.createdate?number_to_datetime?string("yyyy-MM-dd")}充值享${prePay.discount*10}折<span>剩余&nbsp;&yen;${prePay.money}</span></p>
				</#list>
				</#if>
			</dd>
			<dd>消费总额 <span id="total">&nbsp;&yen;0</span></dd>
			<dd>实付金额 <span id="pay">&nbsp;&yen;0</span></dd>
			<dd><div>支付备注</div><textarea name="note" id="note" type="text" placeholder="请输入备注"></textarea></dd>
		</dl>
		<input type="hidden" id="consumeJson" name="consumeJson"/>
		<input type="hidden" id="sourcemoney" name="sourcemoney"/>
		<input type="hidden" id="money" name="money"/>
		<input type="hidden" id="shopmoney" name="shopmoney"/>
		<div class="default-btn">
			<a href="#" id="confirmBtn">&yen;0&nbsp;确认支付</a>
		</div>
		</form>
	</div>

	<script type="text/javascript">
		$(function(){
			$(document).on('click','.bcy',function(){
				var _this=$(this);
				if(_this.is(':checked')){
					$('.bcytext').css({'background-color':'#fff'}).find('input').removeAttr('disabled');
				}else{
					$('.bcytext').css({'background-color':'#ebebe4'}).find('input').attr('disabled','disabled').val("");
				}
			})
			
			$(document).on('blur','input',function(){
				var total = 0;
				var webPrepay = parseFloat("${user.money!0}");
				
				var total_1 = parseFloat($('#total_1').val());
				if(!isNaN(total_1)){
					total = total + total_1;
				}else {
					total_1 = 0;
				}
				var total_2 = parseFloat($('#total_2').val());
				if(!isNaN(total_2)) {
					total = total + total_2;
				}else {
					total_2 = 0;
				}
				
				var pay = total_1;
				var consumeList = [];
				var shopmoney = 0;
				var webmoney = 0;
				$('.p2').each(function(){
					var money = parseFloat($(this).attr('data-money'));
					var discount = parseFloat($(this).attr('data-discount'));
					var id = $(this).attr('data-id');
					var consume = {};
					consume.id = id;
					consume.discount = discount;
					if(pay - money/discount >= 0) {
						consume.id = id;
						consume.money = money;
						consumeList.push(consume);
						shopmoney += money;
						pay = pay - money/discount;
					}else {
						consume.id = id;
						consume.money = pay*discount;
						consumeList.push(consume);
						shopmoney += pay*discount;
						pay = 0;
						return false;
					}
				});
				if(pay != 0 && webPrepay != 0) {

					var consume = {};
					if(pay - webPrepay > 0) {
						consume.money = webPrepay;
						webmoney = webPrepay;
						pay = pay - webPrepay;
					}else {
						
						consume.money = pay;
						webmoney = pay;
						pay = 0;
					}
					consumeList.push(consume);
				}
				
				var realPay = total_2 + pay;
				var realPayShow = Math.round(realPay*100)/100;
				$('#total').html('&nbsp;&yen;' + total);
				$('#sourcemoney').val(total);
				$('#pay').html('&nbsp;&yen;' + realPayShow);
				$('#money').val(realPay);
				$('#shopmoney').val(shopmoney);
				$('#webmoney').val(webmoney);
				$('#confirmBtn').html('&yen;' + realPayShow + '&nbsp;确认订单');
				$('#consumeJson').val(JSON.stringify(consumeList));
			});
			
			
			$(document).on('click','#confirmBtn',function(){
				//alert($('#consumeJson').val());
				$('form').submit();
			});
		})
	</script>
</body>
</html>