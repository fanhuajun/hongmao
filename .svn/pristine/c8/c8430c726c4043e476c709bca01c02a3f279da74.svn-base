<#include "/WEB-INF/template/admin/header.ftl" />
    <style>
    .up500{ height: 150px; width: 265px;}
    .td1{ padding: 5px 0;}

    
    </style>
    <link rel="stylesheet" type="text/css" href="${base}/static/admin/css/jquery.datetimepicker.css"/>
	
	<!-- 板块独有内容 -->
	<script>
	$("#shop").addClass("on");
	</script>
	<div class="zxbody">
		<div class="zxbody_title zxbody_title2">
			<a href="javascript:history.back();" class="zxback">
				<img src="${base}/static/admin/img/do_back.png">
			</a>
			店铺详情
		</div>
		<form id="myform" name="myform" method="post" action="">
			<div class="zxform">
				<table cellspacing="0" cellpadding="0" width="100%" class="zxtable">
					
					<tr  class="tt-0">
						<td class="zxltd">店铺名字：</td>
						<td>${(shop.name)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">店铺电话：</td>
						<td>${(shop.phone)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">店铺地址：</td>
						<td>${(shop.address)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">店铺封面：</td>
						<td>
						    <div class="dialog_upload up500">
								<img id="avatar1" src="${(shop.cover)!}">
							</div>
						</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">人均消费:</td>
						<td>${(shop.consumption)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">三级返佣设置:</td>
						<td><button type="button" class="dia_btn" name="description" id="backjson">设置</button></td>
					</tr>
					
					<tr  class="tt-0">
						<td class="zxltd">营业时间:</td>
						<td>${(shop.thetime)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">评价总数量:</td>
						<td style="color:green;" id="commentcount">${(shop.commentcount)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">分享总数量:</td>
						<td style="color:green;" id="sharecount">${(shop.sharecount)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">创建时间:</td>
						<td style="color:green;" id="createdate">${(shop.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">微信支付密码:</td>
						<td style="color:green;" id="createdate">${(shop.wxPaySecrect)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">appid:</td>
						<td style="color:green;" id="createdate">${(shop.appid)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">appKey:</td>
						<td style="color:green;" id="createdate">${(shop.appKey)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">wxPayno:</td>
						<td style="color:green;" id="createdate">${(shop.wxPayno)!}</td>
					</tr>
					<tr>
						<td></td>
						<td class="btntd">
							<a href="javascript:history.go(-1)"><button type="button" class="dia_btn dialog_ok form_ok" ms-click="checkAll" >返回列表</button></a>
						</td>
					</tr>
					
				</table>
			</div>
		</form>
	</div>
</div>
<!-- 遮罩层 -->
<div class="mask"></div>
<!-- 编辑shopcontent -->
<div class="dialog dialog_backjson">
	<div class="dialog_head">
		<span class="menu_do menu_close"></span>
		<b>返佣设置</b>
	</div>
	<div class="dialog_body">
		<div class="dialog_left">
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
			    <tr>
			    	<td colspan="3">一级返佣设置</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最低返佣：</td> 
					<td td1><input placeholder="" value="${(shop.lowestback1)!}" type="text" style="width:150px !important;" class="dia_inp tip1" id="lowestback1"></td>
				</tr>
				<tr>
					<td class="dia_ltd td1">开始时间</td>
					<td class="td1"><input placeholder="" value="${(shop.lastbackbegin1?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" class="dia_inp tip1" style="width:150px !important;" id="datetime11" ></td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
			    <tr>
			    	<td colspan="3">二级返佣设置</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最低返佣：</td> 
					<td td1><input placeholder="" value="${(shop.lowestback2)!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="lowestback2"></td>
				</tr>
				<tr>
					<td class="dia_ltd td1">开始时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackbegin2?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" class="dia_inp tip2" style="width:150px !important;" id="datetime52" ></td>
				</tr>
			</table>   
		</div>
		<div class="dialog_right">
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
			    	<td colspan="3">&nbsp;</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最高返佣：</td> 
					<td td1><input placeholder="" value="${(shop.highestback1)!}" type="text" class="dia_inp tip1" style="width:150px !important;" maxlength="4" id="highestback1"></td>
					<td>%</td>
				</tr>
				<tr>
					<td class="dia_ltd td1">结束时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackend1?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" style="width:150px !important;" class="dia_inp tip1" id="datetime22" ></td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
			    	<td colspan="3">&nbsp;</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最高返佣：</td> 
					<td td1><input placeholder="" value="${(shop.highestback2)!}" type="text" class="dia_inp tip2" style="width:150px !important;" maxlength="4" id="highestback2"></td>
					<td>%</td>
				</tr>
				<tr>
					<td class="dia_ltd td1">结束时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackend2?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="datetime23" ></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<script src="${base}/static/admin/avalon.js"></script>
<script src="${base}/static/admin/highlight/shCore.js"></script>
<script src="${base}/static/admin/js/jquery.datetimepicker.js"></script>
<script>




$(document).on("click","#backjson" ,function() {

	open_dialog();
	$(".dialog_backjson").show();

});


$(".menu_close").click(function(){
   location.reload();
})
   
	
</script>

<!-- 表单提交 -->
<#include "/WEB-INF/template/admin/myform.ftl" />