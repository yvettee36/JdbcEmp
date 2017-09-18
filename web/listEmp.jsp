<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/9/17
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>雇员列表展示界面</title>
</head>
<body style="text-align: center;">
<table border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td>雇员编号</td>
        <td>雇员姓名</td>
        <td>雇员工作</td>
        <td>上级编号</td>
        <td>雇用日期</td>
        <td>雇员工资</td>
        <td>雇员奖金</td>
        <td>部门编号</td>
    </tr>
    <c:forEach var="c" items="${list}">
        <tr>
            <td>${c.empno}</td>
            <td>${c.ename}</td>
            <td>${c.job}</td>
            <td>${c.mgr}</td>
            <td>${c.hireDate}</td>
            <td>${c.sal}</td>
            <td>${c.comm}</td>
            <td>${c.deptno}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
