<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/5
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Easiliy CURD </title>
</head>
<body>
    <h3 align="center">Welcome TO Add Applicant!</h3>
    <form action="<%= request.getContextPath()%>/applicant/add" method="post">
    <table align="center" border="2" width="50%">
        <tr>
            <th width="10%">id</th>
            <th width="33%">姓名</th>
            <th>qq</th>
            <th width="23%">操作</th>
        </tr>
        <tr >
            <td align="center"></td>
            <td align="center"><input name="name" /></td>
            <td align="center"><input name="qq"/></td>
            <td align="center"><input type="submit" value="确定添加" /></td>
        </tr>
    </table>
    </form>
</body>
</html>
