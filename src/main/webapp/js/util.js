/**
 * Created by Administrator on 2017/1/5.
 */
function syn(input, preview) {
    preview.html(markdown.toHTML(input.val()));
}

$("textarea").on(
    'keydown',
    function(e) {
        if (e.keyCode == 9) {
            e.preventDefault();
            var indent = '    ';
            var start = this.selectionStart;
            var end = this.selectionEnd;
            var selected = window.getSelection().toString();
            selected = indent + selected.replace(/\n/g, '\n' + indent);
            this.value = this.value.substring(0, start) + selected
                + this.value.substring(end);
            this.setSelectionRange(start + indent.length, start
                + selected.length);
        }
    });

$("#create").click(function () {
    $.post(
        "/category/create",
        {name:$("#input").val()},
        function (data, status) {
            if(data.status == true) {
                window.location.reload();
            } else {
                alert(data.info);
            }
        }
    );
});
$("#submit").click(function () {
    $.post("/articles/new",
        {
            category:$("#select").val(),
            content:$("#preview").html(),
            description:$("#description").val(),
            title:$("#title").val()
        },
        function (data, status) {
            if(data.status == false) {
                alert("文章创建失败");
            }
            if(data.status == true) {
                location.href = "../../1010/articles/show";
            }
        }
    );
});

/*绑定删除按钮ajax事件*/
var dangerButtons = $(".btn.btn-sm.btn-danger");
dangerButtons.each(function () {
    $(this).click(function () {
        var td = $(this).parent().parent();
        var id = $(this).parent().parent().children(":first").text();
        var url = "/articles/" + id + "/delete";
        $.get(url,
            function (data, status) {
                if(data.status == true) {
                    td.toggle(1000);
                }
            }
        )
    });
});

