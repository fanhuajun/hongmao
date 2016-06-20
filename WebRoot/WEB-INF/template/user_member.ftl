
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的会员</title>
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
		<script type="text/javascript" src="${base}/static/js/list.js"></script>
	<script type="text/javascript">
		var pn1 = 1;
		var pn2 = 1;
		var pn3 = 1;
//升序降序	
$(document).ready(function(){
	page(1);
	$(window).scroll(function(){
		if(uiIsPageBottom()) {
			var level = 1;
			var nowid = $(".tab-link.active").attr("id");
			if(nowid == "level2"){
				level = 2;
			}else if(nowid == "level3"){
				level = 3;
			}
			page(level);
		}	
	});
	$("#level2").bind("click",function(){
		page(2);
	})
	$("#level3").bind("click",function(){
		page(3);
	})
});
function page(level){
var nowpn = pn1;
if(level==2){
	nowpn=pn2;
}else if(level==3){
	nowpn=pn3;
}
	$.ajax({
		url:"json/member!list.action",
		type:'post',
		data:{pn:nowpn,level:level},
		success:function(html){
			if(level==1){
				if(pn1==1){
					$("#tb1").html(html);
				}else{
					$("#tb1").append(html);
				}
				pn1++;
			}else if(level==2){
				if(pn2==1){
					$("#tb2").html(html);
				}else{
					$("#tb2").append(html);
				}
				pn2++;
			}else if(level==3){
				if(pn3==1){
					$("#tb3").html(html);
				}else{
					$("#tb3").append(html);
				}
				pn3++;
			}
		}
	
	});
}
		
		</script>
</head>
<body class="vip-padd">
	<div class="content">
		<header class="default-head">
			<a href="javascript:history.go(-1)" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
			<div class="head-tit">我的会员</div>
			<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
		</header>
		
		<div class="vip-box1">
			<a href="#tab1" class="tab-link active" id="level1">一级会员(${levelone}个)</a>
			<a href="#tab2" class="tab-link" id="level2">二级会员(${leveltwo}个)</a>
			<a href="#tab3" class="tab-link" id="level3">三级会员(${levelthree}个)</a>
		</div>
		<div class="vip-tit">
			<span>用户名</span>
			<span>加入时间</span>
		</div>
		<div class="tabs">
			<div id="tab1" class="tab active">
				<table class="viptabl">
					<tbody id="tb1">
					</tbody>
				</table>
			</div>
			<div id="tab2" class="tab">
				<table class="viptabl">
					<tbody id="tb2">
					</tbody>
				</table>
			</div>
			<div id="tab3" class="tab">
				<table class="viptabl">
					<tbody id="tb3">
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${base}/static/js/jquery.tabs.js"></script>
</body>
</html>