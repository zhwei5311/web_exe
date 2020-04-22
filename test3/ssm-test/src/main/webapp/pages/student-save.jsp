<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save student's information</title>
</head>
<body>
    <h1>添加学生信息</h1>
    <form name="studentForm" action="${pageContext.request.contextPath}/student/save" method="post">
        名称:<input type="text" name="name"><br>
        性别:<input type="text" name="sex"><br>
        年龄:<input type="text" name="age"><br>
        电话:<input type="text" name="phone"><br>
        班级:<input type="text" name="gradeid"><br>
        <input type="submit" value="保存"><br>
    </form>
</body>
</html>
