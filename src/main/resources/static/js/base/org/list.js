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
            title : 'id',
            field : 'id',
            width : 40,
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
            field : 'type',
            title : '机构类型',
            width : 120,
            formatter:function (value,row,index) {
                return CODE_MAP.ORG.TYPE[value];
            }
        },{
            field : 'remark',
            title : '备注',
            width : 120
        },{
            field : 'updateTime',
            title : '更新时间',
            width : 130
        },{
            field : 'enable',
            title : '状态',
            width : 120,
            formatter : function(value, row, index) {
                if(value){
                    return "<span>正常</span>";
                }else{
                    return "<span style='color: red'>禁用</span>";
                }
            }
        },{
            field : 'action',
            title : '操作',
            width : 260,
            formatter : function(value, row, index) {
                var str = '';
                str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'glyphicon-pencil icon-blue\'" onclick="editOrg(\'{0}\');" >编辑</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-del" data-options="plain:true,iconCls:\'glyphicon-trash icon-red\'" onclick="deleteOrg(\'{0}\');" >删除</a>', row.id);
                str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                str += $.formatString('<a href="javascript:void(0)" class="organization-easyui-linkbutton-add" data-options="plain:true,iconCls:\'glyphicon-plus icon-green\'" onclick="addOrg(\'{0}\');" >新增子机构</a>', row.id);
                return str;
            }
        },{
            field : 'parentId',
            hidden : true
        }] ],
        onLoadSuccess:function(data){
            $('.organization-easyui-linkbutton-edit').linkbutton({text:'编辑'});
            $('.organization-easyui-linkbutton-del').linkbutton({text:'删除'});
            $('.organization-easyui-linkbutton-add').linkbutton({text:'新增子机构'});
        },
        toolbar : '#orgToolbar'
    });
});

function editOrg(id) {
    if (id != undefined) {
        orgTreeGrid.treegrid('select', id);
    }
    var node = orgTreeGrid.treegrid('getSelected');
    if (node) {
        parent.$.modalDialog({
            title : '编辑',
            width : 300,
            height : 330,
            href : '/sys/org/edit?orgId=' + node.id,
            buttons : [ {
                text : '保存',
                handler : function() {
                    parent.$.modalDialog.openner_treeGrid = orgTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#orgEditForm');
                    f.submit();
                }
            } ]
        });
    }
}

function deleteOrg(id) {
    if (id != undefined) {
        orgTreeGrid.treegrid('select', id);
    }
    var node = orgTreeGrid.treegrid('getSelected');
    if (node) {
        parent.$.messager.confirm('询问', '您是否要删除当前部门？<br/>删除当前部门会连同子部门一起删除!', function(r) {
            if (r) {
                progressLoad();
                $.ajax({
                    url: "/sys/org/delete",
                    data:{
                        orgId:node.id
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
}

function addOrg(id) {
    if (id != undefined) {
        orgTreeGrid.treegrid('select', id);
    }
    var node = orgTreeGrid.treegrid('getSelected');
    if (node) {
        parent.$.modalDialog({
            title : '添加子部门',
            width : 300,
            height : 330,
            href : '/sys/org/add?orgId='+node.id,
            buttons : [ {
                text : '提交',
                handler : function() {
                    parent.$.modalDialog.openner_treeGrid = orgTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#orgAddForm');
                    f.submit();
                }
            } ]
        });
    }
}

function addRootOrg() {
    parent.$.modalDialog({
        title : '添加根部门',
        width : 300,
        height : 330,
        href : '/sys/org/add',
        buttons : [ {
            text : '提交',
            handler : function() {
                parent.$.modalDialog.openner_treeGrid = orgTreeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                var f = parent.$.modalDialog.handler.find('#orgAddForm');
                f.submit();
            }
        } ]
    });
}

