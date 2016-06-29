i
<#include "/WEB-INF/template/admin/header.ftl" />
    <style>
    .up500{ height: 150px; width: 265px;}
    .td1{ padding: 5px 0;}
    
    
    </style>
    <link rel="stylesheet" type="text/css" href="${base}/static/admin/css/jquery.datetimepicker.css"/>
	
	<!-- 板块独有内容 -->
	<script>
	$("#wechat").addClass("on");
	</script>
	<div class="zxbody">
		<!--<div class="zxbody_title zxbody_title2">
			<a href="javascript:history.back();" class="zxback">
				<img src="${base}/static/admin/img/do_back.png">
			</a>
			店铺详情
		</div>-->
		<form id="myform" name="myform" method="post" action="">
			<div class="zxform">
				<table cellspacing="0" cellpadding="0" width="100%" class="zxtable">
					
					<tr  class="tt-0">
						<td class="zxltd">Appid：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="appid" id="appid" value="${(shop.appid)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">AppSecret：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="appKey" id="appKey" value="${(shop.appKey)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">微信支付秘钥：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="wxPaySecrect" id="wxPaySecrect" value="${(shop.wxPaySecrect)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">微信支付商户ID：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="wxPayno" id="wxPayno" value="${(shop.wxPayno)!}" ></td>
					</tr>
					
					<tr>
						<td></td>
						<td class="btntd">
							<button type="button" class="dia_btn form_ok1 "  >确定</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
<script src="${base}/static/admin/avalon.js"></script>
<script src="${base}/static/admin/highlight/shCore.js"></script>
<script src="${base}/static/admin/js/jquery.datetimepicker.js"></script>
<script>
//保存修改
$(document).on('click','.form_ok1',function(){
       var appid = $("#appid").val();
       var wxPayno = $("#wxPayno").val();
       var wxPaySecrect = $("#wxPaySecrect").val();
       var appKey = $("#appKey").attr("src");
   if(confirm('保存后在设置的时间段不能修改，确定保存吗？')){
       $.ajax({
           url:'json/wechat!edit.action',
           type:'post',
           dataType:'json',
           data:{name:name,phone:phone,address:address,cover:cover,consumption:consumption,backjson:backjson,
                 lastbackbegin1:lastbackbegin1,lastbackend1:lastbackend1,lastbackbegin2:lastbackbegin2,lastbackend2:lastbackend2,
                 highestback1:highestback1,lowestback1:lowestback1,highestback2:highestback2,lowestback2:lowestback2,
                 thetime:thetime,commentcount:commentcount,sharecount:sharecount,},
           success:function(data){
                if(data.success){
                    boxalert("修改成功");
                    location.reload();
                }
           }
       })
    }
})
//时间转时间戳
function timechange(i){
       var f = $("#"+i).val().split(' ',2);
       if(f==""){return 0;}
       var d = f[0].split('/',3);
       var t = f[1].split(':',2);
       var lastbackbegin1 = new Date(d[0],d[1],d[2],t[0],t[1],0).getTime();
       return lastbackbegin1;
}

//选择图片
$(function() {
	$('#avatar1').live('click', function(){
		$("#file").trigger("click");
	});
	$('#file').live("change",function(){
		fileupload();
	});
});
	
function fileupload(){
$.ajaxFileUpload({
		url:'${base}/upload.action',       //需要链接到服务器地址
		secureuri:false,
		fileElementId:'file',                            //文件选择框的id属性
		dataType: 'text/html',                                   //服务器返回的格式，可以是json
		fileSize:300,     
		data:{width:'520', length:'250',limit:300},
		success: function (data, textStatus) {
			//兼容ie8以及以下版本
        	if(data.success){
        		$("#addPic").val(data.bigurl);
				$("#avatar1").attr("src",data.bigurl);
        	}
            //兼容火狐、谷歌、ie8以上版本
			var dat = eval("("+data+")");
			if(dat.success){
				$("#addPic").val(dat.bigurl);
				$("#avatar1").attr("src",dat.bigurl);
			}
			if(data.msg){
				alert(data.msg)
			}
			if(dat.msg){
				alert(dat.msg)
			}
			
			
		}
	});
}

$(".menu_close").click(function(){
   location.reload();
})
   
	
</script>

<!-- 表单提交 -->
<#include "/WEB-INF/template/admin/myform.ftl" />