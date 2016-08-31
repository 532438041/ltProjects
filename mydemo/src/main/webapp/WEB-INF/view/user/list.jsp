<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/avalon/avalon.js"></script>
</head>
<body ms-controller="userList">
	${msg }
	<input type="button" value="上传图片" ms-click="upload()">
	<div ms-widget="smartgrid, smartgridUserList, $smartgridUserList" ></div>

	<script type="text/javascript">
        require(["smartgrid/avalon.smartgrid"], function() {
            var smartgridUserList = avalon.define("userList", function(vm) {
                vm.$skipArray = ["smartgrid"]
                vm.$smartgridUserList = {
                    columns: [
                        {
                            key : "id", 
                            name : "序号"
                        }, {
                            key : "userName",
                            name : "名称"
                        }
                    ],
                  	//设置分页
        			pageable: true,
        			pager: {
        				onJump: function(e, pagerVM) {
        					showList();
        				},
        				canChangePageSize : true,
        				perPages: 2,
        				options : [2,20,30,50,100],
        				dropdown: {
        					onChange: function(newValue, oldValue, vmodel) {
        						avalon.vmodels.smartgridUserList.pager.perPages = newValue;
        						showList();
        					}
        				}
        			}
                }
                
                vm.upload = function(){
                	window.location.href = "${pageContext.request.contextPath}/upload";
                }
            })
            avalon.scan();
            setTimeout(function() {
        		showList();
        	}, 300);
        })
        
		function showList() {
           	var gridAVM = avalon.vmodels.smartgridUserList;
       		gridAVM.showLoading();
       		$.ajax({
       			type: "post",
       			dataType: "json",
       			data: {
       				pageNo : avalon.vmodels.smartgridUserList.pager.currentPage,
       				pageSize : avalon.vmodels.smartgridUserList.pager.perPages
       			},
       			url: "${pageContext.request.contextPath}/user/getUserList",
       			success: function(dataResult) {
       				var data = dataResult.dataList;
					var totalRecords = dataResult.total;
					if(totalRecords == 0){
						gridAVM.noResult = '暂无结果';
						gridAVM.pageable = false; 
					}else{
						gridAVM.pageable = true; 
						avalon.vmodels.smartgridUserList.pager.totalItems = totalRecords;
					}
					gridAVM.render(data);
					gridAVM.hideLoading();
       			},
       			error: function(XMLHttpRequest, textStatus, errorThrown){  
       				gridAVM.noResult = '服务器获取数据出现问题，请联系管理员。';
       				gridAVM.pageable = false; //分页栏隐藏
       				gridAVM.hideLoading();
       			}
       		});
		}
    </script>

</body>
</html>