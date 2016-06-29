    <tr>
        <th width="120">消费时间</th>
        <th width="120">消费金额</th>
        <th width="120">实际支付</th>
        <th width="120">预付款扣取</th>
	</tr>
	<#if list??>
		<#list list as order>
			<tr>
				<td>${order.paydate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}</td>
				<td>
				${order.sourcemoney}
				</td>
				<td>${order.money}</td>
				<td>${order.shopmoney}</td>
			</tr>
		</#list>
	</#if>