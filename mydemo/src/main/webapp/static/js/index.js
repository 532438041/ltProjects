/**
 * @Title: login.js
 * @Package src/main/webapp/static/js
 * @Description: 登录
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */

var indexApp = angular.module("indexApp", [ "ui.router", "oc.lazyLoad" ]);

indexApp.run([ '$rootScope', function($rootScope) {
	$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
		if (!$.cookie("userId")) {
			// 登录信息失效
			alert("帐号已失效，请重新登录！");
			// 判断是否自动登录 是 自动登录 否 跳转到登录页面
			var isAutoLogin = false;
			if (isAutoLogin) {

			} else {
				$rootScope.logout();
			}
		}
	});

	$rootScope.$on('$stateNotFound', function(event, unfoundState, fromState, fromParams) {

	});

	$rootScope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams, error) {

	});

} ]);

indexApp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");

	$stateProvider.state("default", {
		url : "/",
		template : "404"
	}).state("userList", {
		url : "/userList",
		templateUrl : "system/userList.html",
		resolve : {
			load : function($ocLazyLoad) {
				return $ocLazyLoad.load([ "static/js/system/userList.js" ]);
			}
		}
	}).state("menuList", {
		url : "/menuList",
		templateUrl : "system/menuList.html",
		resolve : {
			load : function($ocLazyLoad) {
				return $ocLazyLoad.load([ "static/js/base/jquery.ztree.all.js", "static/js/system/menuList.js" ]);
			}
		}
	}).state("roleList", {
		url : "/roleList",
		templateUrl : "system/roleList.html",
		resolve : {
			load : function($ocLazyLoad) {
				return $ocLazyLoad.load([ "static/js/system/roleList.js" ]);
			}
		}
	});
});

indexApp.controller("topController", function($scope, $rootScope) {
	$scope.displayName = $.cookie("displayName") || "游客用户";

	// 全局退出登录
	$rootScope.logout = function() {
		$.cookie('userId', '');
		$.cookie('displayName', '');
		window.location.href = "/login.html";
	}
});

indexApp.controller("menuController", function($scope, $location, $http) {
	// 全局变量初始化
	$scope.parentMenuName = "";
	$scope.activeMenuName = $location.path().split("/")[1] || "";
	$scope.activeMenu = function(parentMenuName, activeMenuName) {
		$scope.parentMenuName = parentMenuName;
		$scope.activeMenuName = activeMenuName;
	};

	// 切换菜单右侧箭头
	$scope.getIcon = function(index) {
		if ($("#collapse" + index).hasClass("in")) {
			$("#collapse" + index).prev().find(".fr").removeClass("icon-chevron-down").addClass("icon-chevron-right");
		} else {
			$("#collapse" + index).parent().siblings().find(".fr").removeClass("icon-chevron-down").addClass("icon-chevron-right");
			$("#collapse" + index).prev().find(".fr").removeClass("icon-chevron-right").addClass("icon-chevron-down");
		}
	}

	$http({
		method : "get",
		url : "getMenuTree.json"
	}).success(function(dataResult) {
		$scope.menuList = dataResult.data || [];

		$scope.topMenuList = $.grep($scope.menuList, function(item, index) {
			return item.pid == "0";
		});

		$scope.secondMenuList = $.grep($scope.menuList, function(item, index) {
			return item.pid != "0";
		});

		// 获取当前菜单的menu对象
		var activeMenu = $.grep($scope.secondMenuList, function(item, index) {
			return item.menuUrl == $scope.activeMenuName;
		});
		if (activeMenu.length == 0) {
			return false;
		}
		// 获取当前菜单的父级menu对象
		var parentMenu = $.grep($scope.topMenuList, function(item, index) {
			return item.id == activeMenu[0].pid;
		});
		$scope.parentMenuName = parentMenu[0].menuUrl;
	});

});
