/**
 * @Title: actList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

// 自定义filter
indexApp.filter("state", function() {
	return function(val) {
		switch (val) {
			case "1":
				return "未发布";
			case "2":
				return "正在使用";
			default:
				return "-";
		}
	}
});

indexApp.controller("actListController", function($scope, $http, $filter) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;

	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getActList.json"
		}).success(function(dataResult) {
			$scope.actList = dataResult.data.dataList || [];
			$scope.total = dataResult.data.total;
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

	$scope.delObj = function(id) {
		$http({
			method : "post",
			url : "/tc100/delAct.json?actId=" + id
		}).success(function(dataResult) {
			$scope.showList();
		});
	};

	$scope.resetSearch = function() {
		$scope.s_userName = "";
	};
});
