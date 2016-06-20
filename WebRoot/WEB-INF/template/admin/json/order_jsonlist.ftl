<#if list??>
    <tr>
    	 <th width="80">店名</th>
        <th width="100">订单编号</th>
        <th width="80">用户</th>
        <th width="70">支付金额</th>
        <th width="120">创建时间</th>
		<th width="80">电话</th>
		<th width="80">卖家留言</th>
		<th width="80">支付状态</th>
		<th width="80">操作</th>
    </tr>
<#list list as item>
    <tr>
    	<td>${item.shopname}</td>
		<td>${item.ordersn}</td>
		<td>${(item.username)!}</td>
		<td>${item.money}</td>
		<td><#if item.paydate??>${item.paydate?number_to_datetime?string("yyyy/MM/dd HH:mm")}<#else>-</#if></td>
		<td>${(item.phone)!}</td>
		<td>${(item.note)!}</td>
		<td>
			<#if item.stat == 0>
				<span style="color:red">未支付</span>
			</#if>
			<#if item.stat == 1>
				<span style="color:blue">已支付</span>
			</#if>
			<#if item.stat == 2>
				已评价
			</#if>
		</td>
		<td>
			<a href="order.action?id=${item.id}"><b class="menu_do menu_edit" title="编辑"></b></a>
			<b data-id="${item.id}"  class="menu_do menu_del cancel_btn" title="取消订单"></b>
		</td>
	</#list>
</#if>