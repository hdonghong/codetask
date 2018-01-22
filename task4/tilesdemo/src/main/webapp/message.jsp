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
    <title>温馨提示</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/regist" method="post" >
        <table align="center" width="25%" border="1">
            <caption style="font-weight: 800;font-size:200%;">${message}</caption>
        </table>
    </form>
</body>
</html>
