<#if list??>
    <tr>
        <th width="80">用户名</th>
        <th width="120">创建时间</th>
		<th width="80">建议内容</th>
		<!--<th width="80">操作</th>-->
    </tr>
<#list list as item>
    <tr>
		<td>${(item.username)!}</td>
		<td><#if item.createdate??>${item.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm")}<#else>-</#if></td>
		<td>${(item.content)!}</td>
		
		<!--<td>
			<a href="order.action?id=${item.id}"><b class="menu_do menu_edit" title="编辑"></b></a>
			<b data-id="${item.id}"  class="menu_do menu_del cancel_btn" title="取消订单"></b>
		</td>-->
	</#list>
</#if>