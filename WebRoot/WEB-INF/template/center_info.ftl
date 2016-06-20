<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>我的资料</title>
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
<body class="center-padd">
	<header class="default-head">
		<a href="center.action" class="head-left"><i class="iconfont icon-xiangzuo"></i></a>
		<div class="head-tit">我的资料</div>
		<a href="#" class="head-right"><i class="iconfont icon-gengduo"></i></a>
	</header>

	<div class="content">
		<ul class="datum-box">
			<li>
				<div class="datum-img">
					<span>头像</span>
					<input type="file" id="fileimg" name="file">
					<img id="headimg" src="${(user.pic)!}" alt="">
					<i class='iconfont icon-xiangyou'></i>
				</div>
			</li>
			<li>
				<a href="center!altername.action?username=${(user.name)!}">
					<span class="d-tit">用户名</span>
					<div class='d-right'>
						<span>${(user.name)!}</span>
						<i class='iconfont icon-xiangyou'></i>
					</div>
				</a>
			</li>
			<li>
				<a href="center!alterphone1.action?phoneOld=${(user.phone)!}">
					<span class="d-tit">绑定手机</span>
					<div class='d-right'>
						<span>${(user.phone)!}</span>
						<i class='iconfont icon-xiangyou'></i>
					</div>
				</a>
			</li>
		</ul>
		
		<div class="default-btn">
	  		<button type="button" onclick="logout()" class="tx-btn">退出</button>
	  	</div>
	  		
	</div>
</body>
<script type="text/javascript" src="${base}/static/js/jquery.ajaxfileupload.js"></script>
<script>

$(function(){
		$("#fileimg").bind("change",function(){
			 fileuploadimg();
		})
	})
	
	function updateimg(img){
		var p = img;
		$.ajax({
			url:'${base}/json/user!updataimg.action',
			data:{pic: p},
			type:"post",
		})
	}
	
	 function logout(){
           $.ajax({
                url:'logout.action',
                success:function(html){
                  var json = eval("("+html+")");
                     if(json.success){
                         location.href="login.action";
                     }
                }
           })
       }
	
	
function fileuploadimg(){
 			$.ajaxFileUpload({
				url:'${base}/upload.action',       //需要链接到服务器地址
				secureuri:false,
				fileElementId:'fileimg',                            //文件选择框的id属性
				dataType: 'text/html',                                   //服务器返回的格式，可以是json
				success: function (data, textStatus) {
					                                    //兼容ie8以及以下版本
					var dat = eval("("+data+")");
					if(dat.success){
						var img = dat.bigurl;						
						$("#headimg").attr("src",img);
						
						updateimg(img);
						$("#file").bind("change",function(){
				 			fileuploadimg();
						});
					}
					if(data.msg){
						alert(data.msg);
					}
					if(dat.msg){
						alert(dat.msg);
					}				
					//i++;
				}
		});
	}

</script>




</html>