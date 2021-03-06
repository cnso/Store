<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品详情信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
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
    </style>
    <jsp:useBean id="product" class="edu.zhuoxun.store.entry.Product" scope="request"/>
</head>

<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div style="margin:0 auto;width:950px;">
            <form id="myForm" method="post" action="${pageContext.request.contextPath}/add-to-cart-servlet">
                <div class="col-md-6">
                    <img style="opacity: 1;width:400px;height:350px;" title="" class="medium"
                         src="${pageContext.request.contextPath}/${product.pimage}">
                </div>

                <div class="col-md-6">
                    <div><strong>${product.pname}</strong></div>
                    <div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
                        <div>编号：${product.pid}</div>
                    </div>

                    <div style="margin:10px 0 10px 0;">亿家价: <strong
                            style="color:#ef0101;"><fmt:formatNumber type="currency" value="${product.shop_price}"/>元/份</strong> 参 考 价：
                        <del><fmt:formatNumber type="currency" value="${product.market_price}"/>元/份</del>
                    </div>

                    <div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
                                                              style="background-color: #f07373;">限时抢购</a></div>

                    <div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
                        <div style="margin:5px 0 10px 0;">白色</div>

                        <div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
                            <label for="quantity"><input id="quantity" name="quantity" value="1" maxlength="4" size="10"
                                                         type="text"></label>
                        </div>

                        <input type="hidden" name="pid" value="${product.pid}"/>

                        <div style="margin:20px 0 10px 0;;text-align: center;">
                            <%--加入到购物车 --%>
                            <a href="javascript:void(0)">
                                <input id="btnId"
                                       style="background: url('${pageContext.request.contextPath}/img/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;"
                                       value="加入购物车" type="button">
                            </a> &nbsp;收藏商品
                        </div>
                    </div>
                </div>
            </form>
            <div class="clear"></div>
            <div style="width:950px;margin:0 auto;">
                <div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
                    <strong>商品介绍</strong>
                    <h3>${product.pdesc}</h3>
                </div>
            </div>
        </div>

        <div style="margin-top:50px;">
            <img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势"
                 title="我们的优势"/>
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
    </div>
</div>
</body>
<script>
    $(function () {
        $("#btnId").click(function () {
            let formObj = document.getElementById("myForm");
            formObj.submit();
        });
    });
</script>
</html>