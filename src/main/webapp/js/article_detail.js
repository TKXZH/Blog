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


