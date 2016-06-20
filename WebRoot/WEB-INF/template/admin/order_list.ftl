<#include "/WEB-INF/template/admin/header.ftl" />
	<!-- 板块独有内容 -->
	<script>
	$("#ddgl").addClass("on");
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

function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

$(function(){
	var cid = getQueryString("cid");
	showPage(1, cid);		
	
	//提现跳转
	var tab = getQueryString("tab");
	if(tab){
		f(tab);
	}
	
});
	
function getContentList(pn, cid){
	var url = "json/order!jsonlist.action";
	var table = "table";
	var search=$('#search').val();
	$.ajax({
		url:url,
		type: "post",
		data:{"pn":pn,tt:"${tt!}",keyword:search},
		async:false,
		success:function(html){
			$("#"+table).html(html);
		}
	});
	
}

//取消订单 payStat(5)
$(document).on("click",".cancel_btn",function(){
	if(confirm("确认要取消订单吗?")) {
		var this_ = $(this);
		var id = $(this_).attr("data-id");
		$.ajax({
			url : 'order!cancelOrder.action',
			type : 'post',
			data : {id:id},
			success : function(data) {
				location.reload();
			}
		});
	}
});
	
//生成分页
function showPage(pn, cid){
    var keyword = $("#search").val();
	var url = "json/order!totalNum.action";
	var showpage = "showPage";
	
	if(!pn) pn=1;

	$.ajax({
		url: url,
		type:"post",
		dataType: "json",
		async:false,
		success:function(dat){
			//计算页数
			var pageCount = Math.ceil(dat.total/dat.size);
			if(pageCount < pn){
				pn=pageCount;
			}
			if(dat.total !=0){
			//分页
			$("#"+showpage).createPage({
				dataTotal: dat.total, //数据条数
				pageCount: pageCount, //总页数
				current: pn, //当前页
				backFn: function(pn){
					//单击回调方法，pn是当前页码
					//获取列表数据
					getContentList(pn, cid);
					
				}
			});
			}
			//获取列表数据
			getContentList(pn, cid);
			
		}
		
	});

}


//搜索提交
$(function(){
	var now="";
	$("#searchbtn").bind("click",function(){
		var id=1;
		var pro = $("#search").attr("attr-pro");
		var keyword=$("#search").val();
		if(keyword == now){
			return false;
		}else{
			now = keyword;
		}
		var data={}, hash;
		if(window.location.href.indexOf('?')>=0){
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		}else{
			hashes = {};
		}
		var url = window.location.href.slice(0,window.location.href.indexOf('?')+1);
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			data[hash[0]] = hash[1];
		}
		data["pn"] = id;
		data["ps"]=0;
		data["pro"] = pro;
		data["keyword"] = keyword;
		var param = "";
		for(var key in data){
			param+=(key+"="+data[key]+"&");
		}
		
		param = param.substring(0,param.length-1);
		if(window.location.href.indexOf('?')>=0){
			window.location.href=url+param;
		}else{
		window.location.href=url+"?"+param;
		}
	});
})	



</script>
