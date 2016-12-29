// JavaScript Document
$(function(){
	$('form').bootstrapValidator({
		message: '该字段不能为空！',
		feedbackIcons: {
			valid: '',
			invalid: '',
			validating: ''
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
	$('#addArticleForm').bootstrapValidator({
		message: '该字段不能为空！',
		feedbackIcons: {
			valid: '',
			invalid: '',
			validating: ''
		},
		fields: {
			title: {
				message: '文章标题不能为空！',
				validators: {
					notEmpty: {
						message: '文章标题不能为空！'
					}
				}
			},
			subtitle: {
				message: '副标题/简介不能为空！',
				validators: {
					notEmpty: {
						message: '副标题/简介不能为空！'
					}
				}
			},
			articleCateId: {
				message: '文章标签不能为空！',
				validators: {
					notEmpty: {
						message: '文章标签不能为空！'
					}
				}
			},
			content: {
				message: '文章内容不能为空！',
				validators: {
					notEmpty: {
						message: '文章内容不能为空！'
					}
				}
			}
		}
	});
});