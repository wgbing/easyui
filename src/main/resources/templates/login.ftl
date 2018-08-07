<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>EasyUI - 登录</title>
    <link rel="stylesheet" href="/plugins/toastr/toastr.min.css">
</head>
<style type="text/css">
    html, body, table, tr, td, input {
        margin: 0;
        padding: 0;
    }
    html {
        overflow: hidden;
        border: 0;
    }
    body {
        background: #E2F6FC url("/images/login-bg-01.png") no-repeat fixed;
        background-size: cover;
        overflow-y: hidden;
        border: 0;
    }
    #btn_login {
        margin-top: 10px;
        height: 40px;
        cursor: pointer;
        width:247px;
    }
    #btn_login a {
        text-decoration: none;
        /*background: #E96222;*/
        background: #12BDF0;
        color: #f2f2f2;
        /*padding: 10px 30px 10px 30px;*/
        display: block;
        height: 40px;
        line-height: 40px;
        text-align: center;
        font-size: 16px;
        font-family: 微软雅黑, 宋体, Arial, Helvetica, Verdana, sans-serif;
        font-weight: bold;
        border-radius: 3px;
        -webkit-transition: all linear 0.30s;
        -moz-transition: all linear 0.30s;
        transition: all linear 0.30s;
    }
    #btn_login a:hover {
        /*background: #DE3800;*/
        background: #168FD6;
    }
    .input-text {
        height: 36px;
        line-height:36px;
        width: 240px;
        margin-bottom: 5px;
        padding-left:5px;
        font-size: 16px !important;
    }
    #captcha-wrapper {
        position: relative !important;
    }
    #captcha-image {
        position: absolute;
        top:0;
        right:0;
        padding:2px 2px 0px 0px;
        height:34px;
    }
    a:link {
        color: #000000;
        text-decoration: none;
    }
    a:visited {
        color: #000000;
    }
    .title {
        font-size:26px;
        color:#333
    }

    #login-wrapper {
        width: 300px;
        /*margin: 200px auto !important;*/
        margin: 0 auto !important;
        padding: 20px 0;
        box-shadow: 1px 1px 5px #ccc;
        /*border: 1px solid #ccc;*/
        border-radius:15px;
        background-color:rgba(0,0,0,0.1);
        behavior: url(/plugins/PIE/PIE.htc);
    }
    #tab-wrapper {
        margin:0 auto;
    }
    input {
        border-radius: 5px;
        border: 1px solid #bbb;
        behavior: url(/plugins/PIE/PIE.htc);
    }

    @media \0screen\,screen\9 { /* 只支持IE6、7、8 */
        #login-wrapper{
            background-color:#f0f0f0;
            filter:Alpha(opacity=20);
            position:static;    /* IE6、7、8只能设置position:static(默认属性) ，否则会导致子元素继承Alpha值 */
            *zoom:1;            /* 激活IE6、7的haslayout属性，让它读懂Alpha */
        }
        #tab-wrapper {
            position: relative; /* 设置子元素为相对定位，可让子元素不继承Alpha值 */
        }
    }
</style>
<body>
<div style="width:100%; height:200px;">&nbsp;</div>
<div id="login-wrapper">
    <form id="loginForm" action="/auth" method="post" autocomplete="off">
        <#if _csrf?? && _csrf.parameterName??>
           <input type="hidden" name="${_csrf.parameterName?default('_csrf')}" value="${_csrf.token?default('')}"/>
        </#if>
        <table id="tab-wrapper">
            <tr align="center">
                <td style="padding-bottom:15px !important;">
                    <a href="login.ftl"><img src="/images/jw-logo.png" width="100" height="100" style="vertical-align: middle; margin-bottom: 0px; margin-right: 10px; border:0px;"/><br/><br/><span class="title">Jquery-EasyUI</span></a><br>
                </td>
            </tr>
            <tr>
                <td><input type="text" id="username" class="input-text" name="username" placeholder="用户名" maxlength="20"  ></td> <!-- readonly onfocus="this.removeAttribute('readonly');" -->
            </tr>
            <tr>
                <td><input type="password" id="password" class="input-text" name="password" placeholder="密码" maxlength="20"></td>
            </tr>
            <tr>
                <td align="left" id="captcha-wrapper">
                    <input type="text" id="captcha" class="input-text" name="captcha" for="btn_login" placeholder="验证码" maxlength="4" autocomplete="off">
                    <img id="captcha-image" src="/captcha/image" onclick="this.src='/captcha/image?'+Math.random()" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    <#--<button type="button" id="btn_login" onclick="checkUserForm()" style="padding: 5px;width: 120px; background-color: #5A87C4; border-color: #5A87C4;">登&nbsp;录</button>-->
                    <div id="btn_login">
                        <a onclick="checkUserForm()">登&nbsp;录</a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- Scripts -->
<script src="/plugins/jquery-easyui/jquery.min.js"></script>
<script src="/plugins/toastr/toastr.min.js"></script>
<script src="/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="/plugins/PIE/PIE678.js"></script>
<![endif]-->
<#if error??>
<script>
    $(function(){
        toastr.error("${error? default("")}", "提示信息");
    });
</script>
</#if>
<script type="text/javascript">
    $(function() {
        if (window.PIE) {
            var e = document.getElementById("login-wrapper");
            PIE.attach(e);
        }
        //配置提示框样式
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
    });

    // 兼容低版本浏览器placeholder效果
    $('input').placeholder();

    // 默认光标
    $("#username").focus();

    // 注册键盘事件
    document.onkeydown = function (e) {
        //捕捉回车事件
        var ev = (typeof event != 'undefined') ? window.event : e;
        if (ev.keyCode == 13) {
            checkUserForm();
        }
    }

    // 表单校验
    function checkUserForm() {
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
</script>
</body>
</html>
