<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style type="text/css">
    #user_fm {
        margin: 0;
        padding: 10px 30px;
    }

    .ftitle {
        font-size: 14px;
        font-weight: bold;
        color: #666;
        padding: 5px 0;
        margin-bottom: 10px;
        border-bottom: 1px solid #ccc;
    }

    .fitem {
        margin-bottom: 5px;
    }

    .fitem label {
        display: inline-block;
        width: 80px;
    }
</style>
<script type="text/javascript">

    function formatStatus(val) {

        if(val == 1){
            return "正常";
        }else{
            return "待定"
        }
    }

    function editUser() {
        var row = $('#user_dg').datagrid('getSelected');
        if (row) {
            $('#user_dlg').dialog('open').dialog('setTitle', 'Edit User');
            $('#user_fm').form('load', row);
        }
    }

    function saveUser() {
        if(!$('#user_fm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        $.post("/user/update",$("#user_fm").serialize(), function(data){
            if(data.status == 200){
                $('#user_dlg').dialog('close');		// close the dialog
                $('#user_dg').datagrid('reload');	// reload the user data
            }else{
                $.messager.show({
                    title: '异常',
                    msg: data.msg
                });
            }
        });
    }

    function removeUser() {
        var row = $('#user_dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('提示', '你确定删除这个角色?', function (r) {
                if (r) {
                    $.post('/user/delete', {id: row.id}, function (result) {
                        if (result.status ==200) {
                            $('#user_dg').datagrid('reload');	// reload the user data
                        } else {
                            $.messager.show({	// show error message
                                title: 'Error',
                                msg: result.msg
                            });
                        }
                    }, 'json');
                }
            });
        }
    }
</script>

<table id="user_dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
       url="/user/list"
       toolbar="#user_tb" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">Id</th>
        <th field="username" width="50">账号</th>
        <th field="password" width="50">密码</th>
        <th field="email" width="50">邮箱</th>
        <th field="name" width="50">姓名</th>
        <th field="role" width="50">角色</th>
        <th field="department" width="50">系别</th>
        <th field="status" width="50" formatter="formatStatus">状态</th>
    </tr>
    </thead>
</table>
<div id="user_tb">
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>--%>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除</a>
</div>

<div id="user_dlg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 20px"
     closed="true" buttons="#user_dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="user_fm" method="post">
        <input type="hidden" name="id" required="true">
        <input type="hidden" name="username" required="true">
        <input type="hidden" name="password" required="true">
        <input type="hidden" name="status" required="true">
        <div class="fitem">
            <label>姓名:</label>
            <input name="name" class="easyui-validatebox" validType="length[0,5]" required="true">
        </div>
        <div class="fitem">
            <label>邮箱:</label>
            <input name="email" class="easyui-validatebox" validType="email" required="true">
        </div>
        <div class="fitem">

            <label>角色:</label>
            <input name="role" class="easyui-combobox" data-options="
                valueField: 'role',
                textField: 'role',
                url: '/role/list',
                onSelect: function(rec){
                $('#rId').val(rec.id);
             }"/>
            <input type="hidden" name="rId" id="rId"/>

        </div>
        <div class="fitem">
            <label>系别:</label>

            <input name="department" class="easyui-combobox" data-options="
                valueField: 'department',
                textField: 'department',
                url: '/department/inputList',
                onSelect: function(rec){
                 $('#depId').val(rec.id);
             }"/>
            <input type="hidden" name="depId" id="depId"/>
        </div>

    </form>
</div>
<div id="user_dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#user_dlg').dialog('close')">Cancel</a>
</div>