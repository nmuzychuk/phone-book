<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../layout/head.jsp" %>
    <title>New Record</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h2>New record</h2>
    </div>

    <div class="row">
        <div class="col-md-4">
            <form action="record" method="post">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" name="id" id="id" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input type="text" name="firstName" id="firstName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="lastName">Last name</label>
                    <input type="text" name="lastName" id="lastName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="phoneNumber">Phone number</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" class="form-control"/>
                </div>

                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
