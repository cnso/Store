<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
		<jsp:useBean id="product_page" class="edu.zhuoxun.store.entry.Page" scope="request"/>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<c:if test="${empty product_page.list}">
        	<div class="row" style="width:1210px;margin:0 auto;">
        		<div class="col-md-12">
        			<h1 style="text-align: center;">暂无商品信息</h1>
        		</div>
        	</div>	
        </c:if>
        
        
        <c:if test="${not empty product_page.list}">
	        <div class="row" style="width:1210px;margin:0 auto;">
	          <c:forEach items="${product_page.list}" var="p">
				<div class="col-md-2">
					<a href="${pageContext.request.contextPath}/store/product-servlet?pid=${p.pid}">
						<img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;">
					</a>
					<p style="white-space: nowrap; overflow:hidden; text-overflow: ellipsis; text-align: center"><a href="${pageContext.request.contextPath}/store/product-servlet?pid=${p.pid}" style='color:green'>${p.pname}</a></p>
					<p style="text-align: center;"><span style="color: #FF0000; ">商城价：<fmt:formatNumber type="currency" value="${ p.shop_price }"/></span></p>
				</div>
			  </c:forEach>
			</div>
			
			<div class="paging">
			 <ul>
				 <li class="paging" style="display: inline"><a href="${pageContext.request.contextPath }/store/${product_page.cid == null ?"search-servlet":"product-page-servlet"}?currentPage=${product_page.currentPage==1?1:product_page.currentPage-1}&pageSize=3&${product_page.cid == null?"keyword":"cid"}=${product_page.cid == null? product_page.keyword : product_page.cid}">&lt;&lt;上一页</a></li>
													
				 <li style="display: inline">第${product_page.currentPage}页/共${product_page.totalPage }页</li>
			
				 <li class="paging" style="display: inline"><a href="${pageContext.request.contextPath }/store/${product_page.cid == null ?"search-servlet":"product-page-servlet"}?currentPage=${product_page.currentPage==product_page.totalPage?product_page.totalPage:product_page.currentPage+1}&pageSize=3&${product_page.cid == null?"keyword":"cid"}=${product_page.cid == null? product_page.keyword : product_page.cid}">下一页&gt;&gt;</a></li>
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