<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>创建新文章</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">

        <div class="row">
            <div class="col-md-6">
                <h1>创建新文章</h1>
                <hr/>
                <%--<form:form action="/articles/new" method="post" commandName="article" role="form">--%>
                    <div class="form-group">
                        <label for="title">题目:</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="Enter Title:"/>
                    </div>
                    <div class="form-group">
                        <label for="select">选择文章分类:</label>
                        <select class="form-control" id="select">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="form-group" >
                        <input type="text" class="form-control" id="input" placeholder="创建新分类"/>
                        <button class="btn btn-md btn-success" id="create">创建新分类</button>
                    </div>
                    <div class="form-group">
                        <label for="description">描述:</label>
                        <input type="text" class="form-control" id="description" placeholder="PleaseInput Description"/>
                    </div>
                    <div class="form-group">
                        <label for="content">内容</label>
                        <textarea oninput="syn($('#content'), $('#preview'))" class="form-control" id="content" name="content" rows="8" placeholder="Please Input Content" spellcheck="false"></textarea>
                    </div>

                <button  class="btn btn-sm btn-success" id="submit">提交</button>

                <%--</form:form>--%>
            </div>
            <h1>MarkDown预览</h1>
            <hr/>
            <div class="col-md-6">
                <div id="preview"></div>
            </div>
        </div>

</div>
<!--加载markdown js文件-->

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/markdown.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>