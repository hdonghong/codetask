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
    <h3 align="center">Welcome!</h3>
    <div align="center">
        <form action="<%= request.getContextPath()%>/applicant/" method="post">
            id: <input name="id"/>&nbsp;
            <input type="submit" value="查询" />&nbsp;
            <input type="button" value="添加"
                   onclick="location.href='<%= request.getContextPath()%>/applicant/addpage'">
        </form>
    </div>

    <table align="center" border="2" width="50%">
        <tr>
            <th width="10%">id</th>
            <th width="33%">姓名</th>
            <th>qq</th>
            <th width="23%">操作</th>
        </tr>
    <c:forEach items="${list}" var="i">
        <tr >
            <td align="center">${i.id}</td>
            <td align="center">${i.name}</td>
            <td align="center">${i.qq}</td>
            <td align="center">
                <a href="<%= request.getContextPath()%>/applicant/editpage/${i.id}">修改</a>&nbsp;|&nbsp;
                <a href="javascript:void(0)">删除</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
