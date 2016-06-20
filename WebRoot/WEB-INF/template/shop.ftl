
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>${shop.name}</title>
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
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="http://mp.weixin.qq.com/debug/zh_CN/htmledition/js/jsapisign/sha121d415.js"></script>
	<script type="text/javascript" src="${base}/static/js/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="${base}/static/js/jquery.ajaxfileupload.js"></script>
	<style>
	#shareit {
	  -webkit-user-select: none;
	  display: none;
	  position: absolute;
	  width: 100%;
	  height: 100%;
	  background: rgba(0,0,0,0.85);
	  text-align: center;
	  top: 0;
	  left: 0;
	  z-index: 105;
	}
	#shareit img {
	  max-width: 100%;
	}
	.arrow {
	  position: absolute;
	  right: 10%;
	  top: 5%;
	}
	#share-text {
	  margin-top: 400px;
	}
	
	.wxewm-box {
	    width: 56%;
	    left: 21%;
	    padding: 0.2rem;
	    top: 40%;
     }
     .wxewm-box img {
	    width: 3.5rem;
	    height: 3.5rem;
	}
	.k-img img {
    height: 3.5rem;
}
hr {
    border-style: inset;
    border-width: 1px;
    border-color: rgba(255, 255, 255, 0.44);
    width: 109%;
}
	</style>
	<script type="text/javascript">
	<#assign ttick = tick>
	<#assign nowshop = frontShop>
	<#if ttick??>
	//需要动态从后台获取
	var jsapi_ticket = '${ttick}';
	var url = window.location.href;
	if(url.indexOf("?")>-1){
		url = url+"&uid=${session_customer_id}";
	}else{
		url = url+"?uid=${session_customer_id}";
	}
	var reg=new RegExp("\&?code\={1}[0-9a-zA-Z]+\&{0,}","gmi");
	url = url.replace(reg,"");
	url = url.replace("?&","?");
	var sharepic = "";
	var title = "";
	var webSite = "${nowshop.id}.homao.me/"
	var appId = '${nowshop.appid}'; 
	var timestamp = '1414587457';
	var nonceStr = '1';
	var theUrl = document.URL;
	var string1 = 'jsapi_ticket=' + jsapi_ticket + '&noncestr=' + nonceStr + '&timestamp=' + timestamp + '&url=' + theUrl; 
	var signature = new jsSHA(string1,"TEXT"); //签名算法
		signature = signature.getHash("SHA-1","HEX");
	var jsApiList = ['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','hideOptionMenu'];
	
	//通过config接口注入权限验证配置
	wx.config({
	    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: appId, // 必填，公众号的唯一标识
	    timestamp: timestamp, // 必填，生成签名的时间戳
	    nonceStr: nonceStr, // 必填，生成签名的随机串
	    signature: signature, // 必填，签名，见附录1
	    jsApiList: jsApiList // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	</#if>
	wx.ready(function() {
	//$(".confirm").bind("click",function(){
		//title = $(".fltxt").val();
		wx.onMenuShareTimeline({
			title : "这个地方不错哦，朋友快来吧。", // 分享标题
			link : url, // 分享链接
			imgUrl : "${shop.cover}", // 分享图标
			success : function() {
				
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
				// alert("取消啦");
			}
		});
		 wx.onMenuShareAppMessage({
	        title: "红猫分享" , // 分享标题
	        desc:  "这个地方不错哦，朋友快来吧。", // 分享描述
	        link: url, // 分享链接
	        imgUrl: "${shop.cover}" // 分享图标
	    });
	//});
	
});
//完成
$(document).on('change','.file', function () {
	fileupload();
});
function fileupload(){
	$.ajaxFileUpload({
		url:'${base}/upload.action',       //需要链接到服务器地址
		secureuri:false,
		fileElementId:'file',                            //文件选择框的id属性
		dataType: 'text/html',                                   //服务器返回的格式，可以是json
		fileSize:300,     
		data:{width:'520', length:'250',limit:300},
		success: function (data, textStatus) {
			//兼容ie8以及以下版本
        	if(data.success){
        		$("#sharepic").attr("src",data.bigurl+"@100h_100w");
        		sharepic = 	data.bigurl;
        	}
            //兼容火狐、谷歌、ie8以上版本
			var dat = eval("("+data+")");
			if(dat.success){
				$("#sharepic").attr("src",dat.bigurl+"@100h_100w");
        		sharepic = 	dat.bigurl;
			}
			if(data.msg){
				alert(data.msg);
			}
			if(dat.msg){
				alert(dat.msg);
			}
			
			
		}
	});
}
	</script>
</head>
<body id="touch">
	<div class="content">
		<div class="spdbanner">
			<div class="spdb-box">
				<img src="${shop.cover!}" alt="banner" />
				<div class="spdb-1">
					<!--<a href="#" class="fx"><i class="iconfont icon-fenxiang1"></i></a>
					<a href="#"><i class="iconfont icon-shoucang4"></i></a>-->
				</div>
			</div>
		</div>

		<div class="sp-chunk">
			<dl class="spd-info1">
				<dd>
					<h3 class="spd-i-name">${shop.name}<!--<span style="font-size:.25rem;padding-left:20px" class="sp1">(${shop.cuisine})</span></h3>-->
					<hr>
					<!--<p class="spd-i-b">
						<span class="sp1">${shop.cuisine}</span>
					</p>-->
					<p class="spd-i-a"><span>最新分享返佣&nbsp;:&nbsp;</span>
					<br>一级${shop.lowestback1*100}%~${shop.highestback1*100}%,  <br>二级${shop.lowestback2*100}%~${shop.highestback2*100}%, <br>三级${shop.lowestback3*100}%~${shop.highestback3*100}%
					</p>
					<div style="padding-top:8px">
					<p class="spd-i-a"><span>我的充值折扣&nbsp;:&nbsp;</span><#if (!shop.discount??)>无折扣<#else>${shop.discount*10}折</#if></p>
					<p class="spd-i-a"><span>我的消费排名&nbsp;:&nbsp;<#if user??>${(user.rank)!}<#else><a href="login.action">登录</a></#if></span></p>
					</div>
					<p class="spd-wxewm" data-src="images/2000.jpg">
						<i class="iconfont icon-code"></i>
					</p>
				</dd>
				<dd>
				<!--<div class="spd-i-lb">
						<div class="spd-i-pinfen grade" data-grade="${shop.point}"></div>人均&nbsp;:&nbsp;&yen;60
					</div>-->
				</dd>
				<dd>
					<a class="spd-i-lb" href="tel:${shop.phone}"><i class="iconfont icon-buchongiconsvg09"></i>&nbsp;&nbsp;${shop.phone}</a>
				</dd>
				<dd>
					<a class="spd-i-lb-2" href="javascript:void(0);"><i class="iconfont icon-location i-1"></i><p>${shop.address}</p><i class="iconfont icon-xiangyou iright i-2"></i></a>
				</dd>
				<dd>
					<div class="spd-i-lb" href="#">上班时间&nbsp;:&nbsp;${shop.thetime!}</div>
				</dd>
			</dl>
		</div>

		<div class="sp-chunk">
			<div class="sp-kbox">
				<a class="sp-k-labl" href="news.action?id=${shop.id}">
					<label class="k-labltit">商家动态</span>&nbsp;:</label>
					<#if lastNews??>
					<#list lastNews as news>
					<span class="k-lablcont" style="display:block;height：1rem">${news.title}</span>
					</#list>
					<#else>
					<span class="k-lablcont">暂无动态</span>
					</#if>
					<i class="iconfont icon-xiangyou ilablright"></i>
				</a>
			</div>
		</div>

		<div class="sp-chunk">
			<ul class="sp-menu">
				<a href="center.action">
				<li class="sp-m-6">
					<span class="m-icon m1"></span>
					<span class="m-tit">我的</span>
				</li>
				</a>
				<a href="order!prePay.action">
				<li class="sp-m-6">
					<span class="m-icon m2"></span>
					<span class="m-tit">支付</span>
				</li>
				</a>
				<a href="user!member.action">
				<li class="sp-m-3">
					<span class="m-icon m3"></span>
					<span class="m-tit">我的会员</span>
				</li>
				</a>
				<a href="prepaylog!detail.action">
				<li class="sp-m-3">
					<span class="m-icon m4"></span>
					<span class="m-tit">我的预存</span>
				</li>
				</a>
				<a href="appointment.action">
				<li class="sp-m-3">
					<span class="m-icon m5"></span>
					<span class="m-tit">预约排队</span>
				</li>
				</a>
			</ul>
		</div>

		<div class="sp-chunk">
			<!--<div class="sp-kbox">
				  <div onclick="javascript:location.href='shop!shopStory.action?contentid=0'">
					<h3 class="sp-kdjtit">这是一家有故事的店</h3>
					<p class="kdjsm">${shop.content!}</p>
					<div class="k-img">
						<img src="${shop.contentpic!}" />
					</div>
			  </div>-->
			  <div style="margin-top:.5rem;">
					<#if contents??>
					<#list contents as content>
					<div onclick="javascript:location.href='shop!shopcontent.action?contentid=${content.id}'">
						<h3 class="sp-kdjtit">&nbsp&nbsp&nbsp&nbsp${content.title}</h3>
						<div class="k-img pdkimg">
							<img src="${content.pic}" />
					    </div>
					</div>
					</#list>
					</#if>
			  
			</div>
		</div>

		<div class="sp-chunk">
			<div class="pjadfx">
				<a href="#tab1" class="tab-link active">评价(${commentTotal})</a>
				<!--<a href="#tab2" class="tab-link">分享(${shop.sharecount})</a>-->
			</div>
			<div class="tabs">
				<div class="tab active" id="tab1">
					<dl class="pjbox">
						<#if comments??>
						<#list comments as comment>
						<dd>
							<div class="pj-userinfo-box">
								<div class="user-img">
									<img src="${comment.userpic!}">
								</div>
								<div class="user-mess">
									<h3>${comment.username!} <span>${comment.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm")}</span></h3>
									<div class="user-pf grade" data-grade="${comment.star!}"></div>
								</div>
							</div>
							<p class="user-pllr">${comment.content}</p>
							<div class="user-plimg picture">
								<#if comment.picList??>
									<#list comment.picList as pic>
									<img src="${pic}">
									</#list>
								</#if>
							</div>
						</dd>
						</#list>
						</#if>
						<a href="comment!list.action?id=${shop.id}" class="more-pl">查看&nbsp;${commentTotal}&nbsp;条评论 <i class="iconfont icon-xiangyou"></i></a>
					</dl>
				</div>
				<div class="tab" id="tab2">
					<dl class="pjbox">
						<dd>
							<div class="pj-userinfo-box">
								<div class="user-img">
									<img src="images/2000.jpg">
								</div>
								<div class="user-mess">
									<h3>某某某某某某 <span>2015-12-12 17:00:00</span></h3>
									<div class="user-pf grade" data-grade="4.5"></div>
								</div>
							</div>
							<p class="user-pllr">某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某某</p>
							<div class="user-plimg picture">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
								<img src="images/shopd.png">
							</div>
						</dd>
						<a href="share!list.action?id=${shop.id}" class="more-pl">查看全部&nbsp;${shop.sharecount}&nbsp;条分享 <i class="iconfont icon-xiangyou"></i></a>
					</dl>
				</div>
			</div>
		</div>
		<#if otherShops??&&(otherShops?size gt 0)>
		<div class="sp-chunk">
			<h3 class="sp-d-qtfd">其他分店</h3>
			<dl class="sellerbox">
			<#list otherShops as othershop>
				<dd>
					<a href="shop.action?id=${othershop.id}">
						<div class="seller-box-1">
							<div class="seller-img">
								<img src="${othershop.cover}">
							</div>
							<div class="seller-mess">
								<h3 class="seller-name">${othershop.name} <span class="seller-range" data-lng="${othershop.longitude!}" data-lat="${othershop.latitude!}">1km</span></h3>
								<p class="sller-m-1">
									我的消费折扣&nbsp;:&nbsp;<span class="sller-lr"><#if (!othershop.discount??)||(othershop.discount gte 1)>无折扣<#else>${othershop.discount * 10}折</#if></span>
								</p>
								<p class="sller-m-1">
									我的消费折扣&nbsp;:&nbsp;<span class="sller-lr">
									<#if othershop.backList??>
									<#list entity.backList as back>
						<#if back.level=="one">一级</#if>
						<#if back.level=="two">二级</#if>
						${back.low}-${back.high}%&nbsp;
						</#list>
							<#else>
							商家暂无返佣机制
							</#if>
						</span>
								</p>
								<p class="sller-m-1">
									<#if othershop.lastbackbegin??>(${othershop.lastbackbegin?number_to_datetime?string("yyyy/MM/dd HH:mm")}</#if><#if othershop.lastbackend??>至${othershop.lastbackend?number_to_datetime?string("yyyy/MM/dd HH:mm")})</#if>
								</p>
								<p class="sller-m-2">${othershop.shoptypetwoname} <span class="seller-sq">${othershop.circlename}</span></p>
							</div>
						</div>
						<div class="seller-box-2">
							<div class="s-b-2-cont1">
								<div class="seller-grade">
									<div class="grade" data-grade="${othershop.point}"></div>
									<span>人均：&yen;${othershop.consumption!50}</span>
								</div>
								<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${othershop.address}</p>
							</div>
						</div>
					</a>
				</dd>
				</#list>
			</dl>
		</div>
		</#if>
	</div>
	<div id="shareit">
	  <img class="arrow" src="${base}/static/images/share-it.png">
	  <a href="#" id="follow">
	    <img id="share-text" src="${base}/static/images/share-text.png">
	  </a>
	</div>
	<script type="text/javascript" src="${base}/static/js/grade.js"></script><!-- 评分 -->
	<script type="text/javascript" src="${base}/static/js/jquery.tabs.js"></script><!-- tab切换 -->
	<script type="text/javascript" src="${base}/static/js/swiper.min.js"></script><!-- 轮播 -->
	<script type="text/javascript" src="${base}/static/js/pictureviewer.js"></script><!-- 图片浏览器 -->
	<script type="text/javascript" src="${base}/static/js/jquery.qrcode.min.js" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			//评分
			$(".grade").grade({"show":false});

			//图片浏览器
			$('.picture').picture();

			//弹出微信二维码
			$('.spd-wxewm').click(function(){
				var src=$(this).attr('data-src');
				var htm='<div class="wxewm-box">'+
							'<img src="secure!qrcode.action?bf='+url+'">'+
							'<p>更多优惠等你来!</p>'+
						'</div>';
				$('.pop').addClass('pop-visible');
				
				$('body').append(htm);
			})
			$('.pop').click(function(){
				$('.pop').removeClass('pop-visible');
				$('.wxewm-box').remove();
			})

			//分享弹出层
			$('.fx').click(function(){
				//var htm='<div class="fx-box">'+
				//			'<div class="fx-cont">'+
				//				'<div class="fx-img">'+
				//					'<div class="fxsc">'+
				//						'<img src="'+url+'" id="sharepic">'+
				//						'<input type="file" class="file" id="file" name="file">'+
				//					'<i class="iconfont icon-xiangji4"></i>'+
				//					'</div>'+			
				//				'</div>'+
				//				'<div class="fx-text">'+
				//					'<textarea class="fltxt"></textarea>'+
				//				'</div>'+
				//			'</div>'+
				//			'<div class="fx-btn">'+
				//				'<a href="javascript:;" class="confirm">确定</a>'+
				//				'<a href="javascript:;" class="cancel">取消</a>'+
				//			'</div>'+
				//		'</div>';

				//$('.pop').addClass('pop-visible');
				//$('body').append(htm);
				$("#shareit").show();
  });
				
			})
			$(document).on('click','.cancel,.pop',function(){
				$('.pop').removeClass('pop-visible');
				$('.fx-box').remove();
			});
			$(document).on('click','#shareit',function(){
				$("#shareit").hide();
			});
	</script>
</body>
</html>