<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文件上传</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/upload.css">
	<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/webuploader/webuploader.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/upload.js"></script>
	<script src="${pageContext.request.contextPath}/static/avalon/avalon.js"></script>
</head>
<body ms-controller="imageList">
	<input type="button" value="上传图片" ms-click="upload()">
	<div ms-widget="smartgrid, smartgridImageList, $smartgridImageList" ></div>
	
	<!--弹出遮罩层-->
	<div class="zpzs_gray"></div>
	<!--上传框开始-->
	<div id="uploader">
		<!--上传框头部-->
		<div class="add_img_head">
			<span></span> <b class="closeBtn"></b>
		</div>
		<!--缩略图容器-->
		<div id="fileList"></div>
		<!--选择图片按钮-->
		<div class="add_img">
			<div id="filePicker"></div>
			<p>按住Ctrl可多选照片</p>

			<p>单次上传最多12张(单张最大2M)</p>

			<div class="uploadBtn">开始上传</div>
		</div>
	</div>
	<!--上传框结束-->
	
	<script type="text/javascript">
        require(["smartgrid/avalon.smartgrid"], function() {
            var smartgridImageList = avalon.define("imageList", function(vm) {
                vm.$skipArray = ["smartgrid"]
                vm.$smartgridImageList = {
                    columns: [
                        {
                            key : "id", 
                            name : "序号"
                        }, {
                            key : "imgName",
                            name : "图片名称"
                        }, {
                            key : "imgUrl",
                            name : "图片",
                            format:'imgUrl'
                        }, {
                            key : "userId",
                            name : "图片所有者"
                        }
                    ],
                 	// 渲染列数据的方法集合
        			htmlHelper: {
        				imgUrl: function(vmId, field, index, cellValue, rowData) {
        					return '<img alt="' + rowData.imgName + '" src="${pageContext.request.contextPath}' + rowData.imgUrl + '"  width="50" height="50">';
        				}
        			},
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
        						avalon.vmodels.smartgridImageList.pager.perPages = newValue;
        						showList();
        					}
        				}
        			}
                }
                
                vm.upload = function(){
                	$(".zpzs_gray, #uploader").show();
                }
            })
            avalon.scan();
            setTimeout(function() {
        		showList();
        	}, 300);
        })
        
		function showList() {
           	var gridAVM = avalon.vmodels.smartgridImageList;
       		gridAVM.showLoading();
       		$.ajax({
       			type: "post",
       			dataType: "json",
       			data: {
       				pageNo : avalon.vmodels.smartgridImageList.pager.currentPage,
       				pageSize : avalon.vmodels.smartgridImageList.pager.perPages
       			},
       			url: "${pageContext.request.contextPath}/image/getImageList",
       			success: function(dataResult) {
       				var data = dataResult.dataList;
					var totalRecords = dataResult.total;
					if(totalRecords == 0){
						gridAVM.noResult = '暂无结果';
						gridAVM.pageable = false; 
					}else{
						gridAVM.pageable = true; 
						avalon.vmodels.smartgridImageList.pager.totalItems = totalRecords;
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