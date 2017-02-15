/**
 * @Title: menuList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 菜单列表
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("menuListController", function($scope, $http) {

	$scope.showList = function() {
		$scope.pageNum = 1;
		$scope.pageSize = 10;
		$scope.total = 0;
		$http({
			method : "get",
			url : "/tc100/menu/getMenuTree.json"
		}).success(function(dataResult) {
			var menuList = dataResult.data || [];
			if (menuList.length == 0) {
				$scope.selectedNodeId = "0";
			}
			var treeData = [ {
				id : "0",
				pid : "-1",
				name : "模块管理"
			} ];
			for (var i = 0; i < menuList.length; i++) {
				// 默认选中第一个一级菜单
				if (!!!$scope.selectedNodeId && menuList[i].pid == 0) {
					$scope.selectedNodeId = menuList[i].id;
				}
				var nodeData = {
					id : menuList[i].id,
					pid : menuList[i].pid,
					name : menuList[i].menuName
				};
				treeData.push(nodeData);
			}
			$scope.zTree = $.fn.zTree.init($("#menuTree"), {
				callback : {
					onClick : $scope.selectNode
				}
			}, treeData);
			// 默认第一个展开 选中
			if ($scope.selectedNodeId.length > 0) {
				var node = $scope.zTree.getNodeByParam("id", $scope.selectedNodeId);
				$scope.zTree.selectNode(node);
				$scope.zTree.expandNode(node, true);
				$scope.getMenuByPid();
			}
		});
	};

	$scope.showList();

	// 选中节点事件
	$scope.selectNode = function() {
		// 单击当前节点 不请求
		if ($scope.selectedNodeId == $scope.zTree.getSelectedNodes()[0].id) {
			return false;
		}
		$scope.selectedNodeId = $scope.zTree.getSelectedNodes()[0].id;
		var node = $scope.zTree.getNodeByParam("id", $scope.selectedNodeId);
		$scope.zTree.expandNode(node, true);
		$scope.getMenuByPid();
	};

	// 获取子节点列表
	$scope.getMenuByPid = function(isCallback) {
		var baseParam = {
			pid : $scope.selectedNodeId
		};
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize, baseParam);
		$http({
			method : "post",
			data : param,
			url : "/tc100/menu/getMenuByPid.json"
		}).success(function(dataResult) {
			$scope.menuList = dataResult.data.dataList || [];
			$scope.total = dataResult.data.total;
			if (isCallback)
				return false;
			$('.page-pager').initPagination({
				totalCount : $scope.total,
				limit : $scope.pageSize,
				callback : function(curr, limit, totalCount) {
					$scope.pageNum = curr;
					$scope.getMenuByPid(true);
				}
			});
		})
	};

	var modal = new Modal({
		title : "管理模块",
		content : $('#menuForm'),
		onOk : function() {
			var sNodes = $scope.zTree.getSelectedNodes();
			if (sNodes.length > 0) {
				// 表单校验
				$('#menuForm').bootstrapValidator('validate');
				if ($('#menuForm').data('bootstrapValidator').isValid()) {
					var baseParam = {
						id : $scope.menuId
					}
					if (!!!$scope.menuId) {
						// 添加时的参数
						baseParam.pid = $scope.selectedNodeId;
						baseParam.sort = !!sNodes[0].children ? ++sNodes[0].children.length : 1;
					}
					var param = $("#menuForm").serializeJson(baseParam);
					$http({
						method : "post",
						data : param,
						url : "/tc100/menu/saveMenu.json"
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
			} else {
				alert("请先选中父节点！");
				return false;
			}
		},
		onModalHide : function() {
			// 初始化Modal
			$('#menuForm').bootstrapValidator('validate');
			$('#menuForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.menuId = "";
			$scope.menuUrl = "";
			$scope.menuName = "";
		}
	});

	$scope.addMenuView = function() {
		// 限制到二级
		if (!!$scope.zTree.getSelectedNodes()[0].pid && $scope.zTree.getSelectedNodes()[0].pid != "0") {
			alert("模块只能添加到二级目录");
			return false;
		}
		modal.setTitle("添加模块");
		modal.open();
	};

	$scope.editView = function(id) {
		modal.setTitle("编辑模块");
		$scope.getMenuById(id);
		modal.open();
	};

	$scope.seeView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看模块");
		$scope.getMenuById(id);
		modal.open();
	};

	$scope.getMenuById = function(id) {
		$http({
			method : "get",
			url : "/tc100/menu/getMenuById.json?menuId=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.menuId = data.id;
			$scope.menuUrl = data.menuUrl;
			$scope.menuName = data.menuName;
		});
	};

	$scope.delMenu = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/menu/deleteMenu.json?menuId=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	};

	$scope.resetSearch = function() {
		$scope.s_menuUrl = "";
		$scope.s_menuName = "";
	};
});
