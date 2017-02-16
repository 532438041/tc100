/**
 * @Title: operateFeeList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 帖子奖惩
 * @author LiuTao
 * @date 2017年1月5日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("operateFeeController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 2;
	$scope.total = 0;
	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getOpFeeList.json"
		}).success(function(dataResult) {
			$scope.operateFeeList = dataResult.data.dataList || [];
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
		title : "帖子资费",
		content : $('#operateFeeForm'),
		onOk : function() {
			// 表单校验
			$('#operateFeeForm').bootstrapValidator('validate');
			if ($('#operateFeeForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.operateFeeId
				}
				var param = $("#operateFeeForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/tc100/saveOpFee.json"
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
			$('#operateFeeForm').bootstrapValidator('validate');
			$('#operateFeeForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.operateFeeId = "";
			$scope.vLogType = "";
			$scope.vAmount = "";
			$scope.vRemark = "";
		}
	});

	$scope.addOperateFeeView = function() {
		modal.setTitle("添加资费");
		modal.open();
	};

	$scope.editOperateFeeView = function(id) {
		modal.setTitle("编辑资费");
		$scope.getOperateFeeById(id);
		modal.open();
	};

	$scope.seeOperateFeeView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看资费");
		$scope.getOperateFeeById(id);
		modal.open();
	};

	$scope.getOperateFeeById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getOpFee.json?id=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.operateFeeId = data.id;
			$scope.vLogType = data.logType;
			$scope.vAmount = data.amount;
			$scope.vRemark = data.remark;
		});
	};

	$scope.delOperateFee = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/delOpFee.json?id=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	};

	$scope.resetSearch = function() {
		$scope.logType = "";
	};
});
