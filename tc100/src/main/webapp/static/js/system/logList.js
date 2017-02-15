/**
 * @Title: logList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

// 自定义filter
indexApp.filter("logType", function() {
	return function(val) {
		switch (val) {
			case "00":
				return "后台操作";
			case "01":
				return "后台异常";
			case "10":
				return "前台操作";
			case "11":
				return "前台异常";
			default:
				return "-";
		}
	}
});

indexApp.controller("logListController", function($scope, $http, $filter) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;

	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/log/getLogList.json"
		}).success(function(dataResult) {
			$scope.logList = dataResult.data.dataList || [];
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

	var modal = new Modal({
		title : "查看系统日志",
		content : $('#logForm'),
		buttons : [ {
			html : '<button type="button" class="btn btn-sm btn-default btn-cancel">取消</button>',
			selector : '.btn-cancel'
		} ],
		width : 600
	});

	$scope.seeView = function(id) {
		$scope.getLogById(id);
		modal.open();
	};

	$scope.getLogById = function(id) {
		$http({
			method : "get",
			url : "/tc100/log/getLogById.json?logId=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.createName = data.createName;
			$scope.reqIp = data.reqIp;
			$scope.createTime = $filter('date')(data.createTime, 'yyyy-MM-dd hh:mm:ss');
			$scope.method = data.method;
			$scope.details = data.details;
			$scope.logType = $filter("logType")(data.logType);
			$scope.exCode = data.exCode;
			$scope.exDetail = data.exDetail;
			$scope.params = data.params;
		});
	};

	$scope.resetSearch = function() {
		$scope.s_method = "";
		$scope.s_logType = "";
	};
});
