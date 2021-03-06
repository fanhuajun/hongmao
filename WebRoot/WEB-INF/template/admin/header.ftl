<!-- 板块公共开始 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>红猫管理后台</title>
<link rel="stylesheet" type="text/css" href="${base}/static/admin/css/admin.css" />
<script type="text/javascript" src="${base}/static/admin/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/public.js?v=1"></script>
<script type="text/javascript" src="${base}/static/admin/js/jquery.page.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/getarea.js"></script>

<!--start编辑框样式+js-->
<script src="${base}/static/admin/umeditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/static/admin/umeditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/static/admin/umeditor/ueditor.parse.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/static/admin/umeditor/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
<!--end编辑框样式+js-->

<!-- start检测表单 -->
<link rel="stylesheet" type="text/css" href="${base}/static/admin/css/validationEngine.jquery.css" />
<script type="text/javascript" src="${base}/static/admin/js/jquery.ajaxfileupload.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/jquery.form.js"></script>
<!-- end检测表单 -->

<!-- start时间控件-->
<link rel="stylesheet" type="text/css" href="${base}/static/admin/css/jquery.datetimepicker.css" />
<script type="text/javascript" src="${base}/static/admin/js/jquery.datetimepicker.js"></script>
<!-- end时间控件 -->

<!-- 头像剪切、水印设置等弹出框 -->
<script type="text/javascript" src="${base}/static/admin/js/artDialog4.1.6/jquery.artDialog.js?skin=default"></script>
<script type="text/javascript" src="${base}/static/admin/js/artDialog4.1.6/plugins/iframeTools.js"></script>
<!-- end头像剪切 -->


<style>
.mask,.mask_ecard,.dia_bg,.reg_error,.mask_ewm{background: url(${base}/static/admin/img/black.png) repeat;}
.zxnav_gl{background: url(${base}/static/admin/img/nav_gl.png) no-repeat 25px center;}
.zxnav_sz{background: url(${base}/static/admin/img/nav_sz.png) no-repeat 25px center;}
.zxnav_tg{background: url(${base}/static/admin/img/nav_tg.png) no-repeat 25px center;}
.zxnav_sj{background: url(${base}/static/admin/img/nav_sj.png) no-repeat 25px center;color:#f10;}
.zxnav_sj:hover{background: #eee url(${base}/static/admin/img/nav_sj.png) no-repeat 25px center;}
.zxnav_sj.on{background: #36a65a url(${base}/static/admin/img/nav_sj.png) no-repeat 25px center;color:#fff;}
.menu_add{background: url(${base}/static/admin/img/do_xz.png) no-repeat;}
.menu_del{background: url(${base}/static/admin/img/do_sc.png) no-repeat;}
.menu_edit{background: url(${base}/static/admin/img/do_bj.png) no-repeat;}
.menu_addspace{background: url(${base}/static/admin/img/do_xz.png) no-repeat;}
.menu_delspace{background: url(${base}/static/admin/img/do_sc.png) no-repeat;}
.menu_editspace{background: url(${base}/static/admin/img/do_bj.png) no-repeat;}
.menu_close,.box_close{background: url(${base}/static/admin/img/do_gb.png) no-repeat;}
.menu_close_unclear{background: url(${base}/static/admin/img/do_gb.png) no-repeat;}
.img_edit{background: url(${base}/static/admin/img/img_edit.png) no-repeat;}
.img_del{background: url(${base}/static/admin/img/img_del.png) no-repeat;}
.do_tip{background:url(${base}/static/admin/img/do_tip.png) no-repeat;}
.img_edit2{background: url(${base}/static/admin/img/img_edit2.png) no-repeat;}
.img_del2{background: url(${base}/static/admin/img/img_del2.png) no-repeat;}

/*新增图标*/
.menu_inquery{background: url(${base}/static/admin/img/iconfont-inquery.png) no-repeat; background-size:20px 20px;} /* 查询 */
.menu_qunzuduoren{background: url(${base}/static/admin/img/iconfont-qunzuduoren.png) no-repeat; background-size:20px 20px;} /* 多人 */
.menu_tianjia{background: url(${base}/static/admin/img/iconfont-tianjia.png) no-repeat; background-size:20px 20px;} /* 添加 */
.menu_paixu{background: url(${base}/static/admin/img/iconfont-paixu.png) no-repeat; background-size:20px 20px;} /* 上下前头 */


/* 权限设置 */
a.btn_yes{background:url(${base}/static/admin/img/btn_yes.png) no-repeat;}
a.btn_no{background:url(${base}/static/admin/img/btn_no.png) no-repeat;}
.zxmenu_bar.on .menu_add{background: url(${base}/static/admin/img/do_xz2.png) no-repeat;}
.zxmenu_bar.on .menu_edit{background: url(${base}/static/admin/img/do_bj2.png) no-repeat;}
.zxmenu_bar.on .menu_del{background: url(${base}/static/admin/img/do_sc2.png) no-repeat;}
/* 切换公司 */
.zxhd2{
	float: left;
	padding: 33px 0 0;
	margin-right: 10px;
}
.zxcompany{
	display: inline-block;
	background: #444;
	color: #fff;
	height: 32px;
	line-height: 32px;
	padding: 0 12px;
}
#loading{
	background: url(${base}/static/admin/img/loadbg.png) repeat;
}
#loadtext{
	background: url(${base}/static/admin/img/black.png) repeat;
}
.zxhead{overflow:visible !important;}
.zmbox{overflow:visible;}
.zmenu{
	position:relative;
}
.tcmenu{width:120px; position:absolute; top:30px; left:-50%; background-color:#fff; text-align:center; box-shadow:1px 1px 2px #666,-1px -1px 2px #666; display:none; z-index:99999;}
.tcmenu span,.tcmenu em{
	display:block;
	width:30px;
	height:16px;
	font-size:30px;
	overflow:hidden;
	_position:relative;
	left:50%;
	margin-left:-15px;
	font-family:SimSun;
	position:relative;
}
.tcmenu em{margin-top:-16px;color:#999;font-style:normal; list-style:none; z-index:1;}
.tcmenu span{margin-top:-14px;color:#fff; z-index:2}
.tcmenu li{width:100%; height:34px; line-height:34px; position:relative;}
.tcmenu li:after{
	content:'';
    position:absolute;
    left:0;
    bottom:0;
    right:auto;
    top:auto;
    height:1px;
    width:100%;
    background-color:#999;
    display:block;
    z-index:2;
    -webkit-transform-origin:50% 100%;
    transform-origin:50% 100%;
    -webkit-transform: scaleY(.5);
    transform: scaleY(.5);
    backface-visibility:hidden;
}
.tcmenu li:last-child:after{
	height:0;
}
.tcmenu li a{display:block; width:100%; height:100%; color:#333; font-size:14px;}
.mea{line-height:30px; font-size:14px !important; color:#333 !important;}
.zmenu:hover .tcmenu{
	display:block;
}

 
</style>

</head>

<input type="hidden" id="functionitems" data-val="">

<body>

<!-- 提交加载提示 -->
<div id="loading">
	<div id="loadtext">
		<h1><img src="${base}/static/admin/img/loading4.gif"></h1>
		<p>加载中，请稍候…</p>
	</div>
</div>


<div class="zxhead">
	<div class="main">
		<a href="info!set">
			<span class="zxlogo">
				<img src="">
			</span>
		</a>
		<div class="zxinfo">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td rowspan="2">
					</td>
					<td>
						<div class="zxinfo_01">
							<span class="green"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						<div class="zxinfo_02 zmbox">
							<div class="zmenu">
								<a href="javascript:;" class="mea">用户中心</a>
								<ul class="tcmenu">
									<span>&#9670;</span>
									<em>&#9670;</em>
									<li><a href="shop!alterpass.action">修改密码</a></li>
									<li><a href="logout.action">退出</a></li>
								</ul>	
							</div>
												
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<div style="margin: 20px auto 0;width:1202px;display:none;">
	<a href=""><img src="" style="width:1202px;"></a>
</div>
<#assign isadmin=session_is_admin />
<div class="zxmain">
	<div class="zxnav">
		<div class="zxnav_div">
				<div class="zxnav_title zxnav_sz">商铺管理</div>
			</div>
			<div class="zxnav_ul">
			   <ul>
					<a href="user!list.action">
						<li id="yhgl">用户管理</li>
					</a>
					<#if isadmin==0>
					<a href="shopcategory!list.action">
						<li id="wzgl">文章管理</li>
					</a>
					</#if>
					<a href="order!list.action">
						<li id="ddgl">订单管理</li>
					</a>
					<a href="comment!list.action">
						<li id="comment">用户评论</li>
					</a>
					<#if isadmin==0>
					<a href="news!list.action">
						<li id="news">动态管理</li>
					</a>
					</#if>
					<#if isadmin==1>
					<!--<a href="circle!list.action">
						<li id="circle">商圈</li>
					</a>-->
					</#if>
					<#if isadmin==1>
					<a href="city!list.action">
						<li id="city">城市</li>
					</a>
					</#if>
					<#if isadmin==1>
					<a href="shop!list.action">
						<li id="shop">商家列表</li>
					</a>
					</#if>
					<#if isadmin==1>
					<a href="shopcategory!list.action">
						<li id="shopcategory">商家分类</li>
					</a>
					</#if>
					<a href="wechat!edit.action">
						<li id="wechat">公众号设置</li>
					</a>
					
					<a href="shop!edit.action">
						<li id="myshop">商家设置</li>
					</a>
					<a href="appointment!list.action">
						<li id="appointment">预约管理</li>
					</a>
					<#if isadmin==1>
					<a href="open.action">
						<li id="ktsh">开通商户</li>
					</a>
					</#if>
					<#if isadmin==0>
					<a href="complain!list.action">
						<li id="complain">投诉建议</li>
					</a>
					</#if>
					<#if isadmin==0>
					<a href="deposit!list.action">
						<li id="deposit">提现审核</li>
					</a>
					</#if>
					
					<a href="rebate!list.action">
						<li id="rebate">返佣明细</li>
					</a>
					<#if isadmin==0>
					<a href="recharge.action">
						<li id="dpcz">返佣充值</li>
					</a>
					</#if>
				</ul>
			</div>
			
			<!--<div class="zxnav_ul">
				<ul>
					<a href="leavemanager!leavemanagerList">
						<li id="lygl">留言管理</li>
					</a>
					<a href="develop">
						<li id="tgjl">推广奖励</li>
					</a>
				</ul>
			</div>-->
	</div>
