// JavaScript Document
$(function(){
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
			cateId: {
				message: '选择一个文章标签！',
				validators: {
					notEmpty: {
						message: '文章标签'
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