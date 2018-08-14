<script src="/js/base/org/add.js"></script>
<div style="padding: 3px;">
    <form id="orgAddForm" method="post">
        <#if _csrf?? && _csrf.parameterName??>
            <input type="hidden" name="${_csrf.parameterName?default('_csrf')}" value="${_csrf.token?default('')}"/>
        </#if>
        <input type="hidden" id="parentId" name="parentId" value="${parentId?default('')}"/>
        <table class="grid">
            <tr>
                <td>机构名称</td>
                <td><input name="orgName" type="text" placeholder="请输入机构名称" class="easyui-validatebox" data-options="required:true" ></td>
            </tr>
            <tr>
                <td>机构简称</td>
                <td><input name="shortName" type="text" placeholder="请输入机构简称" class="easyui-validatebox" data-options="required:true" ></td>
            </tr>
            <tr>
                <td>排序</td>
                <td><input name="sortNo" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="min:1,editable:false" value="1"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                    <select name="enable" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="true">正常</option>
                        <option value="false">禁用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>机构类型</td>
                <td>
                    <select name="type" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="1">一级机构</option>
                        <option value="2">二级机构</option>
                        <option value="3">三级机构</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input name="remark" type="text" placeholder="请输入备注" class="easyui-validatebox"></td>
            </tr>
        </table>
    </form>
</div>