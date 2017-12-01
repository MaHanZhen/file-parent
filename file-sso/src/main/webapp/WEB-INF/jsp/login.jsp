<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>登录</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">登录</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form"
              action="#" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <label for="username" class="control-label fa-label"><i
                                class="fa fa-user fa-medium"></i></label>
                        <input type="text" class="form-control" id="username" placeholder="用户名">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i
                                class="fa fa-lock fa-medium"></i></label>
                        <input type="password" class="form-control" id="password" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="checkbox control-wrapper">
                        <label>
                            <input type="checkbox"> 下次自动登录
                        </label>

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