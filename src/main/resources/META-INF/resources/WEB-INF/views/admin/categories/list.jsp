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
        <h2 class="mb-4">Danh Sách Danh Mục</h2>
        <a href="${pageContext.request.contextPath}/admin/category/add"
           class="btn btn-primary mb-3 d-flex justify-content-center align-items-center">Thêm Danh Mục Mới</a>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Hình ảnh</th>
                <th scope="col">Mã danh mục</th>
                <th scope="col">Tên danh mục</th>
                <!-- 		<th scope="col">Trạng thái</th> -->
                <th scope="col">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="cate" varStatus="STT">
                <tr>
                    <th scope="row">${STT.index+1}</th>
                    <td><c:url
                            value="${cate.images.substring(0,5) =='https' ? cate.images : '/image?fname=' += cate.images}"
                            var="imgUrl" /> <img src="${imgUrl}"
                                                 class="table-img" alt="Category Image" /></td>
                    <td>${cate.categoryId}</td>
                    <td>${cate.categoryName}</td>
                        <%-- 				<td><c:if test="${cate.status==1}">
                                                <span class="badge bg-success">Hoạt động</span>
                                            </c:if> <c:if test="${cate.status!=1}">
                                                <span class="badge bg-danger">Khóa hoạt động</span>
                                            </c:if></td> --%>
                    <td class = "action" ><a
                            href="<c:url value='/admin/category/edit?id=${cate.id}'/>"
                            class="btn btn-sm btn-warning">Sửa</a> <a
                            href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
                            class="btn btn-sm btn-danger"
                            onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này không?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>