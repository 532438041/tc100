/**
 * @Title: payCodeList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

indexApp.controller("payCodeListController", function($scope, $http) {

	$http({
		method : "get",
		url : "/tc100/getPayCodeList.json"
	}).success(function(dataResult) {
		var str = "当前可用：\r\n";
		for (var i = 0; i < dataResult.data.length; i++) {
			str += (dataResult.data[i].code + "  ");
		}
		$("#codes").val(str);
	});

	$scope.savePayCode = function() {
		$http({
			method : "post",
			url : "/tc100/createPayCode.json?num=20"
		}).success(function(dataResult) {
			window.location.reload();
		});
	};

});
