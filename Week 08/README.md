# Week 08 학습 정리

## 1. CalcJSP

기본 JSP 계산기 프로젝트를 만들었다.

위치:

```text
Week 08/2. CalcJSP/CalcJSP
```

주요 파일:

```text
src/main/webapp/index.html
src/main/webapp/calc.jsp
src/main/webapp/WEB-INF/web.xml
```

동작 흐름:

1. `index.html`에서 숫자 2개와 연산자 1개를 입력한다.
2. 실행 버튼을 누르면 `calc.jsp`가 호출된다.
3. `calc.jsp`에서 계산을 수행한다.
4. `calc.jsp` 안에서 바로 HTML 결과 화면을 출력한다.

입력 폼:

```html
<form method="post" action="calc.jsp">
    <input type="text" name="n1" size="10">
    <select name="op">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
    <input type="text" name="n2" size="10">
    <input type="submit" value="실행">
</form>
```

접속 주소:

```text
http://localhost:8080/CalcJSP/
```

## 2. CalcJSP2

`CalcJSP`를 복사해서 만든 두 번째 JSP 계산기 프로젝트다.

위치:

```text
Week 08/3. CalcJSP2/CalcJSP2
```

주요 파일:

```text
src/main/webapp/index.html
src/main/webapp/calc.jsp
src/main/webapp/result.jsp
src/main/webapp/WEB-INF/web.xml
```

동작 흐름:

1. `index.html`에서 숫자 2개와 연산자를 입력한다.
2. `calc.jsp`가 값을 받아 계산한다.
3. 계산 결과를 `request.setAttribute()`로 저장한다.
4. `RequestDispatcher`로 `result.jsp`에 전달한다.
5. `result.jsp`에서 결과를 출력한다.

`calc.jsp`의 핵심:

```jsp
request.setAttribute("result", result);
request.getRequestDispatcher("result.jsp").forward(request, response);
```

`result.jsp`의 핵심:

```jsp
결과: <%= request.getAttribute("result") %>
```

화면에는 다음 문구가 출력된다.

```html
<h1>계산 결과(JSP2)</h1>
<p>이 파일은 result.jsp 파일입니다.</p>
```

## 3. CalcJSP3

`CalcJSP2`를 복사해서 만든 세 번째 JSP 계산기 프로젝트다.

위치:

```text
Week 08/4. CalcJSP3/CalcJSP3
```

주요 파일:

```text
src/main/webapp/index.html
src/main/webapp/calc.jsp
src/main/webapp/result.jsp
src/main/webapp/WEB-INF/web.xml
```

동작 흐름:

1. `index.html`에서 숫자 2개와 연산자를 입력한다.
2. `calc.jsp`가 값을 받아 계산한다.
3. `<jsp:forward>`로 `result.jsp`에 이동한다.
4. `<jsp:param>`으로 계산 결과를 전달한다.
5. `result.jsp`에서 `request.getParameter()`로 결과를 받아 출력한다.

`calc.jsp`의 핵심:

```jsp
<jsp:forward page="result.jsp">
    <jsp:param name="result" value="<%= result %>" />
</jsp:forward>
```

`result.jsp`의 핵심:

```jsp
결과: <%= request.getParameter("result") %>
```

화면에는 다음 문구가 출력된다.

```html
<h1>계산 결과(JSP3)</h1>
<p>이 파일은 result.jsp 파일입니다.</p>
```

## 4. JSP 결과 전달 방식 비교

`CalcJSP2`는 request attribute 방식이다.

```jsp
request.setAttribute("result", result);
request.getAttribute("result");
```

`CalcJSP3`는 JSP 액션 태그와 parameter 방식이다.

```jsp
<jsp:param name="result" value="<%= result %>" />
request.getParameter("result");
```

차이점:

```text
setAttribute/getAttribute: 서버 내부에서 객체 값을 request에 담아 전달
jsp:param/getParameter: 문자열 parameter 형태로 값을 전달
```

## 5. Maven 패키징

각 프로젝트는 Maven Web Application 프로젝트다.

패키징 명령:

```powershell
mvn package
```

빌드 결과:

```text
CalcJSP/target/calc_jsp.war
CalcJSP2/target/CalcJSP2.war
CalcJSP3/target/CalcJSP3.war
```

## 6. 컴파일을 다시 해야 하는 경우

JSP 파일만 수정했을 때는 Java 클래스처럼 직접 컴파일할 필요는 없다.

Tomcat은 JSP가 처음 요청되거나 수정된 뒤 다시 요청될 때 JSP를 자동으로 servlet 코드로 변환하고 컴파일한다.

하지만 다음 경우에는 다시 빌드하거나 서버에 다시 배포해야 한다.

```text
WAR 파일을 새로 만들어서 배포해야 할 때
pom.xml을 수정했을 때
프로젝트 이름이나 finalName을 바꿨을 때
Tomcat webapps 폴더에 수정 내용이 반영되지 않았을 때
```

수정 내용이 서버에 바로 보이지 않으면 다음을 확인한다.

```text
1. 저장했는지 확인
2. Tomcat webapps 폴더에 파일이 복사되었는지 확인
3. 브라우저 새로고침
4. 그래도 안 되면 Tomcat 재시작
5. Maven 프로젝트 변경이 있으면 mvn package 다시 실행
```

## 7. 오늘 만든 프로젝트 구조

```text
Week 08
├── 2. CalcJSP
│   └── CalcJSP
├── 3. CalcJSP2
│   └── CalcJSP2
└── 4. CalcJSP3
    └── CalcJSP3
```
