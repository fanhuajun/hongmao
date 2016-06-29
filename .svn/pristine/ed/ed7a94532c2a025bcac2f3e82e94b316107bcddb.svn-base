    <tr>
        <th width="120">动态标题</th>
        <th width="120">创建时间</th>
		<th width="130">操作</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr id="news${item.id}">
				<td>${item.title}</td>
				<td>
					${item.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}
				</td>
				<td>
					<a href="news!edit.action?id=${item.id}"><b class="menu_do menu_edit edit menu_chakan" title="修改"></b></a>&nbsp
					<a href="javascript:deletenews('${item.id}')"><b class="menu_do menu_del del menu_del" title="删除"></b></a>&nbsp
				</td>
			</tr>
		</#list>
	</#if>