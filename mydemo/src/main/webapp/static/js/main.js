/*====================================================
  TABLE OF CONTENT
  1. function declearetion
  2. Initialization
====================================================*/

/*===========================
 1. function declearetion
 ==========================*/
var commonApp = {
	backToTop : function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 100) {
				$('#back-to-top').fadeIn();
			} else {
				$('#back-to-top').fadeOut();
			}
		});
		$('#back-to-top').on('click', function(e) {
			e.preventDefault();
			$('html, body').animate({
				scrollTop : 0
			}, 1000);
			return false;
		});
	},
	isLogin : function() {
		// 操作页面判断是否登录
		if ((window.location.href).indexOf("user") > -1 && !$.cookie("userId")) {
			// 登录信息失效
			// 判断是否自动登录 是 自动登录 否 跳转到登录页面
			var isAutoLogin = false;
			if (isAutoLogin) {

			} else {
				// cookie过期 删除
				$.removeCookie('userId', {
					path : '/'
				});
				$.removeCookie('displayName', {
					path : '/'
				});
				window.location.href = "/login?backUrl=" + window.location.pathname + window.location.search;
			}
		} else {
			if (!!$.cookie("userId")) {
				$("#login").html("<a href='/user/userIndex'>" + ($.cookie("displayName") || "游客") + "</a><a href='javascript:void(0)' onclick='commonApp.logout()'>退出</a>");
			} else {
				$("#login").html("<a href='/login' >登录</a>");
			}
		}
	},
	logout : function() {
		$.ajax({
			type : "get",
			url : "/logout.json",
			dataType : "json",
			success : function(dataResult) {
				window.location.href = "/";
			}
		})
	},
	init : function() {
		commonApp.backToTop();
		commonApp.isLogin();
	}
}
