# Week 10 Product MVC 학습 정리

학습 날짜: 2026-05-06

## 학습 주제

Java Servlet과 JSP를 이용해 Product MVC 웹 애플리케이션을 구성하고, Bootstrap CSS 라이브러리를 적용해 화면을 꾸몄다.

## 주요 학습 내용

### 1. MVC 구조

- `ProductController`가 요청을 받아 처리한다.
- `ProductService`가 상품 데이터를 관리한다.
- `Product`는 상품 정보를 담는 모델 클래스이다.
- JSP 파일은 컨트롤러에서 전달한 데이터를 화면에 출력한다.

### 2. ProductController 흐름

- `doGet(HttpServletRequest request, HttpServletResponse response)`를 오버라이드해 GET 요청을 처리한다.
- `action` 파라미터 값에 따라 목록 화면과 상세 화면을 구분한다.
- `action=info`이면 상품 상세 정보를 보여준다.
- 그 외의 경우 상품 목록을 보여준다.
- `doPost()`는 `doGet()`을 호출하도록 구성해 GET/POST 요청을 같은 방식으로 처리한다.

### 3. JSP 화면 구성

- `productList.jsp`
  - 상품 목록을 Bootstrap 표 형식으로 출력한다.
  - 상품 ID를 클릭하면 상세 페이지로 이동한다.

- `productInfo.jsp`
  - 상품 상세 정보를 Bootstrap 카드 형식으로 출력한다.
  - 제목 색상, 카드 헤더, 가격 강조 박스 등을 추가해 화면을 꾸몄다.

### 4. Bootstrap 적용

Bootstrap 5 CDN을 JSP의 `<head>`에 추가했다.

```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
```

사용한 주요 Bootstrap 클래스:

- `container`
- `card`
- `btn`
- `table`
- `table-hover`
- `alert`
- `badge`
- `row`
- `col-md-6`

### 5. 빌드와 서버 적용

Maven으로 프로젝트를 컴파일하고 WAR 파일을 생성했다.

```bash
mvn clean package
```

빌드 결과:

- Java 파일 컴파일 성공
- `target/productmvc_10.war` 생성 성공
- XAMPP Tomcat 서버에 배포 확인

확인 주소:

```text
http://localhost:8080/productmvc_10/ProductController?action=list
http://localhost:8080/productmvc_10/ProductController?action=info&id=p101
```

## 오늘 정리

오늘은 Servlet Controller가 요청을 분기하고, Service에서 데이터를 가져와 JSP로 전달하는 MVC 흐름을 학습했다. 또한 Bootstrap을 이용해 목록 화면과 상세 화면을 더 보기 좋게 꾸미고, Maven 빌드 후 Tomcat 서버에서 실제 동작까지 확인했다.
