<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품 상세 정보</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .page-title {
            color: #0d6efd;
            font-weight: 700;
        }

        .detail-card {
            max-width: 640px;
            border: 0;
            border-radius: 14px;
            overflow: hidden;
        }

        .detail-header {
            background: linear-gradient(135deg, #0d6efd, #20c997);
            color: #ffffff;
            padding: 28px;
        }

        .detail-header .badge {
            font-size: 0.9rem;
        }

        .info-label {
            color: #6c757d;
            font-size: 0.9rem;
        }

        .price-text {
            color: #dc3545;
            font-size: 1.35rem;
            font-weight: 700;
        }
    </style>
</head>
<body class="bg-light">
<main class="container py-5">
    <div class="d-flex align-items-center justify-content-between mb-4">
        <h2 class="page-title mb-0">상품 상세 정보</h2>
        <a class="btn btn-outline-secondary" href="ProductController?action=list">목록</a>
    </div>

    <c:choose>
        <c:when test="${empty product}">
            <div class="alert alert-warning" role="alert">
                선택한 상품을 찾을 수 없습니다.
            </div>
        </c:when>
        <c:otherwise>
            <div class="card detail-card shadow mx-auto">
                <div class="detail-header">
                    <span class="badge text-bg-light mb-3">상품 ID: ${product.id}</span>
                    <h3 class="card-title mb-0">${product.name}</h3>
                    <p class="mb-0 mt-2 opacity-75">상품의 상세 정보를 확인합니다.</p>
                </div>
                <div class="card-body p-4">
                    <div class="row g-3">
                        <div class="col-md-6">
                            <div class="border rounded-3 p-3 h-100 bg-light">
                                <div class="info-label">제조사</div>
                                <div class="fs-5 fw-semibold">${product.maker}</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="border rounded-3 p-3 h-100 bg-light">
                                <div class="info-label">등록일</div>
                                <div class="fs-5 fw-semibold">${product.date}</div>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="border border-danger-subtle rounded-3 p-3 bg-danger-subtle">
                                <div class="info-label">가격</div>
                                <div class="price-text">${product.price}</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer text-end bg-white">
                    <a class="btn btn-primary px-4" href="ProductController?action=list">상품 목록으로 돌아가기</a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
