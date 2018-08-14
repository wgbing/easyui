<script src="/js/base/role/edit.js"></script>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" style="overflow: hidden;padding: 3px;" >
        <form id="roleEditForm" method="post">
            <#if _csrf?? && _csrf.parameterName??>
                <input type="hidden" name="${_csrf.parameterName?default('_csrf')}" value="${_csrf.token?default('')}"/>
            </#if>
            <input type="hidden" name="id" value="${(role.id)!''}">
            <table class="grid">
                <tr>
                    <td>角色名称</td>
                    <td><input name="name" type="text" value="${(role.name)!''}" placeholder="请输入角色名称" class="easyui-validatebox" data-options="required:true" ></td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td colspan="3"><textarea name="description">${(role.description)!''}</textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>