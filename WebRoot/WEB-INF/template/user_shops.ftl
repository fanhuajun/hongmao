
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的代言</title>
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
		<script type="text/javascript">
		var pn = 1;
//升序降序	
$(document).ready(function(){
	page();
	$(window).scroll(function(){
		if(uiIsPageBottom()) {
			page();
		}	
	});
});
function page(){
	$.ajax({
		url:"json/shops!mine.action",
		type:'post',
		data:{pn:pn},
		success:function(html){
			if(pn == 1){
			$(".seller-mtp").html(html);
			}else{
			$(".seller-mtp").append(html);
			}
			pn++;	
		}
	
	});
}
		
		</script>
</head>
<body class="center-padd">
	<div class="content">
		<header class="default-head">
			<a href="javascript:history.go(-1);" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的代言</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
		</dl>

		<#include "/WEB-INF/template/footer.ftl" />
		
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