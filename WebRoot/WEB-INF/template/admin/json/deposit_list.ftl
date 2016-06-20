    <tr>
        <th width="120">用户名字</th>
        <th width="60">用户ID</th>
        <th width="120">余额</th>
        <th width="120">用户电话</th>
        <th width="120">申请时间</th>
        <th width="120">状态</th>
		<th width="130">操作</th>
	</tr>
	<#if list??>
		<#list list as item>
			<tr>
				<td>${(item.name)!}</td>
				<td>${(item.userid)!}</td>
				<td>${(item.money)!}</td>
				<td>${(item.phone)!}</td>
				<td>${(item.createdate)!?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}</td>
				<td><#if item.tt==0>
				          审核中
				    <#elseif item.tt==-1>
				          审核不通过
				     <#elseif item.tt==1>
				          审核通过
				     </#if>
				</td>
					<td>
						<a href="deposit.action?id=${item.id}"><b class="menu_do menu_edit edit menu_chakan" title="查看"></b></a>&nbsp
					</td>
				
			</tr>
		</#list>
	</#if>