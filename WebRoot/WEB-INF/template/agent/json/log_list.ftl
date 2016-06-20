    <tr>
        <th width="120">时间</th>
        <th width="120">金额</th>
        <th width="120">备注</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${item.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}</td>
				<td <#if item.tt gt 0>style="color:green"<#else>style="color:red"</#if>>${(item.money)!}</td>
				<td>${(item.content)!}</td>
			</tr>
		</#list>
	</#if>