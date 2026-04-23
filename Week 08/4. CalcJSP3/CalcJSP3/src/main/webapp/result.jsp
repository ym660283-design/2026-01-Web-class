<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 계산기</title>
</head>
<body>
<h1>계산 결과(JSP3)</h1>
<p>이 파일은 result.jsp 파일입니다.</p>
<hr>
결과: <%= request.getParameter("result") %>
</body>
</html>
