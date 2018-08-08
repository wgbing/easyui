<!DOCTYPE html>
<html>
<head>
    <title>EasyUI | 主页</title>
    <#include "include/header_css.ftl">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<#--<div id="loading" style="position: fixed;top: -50%;left: -50%;width: 200%;height: 200%;background: #fff;z-index: 100;overflow: hidden;">-->
    <#--<img src="/images/ajax-loader.gif" style="position: absolute;top: 0;left: 0;right: 0;bottom: 0;margin: auto;"/>-->
<#--</div>-->
<div id="mainLayout" class="easyui-layout" data-options="fit:true, border:false">
    <div data-options="region:'north',border:false, collapsedSize:0" style="height:50px;">
        <div class="head">
            <table>
                <tr>
                    <td width="50%" style="font-size: 14px;">EasyUI</td>
                    <td width="50%" align="right" style="font-size: 12px;">
                        <div class="easyui-panel rtool" data-options="border:false" style="text-align: right; background: #09C; color: white; margin-top: -1px;">
                            <a href="#" class="easyui-menubutton" data-options="menu:'#mm1'">
                            </a>
                        </div>
                        <div id="mm1" style="width:150px;">
                            <div data-options="iconCls:'glyphicon-pencil'" onclick='editUserPwd()'>修改密码</div>
                            <div class="menu-sep"></div>
                            <div data-options="iconCls:'glyphicon-log-out'" onclick="logout()">退出</div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="west" class="scrollbar" data-options="region:'west',split:true, border:false, collapsedSize:0" style="width:200px;background-color: #424f63;color:white">
        <div class="west_menu">
            <div class="menu_head">菜单导航</div>
            <ul id="layout_west_tree" class="easyui-tree">
                <li data-options="iconCls:'glyphicon-list-alt'">
                    <span>系统管理</span>
                    <ul>
                        <li data-options="iconCls:'glyphicon-user'">
                            <a href="#" target="right-iframe">用户管理</a>
                        </li>
                        <li data-options="iconCls:'glyphicon-lock'"><span>组织管理</span></li>
                        <li data-options="iconCls:'glyphicon-eye-open'"><span>角色管理</span></li>
                        <li data-options="iconCls:'glyphicon-fire'"><span>角色授权</span></li>
                        <li data-options="iconCls:'glyphicon-menu-hamburger'"><span>字典管理</span></li>
                    </ul>
                </li>
                <li data-options="iconCls:'glyphicon-compressed'">文章管理</li>
                <li data-options="iconCls:'glyphicon-send'">运营管理</li>
            </ul>

        </div>
    </div>
    <div data-options="region:'center', border:false">
        <div id="mainTabs" style="height:250px">
            <div title="首页" data-options="iconCls:'glyphicon-home',border:false">
                <iframe src="/main" class="easyui-panel" data-options="fit:true,border:false" frameborder="0"></iframe>
            </div>
        </div>
    </div>
</div>
<div id="tabsMenu">
    <div data-options="iconCls:'glyphicon-refresh'" type="refresh" style="font-size: 12px;">刷新</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'glyphicon-remove'" type="close" style="font-size: 12px;">关闭</div>
    <div data-options="iconCls:''" type="closeOther">关闭其他</div>
    <div data-options="iconCls:''" type="closeAll">关闭所有</div>
</div>
<div id="tabTools" style="border: 0px; border-bottom: 1px solid #D3D3D3;">
    <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-home" onclick="toHome()"></a>
    <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-refresh" onclick="refreshTab()"></a>
    <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-remove" onclick="closeTab()"></a>
    <a id="fullScreen" href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-fullscreen" onclick="fullScreen()"></a>
</div>
<!--[if lte IE 7]>
<div id="ie6-warning"><p>您正在使用 低版本浏览器，在本页面可能会导致部分功能无法使用。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 8</a> 或以下浏览器：
    <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> / <a href="http://www.google.com/chrome/?hl=zh-CN" target="_blank">Chrome</a> / <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> / <a href="http://www.operachina.com/" target="_blank">Opera</a></p></div>
<![endif]-->
<style>
    /*ie6提示*/
    #ie6-warning{width:100%;position:absolute;top:0;left:0;background:#fae692;padding:5px 0;font-size:12px}
    #ie6-warning p{width:960px;margin:0 auto;}
</style>
<#include "include/footer_js.ftl">
<script src="/js/index.js"></script>
</body>
</html>
