<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 32px;
        }

        section {
            border-top: 1px solid #ddd;
            margin-top: 24px;
            padding-top: 16px;
        }

        table {
            border-collapse: collapse;
            margin-top: 8px;
            width: 560px;
        }

        th,
        td {
            border: 1px solid #ccc;
            padding: 8px 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>JSTL Example</h2>

    <c:set var="name" value="Hong Gil Dong" />
    <c:set var="score" value="85" />
    <c:set var="grade" value="B" />
    <c:set var="numbers" value="10,20,30,40,50" />
    <c:set var="subjects" value="HTML/CSS/JSP/Servlet/JSTL" />
    <%
        Integer[] numberArray = {1, 2, 3};
        String[] fruits = {"Apple", "Banana", "Orange", "Grape"};
        pageContext.setAttribute("numberArray", numberArray);
        pageContext.setAttribute("fruits", fruits);
    %>

    <section>
        <h3>1. JSTL &#48320;&#49688; &#49444;&#51221; &#48143; &#52636;&#47141;</h3>
        <p>&#51060;&#47492;: <c:out value="${name}" /></p>
        <p>&#51216;&#49688;: <c:out value="${score}" /></p>
        <p>&#46321;&#44553;: <c:out value="${grade}" /></p>
    </section>

    <section>
        <h3>2. c:if</h3>
        <c:if test="${score >= 60}">
            <p><c:out value="${name}" />&#45784;&#51008; &#54633;&#44201;&#51077;&#45768;&#45796;.</p>
        </c:if>
        <c:if test="${score < 60}">
            <p><c:out value="${name}" />&#45784;&#51008; &#48520;&#54633;&#44201;&#51077;&#45768;&#45796;.</p>
        </c:if>
    </section>

    <section>
        <h3>3. c:choose, c:when, c:otherwise</h3>
        <c:choose>
            <c:when test="${score >= 90}">
                <p>&#54217;&#44032;: A</p>
            </c:when>
            <c:when test="${score >= 80}">
                <p>&#54217;&#44032;: B</p>
            </c:when>
            <c:when test="${score >= 70}">
                <p>&#54217;&#44032;: C</p>
            </c:when>
            <c:otherwise>
                <p>&#54217;&#44032;: D</p>
            </c:otherwise>
        </c:choose>
    </section>

    <section>
        <h3>4. c:forEach</h3>
        <table>
            <tr>
                <th>&#49692;&#49436;</th>
                <th>&#44050;</th>
            </tr>
            <c:forEach var="num" items="${numbers}" varStatus="status">
                <tr>
                    <td><c:out value="${status.count}" /></td>
                    <td><c:out value="${num}" /></td>
                </tr>
            </c:forEach>
        </table>

        <h4>&#51221;&#49688; &#48176;&#50676; &#52636;&#47141;</h4>
        <ul>
            <c:forEach var="number" items="${numberArray}" varStatus="status">
                <li>
                    ${status.count}. <c:out value="${number}" />
                </li>
            </c:forEach>
        </ul>

        <h4>&#47928;&#51088;&#50676; &#48176;&#50676; &#52636;&#47141;</h4>
        <ul>
            <c:forEach var="fruit" items="${fruits}" varStatus="status">
                <li>
                    ${status.count}. <c:out value="${fruit}" />
                </li>
            </c:forEach>
        </ul>
    </section>

    <section>
        <h3>5. c:forTokens</h3>
        <ul>
            <c:forTokens var="subject" items="${subjects}" delims="/">
                <li><c:out value="${subject}" /></li>
            </c:forTokens>
        </ul>
    </section>

    <section>
        <h3>6. Expression Language &#52636;&#47141;</h3>
        <p>&#51060;&#47492;: ${name}</p>
        <p>&#51216;&#49688;: ${score}</p>
        <p>&#46321;&#44553;: ${grade}</p>
        <p>&#54633;&#44201; &#50668;&#48512;: ${score >= 60 ? "pass" : "fail"}</p>
        <p>&#54217;&#44032;: ${score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : "D"}</p>

        <table>
            <tr>
                <th>&#44396;&#48516;</th>
                <th>EL &#52636;&#47141;</th>
            </tr>
            <tr>
                <td>name</td>
                <td>${name}</td>
            </tr>
            <tr>
                <td>score</td>
                <td>${score}</td>
            </tr>
            <tr>
                <td>grade</td>
                <td>${grade}</td>
            </tr>
        </table>
    </section>
</body>
</html>
