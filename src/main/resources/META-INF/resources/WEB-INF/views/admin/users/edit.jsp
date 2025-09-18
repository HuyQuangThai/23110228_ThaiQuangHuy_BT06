<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

<style>
    select option:hover {
        background-color: #0d6efd;
        color: white;
    }
</style>

<form action="${action}" method="post">
    <input type="hidden" name="id" value="${user.id}"/>

    <div class="row">
        <!-- Account Info -->
        <div class="col-md-6">
            <h5 class="mb-3 border-bottom pb-2">Account Info</h5>

            <div class="mb-3">
                <label for="username" class="form-label"><b>Username</b></label>
                <input type="text" id="username" class="form-control"
                       name="username" placeholder="Enter Username"
                       value="${user.username}" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label"><b>Password</b></label>
                <input type="text" id="password" class="form-control"
                       name="password" placeholder="Enter Password"
                       value="${user.password}" required>
            </div>

            <div class="mb-3">
                <label for="role" class="form-label"><b>Role</b></label>
                <select id="role" name="role" class="form-select rounded" required>
                    <option value="2" ${user.role == 2 ? 'selected' : ''}>Admin</option>
                    <option value="1" ${user.role == 1 ? 'selected' : ''}>User</option>
                </select>
            </div>
        </div>

        <!-- User Info -->
        <div class="col-md-6">
            <h5 class="mb-3 border-bottom pb-2">User Info</h5>

            <div class="mb-3">
                <label for="fullname" class="form-label"><b>Fullname</b></label>
                <input type="text" id="fullname" class="form-control"
                       name="fullName" placeholder="Enter Fullname"
                       value="${user.fullName}">
            </div>

            <div class="mb-3">
                <label for="phone" class="form-label"><b>Contact Phone</b></label>
                <input type="text" id="phone" class="form-control"
                       name="phone" placeholder="Enter Contact Phone"
                       value="${user.phone}">
            </div>

            <div class="mb-3">
                <label for="email" class="form-label"><b>Email</b></label>
                <input type="text" id="email" class="form-control"
                       name="email" placeholder="Enter Email"
                       value="${user.email}">
            </div>

            <div class="mb-3">
                <label for="images" class="form-label"><b>Avatar</b></label>
                <input type="text" id="images" class="form-control"
                       name="images" placeholder="Enter Avatar"
                       value="${user.images}">
            </div>
        </div>
    </div>

    <!-- Alert -->
    <div class="mb-3">
        <c:if test="${alert != null}">
            <div class="alert alert-danger d-flex align-items-center" role="alert">
                <div>${alert}</div>
            </div>
        </c:if>
    </div>

    <!-- Action buttons -->
    <div class="d-flex justify-content-between">
        <a href="${pageContext.request.contextPath}/admin/user" class="btn btn-outline-secondary rounded-3">
            <i class="bi bi-arrow-left me-1"></i> Back
        </a>
        <button type="submit" class="btn btn-primary rounded-3">
            <i class="bi bi-save me-1"></i> Save
        </button>
    </div>
</form>
