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
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/regist" method="post" >
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
                <td colspan="2"><input type="submit" value="注册"/></td>
            </tr>

        </table>
    </form>
</body>
</html>
