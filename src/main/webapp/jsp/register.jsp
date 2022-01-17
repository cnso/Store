<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/dist/jquery.validate.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/dist/localization/messages_zh.min.js" type="text/javascript"></script>
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

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
    <script>
        $(function (){
            $('#registerForm').validate({
                messages: {
                    username: {
                        required: '用户名为必填项',
                        minlength: '用户名至少为三位'
                    },
                    password: {
                        required: '密码为必填项',
                        minlength: '密码至少为六位'
                    },
                    confirmpwd: {
                        required: '确认密码为必填项',
                        minlength: '确认密码至少为六位',
                        equalTo: '两次密码不一致'
                    },
                    email: {
                        email: '请输入一个正确的邮箱'
                    }
                },
                rules: {
                    username: {
                        required: true,
                        minlength: 3
                    },
                    password: {
                        required: true,
                        minlength: 6
                    },
                    confirmpwd: {
                        required: true,
                        minlength: 6,
                        equalTo: '#password'
                    },
                    email: {
                        email: true
                    }
                }

            })
        })
    </script>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
    <div class="row">

        <div class="col-md-2"></div>


        <div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <form class="form-horizontal" style="margin-top:5px;"
                  action="${pageContext.request.contextPath}/regist-servlet" method="post" id="registerForm">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="confirmpwd" name="confirmpwd" placeholder="请输入确认密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入电话">
                    </div>
                </div>
                <div class="form-group opt">
                    <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio1" value="男"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input id="date" type="date" class="form-control" name="birthday">
                    </div>
                </div>
                <div>
                    <p id="error" style="text-align: center; color: red">${ msg }</p>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="注册" name="submit" border="0"
                               style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                                       height:35px;width:100px;color:white;">
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>

    </div>
</div>


<div style="margin-top:50px;">
    <img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势"/>
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




