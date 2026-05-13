# Week 11 학습 정리

날짜: 2026-05-13

## 학습 내용

- WhiteStarUML로 `Student`, `StudentDAO`, `StudentController`, `studentInfo.jsp` 구조의 클래스 다이어그램을 작성했습니다.
- Maven `pom.xml`에 Servlet, JSP, JSTL, MySQL, MariaDB JDBC 의존성을 추가했습니다.
- MariaDB의 `mywebdb2` 데이터베이스와 `student1` 테이블을 Java 웹 프로젝트와 연동했습니다.
- `Student` VO 클래스, `StudentDAO` JDBC 클래스, `StudentController` 서블릿 클래스를 작성했습니다.
- `studentInfo.jsp`에서 학생 목록을 출력하고 학생 등록 폼을 구현했습니다.
- 학생 목록의 비고 컬럼에 수정과 삭제 아이콘을 추가했습니다.
- 수정 아이콘 클릭 시 선택한 학생 정보를 상단 폼에 표시하고 DB 데이터를 업데이트하도록 구현했습니다.
- 삭제 아이콘 클릭 시 선택한 학생 정보를 DB와 목록에서 삭제하도록 구현했습니다.
- Maven 빌드와 Tomcat WAR 배포를 통해 실행 결과를 확인했습니다.

## 주요 파일

- `1. Student_jdbc/student_jdbc_11/src/main/java/kr/hnu/ice/Student.java`
- `1. Student_jdbc/student_jdbc_11/src/main/java/kr/hnu/ice/StudentDAO.java`
- `1. Student_jdbc/student_jdbc_11/src/main/java/kr/hnu/ice/StudentController.java`
- `1. Student_jdbc/student_jdbc_11/src/main/webapp/studentInfo.jsp`
- `1. Student_jdbc/student_jdbc_11/src/main/webapp/WEB-INF/web.xml`
- `1. Student_jdbc/student_jdbc_11/pom.xml`
