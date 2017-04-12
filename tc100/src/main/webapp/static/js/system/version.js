/**
 * @Title: sysParamList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统参数
 * @author LiuTao
 * @date 2017年1月5日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("versionController",
		function($scope, $http) {

			var uploader = WebUploader.create({
				auto : true,
				swf : '/tc100/static/js/webuploader/Uploader.swf',
				server : "/tc100/file/uploadFile.json",
				pick : '#filePicker',
				duplicate : true,
			});

			uploader.on('uploadSuccess', function(file, dataResult) {
				$("input[name='pValue']").val(dataResult.data.fileUrl);
			});

			$http({
				method : "get",
				url : "/tc100/getSysPByKey.json?pKey=version"
			}).success(function(dataResult) {
				var data = dataResult.data;
				$scope.id = data.id;
				$("input[name='pName']").val(data.pName);
				$("input[name='pValue']").val(data.pValue);
			});

			$scope.saveInfo = function() {
				var baseParam = {
					id : $scope.id,
					pKey : "version"
				}
				var param = $("#paramForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/tc100/saveSysP.json"
				}).success(function(dataResult) {
					if (dataResult.status == 0) {
						alert("操作失败");
					} else {
						alert("操作成功");
					}
				});
			};

		});
