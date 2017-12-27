<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post" >
    <table border="1" align="center" width="20%">
        <caption style="font-weight: 800;font-size:200%;">用户登录</caption>
        <tr>
            <td>账号</td>
            <td><input type="text" name="username" maxlength="15" size="20" required/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" maxlength="15" size="20" required/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录"/>
                <a href="${pageContext.request.contextPath}/regist.jsp">注册新用户</a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <label style="color:red;">${message}</label>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
