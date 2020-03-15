<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>bookStore列表</title>
    <%--导入css --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
    <!-- 导入CSS的全局样式 -->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        $(function () {
            //1.给登录按钮绑定单击事件
            $("#btn_sub").click(function () {
                //2.发送ajax请求，提交表单数据
                $.post("/loginServlet",$("#loginForm").serialize(),function (data) {
                    //data : {flag:false,errorMsg:''}
                    if(data.flag){
                        //登录成功
                        console.log(data);
                        location.href="index.html";
                    }else{
                        //登录失败
                        $("#errorMsg").html(data.errorMsg);
                    }
                });
            });
        });
    </script>
</head>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <div width="100%" border="0" cellspacing="0">
        <div>

            <div>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
                </div>

            </div>
        </div>
        <div style="background-color: #5CA5D6">
            <table border="1px" width="50%">
                <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                    <div class="form-group">
                        <label for="user">用户名：</label>
                        <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
                    </div>

                    <div class="form-group">
                        <label for="password">密码：</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
                    </div>

                    <div class="form-group" style="text-align: center;">
                        <input class="btn btn btn-primary" type="submit" value="登录">
                    </div>
                </form>
            </table>
        </div>
    </div>
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>&times;</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>


</body>
</html>
