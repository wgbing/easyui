<script src="/js/base/org/list.js"></script>
<style>
    .tree-node {padding: 4px 4px;}
</style>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false"  style="overflow: hidden;">
        <table id="orgTreeGrid"></table>
    </div>
    <div id="orgToolbar" style="display: none;">
        <a onclick="addRootOrg();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'glyphicon-plus icon-green'">添加</a>
    </div>
</div>