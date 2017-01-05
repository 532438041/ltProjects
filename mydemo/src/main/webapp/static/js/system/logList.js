/**
 * @Title: logList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 系统日志
 * @author LiuTao
 * @date 2017年1月4日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("logListController", function($scope, $stateParams, $http) {

	$scope.pageNum = 1;
	$scope.pageSize = 5;
	$scope.total = 0;

	$scope.showList = function(isCallback) {
		var baseParam = {
			method : $scope.s_method,
			logType : $scope.s_logType
		};
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize, baseParam);
		$http({
			method : "post",
			data : param,
			url : "/log/getLogList.json"
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
	});

	$scope.seeView = function(id) {
		$scope.getLogById(id);
		modal.open();
	};

	$scope.getLogById = function(id) {
		$http({
			method : "get",
			url : "/log/getLogById.json?logId=" + id
		}).success(function(dataResult) {
			var data = dataResult.data;
			$scope.createName = data.createName;
			$scope.reqIp = data.reqIp;
			$scope.createTime = data.createTime;
			$scope.method = data.method;
			$scope.details = data.details;
			$scope.logType = data.logType;
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
