<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
            <meta name="author" content="Hỏi Dân IT" />
            <title>Dashboard - Hỏi Dân IT</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <script>
                $(document).ready(() => {
                    const avatarFile = $("#avatarFile");
                    avatarFile.change(function (e) {
                        const imgURL = URL.createObjectURL(e.target.files[0]);
                        $("#avatarPreview").attr("src", imgURL);
                        $("#avatarPreview").css({ "display": "block" });
                    });
                });
            </script>

        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/tabbar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Create User</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                <li class="breadcrumb-item active">User</li>
                            </ol>
                            <div class="container" style="max-width: 400px; font-family: Arial, sans-serif;">
                                    <h1 class="border-bottom pb-2 mb-4">Create a user</h1>
                                    <form:form 
                                    action="/admin/user/create" 
                                    method="post" 
                                    modelAttribute="newUser" 
                                    class="row"
                                    enctype="multipart/form-data"
                                    >
                                        <div class="mb-3 col-12 col-md-6">
                                            <label class="form-label fw-bold">Email</label>
                                            <form:input type="email" class="form-control" placeholder="Nhập email vào đây" path="email"
                                                required="required" />
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label class="form-label fw-bold">Password</label>
                                            <form:input type="password" class="form-control" placeholder="Nhập mật khẩu vào đây" path="password"
                                                required="required" />
                                        </div>
                                        <div class="mb-3 col-12 col-md-6 ">
                                            <label class="form-label fw-bold">Full name</label>
                                            <form:input type="text" class="form-control" placeholder="Nhập họ tên vào đây" path="fullName"
                                                required="required" />
                                        </div>
                                        <div class="mb-3 col-12 col-md-6 ">
                                            <label class="form-label fw-bold">Phone number</label>
                                            <form:input type="tel" class="form-control" placeholder="Nhập số điện thoại vào đây" path="phoneNumber"
                                                required="required" />
                                        </div>
                                        <div class="mb-3 col-12">
                                            <label class="form-label fw-bold">Address</label>
                                            <form:input type="text" class="form-control" placeholder="Nhập địa chỉ vào đây" path="address"
                                                required="required" />
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label class="form-label">Role:</label>
                                            <form:select class="form-select" path="role.name">
                                                <form:option value="ADMIN">ADMIN</form:option>
                                                <form:option value="USER">USER</form:option>
                                            </form:select>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="avatarFile" class="form-label">Avatar:</label>
                                            <input type="file" class="form-control" 
                                            id="avatarFile" accept=".png, .jpg, .jpeg" name="fileImg"/>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <img alt="avatar preview" id="avatarPreview" style="max-height: 250px; display: none;" />
                                        </div>
                                        
                                        <button class="col-12 mb-5"
                                            style="background-color: #4c7da8; border-radius: 5px; width: 80px; height: 40px;">
                                            Create
                                        </button>
                                    </form:form>
                                </div>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
        </body>

        </html>
