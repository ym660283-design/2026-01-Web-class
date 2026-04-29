<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>&#44228;&#49328;&#44592;</title>
</head>
<body>
    <h2>&#44036;&#45800; &#44228;&#49328;&#44592;</h2>
    <form action="calc.jsp" method="post">
        <p>
            <label>&#49707;&#51088; 1: <input type="number" name="n1" required></label>
        </p>
        <p>
            <label>&#50672;&#49328;&#51088;:
                <select name="op" required>
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
            </label>
        </p>
        <p>
            <label>&#49707;&#51088; 2: <input type="number" name="n2" required></label>
        </p>
        <p>
            <button type="submit">&#44228;&#49328;</button>
        </p>
    </form>
</body>
</html>
