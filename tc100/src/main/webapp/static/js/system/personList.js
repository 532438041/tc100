/**
 * @Title: personList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年4月6日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

indexApp.controller("personListController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;
	
	$scope.isShow_0 = 0;
	$scope.isShow_1 = 0;
	$scope.vLineType = 0;

	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		alert();
		$http({
			method : "post",
			data : param,
			url : "/tc100/getPersonList.json"
		}).success(function(dataResult) {
			$scope.personList = dataResult.data.dataList || [];
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
		title : "发布代做信息",
		content : $('#personForm'),
		onOk : function() {
			// 表单校验
			$('#personForm').bootstrapValidator('validate');
			if ($('#personForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.personId
				}
				if($scope.lineType==0){
					baseParam = {
						id : $scope.personId,
						userId : $scope.userId,
						addName : $scope.addName
					}
				}else{
					baseParam = {
						id : $scope.personId,
						title : $scope.title,
						remark : $scope.remark
					}
				}
				var param = $("#personForm").serializeJson(baseParam);
				console.log(param);
				$http({
					method : "post",
					data : param,
					url : "/tc100/savePerson.json"
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
			$('#personForm').bootstrapValidator('validate');
			$('#personForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.vLineType = 0;
			$scope.vUserName = "";
			$scope.vUserId = "";
			$scope.vAddName = "";
			$scope.vTitle = "";
			$scope.vRemark = "";
		}
	});

	$scope.addPersonView = function() {
		modal.setTitle("添加代做信息");
		modal.open();
	};

	$scope.editPersonView = function(id) {
		modal.setTitle("编辑代做信息");
		$scope.getPersonById(id);
		modal.open();
	};

	$scope.seePersonView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看代做信息");
		$scope.getPersonById(id);
		modal.open();
	};
	
	$scope.selectType = function(){
		if($scope.vLineType == 0){
			$scope.isShow_0 = 1;
			$scope.isShow_1 = 0;
		}else{
			$scope.isShow_0 = 0;
			$scope.isShow_1 = 1;
		}
	}
	$scope.getPersonById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getPerson.json?id=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			if(data.lineType==0){
				$scope.personId = data.id;
				$scope.userId = data.userId;
				$scope.userName = data.userName;
				$scope.addName = data.addName;
			}else{
				$scope.personId = data.id;
				$scope.title = data.title;
				$scope.remark = data.remark;
			}
		});
	};
	
	$scope.delPerson = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/delPerson.json?id=" + id
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
