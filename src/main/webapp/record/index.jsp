<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../layout/head.jsp" %>
    <title>Phone Book</title>
</head>
<body>

<div class="container">
    <div class="page-header">
        <h2>Phone Book</h2>
    </div>
</div>

<div class="container">
    <p>
        <a href="record?action=new" class="btn btn-success">New record</a>
    </p>

    <c:choose>
        <%--@elvariable id="recordList" type="java.util.List"--%>
        <c:when test="${not empty recordList}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="record" items="${recordList}">
                    <tr>
                        <td>${record.id}</td>
                        <td>${record.firstName}</td>
                        <td>${record.lastName}</td>
                        <td>${record.phoneNumber}</td>
                        <td>
                            <a href="record?action=show&id=${record.id}" class="btn btn-info">Show</a>
                            <a href="record?action=edit&id=${record.id}" class="btn btn-warning">Edit</a>

                            <form action="record" method="post" style="display: inline">
                                <input type="hidden" name="_method" value="delete"/>
                                <input type="hidden" name="id" value="${record.id}"/>
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info">
                No records found
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
