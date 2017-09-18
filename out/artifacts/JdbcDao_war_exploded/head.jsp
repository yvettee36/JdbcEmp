<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/9/17
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>头部</title>
    <script src="js/jquery-1.10.2.min.js" language="JavaScript"></script>
    <script type="text/javascript">
        $(function () {
            $("#select").change(function () {
                var deptno = $(this).val();
                $("this #no_select").attr("disabled", "disabled");
                window.parent.main.location.href = "${pageContext.request.contextPath}/EmpListServlet?deptno=" + deptno;
            });
        });
    </script>
</head>
<body style="text-align: center;">
<h1>雇员列表</h1>
<br>
部门编号：<select name="deptno" id="select" style="width: 100px;">
    <option value="0" id="no_select" selected style="color: darkgray">请选择：</option>
    <c:forEach var="dno" items="${list}">
        <option value="${dno}">${dno}</option>
    </c:forEach>
</select>
</body>
</html>
