/**
 * @Title: login.js
 * @Package src/main/webapp/static/js/web
 * @Description: 登录
 * @author LiuTao
 * @date 2016年12月26日 下午2:41:46
 * @version V1.0
 */
var loginApp = angular.module("loginApp", []);
loginApp.controller("loginController", function($scope, $http) {
	$scope.loginBtn = function() {
		$('#loginForm').bootstrapValidator('validate');
		if ($('#loginForm').data('bootstrapValidator').isValid()) {
			var param = $("#loginForm").serializeJson();
			$http({
				method : "post",
				url : "/login.json",
				data : param
			}).success(function(dataResult) {
				if (dataResult.status == 1) {
					alert(dataResult.msg);
					window.location.href = "/";
				} else {
					alert(dataResult.msg);
				}
			});
		}
	};
});
