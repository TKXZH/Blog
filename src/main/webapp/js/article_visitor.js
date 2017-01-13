$(document).ready(function () {
    $("#login").click(function () {
        var password = $("#password").val();
        var username = $("#username").val();
        $.post("/loginJ",
            {
                userName:username,
                passWord:password
            },
            function (data, status) {
                if(data.status == true) {
                    window.location.reload();
                } else {
                    alert("登录失败，请重试");
                }
            });
    });
});


$(document).ready(function () {
    $.get(
        "/userinfo",
        function (data, status) {
            if(data.status == true) {
                $("#show").toggle();
                $("#register").toggle();
                $("#dropdownMenu2").show().text(data.user.nickName);
                $("#myPage").attr("href","/"+data.user.id +"/articles/admin");
            } else {
                $("#dropdownMenu2").hide();
            }
        }
    );
});

$(document).ready(function () {

    $.get(
        "./showJ",
        function (data, status) {
            var articles = [];
            $.each(data, function (i, item) {
                var unixTimestamp = new Date(item.createTime) ;
                commonTime = unixTimestamp.toLocaleString();
                var texts = '<div class="posts animation">'+
                                '<h4 class="posts-title">'+
                                    '<a  href="/articles/'+item.id+'/detail" class="animation">'+item.title+'</a>'+
                                '</h4>'+
                                '<p class="hide" id="articleId">'+item.id+'</p>'+
                                '<p class="time">创建时间: '+commonTime+'</p>'+
                                '<p class="descript">'+ item.description + '</p>'+
                                '<div class="row">'+
                                    '<div class="col-xm-12">'+
                                        '<div class="posts-footer pull-right">'+
                                            '<a class="class animation" > <span class="glyphicon glyphicon-edit"></span>评论('+
                    '<span id = "url::http://xvzonghui.top/articles/'+item.id+'/detail" class = "cy_cmt_count" ></span>'+
                    '<script id="cy_cmt_num" src="http://changyan.sohu.com/upload/plugins/plugins.list.count.js?clientId=cysn6hDCW">'+
                    '</script>)</a>'+
                                            '<a class="class animation" > <span class="glyphicon glyphicon-thumbs-up"></span>赞('+item.star+')</a>'+
                                            '<p class="hide">'+item.id+'</p>'+
                                        '</div>'+
                                    '</div>'+
                                '</div>'+
                            '</div>';
                articles.push(texts);
            });
            var articleNum = articles.length;
            var currentPage = 1;
            function display(pageNum) {
                if(pageNum * 5 >= articleNum) {
                    var current = articles.slice((pageNum-1)*5);
                    var texts = "";
                    for(var i=0; i<current.length; i++) {
                        texts += current[i];
                    }
                    $("#articles").html(texts+
                                '<ul class="pager">'+
                                '<li><a id="pre" >上页</a></li>'+
                                '<li><a id="next">下页</a></li>'+
                                '</ul>');
                    if(pageNum == 1) {
                        $("#pre").hide();
                    }
                    $("#next").hide();
                } else {
                    var current = articles.slice((pageNum-1)*5, (pageNum-1)*5+5);
                    var texts = "";
                    for(var i=0; i<current.length; i++) {
                        texts += current[i];
                    }
                    $("#articles").html(texts+
                        '<ul class="pager">'+
                        '<li><a id="pre" >上页</a></li>'+
                        '<li><a id="next">下页</a></li>'+
                        '</ul>');
                    if(pageNum == 1) {
                        $("#pre").hide();
                    }
                }
                /*为点赞按钮绑定响应事件*/
                /*this永远指向的是调用this关键字所在方法的对象*/
                $(".posts-footer.pull-right").each(function () {
                    $(this).children().eq(1).css("cursor","pointer").click(function () {
                        var articleId = $(this).next().text();
                        var zan = $(this);
                        $.get(
                            "/articles/"+articleId+"/support",
                            function (data, status) {
                                if(data.status == true) {
                                    var pre = Number(zan.text().replace(/[^0-9]+/g, ''));
                                    var now = pre + 1;
                                    zan.text("赞("+now+")");
                                } else {
                                    alert(data.info);
                                }
                            }
                        );
                    });
                });

                $("#next").click(function () {
                    currentPage += 1;
                    display(currentPage);

                });
                $("#pre").click(function () {
                    currentPage -= 1;
                    display(currentPage);
                });
            }
            display(1);
        }
    );

});
