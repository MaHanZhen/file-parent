<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>登录</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script type="application/javascript" src="js/jquery.min.js"></script>

    <script type="application/javascript" src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script type="application/javascript" src="js/bootstrapValidator.js"></script>
    <link href="css/bootstrapValidator.min.css" rel="stylesheet" type="text/css">

    <script type="application/javascript">
        $(function () {
            $('#login')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        username: {
                            validators: {
                                notEmpty: {
                                    message: '账号不能为空'
                                },
                                stringLength: {
                                    min: 5,
                                    max: 10,
                                    message: '账号的长度应在5-10之间'
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: '用户名只能由字母、数字、点和下划线组成'
                                }
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                },
                                stringLength: {
                                    min: 6,
                                    max: 10,
                                    message: '密码的长度应在6-10之间'
                                }
                            }
                        }
                    }
                })
                .on('success.form.bv', function (e) {
                    e.preventDefault();
                    // Get the form instance
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    // Use Ajax to submit form data
                    $.post($form.attr('action'), $form.serialize(), function (msg) {
                        if (msg.status == 200) {
                            //跳转到与角色相对应的页面
                            location.href = msg.data;
                        } else {
                            $("#error").html(msg.msg);
                        }
                    }, 'json');
                });
        })

    </script>

</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">登录</h1>
        <form id="login" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30"
              role="form"
              action="/user/login" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <label for="username" class="control-label fa-label"><i
                                class="fa fa-user fa-medium"></i></label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i
                                class="fa fa-lock fa-medium"></i></label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="checkbox control-wrapper">
                        <%--<label>--%>
                        <%--<input type="checkbox"> 下次自动登录--%>
                        <%--</label>--%>
                        <span id="error" style="color: red">${error}</span>
                        <!-- 留给验证码的地方-->
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="submit" value="登录" class="btn btn-info">

                        <a href="/forgot-password" class="text-right pull-right">忘记密码</a>
                    </div>
                </div>
            </div>
            <hr>
        </form>
        <div class="text-center">
            <a href="/register" class="templatemo-create-new">点我注册 <i class="fa fa-arrow-circle-o-right"></i></a>
        </div>
    </div>
</div>
</body>
</html>