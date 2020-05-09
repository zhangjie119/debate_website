<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>三狗一男辩论网</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
</head>
<script type="text/javascript">
    function checkPassword() {
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;
        if(password1 == password2) {
            return true
        } else {
            alert("两次密码不一致");
            return false;
        }

    }

</script>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">


        <a href="all-admin-index.html"><b>三狗一男</b>辩论网</a>


    </div>

    <div class="register-box-body">
        <p class="login-box-msg">新用户注册</p>

        <form action="user/register" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="登录名" name="username"
                       required oninvalid="setCustomValidity('登录名不能为空')" oninput="setCustomValidity('')">
                <span class="glyphicon glyphicon-glass form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="昵称" name="nickname"
                       required oninvalid="setCustomValidity('昵称不能为空')" oninput="setCustomValidity('')">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="password1" id="password1"
                       required oninvalid="setCustomValidity('密码不能为空')" oninput="setCustomValidity('')">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="确认密码" name="password2" id="password2"
                       required oninvalid="setCustomValidity('请确认密码')" oninput="setCustomValidity('')">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" placeholder="邮箱" name="email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" onclick="return checkPassword();" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
        <br>

        <a href="../pages/login.jsp" class="text-center">我有账号，现在就去登录</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>

</html>