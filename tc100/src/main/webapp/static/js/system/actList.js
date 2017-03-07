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
	
	var modal = new Modal({
		title : "编辑",
		content : $('#actForm'),
		onOk : function() {
			var param = $("#actForm").serializeJson();
			console.log(param);
			if ($("#startTime").val().length>0 && $("#endTime").val().length>0) {
				$http({
					method : "post",
					data : param,
					url : "/tc100/upAct.json"
				}).success(function(dataResult) {
					if (dataResult.status == 0) {
						alert(dataResult.msg);
						return false;
					} else {
						alert("操作成功")
						$scope.showList();
					}
				});
			}else {
				alert("请输入值");
				return false;
			}
		},
		onModalHide : function() {
			// 初始化Modal
			$("#startTime").val("");
			$("#endTime").val("");
		}
	});
	
	$scope.editView = function(id) {
		modal.setTitle("编辑");
		$scope.getActById(id);
		modal.open();
	};
	
	$scope.getActById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getActive.json?actId=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$("#id").val(id);
			$("#startTime").val(data.startTime);
			$("#endTime").val(data.endTime);
		});
	};
	
});
