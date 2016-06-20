    <tr>
        <th width="120">店铺名字</th>
        <th width="120">店铺电话</th>
        <th width="120">创建时间</th>
		<th width="130">操作</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${item.name}</td>
				<td>${item.phone!}</td>
				<td>${item.createdate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</td>
					<td>
						<a href="shop!detail.action?id=${item.id}"><b class="menu_do menu_edit edit menu_chakan" title="查看"></b></a>&nbsp
					</td>
				
			</tr>
		</#list>
	</#if>