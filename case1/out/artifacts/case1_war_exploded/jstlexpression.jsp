<%@ page import="top.zhwei.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: zhwei
  Date: 2020/2/12
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>

<%-- 根据已知数据使用jstl标签对数据大小进行判断 --%>
<%
    int a = 10;
    int b = 12;
%>
<c:if test="${10 < 12}">
    a小于b
</c:if>
<c:if test="${a > b}">
    a大于b
</c:if>
<c:if test="${a = b}">
    a等于b
</c:if>
<%
    User p1=new User();
    p1.setUsername("jack");
    p1.setPassword("abcd");
    User p2=null;
    request.setAttribute("p1", p1);
    request.setAttribute("p2", p2);
%>
<%--
    根据已知数据使用jstl标签判断对象是否为空
 --%>
<c:if test="${not empty p1}">
<%--    p1不为空--%>
    <c:forEach items="p1" var="user" varStatus="s">
        ${user}
    </c:forEach>
</c:if>
<c:if test="${not empty p2}">
    p2不为空
</c:if>
<%-- 使用jstl标签进行0~10数据偶数的循环遍历输出 --%>
<%--<c:forEach begin="1" end="10" var = "i" step="1" varStatus="s">--%>
<%--    <c:if test="${i % 2 == 0}">--%>
<%--        ${i}--%>
<%--    </c:if>--%>
<%--</c:forEach>--%>

</body>
</html>
