<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/avalon/avalon.js"></script>
</head>
<body>
	<div class="div1">
		${msg }
	</div>
	<div class="div2">
		<form method="post" action="${pageContext.request.contextPath}/index">
			用户名：<input type="text" name="userName">
			密码：<input type="password" name="userPwd">
			<input type="submit" value="登录">
		</form>
	</div>
	<div class="demo-show" ms-controller="demo">
        <div ms-widget="accordion,aa,$aaOpts">
        </div>
    </div>
	
	<script type="text/javascript">
    	$(function(){
    		if(${not empty msg }){
    			$(".div1").show();
    			$(".div2").show();
    		}else{
    			$(".div1").hide();
    			$(".div2").show();
    		}
    	});
    	require(["accordion/avalon.accordion"], function() {
    		avalon.define('demo',function(vm){
    			vm.$aaOpts = {
                      data: [{
                          'title': '标题1',
                          'content': '正文1<p>fasdfsdaf</p>'
                      }, {
                          'title': '标题2',
                          'content': '正文2'
                      }],
                      accordionClass: "oni-accordion-customClass",
                      initIndex: 1,
                      width: "500",
                      onBeforeSwitch: function() {
                          avalon.log(this);
                          avalon.log(arguments);
                          avalon.log("onBeforeSwitch callback");
                      },
                      onSwitch: function() {
                          avalon.log("onSwitch callback");
                      },
                      multiple: true
                  }
              });
              avalon.scan();
          });
    </script>
</body>
</html>