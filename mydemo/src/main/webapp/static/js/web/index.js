/**
 * @Title: index.js
 * @Package src/main/webapp/static/js/web
 * @Description: 登录
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */


var indexApp = angular.module("index",[]);
indexApp.controller("indexController", function($scope, $http) {
	$http({
		method : "post",
		url : "/articleList.json",
		data : {}
	}).success(function(dataResult) {
		var result =  dataResult.data.dataList;
		$scope.articleList = result;
	});
});

