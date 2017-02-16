/**
 * @Title: sysParamList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统参数
 * @author LiuTao
 * @date 2017年1月5日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("activeFeeListController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 2;
	$scope.total = 0;
	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getActFeeList.json"
		}).success(function(dataResult) {
			$scope.activeFeeList = dataResult.data.dataList || [];
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
		title : "系统参数",
		content : $('#activeFeeForm'),
		onOk : function() {
			// 表单校验
			$('#activeFeeForm').bootstrapValidator('validate');
			if ($('#activeFeeForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.activeFeeId
				}
				var param = $("#activeFeeForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/tc100/saveActFee.json"
				}).success(function(dataResult) {
					if (dataResult.status == 0) {
						alert(dataResult.msg);
						return false;
					} else {
						$scope.showList();
					}
				});
			} else {
				return false;
			}
		},
		onModalHide : function() {
			// 初始化Modal
			$('#activeFeeForm').bootstrapValidator('validate');
			$('#activeFeeForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.activeFeeId = "";
			$scope.vActType = "";
			$scope.vAmount = "";
			$scope.vUnit = "";
		}
	});

	$scope.addActiveFeeView = function() {
		modal.setTitle("添加资费");
		modal.open();
	};

	$scope.editActiveFeeView = function(id) {
		modal.setTitle("编辑资费");
		$scope.getActiveFeeById(id);
		modal.open();
	};

	$scope.seeActiveFeeView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看资费");
		$scope.getActiveFeeById(id);
		modal.open();
	};

	$scope.getActiveFeeById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getActFee.json?id=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.activeFeeId = data.id;
			$scope.vActType = data.actType;
			$scope.vAmount = data.amount;
			$scope.vUnit = data.unit;
		});
	};

	$scope.delActiveFee = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/delActFee.json?id=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	};

	$scope.resetSearch = function() {
		$scope.actType = "";
	};
});
