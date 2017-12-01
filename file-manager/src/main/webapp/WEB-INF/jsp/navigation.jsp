<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false"
     style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <h3>请选择要管理的部门</h3>
            <input id="nav_dep_input"/>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <div id="nav_tb">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                   onclick="javascript:navigation.add()">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
                   onclick="javascript:navigation.rename()">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
                   onclick="javascript:navigation.delete()">删除</a>
            </div>
            <ul id="navigationCategory" class="easyui-tree">
            </ul>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(function () {
        $('#nav_dep_input').combobox({
            valueField: 'department',
            textField: 'department',
            url: '/department/inputList',
            onContextMenu: function (e, node) {
                e.preventDefault();
                $(this).tree('select', node.target);
                $('#navigationCategoryMenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onSelect: function (rec) {

                $("#navigationCategory").tree({
                    url: '/navigation/treeNode?depId=' + rec.id,
                    animate: true,
                    method: "GET",
                    onAfterEdit: function (node) {
                        var _tree = $(this);
                        if (node.id == 0) {
                            // 新增节点
                            $.post("/navigation/create", {
                                parentId: node.parentId,
                                name: node.text,
                                depId: rec.id
                            }, function (data) {
                                if (data.status == 200) {
                                    _tree.tree("update", {
                                        target: node.target,
                                        id: data.data.id
                                    });
                                } else {
                                    $.messager.alert('提示', '创建' + node.text + ' 分类失败!');
                                }
                            });
                        } else {
                            $.post("/navigation/update", {id: node.id, name: node.text});
                        }
                    }
                });
            }
        });

    });

    var navigation = {
        add: function () {
            var tree = $("#navigationCategory");
            var node = tree.tree("getSelected");
            if (node != null) {
                tree.tree('append', {
                    parent: (node ? node.target : null),
                    data: [{
                        text: '新建分类',
                        id: 0,
                        parentId: node.id
                    }]
                });
            } else {
                tree.tree('append', {
                    parent: 0,
                    data: [{
                        text: '新建分类',
                        id: 0,
                        parentId: 0
                    }]
                });
            }
            var _node = tree.tree('find', 0);
            tree.tree("select", _node.target).tree('beginEdit', _node.target);
        },
        rename: function () {
            var tree = $("#navigationCategory");
            var node = tree.tree("getSelected");
            tree.tree('beginEdit', node.target);
        },
        delete: function () {
            var tree = $("#navigationCategory");
            var node = tree.tree("getSelected");
            $.messager.confirm('确认', '确定删除名为 ' + node.text + ' 的分类吗？', function (r) {
                if (r) {
                    $.post("/navigation/delete", {parentId: node.parentId, id: node.id}, function () {
                        tree.tree("remove", node.target);
                    });
                }
            });
        }

    }
</script>