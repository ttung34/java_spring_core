<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User ${id}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body class="p-5">

    <div class="container">
        <h2 class="fw-bold text-primary mb-4">Delete the user with id = ${id} </h2>
        <hr>
        <div class="alert alert-danger" role="alert">
            Are you sure to delete this user ?
        </div>
        <form:form action="/admin/user/delete" modelAttribute="deleteUser" method="post">
            <div class="mb-3" style="display: none;">
                <label class="form-label fw-bold ">Id</label>
                <form:input type="id" class="form-control" placeholder="Nhập id vào đây" path="id" />
            </div>
            <button class="btn btn-danger btn-lg">Confirm</button>
        </form:form>
    </div>

</body>

</html>