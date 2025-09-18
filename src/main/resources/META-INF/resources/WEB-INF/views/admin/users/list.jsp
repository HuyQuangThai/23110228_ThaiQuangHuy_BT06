<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
<style>
    /* Optional: Custom CSS to enhance the look */
    .table-img {
        max-width: 100px;
        height: auto;
        border-radius: 5px;
    }

    .table-responsive {
        margin-top: 20px;
    }

    .table-img {
        max-width: 120px;
        max-height: 120px;
        object-fit: contain; /* giữ tỉ lệ hình */
        display: block;
        margin: 0 auto; /* căn giữa */
    }
    .main-content {
        margin-left: 50px;    /* đẩy nội dung sang phải bằng với chiều rộng sidebar */
        width:90%;
    }
    .table-striped > tbody > tr:nth-of-type(odd) {
        background-color: transparent !important;
    }
    .action {
        width: 150px;
    }

    .btn-warning {
        width: 60px;
        margin-left: 7.5px;
    }

    .btn-danger {
        width: 60px;
    }

</style>
<div class="container mt-5 main-content">
    <div class="d-flex justify-content-between">
        <h2 class="mb-4">Danh Sách Người dùng</h2>
        <form action="${pageContext.request.contextPath}/admin/user/search" method="get" class="flex-grow-2">
            <input type="text" name="keyword" class="form-control" placeholder="Nhập từ khóa tìm kiếm" />
        </form>
        <a href="${pageContext.request.contextPath}/admin/user/add"
           class="btn btn-primary mb-3 d-flex justify-content-center align-items-center">Thêm user mới</a>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Hình ảnh</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Email</th>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Role</th>
                <th scope="col">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user" varStatus="STT">
                <tr>
                    <th scope="row">${STT.index+1}</th>
                    <td><c:if test="${user.images != null}">
                        <img src="${user.images.substring(0,5) == 'https' ? user.images : '/image?fname=' + user.images}" alt="User images" class="table-img">
                        </c:if>
                    <td>${user.fullName}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><c:if test="${user.role==1}">
                        <span class="badge bg-success">User</span>
                    </c:if> <c:if test="${user.role!=1}">
                        <span class="badge bg-danger">Admin</span>
                    </c:if></td>
                    <td class = "action" ><a
                            href="<c:url value='/admin/user/edit?id=${user.id}'/>"
                            class="btn btn-sm btn-warning">Sửa</a> <a
                            href="<c:url value='/admin/user/delete?id=${user.id}'/>"
                            class="btn btn-sm btn-danger"
                            onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này không?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
