<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Update User ${id}</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link rel="stylesheet" href="../../../../resources/css/demo.css">
            </head>

            <body>
                <div class="container" style="max-width: 400px; font-family: Arial, sans-serif;">
                    <div class="mt-5 p-4 border rounded">
                        <h1 class="border-bottom pb-2 mb-4">Update ${id}</h1>
                        <form:form action="/admin/user/update" method="post" modelAttribute="currentUser">
                            <div class="mb-3" style="display: none;">
                                <label class="form-label fw-bold ">Id</label>
                                <form:input type="id" class="form-control" placeholder="Nhập id vào đây" path="id" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Email</label>
                                <form:input type="email" class="form-control" placeholder="Nhập email vào đây"
                                    path="email" disabled = "true"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Full name</label>
                                <form:input type="text" class="form-control" placeholder="Nhập họ tên vào đây"
                                    path="fullName" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Address</label>
                                <form:input type="text" class="form-control" placeholder="Nhập địa chỉ vào đây"
                                    path="address" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Phone number</label>
                                <form:input type="tel" class="form-control" placeholder="Nhập số điện thoại vào đây"
                                    path="phoneNumber" />
                            </div>
                            <button class="btn text-white"
                                style="background-color: #4c7da8; border-radius: 5px; width: 80px; height: 40px;">
                                Update
                            </button>
                        </form:form>
                    </div>
                </div>
            </body>

            </html>