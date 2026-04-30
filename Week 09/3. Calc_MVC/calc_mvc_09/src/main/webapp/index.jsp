<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Calc MVC</title>
</head>
<body>
  <h2>계산기</h2>

  <form action="CalcControl" method="post">
    <p>
      <label for="n1">첫 번째 숫자</label>
      <input type="number" id="n1" name="n1" step="any" required>
    </p>

    <p>
      <label for="op">연산자</label>
      <select id="op" name="op" required>
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
      </select>
    </p>

    <p>
      <label for="n2">두 번째 숫자</label>
      <input type="number" id="n2" name="n2" step="any" required>
    </p>

    <button type="submit">계산</button>
  </form>
</body>
</html>
