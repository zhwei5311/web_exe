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
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" ></script>
  <script type="text/javascript">
    function findUser() {
      //获得用户名
      var username = $("#username").val();
      //发送ajax请求，访问LoginServlet
      $.post("${pageContext.request.contextPath}/findUserServlet", {username:username},function(data) {
        //接收后台处理结果
        if(null == data || 0 == data.length) {
          alert("没有查询到用户数据!");
          return;
        }
        $("#list tbody tr").eq(0).nextAll().remove();
        $.each(data,function (i,json) {
          var tr = $("<tr></tr>");
          var idTd = $("\"<td>\"+json['id']+\"</td>\"");
          var nameTd = $("<td>"+json['name']+"</td>");
          var ageTd = $("<td>"+json['age']+"</td>");
          var eduTd = $("<td>"+json['edu']+"</td>");
          var genderTd = $("<td>"+json['gender']+"</td>");
          //将td加入tr
          tr.append(idTd);
          tr.append(nameTd);
          tr.append(ageTd);
          tr.append(eduTd);
          tr.append(genderTd);
          //将tr放入表格
          $("#list").append(tr);
        })
      },"json");
    }
  </script>
</head>
<body>
用户名:<input id="username" name="username" /><input type="button" value="查询" onclick="findUser()" /><hr>

<table id="list" border=1 >
  <tr>
    <td>id</td>
    <td>用户名</td>
    <td>年龄</td>
    <td>学历</td>
    <td>性别</td>
  </tr>
</table>
</body>
</html>
