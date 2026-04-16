# Week 07 - 서블릿 고급 기능 및 Java 업그레이드

## 학습 목표
- 서블릿을 이용한 웹 애플리케이션 개발
- Maven을 사용한 프로젝트 빌드 및 배포
- Java 런타임 업그레이드 및 의존성 관리
- 보안 취약점 스캔 및 수정

## 프로젝트 구조

### 1. helloworld2_servlet (기본 서블릿)
- 간단한 HelloWorld 서블릿 예제
- Servlet API 기본 사용법

### 2. calc_servlet (계산기 서블릿)
- 사칙연산 기능 구현
- 파라미터 검증 및 에러 처리
- 사용자 인터페이스 포함

---

## calc_servlet 업그레이드 기록

### 2026-04-16: Java 7 → Java 25 LTS 업그레이드

#### 1. 초기 문제
```
컴파일 에러: Source option 7 is no longer supported. Use 8 or later.
원인: pom.xml의 compiler source/target이 1.7로 설정됨
```

#### 2. 수행한 변경 사항

**pom.xml 수정:**
- `maven.compiler.source`: 1.7 → 25
- `maven.compiler.target`: 1.7 → 25
- `maven-compiler-plugin`: 3.8.0 → 3.13.0 (Java 25 호환성)
- Servlet API: `javax.servlet-api 4.0.1` → `jakarta.servlet-api 6.0.0` (Jakarta EE)

**CalcServlet.java 수정:**
- Import 변경: `javax.servlet.*` → `jakarta.servlet.*`
- 초기화되지 않은 변수 `resultText` 초기화 수정

**index.jsp 개선:**
- 정적 리다이렉트 → 동적 HTML 계산기 UI로 변경
- 사용자 친화적 웹 인터페이스 구현
- 폼 기반 서블릿 호출 방식 적용

#### 3. 최종 결과
- ✅ Java 25로 성공적인 컴파일
- ✅ WAR 파일 생성 (calc_servlet.war)
- ✅ CVE 취약점 없음 (의존성: junit:4.11, jakarta.servlet-api:6.0.0)

---

## CVE 보안 검사

### 스캔 대상 의존성
| 의존성 | 버전 | CVE 결과 |
|--------|------|---------|
| junit | 4.11 | ✅ 안전 |
| jakarta.servlet-api | 6.0.0 | ✅ 안전 |

### 스캔 결과
- **총 의존성**: 2개
- **취약점 발견**: 0개
- **권장 조치**: 없음 (최신 버전 사용 중)

---

## 톰캣 배포 가이드

### 배포 방법
```
1. WAR 파일: target/calc_servlet.war
2. 톰캣 webapps 폴더에 복사
3. 톰캣 재시작
```

### 접근 URL

| 기능 | URL |
|------|-----|
| 계산기 UI | `http://localhost:8080/calc_servlet/` |
| 직접 호출 | `http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+` |

### 파라미터
- `num1`: 첫 번째 정수
- `num2`: 두 번째 정수  
- `op`: 연산자 (+, -, *, /)

### 예시 요청
```
덧셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=+
뺄셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=-
곱셈:   http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=*
나눗셈: http://localhost:8080/calc_servlet/calc?num1=10&num2=5&op=/
```

---

## 주요 기술 스택

| 항목 | 버전 |
|------|------|
| Java | 25 LTS |
| Maven | 3.9+ |
| Jakarta Servlet | 6.0.0 |
| Tomcat (권장) | 10.1+ |

---

## 학습 포인트

### Java 버전 업그레이드
- Java 7 (EOL)에서 Java 25 (최신 LTS)로 업그레이드
- 호환성 문제 해결 (javax → jakarta 마이그레이션)
- 빌드 도구 버전 업데이트 (maven-compiler-plugin)

### 보안 관리
- CVE 취약점 스캔 및 검증
- 의존성 버전 관리
- 보안 업데이트 자동화

### 웹 애플리케이션 개발
- 서블릿 기반 요청 처리
- 파라미터 검증 및 에러 처리
- HTML 폼과 GET/POST 요청 처리
- WAR 파일 빌드 및 배포

---

## 참고 문서

- `calc_servlet/DEPLOY_GUIDE.md`: 상세한 배포 및 사용 가이드
- `calc_servlet/TROUBLESHOOTING.md`: 404 에러 및 문제 해결 가이드