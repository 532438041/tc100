/**
 * @Title: login.js
 * @Package src/main/webapp/static/js
 * @Description: 登录
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
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
				url : "/tc100/adminLogin.json",
				data : param
			}).success(function(dataResult) {
				if (dataResult.status == 1) {
					alert(dataResult.msg);
					window.location.href = "/tc100/view/index.html";
				} else {
					alert(dataResult.msg);
				}
			});
		}
	};

	$scope.registerBtn = function() {
		$('#loginForm').data('bootstrapValidator').resetForm(true);
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
