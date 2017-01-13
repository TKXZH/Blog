<!--博客导航栏-->
<%@page pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">${user.nickName}的主页</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <!--向左对齐-->
            <ul class="nav navbar-nav">
                <li><a href="/${user.id}/articles/show">最近文章</a></li>
                <li><a>关于我</a></li>
                <li><a href="/${user.id}/articles/messages">留言墙</a></li>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" id="dropdownMenu1" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">--%>
                        <%--JavaScript--%>
                        <%--<b class="caret"></b>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">jmeter</a></li>--%>
                        <%--<li><a href="#">EJB</a></li>--%>
                        <%--<li><a href="#">Jasper Report</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <!--向右对齐-->
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="文章检索">
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> 搜索</button>
                </form>
                <li id="register"><a href="#" ><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                <li id="show"><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                <li>
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">用户登录</h4>
                                </div>
                                <div class="modal-body">
                                    <form  role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="用户名" id="username">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="密码" id="password">
                                        </div>
                                    </form>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary" id="login">登录</button>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>
                </li>
                <li class="dropdown">
                    <a id="dropdownMenu2" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
                        <li><a id="myPage" href="#">我的主页</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>