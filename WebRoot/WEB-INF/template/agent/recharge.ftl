<#include "/WEB-INF/template/agent/header.ftl" />
    <style>
    .up500{ height: 150px; width: 265px;}
    .td1{ padding: 5px 0;}
    
    
    </style>
    <link rel="stylesheet" type="text/css" href="${base}/static/admin/css/jquery.datetimepicker.css"/>
	
	<!-- 板块独有内容 -->
	<script>
	$("#dpcz").addClass("on");
	</script>
	<div class="zxbody">
		<div class="zxbody_title zxbody_title2">
			<a href="javascript:history.back();" class="zxback">
				<img src="${base}/static/admin/img/do_back.png">
			</a>
			店铺详情
		</div>
			<div class="zxform">
				<table cellspacing="0" cellpadding="0" width="100%" class="zxtable">
					
					<tr  class="tt-0">
						<td class="zxltd">充值金额：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="money" id="money" value="" ></td>
					</tr>
					<tr>
						<td></td>
						<td class="btntd">
							<button type="button" class="dia_btn form_ok1 " id="rechargeok" >确定</button>
						</td>
					</tr>
				</table>
			</div>
	</div>
</div>
!-- 遮罩层 -->
<div class="mask"></div>
<!-- 编辑shopcontent -->
<div class="dialog dialog_backjson">
	<div class="dialog_head">
		<span class="menu_do menu_close"></span>
		<b>微信二维码扫描</b>
	</div>
	<div class="dialog_body">
		<img src="" id="rechargeqr"/>
	</div>
</div>
<script >
	$(document).ready(function(){
		
		$("#rechargeok").bind("click",function(){
			open_dialog();
			$(".dialog_backjson").show();
			var money = $("#money").val();
			$.ajax({
				url:"json/recharge!prepay.action",
				data:{"money":money},
				success:function(data){
					var dat=eval("("+data+")");
					if(dat.success){
						var rid = dat.rid;
						$("#rechargeqr").attr("src","/secure!qrcode.action?bf="+dat.url);
						var wint= window.setInterval(function(){
							$.ajax({
								url:"json/recharge!checkpay.action",
								data:{id:rid},
								success:function(html){
									if(html=="1"){
										alert("充值成功");
										$(".menu_close").trigger("click");
										window.clearInterval(wint);
									}
								}
							})
						},3000); 
					}
				}	
			})
		})
	})
</script>
<!-- 表单提交 -->
<#include "/WEB-INF/template/admin/myform.ftl" />