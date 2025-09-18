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
                <c:when test="${video.id != null}">Edit Video</c:when>
                <c:otherwise>Add Video</c:otherwise>
            </c:choose>
        </h3>

        <form action="${action}" method="post">

            <input type="hidden" name="id" value="${video.id}"/>

            <div class="mb-3">
                <label for="videoName" class="form-label"><b>Category name</b></label>
                <input type="text" id="videoName" class="form-control"
                       name="videoName" placeholder="Enter Video Name"
                       value="${video.videoName}" required>
            </div>

            <div class="mb-3">
                <label for="url" class="form-label"><b>URL</b></label>
                <input type="text" id="url" class="form-control"
                       name="videoUrl" placeholder="Enter URL"
                       value="${video.videoUrl}" required>
            </div>

            <div class="mb-3">
                <c:if test="${alert != null}">
                    <div class="alert alert-danger d-flex align-items-center" role="alert">
                        <div>${alert}</div>
                    </div>
                </c:if>
            </div>

            <div class="d-flex justify-content-between">
                <a href="${pageContext.request.contextPath}/admin/video" class="btn btn-outline-secondary rounded-3">
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
