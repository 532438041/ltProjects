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
							// 重置注册按钮
							$('#registerForm').bootstrapValidator('disableSubmitButtons', false);
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
				var baseParam = {
					userPwd : $scope.userPwd
				};
				// 判断输入的是手机号还是邮箱
				if (mobilePattern.test($scope.userName)) {
					baseParam.mobile = $scope.userName;
				} else if (emailPattern.test($scope.userName)) {
					baseParam.email = $scope.userName;
				} else {
					baseParam.userName = $scope.userName;
				}
				$http({
					method : "post",
					url : "/register.json",
					data : JSON.stringify({
						param : baseParam
					})
				}).success(function(dataResult) {
					if (dataResult.status == 1) {
						alert(dataResult.msg);
						window.location.href = "/login";
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

$(function() {
	$("#registerForm").bootstrapValidator({
		fields : {
			userName : {
				validators : {
					notEmpty : {
						message : "手机号/邮箱不能为空！"
					},
					regexp : { // 正则校验
						regexp : mobile_or_email,
						message : '请填写正确的手机号/邮箱！'
					},
					stringLength : {
						max : 50,
						message : '请填写正确的手机号/邮箱！'
					}
				}
			},
			userPwd : {
				message : '密码不能为空！',
				validators : {
					notEmpty : {
						message : '密码不能为空！'
					},
					stringLength : {
						min : 6,
						max : 11,
						message : '密码长度为6-11位！'
					}
				}
			}
		}
	});
})
