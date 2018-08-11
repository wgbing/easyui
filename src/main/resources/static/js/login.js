// 判断时候在Iframe框架内,在则刷新父页面
if (self != top) {
    parent.location.reload(true);
    if (!!(window.attachEvent && !window.opera)) {
        document.execCommand("stop");
    } else {
        window.stop();
    }
}

$(function () {
    document.onkeydown = function (e) {
        //捕捉回车事件
        var ev = (typeof event != 'undefined') ? window.event : e;
        if (ev.keyCode == 13) {
            checkLoginForm();
        }
    };
    //配置提示框样式
    if (toastr != undefined) {
        toastr.options = {
            "closeButton":false,//显示关闭按钮
            "debug":false,//启用debug
            "newestOnTop": false,
            "progressBar": true,
            "positionClass":"toast-top-center",//弹出的位置
            "preventDuplicates": false,
            "onclick": null,
            "showDuration":"300",//显示的时间
            "hideDuration":"1000",//消失的时间
            "timeOut":"2000",//停留的时间
            "extendedTimeOut":"1000",//控制时间
            "showEasing":"swing",//显示时的动画缓冲方式
            "hideEasing":"linear",//消失时的动画缓冲方式
            "showMethod":"fadeIn",//显示时的动画方式
            "hideMethod":"fadeOut"//消失时的动画方式
        };
    }
    // 得到焦点
    $("#password").focus(function () {
        $("#left_hand").animate({
            left: "150",
            top: " -38"
        }, {
            step: function () {
                if (parseInt($("#left_hand").css("left")) > 140) {
                    $("#left_hand").attr("class", "left_hand");
                }
            }
        }, 2000);
        $("#right_hand").animate({
            right: "-64",
            top: "-38px"
        }, {
            step: function () {
                if (parseInt($("#right_hand").css("right")) > -70) {
                    $("#right_hand").attr("class", "right_hand");
                }
            }
        }, 2000);
    });
    // 失去焦点
    $("#password").blur(function () {
        $("#left_hand").attr("class", "initial_left_hand");
        $("#left_hand").attr("style", "left:100px;top:-12px;");
        $("#right_hand").attr("class", "initial_right_hand");
        $("#right_hand").attr("style", "right:-112px;top:-12px");
    });
});
function checkLoginForm() {
    var userName = $("#username");
    var userPassword = $("#password");
    var captcha = $("#captcha");

    if ($.trim(userName.val()) === "") {
        toastr.warning("请输入用户名", "提示信息");
        userName.focus();
        return false;
    }
    if ($.trim(userPassword.val()) === "") {
        toastr.warning("请输入密码", "提示信息");
        userPassword.focus();
        return false;
    }
    if ($.trim(captcha.val()) === "") {
        toastr.warning("请输入验证码", "提示信息");
        captcha.focus();
        return false;
    }

    $('#loginForm').submit();
}
