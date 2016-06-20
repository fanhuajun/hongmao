	<#include "/WEB-INF/template/admin/header.ftl" />
	<!-- 板块独有内容 -->
	<script>

	$("#city").addClass("on");
	</script>
	<style>
		.slevel_li{cursor:pointer}
		.zxmenu_link.on{background-color:#36a65a;}
		.zxmenu_link.on span{color:#fff !important;}
		.access_klist{width:100%; height:100%; margin:0; padding-top:20px;}
		.access_klist ul{}
		.access_klist ul:after{clear:both; content:""; display:block;}
		.access_klist ul li{width:250px !important;}
		.dialog_adddh{text-align:center; color:#333}
		.dialog{border:1px solid #ddd;}
		.addhli{height:52px !important; line-height:52px; padding-top:0 !important; padding-bottom:0 !important;}
		.ggbox{width:100%; position:relative;}
		.ggbox:after{clear: both; content:""; display:block;}
		.ggbox li{margin:5px 0 5px 5px; float:left;}
	</style>
	<div class="zxbody">
		<div class="zxbody_title">分类管理</div>
		<div class="zxbody_menu">
			<div class="zxmenu">
				<div class="zxmenu_left">
					<div class="zxmenu_tit">
						<span>一级分类</span>
						<b class="menu_do menu_add" title="新增一级栏目"></b>
					</div>
					<div class="zxmenu_type">
					<#if list?? && list?size gt 0>
						<#list list as city>
						<dl>
							<dt id="nodeId${city.id}" class="zxmenu_bar" data-id="${city.id}">
								<a href="javascript:;" data-id="${city.id}" class="zxmenu_link <#if index??><#if city.id==index>on</#if><#else><#if city_index==0>on</#if></#if>" >
									<span>${city.name}</span>
									<strong>
											<b class="menu_do menu_edit flevel_edit" title="编辑" data-name="${city.name}" data-id="${city.id}" ></b>
											<b class="menu_do menu_del flevel_del" title="删除" data-id="${city.id}" ></b>
									</strong>
								</a>
							</dt>
						</dl>
						<#if index??>
						<#if city.id==index><#assign slevel=city></#if>
						<#else>
						<#if city_index==0><#assign slevel=city></#if>
						</#if>
						</#list>
					</#if>
					</div>
				</div>	
				<div class="zxmenu_right">
					<div class="zxmenu_tit">
						<span>二级分类</span>
					</div>
				
					<div class="access_klist">
			  					<ul id="slevel_ul"> 	 	 	 	
				  					
				  					
								</ul>
					</div>
					
				
			</div>			
		</div>
	</div> 
	
</div>


<!-- 新增、修改、删除弹窗 -->
<#include "/WEB-INF/template/admin/dialog.ftl" />

<!--<script type="text/javascript" src="${base}/static/admin/js/product_menu.js"></script>-->
<script type="text/javascript">

// 点击删除文章
	$(document).on("click",".slevel_del" ,function() {
	
		var thisId = $(this).attr("data-id");// 该分类id
		$("#thisId").val(thisId);
		$("#delcategory").val("del2");
		open_dialog();
		$(".dialog_confirm").show();
	
	});

//添加文章
$(document).on("click",".slevel_add",function(){
	var parentid = $(this).attr("data-id");//获取父类id
	$("#parentid").val(parentid);// 存放新增还是修改
	
	$("#addOrEdit").val('add2');
	
	$(".dialog_add").show();
});

$(function () {
	  var parentId = $(".zxmenu_link").first().attr("data-id");
	  $(".slevel_li").remove();
	  $.ajax({
			url:"json/area!list.action",
			type:"post",
			data:{id:parentId},
			success:function(html){
				
				$("#slevel_ul").html(html);
				
			}
	});
	  
    })

//加载二级分类
$(document).on("click",".zxmenu_bar",function(){
	$(".zxmenu_link").removeClass("on");
	$(this).find("a").addClass("on");
	$(".slevel_li").remove();
	var id = $(this).attr("data-id");
	
	$.ajax({
		url:"json/area!list.action",
		type:"post",
		data:{id:id},
		success:function(html){
			
			$("#slevel_ul").html(html);
			
		}
	});
});

// 点击修改一级分类
$(document).on("click",".flevel_edit",function() {
	var thisId = $(this).attr("data-id");// 获取分类信息
	var thisName = $(this).attr("data-name");
	$("#thisId").val(thisId);
    $("#addName").val(thisName);
	// 存放新增还是修改
	$("#addOrEdit").val('edit1');
	open_dialog();
	$(".dialog_add").show();

	$(".dialog_add .dialog_head b").html('修改栏目');

});

// 点击修改二级分类
$(document).on("click",".slevel_edit",function(){
	var thisName = $(this).attr("data-name");
	var thisId = $(this).attr("data-id");
	$("#addName").val(thisName);
	$("#thisId").val(thisId);
	// 存放新增还是修改
	$("#addOrEdit").val('edit2');
	open_dialog();
	$(".dialog_add").show();

	$(".dialog_add .dialog_head b").html('修改栏目');
		
});

// 点击新增一级分类
$(document).on("click",".zxmenu_tit .menu_add", function() {
	open_dialog();
	$(".dialog_add").show();
	var index = $(".zxmenu_link.on").attr("data-id");
	$("#thisId").val(index);
	$("#parentid").val(index);
	$("#addOrEdit").val('add1');// 存放新增还是修改
	$(".dialog_add .dialog_head b").html('添加城市');
});

// 确定新增或修改
$(".dialog_add .dialog_ok").live("click", function() {

	var thisId = $("#thisId").val();
	var addName = $("#addName").val();
	var parentid = $("#parentid").val();
	if (!addName) {
		boxalert('城市名称不能为空');
		$("#addName").focus();
		return false;
	}
	var addOrEdit = $("#addOrEdit").val();
	// 新增一级分类，不需要父级cid
	if (addOrEdit == "add1") {
		parentid = null;
	}
	// 提交加载中开启
	$("#loading").show();
	$.ajax({
		url : "json/city!saveOrUpdate.action",
		type : "post",
		data : {
			"thisId" : thisId,"name" : addName,addOrEdit:addOrEdit,parentId:parentid,
		},
		success : function(data) {
			$("#loading").hide();// 提交加载中关闭
			var data = eval("("+data+")");
			if (data.success) {
				close_dialog(); // 火狐必须清空输入框
				boxalert("提交成功！");
				location.reload();
				return;
			} else {
				boxalert("提交失败！");
			}
		}
	});
});

// 点击删除一级分类
$(document).on("click",".flevel_del", function() {

	// 该分类id
	var thisId = $(this).attr("data-id");
	$("#thisId").val(thisId)
	$("#delcategory").val("del1")
	
	var delcategory = "del1";
	     $.ajax({
		url : "json/area!totalNum.action",
		type : "post",
		data : {thisId:thisId},
		success : function(data){
			var total = eval("("+data+")").total;
			if(total>0) {
				//有内容，不能删除
				$(".dialog_delete").show();
			}else {
				// 没内容，需要确认
				$(".dialog_confirm").show();
			}
		}
	});
});

// 不能删除有内容！！！！！！的分类
$(".dialog_delete .dialog_ok").live("click", function() {
	close_dialog();
});

// 确定删除没内容的分类
$(".dialog_confirm .dialog_ok").live("click", function() {

	var thisId = $("#thisId").val();// 该分类id
	var delcategory = $("#delcategory").val();
	// 提交加载中开启
	$("#loading").show();

	$.ajax({
		url : "json/city!delete.action",
		type : "post",
		data : {thisId:thisId, delcategory:delcategory},
		success : function(data) {
			// 提交加载中关闭
			$("#loading").hide();
			var data = eval("("+data+")");
			if (data.success) {
				close_dialog();
				boxalert("删除成功");
				// 重新初始化
                location.reload();
			} else {
				boxalert("删除失败");
			}
		}

	});

});

</script>

