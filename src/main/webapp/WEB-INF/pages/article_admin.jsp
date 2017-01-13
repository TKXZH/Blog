<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>博客文章管理</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <div class="row"></div>

    <div class="row">
        <div class="col-md-10">
            <h1>博客文章管理</h1>
        </div>
        <div class="col-md-2">
            <div class="pull-right">
                <a href="/articles/new" class="btn btn-success btn-lg ">创建文章</a>
            </div>

        </div>

    </div>
    <hr/>
    <!-- 如果用户列表非空 -->
    <c:if test="${!empty articles}">
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>文章ID</th>
                <th>文章正文</th>
                <th>创建时间</th>
                <th>作者</th>
                <th>分类</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td>${article.id}</td>
                    <td>${article.content}</td>
                    <td><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${article.uid}</td>
                    <td>${article.category}</td>
                    <td>
                        <button class="btn btn-sm btn-success">查看</button>
                        <button class="btn btn-sm btn-info">修改</button>
                        <button class="btn btn-sm btn-danger">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js" type="text/javascript"></script>
<script src="//cdn.bootcss.com/canvas-nest.js/1.0.0/canvas-nest.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
