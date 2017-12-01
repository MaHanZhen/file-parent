<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>注册</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">注册</h1>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="#"
              method="post">
            <div class="form-inner">
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="first_name" class="control-label">账号</label>
                        <input type="text" class="form-control" id="first_name" placeholder="">
                    </div>
                    <div class="col-md-6">
                        <label for="last_name" class="control-label">系别</label>
                        <%--<input type="text" class="form-control" id="last_name" placeholder="">--%>
                        <select class="form-control" id="last_name">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="password" class="control-label">密码</label>
                        <input type="password" class="form-control" id="password" placeholder="">
                    </div>
                    <div class="col-md-6">
                        <label for="password" class="control-label">确认密码</label>
                        <input type="password" class="form-control" id="password_confirm" placeholder="">
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="username" class="control-label">姓名</label>
                        <input type="text" class="form-control" id="username" placeholder="">
                    </div>
                    <!--
                    <div class="col-md-6 templatemo-radio-group">
                        <label class="radio-inline">
                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"> Male
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"> Female
                        </label>
                    </div>
                    -->
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="username" class="control-label">邮箱</label>
                        <input type="email" class="form-control" id="email" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <!-- 留给验证码的地方-->
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="submit" value="注册" class="btn btn-info">
                        <a href="/login" class="pull-right">已有账号，现在登录</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>