<%--@elvariable id="record" type="com.nmuzychuk.directory.model.Record"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../layout/head.jsp" %>
    <title>Record details</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h2>Record details</h2>
    </div>

    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Record ${record.id}</h3>
                </div>
                <div class="panel-body">
                    <p>
                        ${record.firstName}
                    </p>
                    <p>
                        ${record.lastName}
                    </p>
                    <p>
                        ${record.phoneNumber}
                    </p>
                </div>
            </div>

            <a href="record" class="btn btn-default">Back</a>
        </div>
    </div>

</div>
</body>
</html>
