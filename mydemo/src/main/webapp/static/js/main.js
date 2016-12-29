/*====================================================
  TABLE OF CONTENT
  1. function declearetion
  2. Initialization
====================================================*/

/*===========================
 1. function declearetion
 ==========================*/
var commonApp = {
	backToTop: function() {
		$(window).scroll(function(){
			if ($(this).scrollTop() > 100) {
				$('#back-to-top').fadeIn();
			} else {
				$('#back-to-top').fadeOut();
			}
		});
		$('#back-to-top').on('click', function(e){
			e.preventDefault();
			$('html, body').animate({scrollTop : 0},1000);
			return false;
		});
	},
	isLogin:function(){
		var displayName = $.cookie("displayName");
		if((window.location.href).indexOf("user")>-1 && $.cookie("userId")==null){
			window.location.href = "/";
		}else{
			if($.cookie("userId")){
				$("#login").html("<a href='/user/userIndex'>"+displayName+"</a><a href='javascript:void(0)' id='logout'>退出</a>");
			}else{
				$("#login").html("<a href='/login' >登录</a>");
			}
		}
	},
	logout:function(){
		$("#logout").click(function(){
			$.cookie('userId', '');
			$.cookie('displayName', '');
			window.location.href = "/";
		})
	},
	init: function() {
		commonApp.backToTop();
		commonApp.isLogin();
		commonApp.logout();
	}
}


