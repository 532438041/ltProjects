/**
 * @Title: menuList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 菜单列表
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("menuListController", function($scope, $stateParams, $http) {
	$http({
		method : "get",
		url : "getMenuTree.json"
	}).success(function(dataResult) {
		$scope.menuList = dataResult.data || [];
		var treeData = [];
		for (var i = 0; i < $scope.menuList.length; i++) {
			var topData = {
				id : $scope.menuList[i].id,
				pId : $scope.menuList[i].pid,
				name : $scope.menuList[i].menuName
			};
			treeData.push(topData);
		}
		$.fn.zTree.init($("#menuTree"), {}, treeData);
	});
});
