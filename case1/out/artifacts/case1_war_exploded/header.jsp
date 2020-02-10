<%@ page import="java.util.List" %>
<%@ page import="top.zhwei.domain.Category" %><%--
  Created by IntelliJ IDEA.
  User: zhwei
  Date: 2020/2/10
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    $(function () {
        // if ($("ul li").size() == 0) {
            location.href = "/case1/findAllCategoryServlet";
        // }
    });
</script>
<body>
<ul class="nav navbar-nav">
    <%
        List<Category> categories = (List<Category>) pageContext.findAttribute("categories");
        if (categories != null && categories.size() > 0) {
            for (Category category : categories) {
                out.write("<li><a href = '#'>");
                out.write(category.getCname());
                out.write("</a></li>");
            }
        }
    %>
</ul>
</body>
</html>
