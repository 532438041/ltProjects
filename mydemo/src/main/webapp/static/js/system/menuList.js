/**
 * @Title: menuList.js
 * @Package src/main/webapp/static/js/system/
 * @Description: 菜单列表
 * @author LiuTao
 * @date 2016年11月22日 下午1:54:24
 * @version V1.0
 */

angular.module("indexApp").controller("menuListController", function($scope, $stateParams, $http) {

	$scope.showList = function() {
		$scope.pageNum = 1;
		$scope.pageSize = 20;
		$scope.total = 0;
		$http({
			method : "get",
			url : "/menu/getMenuTree.json"
		}).success(function(dataResult) {
			var menuList = dataResult.data || [];
			var treeData = [ {
				id : "0",
				pId : "-1",
				name : "模块管理"
			} ];
			for (var i = 0; i < menuList.length; i++) {
				// 默认选中第一个一级菜单
				if (!!!$scope.selectedNodeId && menuList[i].pid == 0) {
					$scope.selectedNodeId = menuList[i].id;
				}
				var nodeData = {
					id : menuList[i].id,
					pId : menuList[i].pid,
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
	}

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
	}

	// 获取子节点列表
	$scope.getMenuByPid = function(isCallback) {
		var baseParam = {
			pid : $scope.selectedNodeId
		};
		var param = $(".search-from").serializePageJson($scope.pageNum, $scope.pageSize, baseParam);
		$http({
			method : "post",
			data : param,
			url : "/menu/getMenuByPid.json"
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
	}

	var modal = new Modal({
		content : $('#menuForm'),
		onOk : function() {
			// 表单校验
			$('#menuForm').bootstrapValidator('validate');
			if ($('#menuForm').data('bootstrapValidator').isValid()) {
				var baseParam = {
					id : $scope.menuId,
					pid : $scope.selectedNodeId
				}
				var param = $("#menuForm").serializeJson(baseParam);
				$http({
					method : "post",
					data : param,
					url : "/menu/saveMenu.json"
				}).success(function(dataResult) {
					alert(dataResult.msg);
					if (dataResult.status == 0) {
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
			$('#menuForm').bootstrapValidator('validate');
			$('#menuForm').data('bootstrapValidator').resetForm(true);
		}
	});

	$scope.addMenuView = function() {
		// 限制到二级
		if (!!$scope.zTree.getSelectedNodes()[0].pId && $scope.zTree.getSelectedNodes()[0].pId != "0") {
			alert("模块只能添加到二级目录");
			return false;
		}
		modal.options.title = "添加模块";
		modal.open();
	}

	$scope.delMenu = function(id) {
		confirm({
			msg : "确认删除？",
			onOk : function() {
				$http({
					method : "post",
					url : "/menu/deleteMenu.json?menuId=" + id
				}).success(function(dataResult) {
					$scope.showList();
				});
			}
		});
	}

	$scope.resetSearch = function() {
		$scope.menuId = "";
		$scope.menuUrl = "";
		$scope.menuName = "";
	}
});