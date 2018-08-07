<!DOCTYPE html>
<html>
<head>
    <title>组织管理 | 编辑机构</title>
    <#include "../../include/header_css.ftl">
</head>
<body>
<div class="content-wrapper">
    <section class="container-fluid">
        <table class="form" id="form">
            <tr>
                <td class="formTitle"><span style="color:red">*&nbsp;</span>机构名称</td>
                <td class="formValue">
                    <input type="text" class="form-control" placeholder="机构名称">
                </td>
            </tr>
            <tr>
                <td class="formTitle"><span style="color:red;">*&nbsp;</span>机构简称</td>
                <td class="formValue">
                    <input type="text" class="form-control" placeholder="机构简称">
                </td>
            </tr>
            <tr>
                <td class="formTitle"><span style="color:red">*&nbsp;</span>上级机构</td>
                <td class="formValue">
                    <input type="text" class="form-control pointer" placeholder="一级机构" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td class="formTitle">排序号</td>
                <td class="formValue">
                    <input type="text" class="form-control" placeholder="排序号">
                </td>
            </tr>
            <tr>
                <td class="formTitle">状态</td>
                <td class="formValue">
                    <input name="status" type="checkbox" checked />
                </td>
            </tr>
        </table>
    </section>

    <section class="content-footer">
        <button type="button" id="btn_cancel" class="btn btn-default pull-right">取消</button>
        <button type="button" id="btn_confirm" class="btn btn-info pull-right">确定</button>
        <script>document.getElementsByTagName("body")[0].setAttribute("style", "padding-bottom: 54px !important")</script>
    </section>
</div>

<#include "../../include/footer_js.ftl">
<script src="/js/base/org/edit.js"></script>
</body>
</html>
