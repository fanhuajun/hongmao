
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
			<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的预付</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
			<dd>
				<a href="#">
					<div class="seller-box-1">
						<div class="seller-img">
							<img src="images/shopd.png">
						</div>
						<div class="seller-mess">
							<h3 class="seller-name">厨先生厨先生厨先生厨先 <span class="seller-range">66.5km</span></h3>
							<p class="sller-m-1">
								我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">7折</span>
							</p>
							<p class="sller-m-1">
								我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">一级4%&nbsp;,&nbsp;二级5%</span>
							</p>
							<p class="sller-m-1">
								(2015-12-12 至 2015-12-12)
							</p>
							<p class="sller-m-2">湘菜 <span class="seller-sq">龙华商业圈</span></p>
						</div>
					</div>
					<div class="seller-box-3">
						<div class="s-b-2-cont1">
							<div class="seller-grade">
								<div class="grade" data-grade="4"></div>
								<span>人均：&yen;60</span>
							</div>
							<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区</p>
						</div>
					</div>
				</a>
				<div class="seller-box-4">
					<p class="yufu">预付&nbsp;:&nbsp;<span>&yen;88.00</span></p>
					<a href="#">预付明细</a>
				</div>
				<div class="seller-box-4">
					<div class="yfyh">2015-12-12充值享受6折 <p>剩余&nbsp;:&nbsp;<span>&yen;88.00</span></p></div>
					<div class="yfyh">2015-12-12充值享受6折 <p>剩余&nbsp;:&nbsp;<span>&yen;88.00</span></p></div>
				</div>
			</dd>
			<dd>
				<a href="#">
					<div class="seller-box-1">
						<div class="seller-img">
							<img src="images/shopd.png">
						</div>
						<div class="seller-mess">
							<h3 class="seller-name">厨先生厨先生厨先生厨先 <span class="seller-range">66.5km</span></h3>
							<p class="sller-m-1">
								我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">7折</span>
							</p>
							<p class="sller-m-1">
								我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">一级4%&nbsp;,&nbsp;二级5%</span>
							</p>
							<p class="sller-m-1">
								(2015-12-12 至 2015-12-12)
							</p>
							<p class="sller-m-2">湘菜 <span class="seller-sq">龙华商业圈</span></p>
						</div>
					</div>
					<div class="seller-box-3">
						<div class="s-b-2-cont1">
							<div class="seller-grade">
								<div class="grade" data-grade="4"></div>
								<span>人均：&yen;60</span>
							</div>
							<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区深圳市宝安区</p>
						</div>
					</div>
				</a>
				<div class="seller-box-4">
					<p class="yufu">预付&nbsp;:&nbsp;<span>&yen;88.00</span></p>
					<a href="#">预付明细</a>
				</div>
				<div class="seller-box-4">
					<div class="yfyh">2015-12-12充值享受6折 <p>剩余&nbsp;:&nbsp;<span>&yen;88.00</span></p></div>
					<div class="yfyh">2015-12-12充值享受6折 <p>剩余&nbsp;:&nbsp;<span>&yen;88.00</span></p></div>
				</div>
			</dd>
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