    <tr>
        <th width="100">用户名</th>
        <th width="80">消费金额</th>
        <th width="120">消费时间</th>
        <th width="60">一级返佣</th>
        <th width="60">二级返佣</th>
        <th width="60">三级返佣</th>
        
        
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${(item.username)!}</td>
				<td>${(item.sourcemoney)!}</td>
				<td>${(item.paydate?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}</td>
				<td>${(item.onebackmoney)!}</td>
				<td>${(item.twobackmoney)!}</td>
				<td>${(item.threebackmoney)!}</td>

			</tr>
		</#list>
	</#if>