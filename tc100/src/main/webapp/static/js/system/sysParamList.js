/**
 * @Title: sysParamList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统参数
 * @author LiuTao
 * @date 2017年1月5日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("sysParamListController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;
	$scope.showList = function() {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getSysPList.json"
		}).success(function(dataResult) {
			$scope.paramList = dataResult.data.dataList || [];
			$scope.total = dataResult.data.total;
		});
	};
	$scope.showList();
	var modal = new Modal({
		title : "系统参数",
		content : $('#paramForm'),
		onOk : function() {
			// 表单校验
			$('#paramForm').bootstrapValidator('validate');
			if ($('#paramForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.paramId
				}
				var param = $("#paramForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/tc100/saveSysP.json"
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
			$('#paramForm').bootstrapValidator('validate');
			$('#paramForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.paramId = "";
			$scope.vPName = "";
			$scope.vPKey = "";
			$scope.vPValue = "";
		}
	});

	$scope.addParamView = function() {
		modal.setTitle("添加参数");
		modal.open();
	};

	$scope.editParamView = function(id) {
		modal.setTitle("编辑参数");
		$scope.getParamById(id);
		modal.open();
	};

	$scope.seeParamView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看参数");
		$scope.getParamById(id);
		modal.open();
	};

	$scope.getParamById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getSysP.json?id=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.paramId = data.id;
			$scope.vPName = data.pName;
			$scope.vPKey = data.pKey;
			$scope.vPValue = data.pValue;
		});
	};

	$scope.delParam = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/delSysP.json?id=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	};

	$scope.resetSearch = function() {
		$scope.pName = "";
		$scope.pKey = "";
	};
});
