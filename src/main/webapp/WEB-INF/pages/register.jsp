<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 修改博客</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>用户注册</h1>
    <hr/>
    <form:form action="/createuser" method="post"  role="form">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" class="form-control" id="username" name="name" placeholder="请输入用户名:"/>
        </div>
        <div class="form-group">
            <label for="nickName">昵称:</label>
            <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称:"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" class="form-control" id="password" name="pwd" placeholder="请输入密码:"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">注册</button>
        </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/canvas-nest.js/1.0.0/canvas-nest.min.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>