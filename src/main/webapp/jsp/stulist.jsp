<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>index</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<div>
    <p id="p">学生信息</p>
    <table border="1px" width="500px">
        <tr>
            <td>学生id</td>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
        </tr>
        <c:forEach var="student" items="${pageBean.pageList}">
            <tr>
                <td>${student.id}</td>
                <td>${student.scold}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                当前页数：[${pageBean.currentPage}/${pageBean.pageCount}]
                <a href="student.do?currentPage=1">首页</a>
                <a href="student.do?currentPage=${pageBean.nextPage}">下一页</a>
                <c:forEach begin="${pageBean.startPage}" end="${pageBean.endPage}" var="pageNum">
                    <c:if test="${pageNum == pageBean.currentPage}">
                        ${pageNum}
                    </c:if>
                    <c:if test="${pageNum != pageBean.currentPage}">
                        <a href="student.do?currentPage=${pageNum}">${pageNum}</a>
                    </c:if>
                </c:forEach>
                <a href="student.do?currentPage=${pageBean.previousPage}">上一页</a>
                <a href="student.do?currentPage=${pageBean.pageCount}">尾页</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
