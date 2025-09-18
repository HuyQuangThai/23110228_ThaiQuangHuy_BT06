<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4 rounded-4" style="width: 380px;">
        <h3 class="text-center mb-4">
            <c:choose>
                <c:when test="${category.id != null}">Edit Category</c:when>
                <c:otherwise>Add Category</c:otherwise>
            </c:choose>
        </h3>

        <form action="${action}" method="post">

            <input type="hidden" name="id" value="${category.id}"/>

            <div class="mb-3">
                <label for="categoryName" class="form-label"><b>Category name</b></label>
                <input type="text" id="categoryName" class="form-control"
                       name="categoryName" placeholder="Enter Category Name"
                       value="${category.categoryName}" required>
            </div>

            <div class="mb-3">
                <label for="images" class="form-label"><b>Images</b></label>
                <input type="text" id="images" class="form-control"
                       name="images" placeholder="Enter Images"
                       value="${category.images}" required>
            </div>

            <div class="mb-3">
                <c:if test="${alert != null}">
                    <div class="alert alert-danger d-flex align-items-center" role="alert">
                        <div>${alert}</div>
                    </div>
                </c:if>
            </div>

            <div class="d-flex justify-content-between">
                <a href="${pageContext.request.contextPath}/admin/category" class="btn btn-outline-secondary rounded-3">
                    <i class="bi bi-arrow-left me-1"></i> Back
                </a>
                <button type="submit" class="btn btn-primary rounded-3">
                    <i class="bi bi-save me-1"></i> Save
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
