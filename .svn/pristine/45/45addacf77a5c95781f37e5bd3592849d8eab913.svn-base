<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>商家列表</title>
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
	<script type="text/javascript" src="${base}/static/js/basis.js"></script>
</head>
<body class="seller-padd">
	<div class="content">
		<header class="default-head">
			<a href="#" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">商家列表</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>
		
		<div class="seller-menu">
			<a href="javascript:;" data-nav="category" class="seller-list" id="nowcategory">全部分类 <i class="iconfont icon-xialaxiangxia"></i></a>
			<a href="javascript:;" data-nav="biz" class="seller-list" id="nowplace">全城 <i class="iconfont icon-xialaxiangxia"></i></a>
			<a href="javascript:;" data-nav="sort" class="seller-list" id="nowsort">智能排序 <i class="iconfont icon-xialaxiangxia"></i></a>
		</div>

		<div class="dropdown-wrapper" id="dropdown-wrapper">
			<div class="category-wrapper" id="category-wrapper">
				<ul class="category-1">
					<#list categories as category>
					<li class="jrdy" data-id="${category.id}">${category.name}</li>
					</#list>
				</ul>
				<ul class="category-2">
					
				</ul>
			</div>
			<div class="biz-wrapper" id="biz-wrapper">
				<ul class="biz-1">
					<#list areas as area>
					<li data-id="${area.id}">${area.name}</li>
					</#list>
				</ul>
				<ul class="biz-2">
				</ul>
			</div>
			<div class="sort-wrapper" id="sort-wrapper">
				<ul class="sort-1">
					<li data-sort="dd">智能排序</li>
					<li data-sort="near">离我最近</li>
					<li data-sort="point">评价最高</li>
					<li data-sort="moneylow">人均最低</li>
					<li data-sort="moneyhigh">人均最高</li>
				</ul>
			</div>
		</div>

		<dl class="sellerbox seller-mtp">
		</dl>

		<#include "/WEB-INF/template/footer.ftl" />
	</div>

	
	<!-- <div class="pop pop-visible"></div> -->
	<script type="text/javascript" src="${base}/static/js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript" src="${base}/static/js/classify.js"></script><!-- 分类 -->
	<script type="text/javascript" src="${base}/static/js/model.js"></script><!-- 弹出框 -->
	<script type="text/javascript" src="${base}/static/js/list.js"></script><!-- 弹出框 -->
	<script type="text/javascript">
		var EARTH_RADIUS = 6378137.0; //单位M 
		var PI = Math.PI; 	
		var mylng=0;
		var mylat=0;
		var lng_lat = "${long_lat}";
		var lng_lat_array = lng_lat.split(",");
		mylng = lng_lat_array[0];
		mylat = lng_lat_array[1];
		$(function(){
			//评分
			$(".grade").grade({'show':true});			
		});
		function getRad(d){ 
			return d*PI/180.0; 
		} 
		function getGreatCircleDistance(lat1,lng1,lat2,lng2){ 
			var radLat1 = getRad(lat1); 
			var radLat2 = getRad(lat2); 
			
			var a = radLat1 - radLat2; 
			var b = getRad(lng1) - getRad(lng2); 
			
			var s = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))); 
			s = s*EARTH_RADIUS; 
			s = Math.round(s*10000)/10000.0; 
			return s; 
		} 
	</script>
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
var circleid = $(".biz-2 li.selected").attr("data-id");
var areaid = null;
var oneid = null;
var twoid = $(".category-2 li.selected").attr("data-id");
if(circleid == null || circleid ==0){
	 circleid = null;
	 area = $(".biz-1 li.selected").attr("data-id");
}
if(twoid == null || twoid ==0){
	 twoid = null;
	 oneid = $(".category-1 li.selected").attr("data-id");
}
	var sort = $(".sort-1 li.selected").attr("data-sort");
	$.ajax({
		url:"json/shops.action",
		type:'post',
		data:{keyword:"${keyword!}",oneid:oneid,twoid:twoid,areaid:areaid,circleid:circleid,pn:pn,sort:sort},
		success:function(html){
			if(pn == 1){
			$(".seller-mtp").html(html);
			}else{
			$(".seller-mtp").append(html);
			}
			pn++;	
			sellerRange();
		}
	
	});
}
$(document).on('click','.category-2 li', function () {
	$(this).addClass("selected").siblings().removeClass("selected");
	if($(this).attr("data-id")==0){
		$("#nowcategory").html($(".category-1 li.selected").html());
	}else{
		$("#nowcategory").html($(this).find("a").html());
	}
	$("#nowcategory").trigger("click")
	pn=1;
	page();
});
$(document).on('click','.biz-2 li', function () {
	$(this).addClass("selected").siblings().removeClass("selected");
	if($(this).attr("data-id")==0){
		$("#nowplace").html($(".biz-1 li.selected").html());
	}else{
		$("#nowplace").html($(this).html());
	}
	$("#nowplace").trigger("click");
	pn=1;
	page();
});
$(document).on('click','.sort-1>li', function () {
$(this).addClass("selected").siblings().removeClass("selected");
	$("#nowsort").html($(".sort-1 li.selected").html());
	$("#nowsort").trigger("click");
	pn=1;
	page();
});
function sellerRange(){
	var seller_ranges = $(".seller-range");
	var ll = seller_ranges.length;
	for(var i=0;i<ll;i++){
		var lng = $(seller_ranges[i]).attr("data-lng");
		var lat = $(seller_ranges[i]).attr("data-lat");
		var distance = getGreatCircleDistance(lat,lng,mylat,mylng);
		$(seller_ranges[i]).html(formatDistance(distance));
	}
	
}
function formatDistance(source){
	if(source < 1000){
		return Math.ceil(source) + "m";
	}else{
		return Math.ceil(source/1000) + "KM";
	}
	
}



</script>
</body>
</html>