<%--
  Created by IntelliJ IDEA.
  User: 92564
  Date: 2020/3/23
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>三狗一男辩论网 | Log in</title>

    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page" style="height: auto;background-size: cover; background: url('${pageContext.request.contextPath}/img/background1.jpg') no-repeat center;">
<div class="login-box">
    <div class="login-logo">
        <a href="all-admin-index.html"><b>三狗一男</b>辩论网</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录系统</p>

        <form action="../user/login" name="login-form" method="post">
            <input type="hidden" name="preUrl" value="${preUrl}" >
            <div class="form-group has-feedback">
                <input type="text" name="username" id="username" class="form-control" placeholder="用户名" required oninvalid="setCustomValidity('用户名不能为空')" oninput="setCustomValidity('')"> <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" name="password" id="password" class="form-control" placeholder="密码" required oninvalid="setCustomValidity('密码不能为空')" oninput="setCustomValidity('')"> <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <!-- 登陆验证 -->
            <div id="vaptchaContainer" style="height: 36px;">
                <!--vaptcha-container是用来引入VAPTCHA的容器，下面代码为预加载动画，仅供参考-->
                <div class="vaptcha-init-main">
                    <div class="vaptcha-init-loading">
                        <a href="/" target="_blank">
                            <img src="https://r.vaptcha.net/public/img/vaptcha-loading.gif" />
                        </a>
                        <input type="hidden" name="vaptcha_token">
                        <span class="vaptcha-text">Vaptcha启动中...</span>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label><input type="checkbox" name="auto_login" value="true"> 记住 下次自动登录</label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="../pages/register.jsp" class="text-center">新用户注册</a>


    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="https://v.vaptcha.com/v3.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
<style>
    .vaptcha-init-main {
        display: table;
        width: 100%;
        height: 100%;
        background-color: #eeeeee;
    }
    ​
    .vaptcha-init-loading {
        display: table-cell;
        vertical-align: middle;
        text-align: center;
    }
    ​
    .vaptcha-init-loading > a {
        display: inline-block;
        width: 18px;
        height: 18px;
        border: none;
    }
    ​
    .vaptcha-init-loading > a img {
        vertical-align: middle;
    }
    ​
    .vaptcha-init-loading .vaptcha-text {
        font-family: sans-serif;
        font-size: 12px;
        color: #cccccc;
        vertical-align: middle;
    }
</style>
<script>
    vaptcha({
        vid: "5edb6555b8c19be33e280e24", // 验证单元id
        type: "click", // 显示类型 点击式
        scene: 0, // 场景值 默认0
        container: "#vaptchaContainer", // 容器，可为Element 或者 selector
        offline_server: "...", //离线模式服务端地址，若尚未配置离线模式，请填写任意地址即可。
        //可选参数
        //lang: 'zh-CN', // 语言 默认zh-CN,可选值zh-CN,en,zh-TW,jp
        //https: true, // 使用https 默认 true
        //style: 'dark' //按钮样式 默认dark，可选值 dark,light
        //color: '#57ABFF' //按钮颜色 默认值#57ABFF
    }).then(function (vaptchaObj) {
        obj = vaptchaObj; //将VAPTCHA验证实例保存到局部变量中
        vaptchaObj.render(); // 调用验证实例 vpObj 的 render 方法加载验证按钮
        //获取token的方式一：
        vaptchaObj.renderTokenInput('.login-form')//以form的方式提交数据时，使用此函数向表单添加token值
        //关闭验证弹窗时触发
        vaptchaObj.listen("close", function () {
            //验证弹窗关闭触发
        });
    });
</script>
</body>

</html>
