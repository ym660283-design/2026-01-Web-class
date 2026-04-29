<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>&#44228;&#49328; &#44208;&#44284;</title>
</head>
<body>
    <h2>&#44228;&#49328; &#44208;&#44284;</h2>

    <jsp:useBean id="calc" class="bean_exam.Calculator" />

    <jsp:setProperty name="calc" property="n1" param="n1" />
    <jsp:setProperty name="calc" property="n2" param="n2" />
    <jsp:setProperty name="calc" property="op" param="op" />

    <p>
        <jsp:getProperty name="calc" property="n1" />
        <jsp:getProperty name="calc" property="op" />
        <jsp:getProperty name="calc" property="n2" />
        = <%= calc.calc() %>
    </p>

    <p><a href="index.jsp">&#45796;&#49884; &#44228;&#49328;&#54616;&#44592;</a></p>
</body>
</html>
