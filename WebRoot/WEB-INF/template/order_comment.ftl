<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>评论</title>
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
		<header class="default-head" data-oid="${order.id}">
			<a href="javascript:history.go(-1)" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">评论</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>

		<dl class="sellerbox seller-mtp">
			<dd>
				<a href="#">
					<div class="seller-box-1">
						<div class="seller-img">
							<img src="${shop.cover}">
						</div>
						<div class="seller-mess">
							<h3 class="seller-name">${order.shopname}</h3>
							<div class="s-b-2-cont1">
								<div class="seller-grade">
									<div class="grade" data-grade="${(shop.point)!}"></div>
									<span>人均：&yen;${(shop.cpi)!}</span>
								</div>
								<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${shop.address}</p>
							</div>
						</div>
					</div>
				</a>
				<div class="seller-box-3">
					<div class="s-b-2-cont1">
						<div class='pj-pfbox'>
							评分:&nbsp;&nbsp;
							<div class="stars" data-val="">
			  					<i class="iconfont icon-xingxing1"></i>
			  					<i class="iconfont icon-xingxing1"></i>
			  					<i class="iconfont icon-xingxing1"></i>
			  					<i class="iconfont icon-xingxing1"></i>
			  					<i class="iconfont icon-xingxing1"></i>
			  				</div>
						</div>
					</div>
				</div>
			</dd>
		</dl>

		<textarea class="pj-text" placeholder="说说这家店，让更多小伙伴去品尝吧"></textarea>
		 <!--
		<div class="pj-scimg">
			<div class="scbox">
				<input type="file">
				<i class="iconfont icon-xiangji4"></i>
			</div>
		</div>
		-->
		<div class="default-btn">
			<a href="#" class="tjdz-link">提交</a>
		</div>
	</div>

	<script type="text/javascript" src="${base}/static/js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript" src="${base}/static/js/haoping.js"></script><!-- 好评 -->
	<script type="text/javascript" src="${base}/static/js/model.js"></script><!-- 好评 -->
	<script type="text/javascript">
		$(function(){
			//评分
			$(".grade").grade({'show':true});

			haoping('.stars');
		})
		
		$(function(){
			//评分
		//	haoping('.stars');
			$(".tjdz-link").bind("click",function(){
				if($(this).hasClass("clicked")){
					return false;
				}
				$(this).addClass("clicked");

				var parent = $(this).parent();
				var orderid =  $(".default-head").attr("data-oid");
				var point = parseInt($(".stars").attr("data-val"));
				var content = $(".pj-text").val();
				var pics = $(".scbox").val();<!--上传评价图片-->
				if(isNaN(point)){
				    point = 0;
				}
				$.ajax({
					url:"json/order!comment.action",
					type:"post",
					data:{orderid:"${order.id}",star:point,content:content,pics:pics},
					success:function(ret){
						console.log(ret);
						var dat = eval("("+ret+")");
						if(dat.success){
							$.alert("评论成功!");
							window.location.href="order!list.action";
						}
					}	
				})
			})
		})
	</script>
</body>
</html>