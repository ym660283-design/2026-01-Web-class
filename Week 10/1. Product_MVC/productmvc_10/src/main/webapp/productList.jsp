<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<main class="container py-5">
    <div class="d-flex align-items-center justify-content-between mb-4">
        <h2 class="mb-0">상품 목록</h2>
    </div>

    <div class="card shadow-sm">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover table-bordered align-middle text-center mb-0">
                    <thead class="table-dark">
                    <tr>
                        <th>상품 ID</th>
                        <th>상품명</th>
                        <th>제조사</th>
                        <th>가격</th>
                        <th>등록일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>
                                <a class="link-primary fw-semibold text-decoration-none"
                                   href="ProductController?action=info&id=${product.id}">
                                    ${product.id}
                                </a>
                            </td>
                            <td>${product.name}</td>
                            <td>${product.maker}</td>
                            <td>${product.price}</td>
                            <td>${product.date}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
