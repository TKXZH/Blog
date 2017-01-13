<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="${pageContext.request.contextPath}/js/article_detail.js" type="text/javascript"></script>
</head>
<body>

<%@include file="common/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-9" id="articles">
            <div class="post">
                <div class="header">
                    <div class="title">
                        <h2 class="text-center">${aacDto.article.title}</h2>
                    </div>
                    <div class='time'>编辑于 <fmt:formatDate value="${aacDto.article.createTime}" pattern="yyyy:MM:dd: HH:mm:ss"/></div>
                    <div style="clear:both;"></div>
                </div>

                <div class="article">${aacDto.article.content}</div>

            </div>
            <!--PC和WAP自适应版-->
            <div id="SOHUCS" sid="请将此处替换为配置SourceID的语句" ></div>
            <script type="text/javascript">
                (function(){
                    var appid = 'cysn6hDCW';
                    var conf = 'prod_01765d062ae929a1965dd8f03e9a6cbf';
                    var width = window.innerWidth || document.documentElement.clientWidth;
                    if (width < 960) {
                        window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>

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
                        <h3>${aacDto.user.nickName}</h3>
                        <ul class="status">
                            <li><span class="normal">${aacDto.user.articleNum}</span><br>文章</li>
                            <li><span class="normal">${aacDto.user.categoryNum}</span><br>分类</li>
                            <li><span class="normal">${aacDto.user.star_num}</span><br>收到的赞</li>
                        </ul>
                    </div>
                    <div style="clear:both;"></div>
                </div>

                <!-- start category area -->
                <h5>分类</h5>

                <ul class='nav nav-sidebar'>
                    <c:forEach items="${aacDto.authorCategories}" var="category">
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