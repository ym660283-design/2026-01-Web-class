<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    String op = request.getParameter("op");

    long result = 0;
    switch (op) {
        case "+": result = n1 + n2; break;
        case "-": result = n1 - n2; break;
        case "*": result = n1 * n2; break;
        case "/": result = n1 / n2; break;
    }
%>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 계산기</title>
</head>
<body>
<h1>계산 결과</h1>
<hr>
결과: <%= result %>
</body>
</html>
