<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- Bootstrap Icons -->
<link
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
        rel="stylesheet">
<style>
    .sidebar .sidebar_item {
        display: block;
        padding: 10px 20px;
        margin: 5px 10px;
        border-radius: 8px;
        text-decoration: none;
        color: #333;
        font-weight: 500;
        position: relative;
        top: 100px;
    }
    .sidebar .sidebar_item:hover, .sidebar .sidebar_item.active {
        background-color: #007bff;
        color: white;
    }
    .content {
        margin-left: 200px; /* chừa chỗ cho sidebar */
        padding: 20px;
    }
</style>
<!-- Sidebar -->
<div class="bg-light border-end position-fixed top-0 start-0 h-100 p-3 bg-white sidebar"
     style="width: 200px;">
    <nav>
        <a href="${home}"
           class="nav-link ${active_home} d-flex align-items-center mb-2 sidebar_item"> <i
                class="bi bi-house-door me-2"></i> Home
        </a> <a href="${category}"
                class="nav-link ${active_category} d-flex align-items-center sidebar_item"> <i
            class="bi bi-folder me-2"></i> Category
    </a> <a href="${user}"
            class="nav-link ${active_user} d-flex align-items-center sidebar_item"> <i
            class="bi bi-people me-2"></i> User
    </a> <a href="${video}"
            class="nav-link ${active_video} d-flex align-items-center sidebar_item"> <i
            class="bi bi-camera-video me-2"></i> Video
    </a>
    </nav>
</div>