
<#include "/WEB-INF/template/admin/header.ftl" />
    <style>
    .up500{height: 150px;width: 265px;}
    </style>
	<input type="hidden" id="depositStatus" value="${(deposit.tt)!}">
	<div class="zxbody">
		<div class="zxbody_title zxbody_title2">
			<a href="javascript:history.back();" class="zxback">
				<img src="${base}/static/admin/img/do_back.png">
			</a>
			退款审核
		</div>

			<div class="zxform">
				<form id="myform" name="myform" method="post" action="">
				<input type="hidden" id="depositid" value="${deposit.id}"/>
				<table cellspacing="0" cellpadding="0" width="100%" class="zxtable">
					<tr  class="tt-0">
						<td class="zxltd">用户ID：</td>
						<td id="userid">${(deposit.userid)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">用户真实姓名：</td>
						<td>${(deposit.name)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">提现申请时间：</td>
						<td>${(deposit.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm"))!}</td>
					</tr>
					<tr>
					<td class="zxltd">提现金额：</td>
					<td>${(deposit.money)!}元</td>
				    </tr>
				    
					<tr  class="tt-0">
						<td class="zxltd">提现途径：</td>
						<td> 
						<#if deposit.deposittype=="weixin">
						            		  微信钱包
						     <#elseif deposit.deposittype=="card">
						           		  银行卡
						     </#if>
			            </td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">手机号：</td>
						<td>${deposit.phone}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">银行卡号：</td>
						<td>${deposit.card}</td>
					</tr>
					
					<tr class="tt-0">
						<td></td>
						<td id="wrap">
							<label><input class="radioItem" name="stat" type="radio"  value="1" checked/>同意退款</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input class="radioItem" name="stat" type="radio"  value="-1"  />不同意退款</label>
						</td>
					</tr>
				<!--	<tr  class="tt-0 feedback">
						<td class="zxltd">拒绝理由</td>
						<td><textarea  rows="4" cols="45"  name="reason" id="reason" >${deposit.refuseReason!}</textarea></td>
					</tr> -->
					<tr>
						<td></td>
						<td class="btntd">
							<button type="button" class="dia_btn dialog_ok form_ok"  >确定</button>
							<b style='color:red;' id = "tip"></b>
						</td>
					</tr>
			</table>
			</form>
			</div>
		
</div>
<script src="${base}/static/admin/avalon.js"></script>
<script src="${base}/static/admin/highlight/shCore.js"></script>
<script>

    //弹出退款理由输入框
   // $(document).on("change","input[name='stat']:checked",function(){
        //             var stat = $("input[name='stat']:checked").val();
       //            if(stat==-1){
       //                 $(".feedback").fadeIn();
       //              }else{
      //                  $(".feedback").fadeOut();
       //              }
  //  })
    $(function(){
      //$(".feedback").fadeOut();
      var depositStatus = $("#depositStatus").val();
      if(depositStatus==1){
          $("input[name='stat']").attr("disabled","disabled");
          $(".form_ok").attr("disabled","disabled").css({"color":"gray"});
      }
    })
    
	$(document).on("click",".form_ok",function(){
		var stat = $(":checked").val();
		//var reason = $("#reason").val();
		var depositid = parseInt($("#depositid").val());
		$.ajax({
			url:'json/deposit!statchange.action',
			type: "post",
			data:{stat:stat,id:depositid},
			success:function(data){
			    json = eval("("+data+")");
			      if(json.success){
			         boxalert("已修改");
			         location.href='deposit!list.action';
			      }
		    }
	   })
		
	});
	
</script>

<!-- 表单提交 -->
<#include "/WEB-INF/template/admin/myform.ftl" />