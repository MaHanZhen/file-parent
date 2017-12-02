<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>注册</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">

    <script type="application/javascript" src="js/jquery.min.js"></script>

    <script type="application/javascript" src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script type="application/javascript" src="js/bootstrapValidator.js"></script>
    <link href="css/bootstrapValidator.min.css" rel="stylesheet" type="text/css">

    <script type="application/javascript">

        $(function () {

            $('#register')
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
                                //{"valid":true}
                                remote: {
                                    url: '/check/data/1',
                                    message: '该账号不可用'
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
                        depId: {
                            validators: {
                                notEmpty: {
                                    message: '请选选择部门'
                                }
                            }
                        },
                        email: {
                            validators: {
                                notEmpty: {
                                    message: '邮箱不能为空'
                                },
                                remote: {
                                    url: '/check/data/2',
                                    message: '该邮箱不可用'
                                },
                                emailAddress: {
                                    message: '这不是一个有效的电子邮件地址'
                                }
                            }
                        },
                        name: {
                            validators: {
                                notEmpty: {
                                    message: '姓名不能为空'
                                },
                                stringLength: {
                                    min: 2,
                                    max: 5,
                                    message: '姓名的长度应在5-10之间'
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
                        },
                        password_confirm: {
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                },
                                stringLength: {
                                    min: 6,
                                    max: 10,
                                    message: '密码的长度应在6-10之间'
                                },
                                identical: {
                                    field: 'password',
                                    message: '确认密码与密码不一致'
                                },
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
                    $.post($form.attr('action'), $form.serialize(), function (result) {
                        console.log(result);
                    }, 'json');
                });

            $.post("/department/list",
                function (msg) {
                    if (msg.status == 200) {
                        var $department = $("#department");
                        $.each(msg.data, function (i, item) {
                            var option = "<option  value='" + item.id + "'>" + item.department + "</option>"
                            $department.append($(option));
                        })
                    }
                }
            );
        })
    </script>
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">注册</h1>
<div class="container">
    <div class="col-md-12">
        <form id="register" class="form-horizontal templatemo-create-account templatemo-container" role="form"
              action="/user/register"
              method="post">
            <div class="form-inner">
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="username" class="control-label">账号</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="">
                    </div>
                    <div class="col-md-6">
                        <label for="department" class="control-label">系别</label>
                        <select class="form-control" name="depId" id="department"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="email" class="control-label">邮箱</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="name" class="control-label">姓名</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="password" class="control-label">密码</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="">
                    </div>
                    <div class="col-md-6">
                        <label for="password" class="control-label">确认密码</label>

                        <input type="password" class="form-control" name="password_confirm" id="password_confirm"
                               placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <!-- 可以留给验证码 -->
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="submit" value="注册" class="btn btn-info">
                        <span id="error" style="color: red">error</span>
                        <a href="/login" class="pull-right">已有账号，立即登录</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>