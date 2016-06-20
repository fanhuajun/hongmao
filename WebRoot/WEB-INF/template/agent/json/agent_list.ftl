    <tr>
        <th width="120">代理名字</th>
        <th width="120">代理电话</th>
        <th width="120">创建时间</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${(item.name)!}</td>
				<td>${(item.phone)!}</td>
				<td>${(item.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm:ss"))!}</td>
			</tr>
		</#list>
	</#if>