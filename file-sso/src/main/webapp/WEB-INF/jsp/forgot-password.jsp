<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>找回密码</title>
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
        <h1 class="margin-bottom-15">找回</h1>
        <form class="form-horizontal templatemo-forgot-password-form templatemo-container" role="form" action="#"
              method="post">
            <div class="form-group">
                <div class="col-md-12">
                    请，填写您账号所绑定的邮箱，我们会发送邮件，请到邮箱中查收
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <input type="text" class="form-control" id="email" placeholder="您账号所绑定的邮箱">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <input type="submit" value="找回密码" class="btn btn-danger">
                    <br><br>
                    <a href="/login">登录</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>