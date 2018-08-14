<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>EasyUI - 登录</title>
    <link rel="stylesheet" href="/plugins/toastr/toastr.min.css">
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231);border-image:none;width:400px;text-align: center;">
    <form id="loginForm" action="/auth" method="post" autocomplete="off">
        <#if _csrf?? && _csrf.parameterName??>
           <input type="hidden" name="${_csrf.parameterName?default('_csrf')}" value="${_csrf.token?default('')}"/>
        </#if>
        <div style="width: 165px; height: 96px; position: absolute;">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P style="padding: 30px 0px 10px; position: relative;">
            <span class="u_logo"></span>
            <input class="ipt" type="text" id="username" name="username" placeholder="请输入登录名" value="admin"/>
        </P>
        <P style="position: relative;">
            <span class="p_logo"></span>
            <input class="ipt" type="password" id="password" name="password" placeholder="请输入密码" value="admin@123"/>
        </P>
        <P style="padding: 10px 0px 10px; position: relative;">
            <input class="captcha" type="text" id="captcha" name="captcha" placeholder="请输入验证码" maxlength="4" autocomplete="off"/>
            <img id="captcha-image" alt="验证码" src="/captcha/image" onclick="this.src='/captcha/image?'+Math.random()" style="vertical-align:middle;border-radius:4px;width:94.5px;height:35px;cursor:pointer;">
        </P>
        <P style="position: relative;text-align: left;">
            <input class="rememberMe" type="checkbox" name="rememberMe" value="1" checked style="vertical-align:middle;margin-left:40px;height:20px;"/> 记住密码
        </P>
        <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <span style="float: left;">
                    <a style="color: rgb(204, 204, 204);" href="javascript:;">忘记密码?</a>
                </span>
                <span style="float: right;">
                    <a style="color: rgb(204, 204, 204); margin-right: 10px;" href="javascript:;">注册</a>
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:;" onclick="checkLoginForm()">登录</a>
                </span>
            </P>
        </div>
    </form>
</div>
<script src="/plugins/jquery-easyui/jquery.min.js"></script>
<script src="/plugins/toastr/toastr.min.js"></script>
<script src="/js/login.js"></script>
<#if error??>
<script>
    $(function(){
        toastr.error("${error? default("")}", "提示信息");
    });
</script>
</#if>
</body>
</html>
