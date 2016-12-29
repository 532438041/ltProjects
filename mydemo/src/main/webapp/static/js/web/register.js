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
	$scope.canRegister = false;
	// 初始化验证插件
	$http({
		method : "get",
		url : "pc-geetest/register.java?t=" + (new Date()).getTime()
	}).success(function(dataResult) {
		initGeetest({
			gt : dataResult.gt,
			challenge : dataResult.challenge,
			product : "float", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
		}, function(captchaObj) {
			// 将验证码加到class为captcha的元素里
			captchaObj.appendTo(".captcha");
			// 验证码刷新 需重新验证
			captchaObj.onRefresh(function() {
				$scope.canRegister = false;
			});
			// 成功的回调
			captchaObj.onSuccess(function() {
				var validate = captchaObj.getValidate();
				$.ajax({
					url : "pc-geetest/validate.java", // 进行二次验证
					type : "post",
					dataType : "json",
					data : {
						// 二次验证所需的三个值
						geetest_challenge : validate.geetest_challenge,
						geetest_validate : validate.geetest_validate,
						geetest_seccode : validate.geetest_seccode
					},
					success : function(data) {
						if (data && (data.status === "success")) {
							$scope.canRegister = true;
						} else {
							$scope.canRegister = false;
						}
					}
				});
			});
		});
	});

	$scope.registerBtn = function() {
		$('#registerForm').bootstrapValidator('validate');
		if ($('#registerForm').data('bootstrapValidator').isValid()) {
			if ($scope.canRegister) {
				var param = $("#registerForm").serializeJson();
				$http({
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
				});
			} else {
				alert("请先完成滑块验证！");
			}
		}
	};
});
