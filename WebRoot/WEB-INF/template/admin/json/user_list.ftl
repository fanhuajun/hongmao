    <tr>
        <th width="120">用户名字</th>
        <th width="120">余额</th>
        <th width="120">用户电话</th>
        <th width="120">创建时间</th>
        <th width="120">消费排名</th>
		<th width="130">操作</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td><#if item[1]??>${(item[1])!}<#else>${(item[2])!}</#if></td>
				<td>
				<#if item[3]??>
				<#assign json=item[3]?eval />
				<#list json as prepay>
				<p>${prepay.createdate?number_to_datetime?string("yyyy-MM-dd")}充值享受${prepay.discount*10}折 <p>剩余&nbsp;:&nbsp;<span>&yen;${prepay.money}</span></p>
				</#list>
				</#if>
				</td>
				<td>${(item[2])!}</td>
				<td>${(item[4]?number_to_datetime?string("yyyy-MM-dd HH:mm:ss"))!}</td>
				<td>${(item[0])!}</td>
					<td>
						<a href="user!consume.action?id=${item[0]}"><b class="menu_do menu_edit edit menu_chakan" title="查看"></b></a>&nbsp
					</td>
				
			</tr>
		</#list>
	</#if>