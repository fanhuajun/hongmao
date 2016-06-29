<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>钱包提现</title>
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
			<div class="head-tit">返佣提现</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<div class="tx-box">
			<p class="tx-total">可提现金额&nbsp;:&nbsp;<span>&yen;#{limit;m2M2}</span><a href="deposit!details.action">提现明细</a></p>
			<form action="deposit!apply.action" method="post">
			<div class="tx-list tx-marg">
				<span class="txtit">提现方式&nbsp;:&nbsp;</span>
				<div class="tx-cont">
					<label class="txfs-lab">
						<input type="radio" name="deposittype" value="weixin" checked="checked" class="txfsipt" id="wxipt"><i class="iconfont icon-duigou"></i>微信钱包
					</label>
					<label class="txfs-lab">
						<input type="radio" name="deposittype" value="card" class="txfsipt"><i class="iconfont icon-duigou" id="bankipt"></i>银行卡
					</label>
				</div>
			</div>
		
			<div class="tx-group">
				<div class="tx-g-list">
					<span class="txtit">提现金额&nbsp;:&nbsp;</span>
					<div class="tx-container">
						<input data-limit="#{limit;m2M2}" id="total" type='text' class="tx-g-ipt" value="#{limit;m2M2}" placeholder="请填写提现金额" disabled="disabled" />
					</div>
				</div>
				<div class="tx-g-list">
					<span class="txtit">真实姓名&nbsp;:&nbsp;</span>
					<div class="tx-container">
						<input id="tureName" name="name" type='text' class="tx-g-ipt" placeholder="请填写真实姓名">
					</div>
				</div>
				
				<div class="tx-g-list wx"  >
					<span class="txtit">微信帐号&nbsp;:&nbsp;</span>
					<div class="tx-container">
						<input type='text' id="wxname" name="wxname" class="tx-g-ipt" placeholder="请填写微信号">
					</div>
				</div>
				<div class="tx-g-list bank" >
					<span class="txtit">银行卡号&nbsp;:&nbsp;</span>
					<div class="tx-container">
						<input type='text'  name="card"  class="tx-g-ipt" placeholder="请填写银行卡号">
					</div>
				</div>
				<div class="tx-g-list bank" >
					<span class="txtit">银行信息&nbsp;:&nbsp;</span>
					<div class="tx-container">
						<input type='text' name="bankName" class="tx-g-ipt" placeholder="请填写如:工商银行xx支行">
					</div>
				</div>
				<input type="hidden" name="phone" value="${phone!}"/>
				<input type="hidden" name="shopid" value="${shopid!}"/>
			</div>
		</div>
		</form>
		<div class="default-btn">
			<a href="javascript:;" class='tx-btn'>提现</a>
		</div>
	</div>

	<div class="modal">
		<h3 class="modal-text">本次操作需要短信确认，验证码已发送至手机:${encryptPhone!}，请按提示操作。</h3>
		<div class="modal-ipt">
			<input type="text" placeholder="请填写验证码" class="yzmtext" maxlength="6" id="validateCode">
			<input type="button" class="yzmbtn" value="获取验证码" id="identifying-btn" data-phone="${phone!}">
		</div>
		<div class="modal-btns">
			<a href="#" class="confirmbtn" id="confirmbtn">确定</a>
			<a href="#" class="cancelbtn">取消</a>
		</div>
	</div>
	<div class="modal-overlay"></div>

	
	<script type="text/javascript" src="${base}/static/js/send-identifyingcode.js"></script>
	<script type="text/javascript">
		$(function(){
			$('.bank').css({display:'none'});
			$('.wx').css({display:'block'});
			//提现方式切换
			$(document).on('click','.txfsipt',function(){
				if($('#wxipt').is(':checked')){
					$('.bank').css({display:'none'});
					$('.wx').css({display:'block'});
				}else{
					$('.wx').css({display:'none'});
					$('.bank').css({display:'block'});
				}
			});
			
			$(document).on('keyup','#total',function(){
				var total = $(this).val();
				var limit = $(this).attr('data-limit')
				var reg = /^[0-9]*[1-9][0-9]*$/;
				if(!reg.test(total)) {
					$(this).val("");
				}
				if(parseFloat(total) > parseFloat(limit)) {
					$(this).val(limit);
				}
				
				
			});
			
			$(document).on('click','#confirmbtn',function(){
				var phone = $('#identifying-btn').attr('data-phone');
				var code = $('#validateCode').val();
				
				
				$.ajax({
					url : 'json/deposit!checkValidateCode.action',
					type : 'post',
					dataType : 'json',
					data : {phone : phone,code : code},
					success : function(data) {
						if(data.success) {
							$('form').submit();
						}else {
							alert(data.msg);
						}
					}
				});
			});
			
			//打开弹出层
			$(document).on('click','.tx-btn',function(){
			    var wxname = $('#wxname').val();
				var tureName = $('#tureName').val();
				if(tureName==""){
				   alert("真实姓名不能为空");return;
				}
				if(wxname==""){
				   alert("微信账号不能为空");return;
				}
				$('.modal').css('display','block');
				$('.modal-overlay').addClass('modal-overlay-visible');
			});
			//关闭弹出层
			$(document).on('click','.cancelbtn',function(){
				$('.modal').css('display','none');
				$('.modal-overlay').removeClass('modal-overlay-visible');
			});

			//发送验证码
			$(document).on('click','#identifying-btn',function(){
				var phone = $(this).attr('data-phone');
				$.ajax({
					url : 'json/deposit!sendValidateCode.action',
					type : 'post',
					dataType : 'json',
					data : {phone : phone},
					success : function(data) {
						if(data.success) {
							sendMessage();
						}
					}
				});
				
			});
		})
	</script>
</body>
</html>