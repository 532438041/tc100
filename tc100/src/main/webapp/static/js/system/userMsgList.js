/**
 * @Title: userMsgList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

indexApp.controller("userMsgListController", function($scope, $http) {

	$scope.saveUserMsg = function() {
		var param = $(".search-from").serializeJson();
		$http({
			method : "post",
			data : param,
			url : "/tc100/saveUserMsg.json"
		}).success(function(dataResult) {
			alert("推送成功！");
			window.location.reload();
		});
	};

});
