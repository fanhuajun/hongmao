<#include "/WEB-INF/template/admin/header.ftl" />
<style type="text/css">
	.menu_jf{background: url(${base}/static/admin/img/iconfont-jifen.png) no-repeat; background-size:20px 20px;}
	.menu_chakan { background: url(/static/admin/img/iconfont-chakan.png) no-repeat; background-size: 22px 22px;
}
</style>
<script src="${base}/static/admin/js/jquery.page-noajax.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/wxmenu.js"></script>
	<!-- 板块独有内容 -->
	<script>
	$("#appointment").addClass("on");
	</script>
	<div class="zxbody" style="position:relative;">
		
		<div class="extend_list">
			<table cellspacing="0" cellpadding="0" width="100%" class="extend_table" id="table">
					
			</table>
		</div>
		<div class="zxbody_page">
			<div class="showPage" id="showPage">
			</div>
		</div>
	</div>
</div>

<script>



$(function(){
	showPage(1,"");		
});
	
function getContentList(pn,stat){
	var url = "json/appointment!jsonlist.action";
	var search=$('#search').val();
    if(pn==0){
        pn=1;
    }
	$.ajax({
		url:url,
		type: "post",
		data:{pn:pn,stat:stat,keyword:search},
		async:false,
		success:function(html){
			$("#table").html(html);
		}
	});
}



	
//生成分页
function showPage(pn,stat){
    var keyword = $("#search").val();
	var url = "json/appointment!totalNum.action";
	var showpage = "showPage";
	if(!pn) pn=1;
	$.ajax({
		url: url,
		type:"post", 
		data:{},
		dataType: "json",
		async:false,
		success:function(dat){
			//计算页数
			var pageCount = Math.ceil(dat.total/dat.size);
			if(pageCount < pn){
				pn=pageCount;
			}
			//分页
			$("#"+showpage).createPage({
				dataTotal: dat.total, //数据条数
				pageCount: pageCount, //总页数
				current: pn, //当前页
				backFn: function(pn,stat){
					//单击回调方法，pn是当前页码
					//获取列表数据
					getContentList(pn,stat);
					
				}
			});
			//获取列表数据
			getContentList(pn,stat);
		}
	});
}
</script>
