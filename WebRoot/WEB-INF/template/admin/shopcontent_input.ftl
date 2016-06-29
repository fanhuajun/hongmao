<#include "/WEB-INF/template/admin/header.ftl" />

	<style>
	
	</style>
	<!-- 板块独有内容 -->
	<script>
	$("#wzgl").addClass("on");
	</script>
	<div class="zxbody">
		<div class="zxbody_title zxbody_title2">
			<a href="javascript:history.back();" class="zxback">
				<img src="${base}/static/admin/img/do_back.png">
			</a>
			添加内容
		</div>
		
			<input type="hidden" value="${(id)!}" name="id"/>
			<div class="zxform">
				<table cellspacing="0" cellpadding="0" width="100%" class="zxtable">
					<tr>
						<td class="zxltd"><span class="must">*</span>标题：</td>
						<td><input id="addName2" class="form_inp validate[required]" type="text" placeholder="请输入动态标题" name="title" value="${(shopcontent.title)!}"></td>
					</tr>
					<tr>
						<td class="zxltd"><span class="must">*</span>排序：</td>
						<td><input id="orderbyid" class="form_inp validate[required]" type="text" placeholder="" name="title" style="width:2rem" value="${(shopcontent.orderbyid)!}"></td>
					</tr>
					<tr>
						<td class="zxltd">封面图片：</td>
						<td>
							<table cellspacing="0" cellpadding="0" width="100%" class="form_table">
								<tr>
									<td class="imgtd">
										<div class="dialog_upload">
											<img id="avatar1" src="<#if shopcontent??>${shopcontent.pic}<#else>${base}/static/admin/img/img520.jpg</#if>">
											<input type="file" id="file"  name="file" class="dia_file">
											<input type="hidden" id="addPic" name="addPic" value="">
										</div>
									</td>
									<td class="tiptd">
										<div class="dialog_tip form_tip">
											<h1>点击上传封面图片</h1>
											<p>
											建议上传图片规则:
											<br>
											尺寸：400*300像素
											<br>
											格式：jpg、jpeg、png
											<br>
											图片大小不超过300kb（太大网站会加载很慢）
											</p>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr  class="tt-0">
						<td class="zxltd">内容介绍：</td>
						<td>
							<script type="text/plain" id="mycentent"  style="width:700px;height:240px;">
							
						    	${(shopcontent.content)!}
					     	
							</script>
							<textarea style="display:none" id="txt-content" name="content" >
							
						    	${(shopcontent.content)!}
					     	
							</textarea>
							<script>
							var ue = UE.getEditor('mycentent');
							ue.addListener('blur',function(){
								$("#txt-content").val(ue.getContent());
							});
							</script>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="btntd">
							<button type="button" class="dia_btn dialog_ok form_ok">确定</button>
						</td>
					</tr>
					
				</table>
			</div>
			<#-- 分类id -->
			<input type="hidden" name="nodeId" id="nodeId" value="${nodeId!}">
	</div>
</div>
<script>
//选择图片
$(function() {
//another option is using modals
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

	$(function(){
	//保存或修改文章
	$(document).on('click','.form_ok',function(){
	      var pic = $("#avatar1").attr("src");
	      var content = $("#txt-content").val();
	      var orderbyid2 = $("#orderbyid").val();
	      var title = $("#addName2").val();
	      var thisId = ${(thisId)!0};
	      var addOrEdit =  ${addOrEdit};
	      var parentId = ${(parentId)!0};
	      var toindex = 1;
	      //alert(parentId);return;
	      $.ajax({
		     url:'json/shopcontent!saveOrUpdate.action',
		     type:'post',
		     data:{pic:pic,content:content,thisId:thisId,title:title,toindex:toindex,
		           addOrEdit:addOrEdit,parentId:parentId,orderbyid2:orderbyid2,},
		     success:function(data){
		     var json = eval("("+data+")");
		         if(json.success){
		             boxalert("保存成功");
		         }
		     }
		});
	})
})
	
	
	
	

</script>

<!-- 表单提交 -->
<#include "/WEB-INF/template/admin/myform.ftl" />