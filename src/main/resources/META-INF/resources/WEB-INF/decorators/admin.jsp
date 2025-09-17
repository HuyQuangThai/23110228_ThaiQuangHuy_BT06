<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
</head>
<style>
    .content {
        width: 80%;
        padding: 50px;
    }
</style>
<body>
<%@ include file="/commons/left.jsp" %>
<div class = "content">
    <sitemesh:write property="body" />
</div>
</body>
</html>