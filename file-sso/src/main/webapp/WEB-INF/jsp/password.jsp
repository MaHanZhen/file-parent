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
        <h1 class="margin-bottom-15">请填写新密码</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form"
              action="#" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <%--<label for="username" class="control-label fa-label"><i--%>
                        <%--class="fa fa-user fa-medium"></i></label>--%>
                        <label for="password" class="control-label fa-label"><i
                                class="fa fa-lock fa-medium"></i></label>
                        <input type="text" class="form-control" id="username" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i
                                class="fa fa-lock fa-medium"></i></label>
                        <input type="password" class="form-control" id="password" placeholder="确认密码">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="submit" value="提交" class="btn btn-info">
                    </div>
                </div>
            </div>
            <hr>
        </form>

    </div>
</div>
</body>
</html>