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
		var backUrl = window.location.search;
		if (!!backUrl && backUrl.indexOf("backUrl") > -1) {
			backUrl = backUrl.substring(9, backUrl.length);
		} else {
			backUrl = "/";
		}
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
					window.location.href = backUrl;
				} else {
					alert(dataResult.msg);
				}
			});
		}
	};
});

$(function() {
	$("#loginForm").bootstrapValidator({
		fields : {
			userName : {
				validators : {
					notEmpty : {
						message : "手机号/邮箱不能为空！"
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
					}
				}
			}
		}
	});
})
