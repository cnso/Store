<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>

	<head>
		<title>页首</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
		<jsp:useBean id="loginUser" class="edu.zhuoxun.store.entry.User"  scope="session"/>
	</head>

	<body>
		<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png"  alt="header"/>
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
					
					  <c:if test="${empty loginUser.uid}">
						<li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></li>
					  </c:if>
						
					  <c:if test="${not empty loginUser.uid}">
						<li>欢迎${loginUser.name}</li>
						<li><a href="${pageContext.request.contextPath}/logout-servlet">退出</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">我的订单</a></li>
					  </c:if>	
						
					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="myUL">
							  <%-- 
								  <c:forEach items="${allCats}" var="c">	
									<li><a href="#">${c.cname}</a></li>
								  </c:forEach> 
							  --%>
							</ul>
							<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/store/search-servlet" method="get">
								<div class="form-group">
									<label>
										<input type="text" name="keyword" class="form-control" placeholder="关键字">
									</label>
									<input type="hidden" name="currentPage" value="1">
									<input type="hidden" name="pageSize" value="3">
								</div>
								<input type="submit" class="btn btn-default" value="搜索">
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
	</body>
<script>
$(function(){
	//向服务端CategoryServlet__>gteAllCats发起ajax请求,服务端经过处理,
	//将所有分类信息以JSON格式的数据返回,获取到返回的所有分类绑定在页面的显示分类区域
	let url="/store/category-servlet";
	let obj={"method":"findAllCats"};
	$.post(url,obj,function(data){
		//alert(data);
	
		//获取到服务端响应会的数据,经过观察data中存放的是一个JSON格式数组,遍历数组,动态的显示分类区域代码	
		$.each(data,function(i,obj){
			let li="<li><a href='/store/product-page-servlet?currentPage=1&pageSize=3&cid="+obj.cid+"'>"+obj.cname+"</a></li>";
			$("#myUL").append(li);
		});
		
	},"json");
	
	
});
</script>
</html>