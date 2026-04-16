# calc_servlet - 톰캣 배포 및 사용 가이드

## 프로젝트 정보
- **프로젝트명**: calc_servlet
- **타입**: Maven WAR (서블릿 기반 웹 애플리케이션)
- **Java 버전**: Java 25 LTS
- **Servlet API**: Jakarta Servlet 6.0.0
- **서블릿 경로**: `/calc`

## 빌드

### 요구사항
- Java 25 이상
- Maven 3.9 이상

### 빌드 방법
```bash
cd c:\Users\ym660\2026-01-Web-class\Week 07\4. calc_servlet\calc_servlet
mvn clean package
```

빌드 결과: `target/calc_servlet.war`

## 톰캣 배포

### 1. 수동 배포
```
1. WAR 파일을 복사합니다:
   src: target/calc_servlet.war
   dst: <TOMCAT_HOME>/webapps/calc_servlet.war

2. 톰캣을 시작/재시작합니다:
   Windows: %CATALINA_HOME%\bin\startup.bat
   Linux:   $CATALINA_HOME/bin/startup.sh
```

### 2. 톰캣 Manager 앱을 통한 배포
```
1. http://localhost:8080/manager/html 접속
2. Username/Password 입력
3. "WAR file to deploy" 섹션에서 WAR 파일 선택
4. Deploy 버튼 클릭
```

## 사용 방법

### 접근 URL
- **메인 페이지 (계산기 UI)**: `http://localhost:8080/calc_servlet/`
- **직접 계산 요청**: `http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+`

### 메인 페이지 - 웹 UI
```
URL: http://localhost:8080/calc_servlet/
설명: 사용자 친화적인 계산기 인터페이스
- 첫 번째 수 입력
- 연산자 선택 (+, -, *, /)
- 두 번째 수 입력
- 계산하기 버튼 클릭
```

### 직접 서블릿 호출 (GET 요청)
```
URL 형식: /calc_servlet/calc?num1=<값>&num2=<값>&op=<연산자>

파라미터:
- num1 (필수): 정수 (첫 번째 수)
- num2 (필수): 정수 (두 번째 수)
- op (필수): 연산자 (+, -, *, /)

예시:
- 덧셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+
- 뺄셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=-
- 곱셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=*
- 나눗셈: http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=/

응답 형식: HTML
```

### POST 요청
```
서블릿이 POST 메서드도 지원합니다.

필드명: num1, num2, op
메서드: doPost()
```

## 주요 기능

### 1. 사칙연산
- ✅ 덧셈 (+)
- ✅ 뺄셈 (-)
- ✅ 곱셈 (*)
- ✅ 나눗셈 (/)

### 2. 유효성 검사
- ✅ 파라미터 필수 입력 확인
- ✅ 숫자 형식 검증
- ✅ 0으로 나누기 예외 처리
- ✅ 지원되지 않는 연산자 검증

### 3. 에러 처리
- `파라미터 누락`: "num1, num2, op 파라미터를 모두 입력하세요."
- `숫자 형식 오류`: "num1과 num2는 정수여야 합니다."
- `0으로 나누기`: "0으로 나눌 수 없습니다."
- `잘못된 연산자`: "지원하지 않는 연산자입니다: <값>"

## 소스 코드 구조
```
calc_servlet/
├── src/
│   └── main/
│       ├── java/
│       │   └── CalcServlet.java       # 메인 서블릿 클래스
│       └── webapp/
│           ├── index.jsp             # 계산기 UI
│           └── WEB-INF/
│               └── web.xml           # 웹 애플리케이션 설정
├── pom.xml                           # Maven 설정
├── target/
│   └── calc_servlet.war              # 배포 가능한 WAR 파일
└── TROUBLESHOOTING.md                # 문제 해결 가이드
```

## 기술 스택

| 항목 | 버전 |
|------|------|
| Java | 25 LTS |
| Maven | 3.9+ |
| Jakarta Servlet | 6.0.0 |
| JUnit | 4.11 |
| Tomcat (권장) | 10.1+ |

## 문제 해결

### 404 에러 발생
- **원인**: WAR 파일이 톰캣에 배포되지 않음
- **해결**: 위의 "톰캣 배포" 섹션 참조

### 톰캣 호환성 문제
- **확인**: Tomcat 10.1 이상 필요 (Jakarta EE 지원)
- **로그**: `<TOMCAT_HOME>/logs/catalina.out` 확인

### 파라미터 에러
- **확인**: URL의 파라미터가 올바르게 전달되었는지 확인
- **예시**: `?num1=10&num2=5&op=+` 형식 정확히 입력

더 자세한 정보는 `TROUBLESHOOTING.md` 참조합니다.