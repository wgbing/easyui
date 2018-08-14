<script src="/js/base/role/list.js"></script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff;margin: 5px">
        <form id="searchRoleForm">
            <table>
                <tr>
                    <td style="padding-right: 5px;padding-left: 5px;">名称:&nbsp;</td>
                    <td><input name="name" type="text" placeholder="请输入角色名称" class="easyui-textbox" ></td>
                    <td style="padding-right: 5px;padding-left: 5px;">更新时间:</td>
                    <td>
                        <input name="beginTime" type="text" placeholder="点击选择时间" class="easyui-datebox" >
                    </td>
                    <td style="padding-right: 5px;padding-left: 5px;">至</td>
                    <td>
                        <input name="endTime" type="text" placeholder="点击选择时间" class="easyui-datebox" >
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'glyphicon-search',plain:true" onclick="searchRoleFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'glyphicon-remove-circle',plain:true" onclick="cleanRoleFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:false"">
        <table id="roleDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
<div id="roleToolbar" style="display: none;">
        <a onclick="addRole();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'glyphicon-plus icon-green'">添加</a>
</div>
