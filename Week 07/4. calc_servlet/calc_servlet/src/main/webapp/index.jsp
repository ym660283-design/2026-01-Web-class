<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계산기 - Calc Servlet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-weight: bold;
            color: #555;
        }
        input, select {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        button:hover {
            background-color: #45a049;
        }
        .info {
            background-color: #e8f4f8;
            padding: 15px;
            border-left: 4px solid #2196F3;
            margin-top: 20px;
            border-radius: 4px;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>계산기</h1>
        <form action="calc" method="get">
            <div>
                <label for="num1">첫 번째 수:</label>
                <input type="number" id="num1" name="num1" required>
            </div>
            <div>
                <label for="op">연산자:</label>
                <select id="op" name="op" required>
                    <option value="">선택하세요</option>
                    <option value="+">더하기 (+)</option>
                    <option value="-">빼기 (-)</option>
                    <option value="*">곱하기 (*)</option>
                    <option value="/">나누기 (/)</option>
                </select>
            </div>
            <div>
                <label for="num2">두 번째 수:</label>
                <input type="number" id="num2" name="num2" required>
            </div>
            <button type="submit">계산하기</button>
        </form>
        <div class="info">
            <strong>사용 방법:</strong><br>
            - 두 개의 수를 입력하고 연산자를 선택한 후 '계산하기' 버튼을 클릭하세요.
        </div>
    </div>
</body>
</html>
