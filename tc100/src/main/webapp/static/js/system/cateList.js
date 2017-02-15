/**
 * @Title: cateList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 分类列表
 * @author LiuTao
 * @date 2017年1月5日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("cateListController", function($scope, $http) {

	$scope.showList = function() {
		$scope.pageNum = 1;
		$scope.pageSize = 10;
		$scope.total = 0;
		$http({
			method : "get",
			url : "/tc100/getCateTree.json"
		}).success(function(dataResult) {
			var cateList = dataResult.data || [];
			if (cateList.length == 0) {
				$scope.selectedNodeId = "0";
			}
			var treeData = [ {
				id : "0",
				pid : "-1",
				cateLevel : 0,
				name : "分类管理"
			} ];
			for (var i = 0; i < cateList.length; i++) {
				// 默认选中第一个一级分类
				if (!!!$scope.selectedNodeId && cateList[i].pid == 0) {
					$scope.selectedNodeId = cateList[i].id;
				}
				var nodeData = {
					id : cateList[i].id,
					pid : cateList[i].pid,
					pids : cateList[i].pids,
					cateLevel : cateList[i].cateLevel,
					name : cateList[i].cateName
				};
				treeData.push(nodeData);
			}
			$scope.zTree = $.fn.zTree.init($("#cateTree"), {
				callback : {
					onClick : $scope.selectNode
				}
			}, treeData);
			// 默认第一个展开 选中
			if ($scope.selectedNodeId.length > 0) {
				var node = $scope.zTree.getNodeByParam("id", $scope.selectedNodeId);
				$scope.zTree.selectNode(node);
				$scope.zTree.expandNode(node, true);
				$scope.getCateByPid();
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
		$scope.getCateByPid();
	};

	// 获取子节点列表
	$scope.getCateByPid = function(isCallback) {
		var baseParam = {
			pid : $scope.selectedNodeId
		};
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize, baseParam);
		$http({
			method : "post",
			data : param,
			url : "/tc100/getCateByPid.json"
		}).success(function(dataResult) {
			$scope.cateList = dataResult.data.dataList || [];
			$scope.total = dataResult.data.total;
			if (isCallback)
				return false;
			$('.page-pager').initPagination({
				totalCount : $scope.total,
				limit : $scope.pageSize,
				callback : function(curr, limit, totalCount) {
					$scope.pageNum = curr;
					$scope.getCateByPid(true);
				}
			});
		})
	};

	var modal = new Modal({
		title : "管理分类",
		content : $('#cateForm'),
		onOk : function() {
			var sNodes = $scope.zTree.getSelectedNodes();
			if (sNodes.length > 0) {
				// 表单校验
				$('#cateForm').bootstrapValidator('validate');
				if ($('#cateForm').data('bootstrapValidator').isValid()) {
					var baseParam = {
						id : $scope.cateId
					}
					if (!!!$scope.cateId) {
						// 添加时的参数
						baseParam.pid = $scope.selectedNodeId;
						baseParam.pids = (!!sNodes[0].pids ? (sNodes[0].pids + ',') : '') + sNodes[0].id;
						baseParam.cateLevel = ++sNodes[0].cateLevel;
						baseParam.sort = !!sNodes[0].children ? ++sNodes[0].children.length : 1;
					}

					var param = $("#cateForm").serializeJson(baseParam);
					$http({
						method : "post",
						data : param,
						url : "/tc100/saveCate.json"
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
			$('#cateForm').bootstrapValidator('validate');
			$('#cateForm').data('bootstrapValidator').resetForm(true);
			modal.showButton(".btn-ok");
			$scope.cateId = "";
			$scope.cateName = "";
			$scope.remark = "";
		}
	});

	$scope.addCateView = function() {
		/*
		 * // 限制到二级 if (!!$scope.zTree.getSelectedNodes()[0].pid &&
		 * $scope.zTree.getSelectedNodes()[0].pid != "0") {
		 * alert("分类只能添加到二级目录"); return false; }
		 */
		modal.setTitle("添加分类");
		modal.open();
	};

	$scope.editView = function(id) {
		modal.setTitle("编辑分类");
		$scope.getCateById(id);
		modal.open();
	};

	$scope.seeView = function(id) {
		modal.hideButton(".btn-ok");
		modal.setTitle("查看分类");
		$scope.getCateById(id);
		modal.open();
	};

	$scope.getCateById = function(id) {
		$http({
			method : "get",
			url : "/tc100/getCateById.json?cateId=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.cateId = data.id;
			$scope.cateName = data.cateName;
			$scope.remark = data.remark;
		});
	};

	$scope.delCate = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/tc100/deleteCate.json?cateId=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	};

	$scope.resetSearch = function() {
		$scope.s_cateName = "";
		$scope.s_remark = "";
	};
});
