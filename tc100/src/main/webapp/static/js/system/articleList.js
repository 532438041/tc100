/**
 * @Title: articleList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 文章管理
 * @author LiuTao
 * @date 2017年1月6日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp");

indexApp.controller("articleListController", function($scope, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 10;
	$scope.total = 0;

	$scope.showList = function(isCallback) {
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize);
		$http({
			method : "post",
			data : param,
			url : "/tc100/articleList.json"
		}).success(function(dataResult) {
			$scope.articleList = dataResult.data.dataList || [];
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
		title : "文章下架",
		content : $('#articleForm'),
		width : 400,
		onOk : function() {
			$('#articleForm').bootstrapValidator('validate');
			if ($('#articleForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.id,
					state : "3"
				}
				var param = $("#articleForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/tc100/article/checkArticle.json"
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
			$('#articleForm').bootstrapValidator('validate');
			$('#articleForm').data('bootstrapValidator').resetForm(true);
			$scope.id = "";
		}
	});

	$scope.checkView = function(id) {
		$scope.id = id;
		modal.open();
	}

	$scope.recommend = function(id) {
		$http({
			method : "post",
			url : "/tc100/article/recommendArticle.json?articleId=" + id
		}).success(function(dataResult) {
			$scope.showList();
		});
	}

	$scope.resetSearch = function() {
		$scope.s_title = "";
		$scope.s_displayName = "";
	};
});
