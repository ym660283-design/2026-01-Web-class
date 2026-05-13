<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Info</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 32px;
      color: #222;
    }

    h1 {
      margin-bottom: 20px;
      font-size: 28px;
    }

    form {
      display: grid;
      grid-template-columns: repeat(5, minmax(120px, 1fr)) auto;
      gap: 8px;
      margin-bottom: 24px;
      align-items: end;
    }

    label {
      display: block;
      margin-bottom: 4px;
      font-size: 13px;
      font-weight: bold;
    }

    input {
      width: 100%;
      box-sizing: border-box;
      padding: 8px;
      border: 1px solid #bbb;
    }

    button {
      padding: 9px 16px;
      border: 1px solid #555;
      background: #333;
      color: white;
      cursor: pointer;
    }

    .actions {
      display: flex;
      gap: 8px;
      align-items: center;
    }

    .icon-button {
      display: inline-flex;
      align-items: center;
      justify-content: center;
      width: 34px;
      height: 34px;
      padding: 0;
      border: 1px solid #aaa;
      background: white;
      color: #222;
    }

    .icon-button.delete {
      color: #b00020;
    }

    .icon-button svg {
      width: 18px;
      height: 18px;
      stroke: currentColor;
      stroke-width: 2;
      fill: none;
      stroke-linecap: round;
      stroke-linejoin: round;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th,
    td {
      padding: 10px;
      border: 1px solid #ccc;
      text-align: left;
    }

    th {
      background: #f1f1f1;
    }

    .error {
      margin-bottom: 16px;
      padding: 10px 12px;
      border: 1px solid #d33;
      background: #fff0f0;
      color: #9b1111;
    }
  </style>
</head>
<body>
  <h1>Student Info</h1>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>

  <form action="student" method="post">
    <input type="hidden" name="action" value="${empty editStudent ? 'insert' : 'update'}">
    <div>
      <label for="id">ID</label>
      <input type="number" id="id" name="id" value="${editStudent.id}" ${empty editStudent ? '' : 'readonly'} required>
    </div>
    <div>
      <label for="name">Name</label>
      <input type="text" id="name" name="name" value="${editStudent.name}" required>
    </div>
    <div>
      <label for="univ">University</label>
      <input type="text" id="univ" name="univ" value="${editStudent.univ}" required>
    </div>
    <div>
      <label for="birthdate">Birthdate</label>
      <input type="text" id="birthdate" name="birthdate" value="${editStudent.birthdate}" placeholder="YYYY-MM-DD" required>
    </div>
    <div>
      <label for="email">Email</label>
      <input type="email" id="email" name="email" value="${editStudent.email}" required>
    </div>
    <button type="submit">${empty editStudent ? 'Add' : 'Update'}</button>
  </form>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>University</th>
        <th>Birthdate</th>
        <th>Email</th>
        <th>비고</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="student" items="${students}">
        <tr>
          <td>${student.id}</td>
          <td>${student.name}</td>
          <td>${student.univ}</td>
          <td>${student.birthdate}</td>
          <td>${student.email}</td>
          <td>
            <div class="actions">
              <form action="student" method="get">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="${student.id}">
                <button class="icon-button" type="submit" title="Update">
                  <svg viewBox="0 0 24 24" aria-hidden="true">
                    <path d="M12 20h9"></path>
                    <path d="M16.5 3.5a2.1 2.1 0 0 1 3 3L7 19l-4 1 1-4 12.5-12.5z"></path>
                  </svg>
                </button>
              </form>
              <form action="student" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="${student.id}">
                <button class="icon-button delete" type="submit" title="Delete">
                  <svg viewBox="0 0 24 24" aria-hidden="true">
                    <path d="M3 6h18"></path>
                    <path d="M8 6V4h8v2"></path>
                    <path d="M19 6l-1 14H6L5 6"></path>
                    <path d="M10 11v6"></path>
                    <path d="M14 11v6"></path>
                  </svg>
                </button>
              </form>
            </div>
          </td>
        </tr>
      </c:forEach>
      <c:if test="${empty students}">
        <tr>
          <td colspan="6">No students found.</td>
        </tr>
      </c:if>
    </tbody>
  </table>
</body>
</html>
