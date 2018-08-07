<!DOCTYPE html>
<html>
<head>
    <title>系统管理 | 组织管理</title>
    <#include "../../include/header_css.ftl">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <div class="hidden-xs">
                <h4>
                    <i class="fa fa-sitemap" style="font-size: 20px;"></i>
                    &nbsp; 组织管理
                </h4>
            </div>
        </div>
        <div class="col-md-6">
            <div class="btn-toolbar pull-right">
                <div class="btn-group">
                    <a href="#" class="btn btn-default" id="btn_search" title="查询" onclick="showSearch()"><i class="fa fa-filter"></i> 查询</a>
                    <a href="#" class="btn btn-default" id="btn_refreshTree" title="刷新" onclick="refreshTree()"><i class="fa fa-refresh"></i> 刷新</a>
                    <a href="#" class="btn btn-default" id="btn_expandTreeNode" title="展开" onclick="expandTreeNode()"><i class="fa fa-angle-double-down"></i> 展开</a>
                    <a href="#" class="btn btn-default" id="btn_collapseTreeNode" title="折叠全部" onclick="collapseTreeNode()"><i class="fa fa-angle-double-up"></i> 折叠</a>
                    <a href="#" class="btn btn-default" id="btn_addOrg" title="新增机构" onclick="addRootOrg()"><i class="fa fa-plus"></i> 新增</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- searchForm -->
        <form id="searchForm" name="searchForm" class="form-horizontal" hidden>
            <h5 class="page-header"></h5>
            <div class="col-sm-3">
                <div class="form-group">
                    <label class="control-label col-sm-6">机构名称：</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="orgName" name="orgName" placeholder="机构名称">
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label class="control-label col-sm-6">机构简称：</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="shortName" name="shortName" placeholder="机构简称">
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label class="control-label col-sm-6">状态：</label>
                    <div class="col-sm-6">
                        <select class="form-control">
                            <option value="true">正常</option>
                            <option value="false">禁用</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="col-sm-4"></div>
                <div class="col-sm-8">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-md">查询</button>
                        <button type="reset" class="btn btn-default btn-md">重置</button>
                    </div>
                </div>
            </div>
        </form>
        <!-- /.searchForm -->
    </div>
    <div class="row">
        <table id="dataGrid"></table>
    </div>
</div>

<#include "../../include/footer_js.ftl">
<script src="/js/base/org/list.js"></script>
</body>
</html>
