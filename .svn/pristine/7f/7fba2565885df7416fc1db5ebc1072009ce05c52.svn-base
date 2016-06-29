<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>商品详情</title>
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
<body class='center-padd'>
	<header class="default-head">
		<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
		<div class="head-tit">查找商家</div>
		<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
	</header>
	
	<div class="content">
		<div class="search-box">
			<div class="search-area">
				<div class="key">
					<bottom class="mkey"><i class="iconfont icon-shangjiadizhi"></i><span class="keytext">龙华区</span></bottom>
					<ul class="keyul">
						<li>龙华新区</li>
						<li>宝安区</li>
						<li>龙岗区</li>
						<li>罗湖区</li>
						<li>福田区</li>
						<li>南山区</li>
					</ul>
				</div>
				<input type="text" class="searchtext" placeholder='输入关键字...'>
			</div>
		</div>
	</div>

	<div class="default-btn">
		<a id="searchBtn"  href="#">搜索</a>
	</div>
	
	
	<nav class="nav-menu">
		<a href="#">
			<i class="iconfont icon-shouye2"></i>
			<span class="labl">首页</span>
		</a>
		<a href="#" class="active">
			<i class="iconfont icon-chazhao1"></i>
			<span class="labl">商家搜索</span>
		</a>
		<a href="${base}/center.action">
			<i class="iconfont icon-dailiqudaoguanli"></i>
			<span class="labl">我的代言</span>
		</a>
		<a href="#">
			<i class="iconfont icon-wode2"></i>
			<span class="labl">我的</span>
		</a>
	</nav>
	<script type="text/javascript">
		$(function(){
			$(document).on('click','.mkey',function(){
				$('.keyul').show();

				$('.keyul li').click(function(){
					var keyval=$(this).text();
					$('.keytext').text(keyval);
					$('.keyul').hide();
				})
			})
		})
		
	</script>
</body>
</html>