/**
 * @Title: userList.js
 * @Package src/main/webapp/static/js
 * @Description: 用户列表
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("userListController", function($scope, $http){
	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;
	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getUserList.json"
		}).success(function(dataResult) {
			$scope.userList = dataResult.data.dataList || [];
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

	$scope.resetSearch = function() {
		$scope.userName = "";
	};
	
	$scope.changeUesrState = function(id,state) {
		$http({
			method : "post",
			url : "/tc100/changeUesrState.json?userId=" + id+"&state="+state
		}).success(function(dataResult) {
			alert("解除禁止成功，该用户可正常发布");
			$scope.showList();
		});
	};
	
});