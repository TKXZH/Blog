/**
 * Created by Administrator on 2017/1/12.
 */
/**
 * Created by Administrator on 2017/1/9.
 */
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
    $("#submit").click(function () {
        $.get(
            "/userinfo",
            function (data, status) {
                if(data.status == true) {
                    var from = data.user.id;
                    var to = $("#user").text();
                    $.post(
                        "/messages/new",
                        {
                            from:from,
                            to:to,
                            content:$("#message").val()
                        },
                        function (fata, status) {
                            if(data.status == true) {
                                window.location.reload();
                            } else {
                                alert("留言失败");
                            }
                        }
                    );
                } else {
                    alert("请点击右上角进行登录！")
                }
            }
        );
    });
});