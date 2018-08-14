$(function() {
    $('#orgAddForm').form({
        url : '/sys/org/save',
        onSubmit : function() {
            progressLoad();
            var isValid = $(this).form('validate');
            if (!isValid) {
                progressClose();
            }
            return isValid;
        },
        success : function(result) {
            progressClose();
            result = $.parseJSON(result);
            if (result.success) {
                parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为organization.jsp页面预定义好了
                parent.$.modalDialog.handler.dialog('close');
            } else {
                var form = $('#orgAddForm');
                parent.$.messager.alert('提示', eval(result.msg), 'warning');
            }
        }
    });

});