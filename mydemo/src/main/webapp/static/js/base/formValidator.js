// JavaScript Document
$(function(){
	$('form').bootstrapValidator({
		message: '该字段不能为空！',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			userName: {
				message: '用户名不能为空！',
				validators: {
					notEmpty: {
						message: '用户名不能为空！'
					}
				}
			},
			userPwd: {
				message: '密码不能为空！',
				validators: {
					notEmpty: {
						message: '密码不能为空！'
					},
					stringLength: {
						min: 6,
						max: 11,
						message: '密码长度为6-11位！'
					}
				}
			}
		}
	});
});