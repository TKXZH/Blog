<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>博客文章管理</title>
    <title>Bootstrap 实例 - 组件对齐方式</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href='http://lihancong.cn/public/css/index.css' rel='stylesheet'>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap-hover-dropdown/2.0.10/bootstrap-hover-dropdown.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/article_category.js" type="text/javascript"></script>
</head>
<body>

<%@include file="common/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="posts nav-info animation">
                <p class="posts-info">${acDto.category.name}</p>
            </div>
            <div id="articles"></div>
        </div>

        <div class="col-md-3 sidebar">
            <div class="clearfix"></div>
            <div class="sidebar-content">
                <!-- start info area -->
                <div class="card">
                    <div class="header"></div>
                    <div class="avater">
                        <img alt="avater" src="/public/pics/head.jpg">
                    </div>
                    <div class="content">
                        <h3>${acDto.author.nickName}</h3>
                        <ul class="status">
                            <li><span class="normal">${acDto.author.articleNum}</span><br>文章</li>
                            <li><span class="normal">${acDto.author.categoryNum}</span><br>分类</li>
                            <li><span class="normal">${acDto.author.star_num}</span><br>收到的赞</li>
                        </ul>
                    </div>
                    <div style="clear:both;"></div>
                </div>

                <!-- start category area -->
                <h5>分类</h5>

                <ul class='nav nav-sidebar'>
                    <c:forEach items="${acDto.categories}" var="category">
                        <li class="">
                            <a href="/categories/${category.id}/show">${category.name}</a>
                        </li>
                    </c:forEach>
                </ul>

            </div>
        </div>
    </div>

</div>

</body>
</html>