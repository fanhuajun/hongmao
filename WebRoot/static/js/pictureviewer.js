;(function($) {
	var defaults = {
		show:null
	};
	$.fn.extend({
		picture:function(options){
			var options = $.extend(defaults, options);
			//定义图片浏览器的弹出层盒子
			var oDiv='<div class="picturebox">'+
						'<div class="picturearea"></div>'+
						'<a href="javascript:;" class="close-picturebox"><i class="iconfont icon-close"></i></a>'+
						'<p class="pages"></p>'+
				 	 '</div>'+
				 	 '<div class="pop"></div>';
			//将盒子添加到页面中
			$('body').append(oDiv);

			//循环元素
			this.each(function(){
				var _this=$(this);
				var objimg=_this.find('img');//查找当前元素中的img			
				var oImgside='';				

				//循环img
				for(var i=0; i<objimg.length; i++){
					//获取每个img的src
					var src=objimg[i].getAttribute('src');
					//将所有循环到的src添加到图片盒子中
					var bi=parseInt(i+1);
					oImgside += '<div class="swiper-slide">'+
			      				'<div class="imgbox"><p><span><img src="'+src+'"></span></p></div>'+
				      		'</div>';

					//获取当前点击的图片索引
					(function(index){
						objimg[i].onclick=function(){
							var wrap='<div class="swiper-container" id="swiper-container">'+
										'<div class="swiper-wrapper">'+oImgside+'</div>'+
									'</div>';					
							$('.picturearea').html(wrap);
							$('.picturebox').addClass('picture-visible');
							$('.pop').addClass('pop-visible');
							$('body').css({overflow:'hidden'});

							//点击加载js到页面中
							var js='<script>'+
										'var swiper = new Swiper(".swiper-container", {'+
											'pagination: ".swiper-pagination",'+
											'paginationClickable: true,'+
											'initialSlide :'+index+','+
								            'spaceBetween:0,'+
								            'onSlideChangeStart: function(swiper){'+
												'$(".pages").html(swiper.activeIndex+1+"/"+swiper.slides.length);'+
										    '},'+
										    'onInit: function(swiper){'+
											    '$(".pages").html(swiper.activeIndex+1+"/"+swiper.slides.length);'+
											'}'+
								        '});'+
									'</script>';
							$('body').append(js);					
						}
					})(i);					
				}	
			});
			//关闭图片浏览器
			$(document).on('click','.close-picturebox',function(){
				$('body').css({overflow:''});	
				$('.picturebox').removeClass('picture-visible');
				$('.pop').removeClass('pop-visible');
				$('.swiper-container').remove();
			})
		}
	})
})(jQuery);