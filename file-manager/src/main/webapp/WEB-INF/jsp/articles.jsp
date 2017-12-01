<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false"
     style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:200px;padding:5px">
            <h3>请选择要管理的部门</h3>
            <input id="art_dep_input"/>
            <hr/>
            <h3>请选择要内容</h3>
            <ul id="art_tree"></ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table id="art_dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
                   toolbar="#atr_tb" pagination="true"
                   rownumbers="true" fitColumns="true" singleSelect="true">
                <thead>
                <tr>
                    <th field="id" width="20">Id</th>
                    <th field="author" width="30">作者</th>
                    <th field="title" width="100">标题</th>
                    <th field="department" width="30">系别</th>
                    <th field="created" width="30" formatter="formatDate">上传时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div id="atr_tb">
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editArticle()">查看</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeArticle()">删除</a>
</div>
<script type="application/javascript">

    function removeArticle() {
        var row = $('#art_dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('提示', '你确定删除这篇文章 ?', function (r) {
                if (r) {
                    $.post('/article/delete', {id: row.id}, function (result) {
                        if (result.status ==200) {
                            $('#art_dg').datagrid('reload');	// reload the user data
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


    //毫秒数装换成时间 --开始
    function formatDate(value) {
        if (value == null || value == '') {
            return '';
        }
        var dt = parseToDate(value);//关键代码，将那个长字符串的日期值转换成正常的JS日期格式
        return dt.format("yyyy-MM-dd"); //这里用到一个javascript的Date类型的拓展方法，这个是自己添加的拓展方法，在后面的步骤3定义
    }

    //为Date类型拓展一个format方法，用于格式化日期
    Date.prototype.format = function (format) //author: meizz
    {
        var o = {
            "M+": this.getMonth() + 1, //month
            "d+": this.getDate(),    //day
            "h+": this.getHours(),   //hour
            "m+": this.getMinutes(), //minute
            "s+": this.getSeconds(), //second
            "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
            "S": this.getMilliseconds() //millisecond
        };
        if (/(y+)/.test(format))
            format = format.replace(RegExp.$1,
                (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(format))
                format = format.replace(RegExp.$1,
                    RegExp.$1.length == 1 ? o[k] :
                        ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    };

    function parseToDate(value) {
        if (value == null || value == '') {
            return undefined;
        }
        var dt;
        if (value instanceof Date) {
            dt = value;
        }
        else {
            if (!isNaN(value)) {
                dt = new Date(value);
            }
            else if (value.indexOf('/Date') > -1) {
                value = value.replace(/\/Date(−?\d+)\//, '$1');
                dt = new Date();
                dt.setTime(value);
            } else if (value.indexOf('/') > -1) {
                dt = new Date(Date.parse(value.replace(/-/g, '/')));
            } else {
                dt = new Date(value);
            }
        }
        return dt;
    }

    // --结束

    $(function () {
        $('#art_dep_input').combobox({
            valueField: 'department',
            textField: 'department',
            url: '/department/inputList',
            onSelect: function (rec) {
                $('#art_dg').datagrid('loadData', {total: 0, rows: []});
                $("#art_tree").tree({
                    url: '/navigation/treeNode?depId=' + rec.id,
                    animate: true,
                    method: "GET",
                    onClick: function (node) {
                        var url = "/article/dataGridList?navId=" + node.id;
//                        alert();  // 在用户点击的时候提示
                        $("#art_dg").datagrid("reload", url);
                    }

                })
            }
        })
    })
</script> 