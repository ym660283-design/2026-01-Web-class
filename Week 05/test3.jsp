<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%!
    String getGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
%>
<%
    String studentName = "홍길동";
    int score = 88;
    Date now = new Date();
    String grade = getGrade(score);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 기본 문법 예제</title>
    <style>
        body {
            font-family: "Malgun Gothic", sans-serif;
            margin: 40px;
            line-height: 1.7;
        }
        .box {
            max-width: 720px;
            padding: 24px;
            border: 1px solid #cccccc;
            border-radius: 12px;
            background-color: #f9fbff;
        }
        h1 {
            color: #1f4b99;
        }
        ul {
            padding-left: 20px;
        }
        code {
            background-color: #eef3ff;
            padding: 2px 6px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="box">
        <h1>JSP 기본 문법 정리</h1>
        <p>이 페이지는 JSP의 주요 요소를 한 번에 연습할 수 있도록 만든 예제입니다.</p>

        <h2>1. 현재 서버 시간</h2>
        <p><%= now %></p>

        <h2>2. 스크립틀릿(scriptlet)</h2>
        <p><code>&lt;% ... %&gt;</code> 안에서 자바 코드를 작성할 수 있습니다.</p>

        <h2>3. 표현식(expression)</h2>
        <p><code>&lt;%= ... %&gt;</code> 을 사용하면 값을 화면에 출력할 수 있습니다.</p>
        <p>학생 이름: <strong><%= studentName %></strong></p>
        <p>점수: <strong><%= score %></strong></p>
        <p>학점: <strong><%= grade %></strong></p>

        <h2>4. 선언문(declaration)</h2>
        <p><code>&lt;%! ... %&gt;</code> 안에서는 메서드나 멤버 변수를 선언할 수 있습니다.</p>
        <p>이 페이지에서는 <code>getGrade()</code> 메서드를 선언해서 학점을 계산했습니다.</p>

        <h2>5. JSP의 특징</h2>
        <ul>
            <li>HTML 안에 자바 코드를 함께 작성할 수 있습니다.</li>
            <li>서버에서 실행된 결과가 브라우저에 전달됩니다.</li>
            <li>동적인 웹 페이지를 만들 때 사용됩니다.</li>
        </ul>
    </div>
</body>
</html>
