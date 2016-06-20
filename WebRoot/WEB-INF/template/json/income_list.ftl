<#list list as entity>
<tr>
	<td>${entity.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm")}</td>
	<td>&yen;${entity.money}</td>
	<td>&yen;${entity.restmoney}</td>
	<td>
		<#if entity.attach=="1">
		一
		</#if>
		<#if entity.attach=="2">
		二
		</#if>
		<#if entity.attach=="3">
		三
		</#if>
		级返佣
	</td>
</tr>
</#list>