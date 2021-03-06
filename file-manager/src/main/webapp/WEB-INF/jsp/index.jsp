<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>淘淘商城后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.3/themes/icon.css"/>

    <script type="text/javascript" src="js/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5.3/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>

</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">

    <a id="logout" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">安全登出</a>
    <hr/>
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>账号管理</span>
            <ul>
                <li data-options="attributes:{'url':'user'}">编辑账号</li>
            </ul>
        </li>
        <li>
            <span>系别管理</span>
            <ul>
                <li data-options="attributes:{'url':'department'}">系别管理</li>
            </ul>
        </li>
        <li>
            <span>内容管理</span>
            <ul>
                <li data-options="attributes:{'url':'navigation'}">内容管理</li>
                <li data-options="attributes:{'url':'articles'}">文章管理</li>
            </ul>
        </li>
    </ul>


</div>
<div data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs">
        <div title="首页" style="padding:20px;">

        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#logout').bind('click', function () {
            var href = "/user/logout";
            $.post(href, function (msg) {
                if (msg.status == 200) {
                    //跳转到与角色相对应的页面
                    location.href = msg.data;
                } else {
                    $("#error").html(msg.msg);
                }
            }, 'json');
        });

        $('#menu').tree({
            onClick: function (node) {
                if ($('#menu').tree("isLeaf", node.target)) {
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab", node.text);
                    if (tab) {
                        tabs.tabs("select", node.text);
                    } else {
                        tabs.tabs('add', {
                            title: node.text,
                            href: node.attributes.url,
                            closable: true,
                            bodyCls: "content"
                        });
                    }
                }
            }
        });
    });
</script>
</body>
</html>