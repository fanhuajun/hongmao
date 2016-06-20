    <tr>
        <th width="120">城市</th>
        <th width="120">区域</th>
        <th width="120">商圈名字</th>
		<th width="130">操作</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${item.cityname}</td>
				<td>${item.areaname}</td>
				<td>${item.name}</td>
					<td>
					<!-- <a href="user.action?id="><b class="menu_do menu_edit edit menu_chakan" title="查看"></b></a>&nbsp
					-->
					</td>
				
			</tr>
		</#list>
	</#if>