/**
 * @Title: payLogList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

indexApp.controller("payLogListController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;

	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getPayLogList.json"
		}).success(function(dataResult) {
			$scope.payLogList = dataResult.data.dataList || [];
			$scope.total = dataResult.data.total;
			$scope.cishu = $scope.payLogList.length;
			$scope.jine = 0;
			for (var i = 0; i < dataResult.data.dataList.length; i++) {
				$scope.jine += dataResult.data.dataList[i].amount;
			};
			if (isCallback)
				return false;
			$('.page-pager').initPagination({
				totalCount : $scope.total,
				limit : $scope.pageSize,
				callback : function(curr, limit, totalCount) {
					$scope.pageNum = curr;
					$scope.showList(true);
				}
			});
		});
	};

	$scope.showList();

	$scope.resetSearch = function() {
		$scope.createTime = "";
		$scope.userName = "";
	};
});
