<#list list as entity>
<dd>
	<a href="shop.action?id=${entity.id}">
		<div class="seller-box-1">
			<div class="seller-img">
				<img src="${entity.cover!}">
			</div>
			<div class="seller-mess">
				<h3 class="seller-name">${(entity.name)!} <span class="seller-range" data-lng="${(entity.longitude)!}" data-lat="${(entity.latitude)!}">1km</span></h3>
				<p class="sller-m-1">
					消费折扣&nbsp;:&nbsp;<span class="sller-lr"><#if (!entity.discount??)||(entity.discount gte 1)>无折扣<#else>${entity.discount * 10}折</#if></span>
				</p>
				<#if entity.backList??>
				<p class="sller-m-1">
					代言返佣&nbsp;:&nbsp;<span class="sller-lr">
					<#list entity.backList as back>
						<#if back.level=="one">一级</#if>
						<#if back.level=="two">二级</#if>
						${back.low}-${back.high}%&nbsp;
					</#list>
					</span>
				</p>
				<#else>
				<p class="sller-m-1">
					代言返佣&nbsp;:&nbsp;<span class="sller-lr">
					商家暂无返佣机制
					</span>
				</p>
				</#if>
				<p class="sller-m-1">
					<#if entity.lastbackbegin??>(${entity.lastbackbegin?number_to_datetime?string("yyyy/MM/dd HH:mm")}</#if><#if entity.lastbackend??>至${entity.lastbackend?number_to_datetime?string("yyyy/MM/dd HH:mm")})</#if>
				</p>
				<p class="sller-m-2">${entity.shoptypetwoname} <span class="seller-sq">${entity.circlename}</span></p>
			</div>
		</div>
		<div class="seller-box-3">
			<div class="s-b-2-cont1">
				<div class="seller-grade">
					<div class="grade" data-grade="${entity.point}"></div>
					<span>人均：&yen;${entity.consumption!50}</span>
				</div>
				<p class="seller-addr"><i class="iconfont icon-dingwei3"></i>${entity.address}</p>
			</div>
		</div>
	</a>
	<div class="seller-box-4">
		<#if consume??>
		<a href="#">优惠买单</a>
		</#if>
		<a href="#" class="jrdy">加入代言</a>
	</div>
</dd>
</#list>