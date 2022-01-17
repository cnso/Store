<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购物车</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
		<style>
			body {
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
		<jsp:useBean id="cart" class="edu.zhuoxun.store.entry.Cart" scope="session"/>
	</head>

	<body>

		
		<jsp:include page="header.jsp"/>
		<div class="container">
		    <c:if test="${not empty cart.cartItems }">
			<div class="row">
            
				<div style="margin: 10px auto 0;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
						<c:forEach items="${cart.cartItems}" var="item">	
							<tr class="active">
								<td width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> ${item.product.pname}</a>
								</td>
								<td width="20%">
									<fmt:formatNumber type="currency" value="${item.product.shop_price}"/>
								</td>
								<td width="10%">
									<label>
										<input type="text" name="quantity" value="${item.num}" maxlength="4" size="10">
									</label>
								</td>
								<td width="15%">
									<span class="subtotal"><fmt:formatNumber type="currency" value="${item.subTotal}"/></span>
								</td>
								<td>
									<a href="javascript:void(0)" id="${item.product.pid}" class="delete">删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					赠送积分: <em style="color:#ff6600;"><fmt:formatNumber type="number" maxFractionDigits="0" value="${cart.total}"/></em>&nbsp; 商品金额: <strong style="color:#ff6600;"><fmt:formatNumber type="currency" value="${cart.total}"/></strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/clear-cart-servlet" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath}/save-order-servlet">
						<%--提交表单 --%>
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>
          </c:if>
		</div>

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
			Copyright &copy; 2005-2016版权所有
		</div>

	</body>
<script>
	$(function(){
		//页面加载完毕之后获取到class的值为delete元素,为其绑定点击事件
		$(".delete").click(function(){
			if(confirm("确认删除?")){
				//获取到被删除商品pid
				let pid = this.id;
				window.location.href="/store/del-from-cart-servlet?id="+pid;
			}
		});
	});
</script>
</html>