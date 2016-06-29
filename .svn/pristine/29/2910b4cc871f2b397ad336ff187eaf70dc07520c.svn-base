<#include "/WEB-INF/template/admin/header.ftl" />
	
	
	<!-- 板块独有内容 -->
	<script>
	$("#scdd").addClass("on");
	</script>
	<div class="zxbody" style="position:relative;">
		<div class="zxbody_title">
		订单信息
		<#if order.paymentStatus=="paid"><a href="javascript:;" class="zxbody_tright zxbody_cash" id="kdinput">填写快递信息并发货</a></#if>
		<#if order.paymentStatus=="send"><a href="javascript:;" class="zxbody_tright zxbody_cash" id="kdinput">修改快递信息</a></#if>
		</div>
		<div class="tui_total">
			<ul>
				<li class="hasborder">
					<h1>${order.ordersn}</h1>
					<p>订单编号</p>
				</li>
				<li class="hasborder">
					<h1>${order.money}元</h1>
					<p>订单金额</p>
				</li>
				<li>
					<h1>
					<#if order.paymentStatus == "paid">
					已支付
					</#if>
					<#if order.paymentStatus == "send">
					已发货
					</#if>
					<#if order.paymentStatus == "deal">
					已确认
					</#if>
					<#if order.paymentStatus == "commented">
					交易完成
					</#if>
					</h1>
					<p>订单状态</p>
				</li>
			</ul>
		</div>
		<div class="zxbody_intro" style="margin:10px 0">
			<p>收货地址:${order.address}&nbsp;${order.name}&nbsp;${order.phone}</p>
		</div>
		<div class="extend_list" style="margin:10px 0">
			<table cellspacing="0" cellpadding="0" width="100%" class="extend_table" id="table1">
				  <tr>
        <th width="100">商品名字</th>
        <th width="120">商品单价</th>
        <th width="120">商品数量</th>
    			</tr>
    			<#list items as item>
    			<tr>
        <td>${item.productName}<#if item.size??>[${item.size}]</#if></td>
        <td>${item.productPrice}</td>
        <td>${item.productQuantity}</td>
    			</tr>
    			</#list>
			</table>
		</div>
	</div>
</div>
<!-- 提现余额到银行卡弹出层 -->
<div class="dialog dialog_extend dialog_cash" style="height:466px;">
	<div class="dialog_head">
		<span class="menu_do menu_close_unclear"></span>
		<b>确认发货</b>
	</div>
	<div class="dialog_body">
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
					<td class="dia_ltd">快递公司：</td>
					<td>
						<select class="dia_select" id="cc">
							<#list list as kd>
							<option value="${kd.keyid}" <#if order.carrcompanykey??&&order.carrcompanykey==kd.keyid>selected="selected"</#if> >${kd.name}</option>
							</#list>
							<option value="other"  <#if order.carrcompanykey??&&order.carrcompanykey=="other">selected="selected"</#if>>其他快递</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="dia_ltd">快递单号：</td>
					<td><input placeholder="请填写快递单号" type="text" class="dia_inp" id="no" name="no" value="${(order.carrno)!}"></td>
				</tr>
			</table>
	</div>
	<div class="dialog_foot">
		<button type="button" class="dia_btn dialog_no">取消</button>
		<button type="button" class="dia_btn dialog_ok">确定<#if order.paymentStatus=="paid">发货</#if></button>
	</div>
</div>
<script>
	$(function(){
		$("#kdinput").bind("click",function(){
			$(".dialog_cash").show();
		});
		$(".dialog_ok").bind("click",function(){
			var cc = $("#cc").val();
			var no = $("#no").val();
			$.ajax({
				url:"order!send.action",
				data:{cc:cc,no:no,id:"${id}",<#if order.paymentStatus=="paid">tt:"1"</#if>},
				type:"post",
				success:function(html){
					window.location.href='order.action?id=${id}';
				}
			})
		})
	})
</script>

