<%--@elvariable id="record" type="com.nmuzychuk.directory.model.Record"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../layout/head.jsp" %>
    <title>Editing record</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h2>Editing record</h2>
    </div>

    <div class="row">
        <div class="col-md-4">
            <form action="record" method="post">
                <input type="hidden" name="_method" value="put"/>

                <input type="hidden" name="id" value="${record.id}"/>

                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input type="text" name="firstName" id="firstName" value="${record.firstName}"
                           class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="lastName">Last name</label>
                    <input type="text" name="lastName" id="lastName" value="${record.lastName}" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="phoneNumber">Phone number</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" value="${record.phoneNumber}"
                           class="form-control"/>
                </div>

                <button type="submit" class="btn btn-success">Update</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
