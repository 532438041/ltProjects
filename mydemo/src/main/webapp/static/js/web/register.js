/**
 * @Title: register.js
 * @Package src/main/webapp/static/js/web
 * @Description: 注册
 * @author LiuTao
 * @date 2016年12月26日 下午2:41:46
 * @version V1.0
 */
var registerApp = angular.module("registerApp", []);
registerApp.controller("registerController", function($scope, $http) {
	$scope.registerBtn = function() {
		$('#registerForm').bootstrapValidator('validate');
		if ($('#registerForm').data('bootstrapValidator').isValid()) {
			var param = $("#registerForm").serializeJson();
			/*$http({
				method : "post",
				url : "/register.json",
				data : param
			}).success(function(dataResult) {
				if (dataResult.status == 1) {
					alert(dataResult.msg);
					window.location.href = "/";
				} else {
					alert(dataResult.msg);
				}
			});*/
		}
	};
});
