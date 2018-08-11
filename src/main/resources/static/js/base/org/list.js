var orgTreeGrid;
$(function() {
    orgTreeGrid = $('#orgTreeGrid').treegrid({
        url : '/sys/org/list',
        method:'GET',
        idField : 'id',
        treeField : 'orgName',
        parentField : 'parentId',
        fit : true,
        fitColumns : false,
        border : false,
        frozenColumns : [ [ {
            title : 'orgName',
            field : 'orgName',
            width : 180,
            hidden : true
        } ] ],
        columns : [ [ {
            field : 'orgName',
            title : '机构名称',
            width : 180
        },{
            field : 'shortName',
            title : '机构简称',
            width : 180
        },{
            field : 'sortNo',
            title : '排序号',
            width : 80
        },{
            field : 'type',
            title : '机构类型',
            width : 120
        },{
            field : 'updateTime',
            title : '更新时间',
            width : 130
        },{
            field : 'enable',
            title : '状态',
            width : 120
        },{
            field : 'action',
            title : '操作',
            width : 130,
            formatter : function(value, row, index) {
                var str = '';
                str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'glyphicon-pencil icon-blue\'" onclick="editOrganizationFun(\'{0}\');" >编辑</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-del" data-options="plain:true,iconCls:\'glyphicon-trash icon-red\'" onclick="deleteOrganizationFun(\'{0}\');" >删除</a>', row.id);
                return str;
            }
        },{
            field : 'parentId',
            hidden : true
        }] ],
        onLoadSuccess:function(data){
            $('.organization-easyui-linkbutton-edit').linkbutton({text:'编辑'});
            $('.organization-easyui-linkbutton-del').linkbutton({text:'删除'});
        },
        toolbar : '#orgToolbar'
    });
});

function editOrganizationFun(id) {
    if (id != undefined) {
        orgTreeGrid.treegrid('select', id);
    }
    var node = orgTreeGrid.treegrid('getSelected');
    if (node) {
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/organization/editPage?id=' + node.id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_treeGrid = orgTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#organizationEditForm');
                    f.submit();
                }
            } ]
        });
    }
}

function deleteOrganizationFun(id) {
    if (id != undefined) {
        orgTreeGrid.treegrid('select', id);
    }
    var node = orgTreeGrid.treegrid('getSelected');
    if (node) {
        parent.$.messager.confirm('询问', '您是否要删除当前资源？删除当前资源会连同子资源一起删除!', function(b) {
            if (b) {
                progressLoad();
                $.post('/organization/delete', {
                    id : node.id
                }, function(result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        parent.$.messager.alert('提示', result.msg, 'info');
                        orgTreeGrid.treegrid('reload');
                    }else{
                        parent.$.messager.alert('提示', result.msg, 'info');
                    }
                    progressClose();
                }, 'text');
            }
        });
    }
}

function addOrganizationFun() {
    parent.$.modalDialog({
        title : '添加',
        width : 500,
        height : 300,
        href : '/organization/addPage',
        buttons : [ {
            text : '添加',
            handler : function() {
                parent.$.modalDialog.openner_treeGrid = orgTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#organizationAddForm');
                f.submit();
            }
        } ]
    });
}
