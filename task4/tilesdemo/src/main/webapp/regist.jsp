<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/29
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        // 获取短信验证码
        function getCheckCode() {
            var phone = $("#phone").val();
            var url = "${pageContext.request.contextPath}/user/checkCode";
            var params = {"phone": phone};
//            alert(phone)
            $.post(url, params, function(data){
                if (!data || data == "") {
                    alert("验证失败");
                } else {
                    $("#server_code").val(data);
                    alert(data);
                }
            });
        }

        // 提交表单前进行检查
        function checkForm() {
            var server_code = $("#server_code").val();
            var check_code = $("#check_code").val();
            if (server_code == check_code) {
                return true;
            }
            alert("验证码错误，请重新输入")
            return false;
        }

    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/regist" method="post" onsubmit="return checkForm()">
        <table align="center" width="25%" border="1">
            <caption style="font-weight: 800;font-size:200%;">用户注册</caption>
            <tr>
                <td height="40px;">账号</td>
                <td><input type="text" name="username" maxlength="15" size="20" required/></td>
            </tr>
            <tr>
                <td height="40px;">密码</td>
                <td><input type="password" name="password" maxlength="15" size="20" required/></td>
            </tr>
            <tr>
                <td height="40px;">手机</td>
                <td><input type="text" name="phone" maxlength="15" size="20" required id="phone"/></td>
            </tr>
            <tr>
                <td height="40px;">邮箱</td>
                <td><input type="email" name="email" maxlength="15" size="20" required/></td>
            </tr>
            <tr>
                <td height="40px;">头像</td>
                <td><input type="file" name="head" maxlength="15" size="20" /></td>
            </tr>
            <tr>
                <td height="40px;">验证码</td>
                <td>
                    <input type="text" id="check_code" name="check_code" maxlength="15" size="20" required />
                    <input type="hidden" id="server_code" value="" />
                    <button onclick="getCheckCode()" >获取短信验证码</button>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
