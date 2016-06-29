<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>支付订单</title>
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
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="http://mp.weixin.qq.com/debug/zh_CN/htmledition/js/jsapisign/sha121d415.js"></script>
	<script>
		var jsapi_ticket = '${ticket!}';
		var appId = '${appId!}'; 
		var timestamp = '1';
		var nonceStr = '5K8264ILTKCH16CQ2502SI8ZNMTM67VS';
		var theUrl = document.URL;
		var string1 = 'jsapi_ticket=' + jsapi_ticket + '&noncestr=' + nonceStr + '&timestamp=' + timestamp + '&url=' + theUrl; 
		var signature = new jsSHA(string1,"TEXT"); //签名算法
			signature = signature.getHash("SHA-1","HEX");
		var jsApiList = ['chooseWXPay'];
		//通过config接口注入权限验证配置
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: appId, // 必填，公众号的唯一标识
		    timestamp: timestamp, // 必填，生成签名的时间戳
		    nonceStr: nonceStr, // 必填，生成签名的随机串
		    signature: signature, // 必填，签名，见附录1
		    jsApiList: jsApiList // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
		
			function wxpay(data){
				wx.chooseWXPay({
					appId: appId,
				    timestamp: '1', // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
				    nonceStr: '5K8264ILTKCH16CQ2502SI8ZNMTM67VS', // 支付签名随机串，不长于 32 位
				    package: 'prepay_id='+data.preid, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
				    signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
				    paySign: data.paySign, // 支付签名
				    success: function (res) {
			    		window.location.href="pay!ok.action?orderid=" + data.oid;
		
				    },
				    fail:function(res){
				    	alert("支付失败");
				    },
				    cancel:function(res){
				    	alert("用户取消订单");
				    }
				});
				
			}
	</script>
</head>
<body class="header-padd">
	<div class="content">
		<header class="default-head">
			<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">支付订单</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<div class='pay-ord'>
			<p>订单商家&nbsp;:&nbsp;${shopName}</p>
			<p>订单金额&nbsp;:&nbsp;<span class="p-o-mony">&yen;${money}</span></p>
		</div>

		<dl class="pay-mode">
			<dd>
				<label for='pay-weixin'>
					<i class="iconfont icon-weixin2 wx"></i>微信支付
				</label>
				<input type="radio" id="pay-weixin" checked="checked" name="paymode">
				<i class="iconfont icon-wancheng"></i>
			</dd>
			<!-- <dd>
				<label for='pay-weixin'>
					<i class="iconfont icon-yinlian1 yl"></i>银联支付
				</label>
				<input type="radio" id="pay-weixin" name="paymode">
				<i class="iconfont icon-wancheng"></i>
			</dd> -->
		</dl>

		<div class="default-btn">
			<a href="#" id="confirm">确认支付</a>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	$(document).on('click','#confirm',function(){
		var orderid = "${orderid!}";
		$.ajax({
			url : 'json/pay.action',
			type : 'post',
			dataType : 'json',
			data:{orderid : orderid},
			success : function(data){
				if(data.success) {
					wxpay(data);
				}else {
					alert(data.msg);
				}
			}
		});
		
	});

</script>