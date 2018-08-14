var roleDataGrid;
$(function() {
    roleDataGrid = $('#roleDataGrid').datagrid({
        url : '/sys/role/list',
        method:'GET',
        fit : true,
        striped : true,
        rownumbers : true,
        pagination : true,
        singleSelect : true,
        idField : 'id',
        sortName : 'id',
        sortOrder : 'asc',
        pageSize : 20,
        pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
        frozenColumns : [ [ {
            width : '80',
            title : '名称',
            field : 'name',
            sortable : true
        },{
            width : '200',
            title : '描述',
            field : 'description'
        },{
            width : '130',
            title : '更新时间',
            field : 'updateTime',
            sortable : true
        }, {
            field : 'action',
            title : '操作',
            width : '230',
            formatter : function(value, row, index) {
                var str = '';
                str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'glyphicon-ok icon-green\'" onclick="grantRoleFun(\'{0}\');" >授权</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'glyphicon-pencil icon-blue\'" onclick="editRole(\'{0}\');" >编辑</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'glyphicon-trash icon-red\'" onclick="deleteRole(\'{0}\');" >删除</a>', row.id);
                return str;
            }
        } ] ],
        onLoadSuccess:function(data){
            $('.role-easyui-linkbutton-ok').linkbutton({text:'授权'});
            $('.role-easyui-linkbutton-edit').linkbutton({text:'编辑'});
            $('.role-easyui-linkbutton-del').linkbutton({text:'删除'});
        },
        toolbar : '#roleToolbar'
    });
});

function addRole() {
    parent.$.modalDialog({
        title : '添加',
        width : 500,
        height : 300,
        href : '/sys/role/add',
        buttons : [ {
            text : '确定',
            handler : function() {
                parent.$.modalDialog.openner_dataGrid = roleDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#roleAddForm');
                f.submit();
            }
        } ]
    });
}

function editRole(id) {
    if (id == undefined) {
        var rows = roleDataGrid.datagrid('getSelections');
        id = rows[0].id;
    } else {
        roleDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
    }
    parent.$.modalDialog({
        title : '编辑',
        width : 500,
        height : 300,
        href : '/sys/role/edit?roleId=' + id,
        buttons : [ {
            text : '确定',
            handler : function() {
                parent.$.modalDialog.openner_dataGrid = roleDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#roleEditForm');
                f.submit();
            }
        } ]
    });
}

function deleteRole(id) {
    if (id == undefined) {//点击右键菜单才会触发这个
        var rows = roleDataGrid.datagrid('getSelections');
        id = rows[0].id;
    } else {//点击操作里面的删除图标会触发这个
        roleDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
    }
    parent.$.messager.confirm('询问', '您是否要删除当前角色？', function(r) {
        if (r) {
            progressLoad();
            $.ajax({
                url: "/sys/role/delete",
                data:{
                    roleId:id
                },
                type: "GET",
                dataType: "json",
                success: function (result) {
                    if (result.success) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        orgTreeGrid.treegrid('reload');
                    }else{
                        parent.$.messager.alert('提示', result.message, 'info');
                    }
                },
                error: ajaxErrorHandler
            });
            progressClose();
        }
    });
}

function grantRoleFun(id) {
    if (id == undefined) {
        var rows = roleDataGrid.datagrid('getSelections');
        id = rows[0].id;
    } else {
        roleDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
    }

    parent.$.modalDialog({
        title : '授权',
        width : 500,
        height : 500,
        href : '/sys/role/grantPage?id=' + id,
        buttons : [ {
            text : '确定',
            handler : function() {
                parent.$.modalDialog.openner_dataGrid = roleDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#roleGrantForm');
                f.submit();
            }
        } ]
    });
}
function searchRoleFun() {
    var form = $.serializeObject($('#searchRoleForm'));
    var params = {
        "paramMap[name]":form.name,
        "paramMap[beginTime]":form.beginTime,
        "paramMap[endTime]":form.endTime
    };
    roleDataGrid.datagrid('load', params);
}
function cleanRoleFun() {
    $('#searchRoleForm input').val('');
    roleDataGrid.datagrid('load', {});
}