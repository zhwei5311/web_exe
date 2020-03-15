<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>编辑</title>

        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">编辑</h3>
        <form action="${pageContext.request.contextPath}/updateServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${books.id}">

          <div class="form-group">
            <label for="name">商品名称：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${books.name}" readonly="readonly" placeholder="请输入商品名称" />
          </div>

          <div class="form-group">
            <label for="price">商品价格：</label>
            <input type="text" class="form-control" value="${books.price}" id="price"  name="price" placeholder="请输入价格" />
          </div>

          <div class="form-group">
            <label for="pnum">商品数量：</label>
            <input type="text" id="pnum" class="form-control" value="${books.pnum}" name="pnum" placeholder="请输入商品数量"/>
          </div>

          <div class="form-group">
            <label for="category">商品类别：</label>
             <select name="category" id="category" class="form-control" >
                 <c:if test="${books.category == '少儿'}">
                     <option value="少儿"  selected>少儿</option>
                     <option value="文学">文学</option>
                     <option value="计算机">计算机</option>
                     <option value="武侠">武侠</option>
                 </c:if>

                 <c:if test="${books.category == '文学'}">
                     <option value="少儿">少儿</option>
                     <option value="文学"  selected>文学</option>
                     <option value="计算机">计算机</option>
                     <option value="武侠">武侠</option>
                 </c:if>

                 <c:if test="${books.category == '计算机'}">
                     <option value="少儿">少儿</option>
                     <option value="文学">文学</option>
                     <option value="计算机" selected>计算机</option>
                     <option value="武侠">武侠</option>
                 </c:if>

                 <c:if test="${books.category == '武侠'}">
                     <option value="少儿">少儿</option>
                     <option value="文学">文学</option>
                     <option value="计算机">计算机</option>
                     <option value="武侠" selected>武侠</option>
                 </c:if>
            </select>
          </div>


             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>