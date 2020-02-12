<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="top.zhwei.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: zhwei
  Date: 2020/2/11
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elexpression</title>
</head>
<body>
<%
    List<String> list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("msg",list);

    Map<String,String> map = new HashMap<>();
    map.put("key1","aaa");
    map.put("key2","bbb");
    application.setAttribute("msg",map);

    User user1 = new User();
    User user2 = null;
    request.setAttribute("user1",user1);
    request.setAttribute("user2",user2);
%>

${requestScope.msg[1]}<br>
${applicationScope.msg["key2"]}<br>
${applicationScope.msg.key1}<br>
${empty user1}<br>
${not empty user2}
</body>
</html>
