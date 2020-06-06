<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员注册页面</title>
    <%--    静态包含--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script>
        $(function () {
            //提交表单
            $("#sub_btn").click(function () {

                let username = $("#username").val();
                let password = $("#password").val();
                let repeatPassword = $("#repwd").val();
                let email = $("#email").val();
                let Captcha = $("#code").val().trim();

                let errMsg = $("span.errorMsg");

                //用户名  字母数字下划线，5-12位 ,字母或数字开头
                let usernamePattern = /^[a-zA-Z|0-9]\w{4,11}$/;
                //密码	字母数字下划线，5-12位 ,字母或数字开头
                let passwordPattern = /^[a-zA-Z]\w{4,17}$/;
                //邮箱
                let emailPattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                //验证用户名
                if (!usernamePattern.test(username)) {
                    errMsg.text("用户名不合法");
                    return false;
                }
                //验证密码
                if (!passwordPattern.test(password)) {
                    errMsg.text("密码不合法");
                    return false;
                }
                //确认密码
                if (repeatPassword !== password) {
                    errMsg.text("密码不一致");
                    return false;
                }
                //
                //验证邮箱
                if (!emailPattern.test(email)) {
                    errMsg.text("邮箱不合法");
                    return false;
                }
                if (Captcha == null || Captcha === "") {
                    errMsg.text("验证错误！");
                    return false;
                }


                errMsg.text("");
            })
        })

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册会员</h1>
                    <span class="errorMsg">
                        ${empty requestScope.msg?" 请输入用户名和密码":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="${requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" id="code" autocomplete="off"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>