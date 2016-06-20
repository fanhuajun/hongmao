<#include "/WEB-INF/template/admin/header.ftl" />
    <style>
    .up500{ height: 150px; width: 265px;}
    .td1{ padding: 5px 0;}
       .dia_table td {
    padding: 7px 0;
}
    
    </style>
    <link rel="stylesheet" type="text/css" href="${base}/static/admin/css/jquery.datetimepicker.css"/>
	
	<!-- 板块独有内容 -->
	<script>
	$("#myshop").addClass("on");
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
						<td class="zxltd">企业名称：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="name" id="name" value="${(shop.name)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">企业电话：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="phone" id="phone" value="${(shop.phone)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">企业地址：</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="address" id="address" value="${(shop.address)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">企业封面：</td>
						<td>
						    <div class="dialog_upload up500">
								<img id="avatar1" src="${(shop.cover)!}" data-default="${base}/static/admin/img/img520.jpg">
								<input type="file" id="file" name="file" class="dia_file">
								<input type="hidden" id="addPic" name="addPic" value="">
							</div>
						</td>
					</tr>
					<!--<tr  class="tt-0">
						<td class="zxltd">人均消费:</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="description" id="consumption" value="${(shop.consumption)!}" ></td>
					</tr>-->
					<tr  class="tt-0">
						<td class="zxltd">属性设置:</td>
						<td><input class="dia_inp" type="text" placeholder=" "  name="description" id="cuisine" value="${(shop.cuisine)!}" >
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">最新消费折扣:</td>
						<td><input class="dia_inp" style="width:28px" type="text" placeholder=" "  name="description" id="discount" value="${(shop.discount)!*10}" >折</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">返佣设置:</td>
						<td><button type="button" class="dia_btn" name="description" id="backjson">设置</button></td>
					</tr>
					
					<tr  class="tt-0">
						<td class="zxltd">营业时间:</td>
						<td><input  class="dia_inp" type="text" placeholder=" "  name="description" id="thetime" value="${(shop.thetime)!}" ></td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">评价总数量:</td>
						<td style="color:green;" id="commentcount">${(commentTotal)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">分享总数量:</td>
						<td style="color:green;" id="sharecount">${(shop.sharecount)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">创建时间:</td>
						<td style="color:green;" id="createdate">${(shop.createdate?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">微信支付密码:</td>
						<td style="color:green;" id="createdate">${(shop.wxPaySecrect)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">appid:</td>
						<td style="color:green;" id="createdate">${(shop.appid)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">appKey:</td>
						<td style="color:green;" id="createdate">${(shop.appKey)!}</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">wxPayno:</td>
						<td style="color:green;" id="createdate">${(shop.wxPayno)!}</td>
					</tr>
					<!--<tr>
						<td></td>
						<td class="btntd">
							<a href="javascript:history.go(-1)"><button type="button" class="dia_btn dialog_ok form_ok" ms-click="checkAll" >返回列表</button></a>
						</td>
					</tr>-->
					
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
<!-- 遮罩层 -->
<div class="mask"></div>
<!-- 编辑shop-edit -->
<div class="dialog dialog_backjson">
	<div class="dialog_head">
		<span class="menu_do menu_close"></span>
		<b>返佣设置</b>
	</div>
	<div class="dialog_body">
		<div class="dialog_left">
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
			    <tr>
			    	<td colspan="3">一级返佣设置</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最低返佣：</td> 
					<td td1><input placeholder="" value="${(shop.lowestback1*100)!}" type="text" style="width:150px !important;" class="dia_inp tip1" id="lowestback1"></td>
				</tr>
				<tr>
					<td class="dia_ltd td1">开始时间</td>
					<td class="td1"><input placeholder="" value="${(shop.lastbackbegin1?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" class="dia_inp tip1" style="width:150px !important;" id="datetime11" ></td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
			    <tr>
			    	<td colspan="3">二级返佣设置</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最低返佣：</td> 
					<td td1><input placeholder="" value="${(shop.lowestback2*100)!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="lowestback2"></td>
				</tr>
				<tr>
					<td class="dia_ltd td1">开始时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackbegin2?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" class="dia_inp tip2" style="width:150px !important;" id="datetime52" ></td>
				</tr>
			</table>   
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
			    <tr>
			    	<td colspan="3">三级返佣设置</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最低返佣：</td> 
					<td td1><input placeholder="" value="${(shop.lowestback3*100)!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="lowestback3"></td>
				</tr>
				<tr>
					<td class="dia_ltd td1">开始时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackbegin3?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" class="dia_inp tip2" style="width:150px !important;" id="datetime33" ></td>
				</tr>
			</table>   
		</div>
		<div class="dialog_right">
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
			    	<td colspan="3">&nbsp;</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最高返佣：</td> 
					<td td1><input placeholder="" value="${(shop.highestback1*100)!}" type="text" class="dia_inp tip1" style="width:150px !important;" maxlength="4" id="highestback1"></td>
					<td>%</td>
				</tr>
				<tr>
					<td class="dia_ltd td1">结束时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackend1?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" style="width:150px !important;" class="dia_inp tip1" id="datetime22" ></td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
			    	<td colspan="3">&nbsp;</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最高返佣：</td> 
					<td td1><input placeholder="" value="${(shop.highestback2*100)!}" type="text" class="dia_inp tip2" style="width:150px !important;" maxlength="4" id="highestback2"></td>
					<td>%</td>
				</tr>
				<tr>
					<td class="dia_ltd td1">结束时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackend2?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="datetime23" ></td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" class="dia_table">
				<tr>
			    	<td colspan="3">&nbsp;</td>
			    </tr>
				<tr>
					<td class="dia_ltd td1"><span class="must">*</span>最高返佣：</td> 
					<td td1><input placeholder="" value="${(shop.highestback3*100)!}" type="text" class="dia_inp tip2" style="width:150px !important;" maxlength="4" id="highestback3"></td>
					<td>%</td>
				</tr>
				<tr>
					<td class="dia_ltd td1">结束时间</td>
					<td td1><input placeholder="" value="${(shop.lastbackend3?number_to_datetime?string("yyyy/MM/dd HH:mm"))!}" type="text" style="width:150px !important;" class="dia_inp tip2" id="datetime24" ></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="dialog_foot">
		<button type="button" class="dia_btn dialog_ok form_ok1">确定</button>
	</div>
</div>
<script src="${base}/static/admin/avalon.js"></script>
<script src="${base}/static/admin/highlight/shCore.js"></script>
<script src="${base}/static/admin/js/jquery.datetimepicker.js"></script>
<script>




$(document).on("click","#backjson" ,function() {
var timenow = new Date().getTime();
    var lastbackend1 = timechange("datetime22");
    var lastbackend2 = timechange("datetime23");
    var lastbackend3 = timechange("datetime24");
    if(timenow<lastbackend1){
        $("#datetime11").attr("readonly","readonly");
        $("#datetime22").attr("readonly","readonly");
        $("#highestback1").attr("readonly","readonly");
        $("#lowestback1").attr("readonly","readonly");
    }else{
        $('#datetime11').datetimepicker();
        $('#datetime22').datetimepicker();
    }
    if(timenow<lastbackend2){
        $("#datetime52").attr("readonly","readonly");
        $("#datetime23").attr("readonly","readonly");
        $("#lowestback2").attr("readonly","readonly");
        $("#highestback2").attr("readonly","readonly");
    }else{
        $('#datetime52').datetimepicker();
        $('#datetime23').datetimepicker();
    }
    
    if(timenow<lastbackend3){
        $("#datetime33").attr("readonly","readonly");
        $("#datetime24").attr("readonly","readonly");
        $("#lowestback3").attr("readonly","readonly");
        $("#highestback3").attr("readonly","readonly");
    }else{
        $('#datetime33').datetimepicker();
        $('#datetime24').datetimepicker();
    }
	open_dialog();
	$(".dialog_backjson").show();

});


//保存修改
$(document).on('click','.form_ok1',function(){
       var name = $("#name").val();
       var phone = $("#phone").val();
       var address = $("#address").val();
       var cover = $("#avatar1").attr("src");
       var consumption = $("#consumption").val();
       var discount = parseInt($("#discount").val())*0.1;
       var cuisine = $("#cuisine").val();
       var backjson = $("#backjson").val();
       var lastbackbegin1 = timechange("datetime11");
       var lastbackend1 = timechange("datetime22");
       var lastbackbegin2 = timechange("datetime52");
       var lastbackend2 = timechange("datetime23");
       
        var lastbackbegin3 = timechange("datetime33");
       var lastbackend3 = timechange("datetime24");
       
       
       var highestback1 = $("#highestback1").val();
       var lowestback1 = $("#lowestback1").val();
       var highestback2 = $("#highestback2").val();
       var lowestback2 = $("#lowestback2").val();
       
       
       var highestback3 = $("#highestback3").val()==""?0:$("#highestback3").val();
       var lowestback3 = $("#lowestback3").val()==""?0:$("#lowestback3").val();
       var thetime = $("#thetime").val();
       var commentcount = $("#commentcount").val();
       var sharecount = $("#sharecount").val();
       
       if(highestback1==""||lowestback1==""||highestback2==""||lowestback2==""||highestback3==""||lowestback3==""){
          alert("数据不能为空");return;
       }
       if((lastbackbegin2>lastbackend2)||(lastbackbegin1>lastbackend1)){
           boxalert("开始时间不能大于结束时间");
           return;
       }
   if(confirm('保存后在设置的时间段不能修改，确定保存吗？')){
       
      // alert(timenow);
      // alert(lastbackbegin2); return;
       $.ajax({
           url:'json/shop!shopedit.action',
           type:'post',
           dataType:'json',
           data:{name:name,phone:phone,address:address,cover:cover,cuisine:cuisine,discount:discount,consumption:consumption,backjson:backjson,
                 lastbackbegin1:lastbackbegin1,lastbackend1:lastbackend1,lastbackbegin2:lastbackbegin2,lastbackend2:lastbackend2,lastbackbegin3:lastbackbegin3,lastbackend3:lastbackend3,
                 highestback1:highestback1,lowestback1:lowestback1,highestback2:highestback2,lowestback2:lowestback2,highestback3:highestback3,lowestback3:lowestback3,
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