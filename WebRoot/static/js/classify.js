var downcategorydat = {};
var downcircledat = {};
$('.seller-list').on(
		'click',
		function() {
			var _this = $(this);
			var type = _this.attr('data-nav');

			if (type === "category") {
				_this.hasClass('active') ? _this.removeClass('active')
						&& $('.dropdown-wrapper').removeClass('visible-block')
						&& $('.category-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'visible',
							'height' : ''
						}) : _this.addClass('active')
						&& $('.dropdown-wrapper').addClass('visible-block')
						&& $('.category-wrapper').addClass('active-1')
						&& _this.siblings(_this).removeClass('active')
						&& $('.biz-wrapper').removeClass('active-1')
						&& $('.sort-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'hidden',
							'height' : '100%'
						});

			}
			if (type === "biz") {
				_this.hasClass('active') ? _this.removeClass('active')
						&& $('.dropdown-wrapper').removeClass('visible-block')
						&& $('.biz-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'visible',
							'height' : ''
						}) : _this.addClass('active')
						&& $('.dropdown-wrapper').addClass('visible-block')
						&& $('.biz-wrapper').addClass('active-1')
						&& _this.siblings(_this).removeClass('active')
						&& $('.category-wrapper').removeClass('active-1')
						&& $('.sort-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'hidden',
							'height' : '100%'
						});
			}
			if (type === "sort") {
				_this.hasClass('active') ? _this.removeClass('active')
						&& $('.dropdown-wrapper').removeClass('visible-block')
						&& $('.sort-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'visible',
							'height' : ''
						}) : _this.addClass('active')
						&& $('.dropdown-wrapper').addClass('visible-block')
						&& $('.sort-wrapper').addClass('active-1')
						&& _this.siblings(_this).removeClass('active')
						&& $('.category-wrapper').removeClass('active-1')
						&& $('.biz-wrapper').removeClass('active-1')
						&& $('html,body').css({
							'overflow' : 'hidden',
							'height' : '100%'
						});

			}
		})
$('.category-1>li').on('click', function() {
	var id = $(this).attr("data-id");
	if(downcategorydat[id]==null){
		$.ajax({
			url:"json/category!down.action",
			data:{nodeid:id},
			success:function(data){
				var dat = eval("("+data+")");
				if(dat.success){
					downcategorydat[id] = dat.categories;
					downcategory(dat.categories);
				}
			}
		})
	}else{
		downcategory(downcategorydat[id]);
	}
	$(this).addClass("active").siblings().removeClass("active");
	$(this).addClass("selected").siblings().removeClass("selected");
	
});
function downcategory(downdat){
	$('.category-2').html("");
	var length = downdat.length;
	$('.category-2').append('<li data-id="0"><a href="#" class="jrdy">分类全部</a></li>');
	for(var i=0;i<length;i++){
		var down = downdat[i];
		$('.category-2').append('<li data-id="'+down.id+'"><a href="#" class="jrdy">'+down.name+'</a></li>');
	};
	$('.category-2').addClass('active');
}
function downCircle(downdat){
	$(".biz-2").html("");
	var length = downdat.length;
	$('.biz-2').append('<li data-id="0">全部商圈</li>');
	for(var i=0;i<length;i++){
		var down = downdat[i];
		$('.biz-2').append('<li data-id="'+down.id+'">'+down.name+'</li>');
	};
	$('.biz-2').addClass('active');
}
$('.biz-1>li').on('click', function() {
	var id = $(this).attr("data-id");
	if(downcircledat[id]==null){
		$.ajax({
			url:"json/circle!list.action",
			data:{areaid:id},
			success:function(data){
				var dat = eval("("+data+")");
				if(dat.success){
					downcircledat[id] = dat.circles;
					downCircle(dat.circles);
				}
			}
		})
	}else{
		downCircle(downcircledat[id]);
	}
	$(this).addClass("active").siblings().removeClass("active");
	$(this).addClass("selected").siblings().removeClass("selected");
})

var dropdown = document.getElementById('dropdown-wrapper');
var category = document.getElementById('category-wrapper');
var bizw = document.getElementById('biz-wrapper');
var sortw = document.getElementById('sort-wrapper');
eventuti.addHandler(dropdown, 'touchstart', function(event) {
	eventuti.preventDefault(event);
	eventuti.stopPropagation(event);
})
eventuti.addHandler(category, 'touchstart', function(event) {
	// eventuti.preventDefault(event);
	eventuti.stopPropagation(event);
})
eventuti.addHandler(bizw, 'touchstart', function(event) {
	// eventuti.preventDefault(event);
	eventuti.stopPropagation(event);
})
eventuti.addHandler(sortw, 'touchstart', function(event) {
	// eventuti.preventDefault(event);
	eventuti.stopPropagation(event);
});
