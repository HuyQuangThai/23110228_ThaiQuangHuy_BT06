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
        <h2 class="mb-4">Danh Sách Video</h2>
        <form action="${pageContext.request.contextPath}/admin/video/search" method="get" class="flex-grow-2">
            <input type="text" name="keyword" class="form-control" placeholder="Nhập từ khóa tìm kiếm" />
        </form>
        <a href="${pageContext.request.contextPath}/admin/video/add"
           class="btn btn-primary mb-3 d-flex justify-content-center align-items-center">Thêm video mới</a>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Title</th>
                <th scope="col">URL</th>
                <th scope="col">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${videos}" var="video" varStatus="STT">
                <tr>
                    <th scope="row">${STT.index+1}</th>
                    <td>${video.videoName}</td>
                    <td><c:url
                            value="${video.videoUrl}"
                            var="videoUrl" /> <a href="${videoUrl}">Đường dẫn</a></td>
                    <td class = "action" ><a
                            href="<c:url value='/admin/video/edit?id=${video.id}'/>"
                            class="btn btn-sm btn-warning">Sửa</a> <a
                            href="<c:url value='/admin/video/delete?id=${video.id}'/>"
                            class="btn btn-sm btn-danger"
                            onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này không?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>