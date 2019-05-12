let loginStatus = {
    response: false,
    isLogin: false
};
let user = {};
(function () {
    $.get("/myForum/api/user/status", function (result) {
        loginStatus.response = true;
        user = $.parseJSON(result);
        if (user.status === true) {
            loginStatus.isLogin = true;
        }
    }, "text");
})();

function loginRender() {
    $(".login-group").empty().append(" <li class=\"dropdown\">\n" +
        "                        <a href=\"#\" class=\"dropdown-toggle userinfo\" data-toggle=\"dropdown\">\n" +
        "                           未设置昵称 <b class=\"caret\"></b>\n" +
        "                        </a>\n" +
        "                        <ul class=\"dropdown-menu\">\n" +
        "                            <li class='personal-setting'><a>个人设置</a></li>\n" +
        "                            <li class='logout'><a>注销</a></li>\n" +
        "                        </ul>\n" +
        "                    </li>");
    $(".main-module").append("<li><a class=\"write\" href=\"/myForum/compose.html\">写文章</a></li>");
    $(".userinfo").text(user.nickname);
    $(".logout").click(function () {
        $.get("/myForum/api/user/logout",function (result) {
            if(result || result === 'done') {
                alert("注销成功！");
                window.location.reload();
            }
        });
    });
}

$(function () {
    if (loginStatus.isLogin === true) {
        loginRender();
    } else if (loginStatus.response === false) {
        loginStatus = new Proxy({}, {
            set: function (obj, prop, value) {
                obj[prop] = value;
                if (prop === 'isLogin' && value === true) {
                    loginRender();
                }
                return true;
            }
        });
    }
});
