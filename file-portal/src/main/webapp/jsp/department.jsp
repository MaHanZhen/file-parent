<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $('#depart_dg').edatagrid({
            url: '/department/dataGridList',
            saveUrl: '/department/create',
            updateUrl: '/department/update',
            destroyUrl: '/department/delete',
            destroyMsg: {
                norecord: {    // when no record is selected
                    title: '提示',
                    msg: '没有信息被选中.'
                },
                confirm: {    // when select a row
                    title: '提示',
                    msg: '是否删除这条信息?删除后此部门下所有角色将处于待定状态'
                }
            }
        });
    });
</script>

<table id="depart_dg" title="My Users" style="width:700px;height:350px"
       toolbar="#depart_tb" pagination="true" idField="id"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <%--<th field="id" width="50">ID</th>--%>
        <th field="department" width="50" editor="{type:'validatebox',options:{required:true}}">系别</th>
    </tr>
    </thead>
</table>
<div id="depart_tb">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="javascript:$('#depart_dg').edatagrid('addRow')">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#depart_dg').edatagrid('destroyRow')">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"
       onclick="javascript:$('#depart_dg').edatagrid('saveRow')">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true"
       onclick="javascript:$('#depart_dg').edatagrid('cancelRow')">取消</a>
</div>