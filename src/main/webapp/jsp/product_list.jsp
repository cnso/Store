<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>
		
		<c:if test="${empty page.list}">
        	<div class="row" style="width:1210px;margin:0 auto;">
        		<div class="col-md-12">
        			<h1>暂无商品信息</h1>
        		</div>
        	</div>	
        </c:if>
        
        
        <c:if test="${not empty page.list}">
	        <div class="row" style="width:1210px;margin:0 auto;">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="#">首页</a></li>
					</ol>
				</div>
	          <c:forEach items="${page.list}" var="p">
				<div class="col-md-2">
					<a href="${pageContext.request.contextPath}/ProductServlet?pid=${p.pid}">
						<img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;">
					</a>
					<p><a href="${pageContext.request.contextPath}/ProductServlet?pid=${p.pid}" style='color:green'>${p.pname}</a></p>
					<p><font color="#FF0000">商城价：&yen;${p.shop_price}</font></p>
				</div>
			  </c:forEach>
			</div>
			
			<div class="paging">
			 <ul>
				 <li class="paging"><a href="${pageContext.request.contextPath }/ProductPageServlet?currentPage=${page.currentPage==1?1:page.currentPage-1}&pageSize=3&cid=${page.cid}">&lt;&lt;上一页</a></li>
													
				 <li>第${page.currentPage}页/共${page.totalPage }页</li>
			
				 <li class="paging"><a href="${pageContext.request.contextPath }/ProductPageServlet?currentPage=${page.currentPage==page.totalPage?page.totalPage:page.currentPage+1}&pageSize=3&cid=${page.cid}">&lt;&lt;下一页</a></li>
			</ul>
	       </div>
        </c:if>
 	

        

		<!--
       		商品浏览记录:
        -->
		
		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 版权所有
		</div>

	</body>

</html>