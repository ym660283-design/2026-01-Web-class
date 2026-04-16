# calc_servlet 404 에러 해결 가이드

## 문제 진단

### 1. WAR 파일 배포 상태 확인
- WAR 파일 위치: `target/calc_servlet.war`
- 빌드 상태: ✅ 성공 (2026-04-16 17:24)
- WAR 포함 파일:
  - ✅ CalcServlet.class (서블릿 구현)
  - ✅ index.jsp (리다이렉트)
  - ✅ WEB-INF/web.xml (설정)

### 2. 서블릿 매핑 확인
```java
@WebServlet("/calc")
public class CalcServlet extends HttpServlet { ... }
```

### 3. 인덱스 페이지 설정
```jsp
<%
    response.sendRedirect(request.getContextPath() + "/calc");
%>
```

## 올바른 접근 경로

| 상황 | URL |
|------|-----|
| 기본 접근 | `http://localhost:8080/calc_servlet/` |
| 서블릿 직접 접근 | `http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+` |

## 404 에러 원인별 해결 방법

### 원인 1: WAR 파일이 톰캣에 배포되지 않음
**해결 방법:**
1. WAR 파일 복사:
   ```
   src: c:\Users\ym660\2026-01-Web-class\Week 07\4. calc_servlet\calc_servlet\target\calc_servlet.war
   dst: <TOMCAT_HOME>\webapps\calc_servlet.war
   ```
2. 톰캣 재시작 (또는 Manager 앱으로 배포)

### 원인 2: 잘못된 URL 사용
**확인 사항:**
- ❌ http://localhost:8080/calc (앱 이름 누락)
- ❌ http://localhost:8080/CalcServlet (클래스명 사용 - 잘못됨)
- ❌ http://localhost:8080/servlet/CalcServlet (서블릿 경로 방식 - 설정되지 않음)
- ✅ http://localhost:8080/calc_servlet/ (올바른 URL)
- ✅ http://localhost:8080/calc_servlet/calc (직접 서블릿 호출)

### 원인 3: 톰캣의 Java 버전 호환성
**확인:**
- 톰캣이 Java 25 호환성 지원 필요
- Tomcat 10.1+ 권장 (Jakarta EE 지원)

## 테스트 URL 예시

```
# GET 요청으로 테스트
http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+

# 파라미터 설명
- num1: 첫 번째 수 (정수)
- num2: 두 번째 수 (정수)
- op: 연산자 (+, -, *, /)

# 예상 응답
계산 결과: 10 + 5 = 15
```

## 톰캣 로그 확인
톰캣 로그에서 배포 상태 확인:
```
<TOMCAT_HOME>\logs\catalina.out
<TOMCAT_HOME>\logs\localhost.*.log
```

## 다음 단계
1. 위의 URL로 접근해보기
2. 톰캣 로그 확인
3. 여전히 404가 나면 로그 메시지 공유해주기