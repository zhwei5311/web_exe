<%--
  Created by IntelliJ IDEA.
  User: zhwei
  Date: 2020/2/23
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>使用ajax加载json数据查询显示用户信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js" ></script>
    <script type="text/javascript">
      function login() {
        //获得用户名
        var username = $("#username").val();
        //发送ajax请求，访问LoginServlet
        $.post("${pageContext.request.contextPath}/loginServlet", {username:username},function(json) {
          //接手后台处理结果
          if(json.type == 1) {
            //登录成功，将页面中的登录表单替换为欢迎信息
            $("info").empty();
            $("info").append($("<span>" + json.msg + "</span>"));
          } else {
            //登陆失败，弹出错误提示
            alert(json.msg);
          }
        },"json");
      }
    </script>
  </head>
  <body>
  <h2>使用ajax加载json数据查询显示用户信息</h2>
  <div id="info" align="left" >
    用户名:<input type="text" id="username" name="username"  /><br/><br/>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password" /><br/><br/>
    <input type="button" onclick="login();" value="登录">
  </div>
  </body>
</html>
