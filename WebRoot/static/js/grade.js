
/* 	<div class="grade" data-grade="4.5"></div>
	<script type="text/javascript" src="js/grade.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".grade").grade({"show":true}); // show:true 显示评分
		})
	</script>
*/

;(function($) {
	var defaults = {
		show:null
	};
	
	$.fn.extend({		
		grade: function(options){      		
			var options = $.extend(defaults, options);
			var min=0,max=5;

			this.each(function(){
				var obj=$(this);
				var num=obj.attr('data-grade');
				var integer=num;
				var dec=integer.split(".");
				var inte=Number(dec[0]),
					decimal=Number(dec[1]);

				var htm='<i></i>'+
						'<i></i>'+
						'<i></i>'+
						'<i></i>'+
						'<i></i>';
				obj.html(htm);
				var ilen=obj.find('i');

				if(integer>min && integer<=max){
					if(inte<1){
						if(decimal>0 && decimal<=9){
							for(var i=0; i<1; i++){
								ilen.eq(i).addClass('grd2');
							}
						}						
					}
					else if(inte<2){
						for(var i=0; i<inte; i++){
							ilen.eq(i).addClass('grd1');
						}
						if(decimal>0 && decimal<=9){
							ilen.eq(inte).addClass('grd2');
						}						
					}
					else if(inte<3){
						for(var i=0; i<inte; i++){
							ilen.eq(i).addClass('grd1');
						}
						if(decimal>0 && decimal<=9){
							ilen.eq(inte).addClass('grd2');
						}
					}
					else if(inte<4){
						for(var i=0; i<inte; i++){
							ilen.eq(i).addClass('grd1');
						}
						if(decimal>0 && decimal<=9){
							ilen.eq(inte).addClass('grd2');
						}
					}
					else if(inte<5){
						for(var i=0; i<inte; i++){
							ilen.eq(i).addClass('grd1');
						}
						if(decimal>0 && decimal<=9){
							ilen.eq(inte).addClass('grd2');
						}
					}
					else{
						for(var i=0; i<inte; i++){
							ilen.eq(i).addClass('grd1');
						}
					}

				}else{
					//alert('数值错误！');
					return;
				}

				if(options.show===true){
					obj.append('<span>'+integer+'分</span>');
				}else{
					return;
				}
			})
			
		}
	});

})(jQuery);