# Week 09

## Date

2026-04-29

## Learning Summary

- JSP `useBean`을 이용해 계산기 예제를 작성했다.
- `Calculator` JavaBean을 만들고 JSP에서 `jsp:useBean`, `jsp:setProperty`, `jsp:getProperty`를 사용했다.
- JSP 페이지의 UTF-8 인코딩 설정과 한글 깨짐 문제를 확인했다.
- `web.xml`을 Servlet 4.0 형식으로 작성했다.
- Maven `pom.xml`에 JSTL 라이브러리 의존성을 추가했다.
- JSTL Core 태그 라이브러리를 사용해 `c:set`, `c:out`, `c:if`, `c:choose`, `c:when`, `c:otherwise`, `c:forEach`, `c:forTokens` 예제를 작성했다.
- Expression Language `${...}`를 사용해 JSTL 출력 결과와 동일한 값을 출력했다.
- 배열을 JSP에서 생성하고 `pageContext`에 저장한 뒤 `c:forEach`로 출력했다.

## Date

2026-04-30

## Learning Summary

- Calc MVC 프로젝트에서 Maven `pom.xml`에 `commons-beanutils`, `jstl`, `javax.servlet-api` 의존성을 추가했다.
- `index.jsp`에서 `CalcControl`로 `POST` 요청을 보내는 계산기 입력 폼을 작성했다.
- `n1`, `n2`는 실수 입력이 가능하도록 `number` 타입과 `step="any"`를 사용했다.
- `Calculator` POJO를 만들고 `private` 필드, 기본 생성자, getter/setter, `calc()`, `getResult()` 메소드를 작성했다.
- `CalcController` 서블릿을 생성하고 `@WebServlet("/CalcControl")`로 호출 패턴을 지정했다.
- `BeanUtils.populate()`를 사용해 요청 파라미터를 `Calculator` 객체에 자동으로 저장했다.
- 계산 결과를 `request`에 저장한 뒤 `calcResult.jsp`로 forwarding했다.
- JSP expression 대신 EL `${calculator.result}`를 사용해 계산 결과를 출력했다.
- Product MVC 프로젝트에서 `Product` POJO를 생성하고 `id`, `name`, `maker`, `price`, `data` 필드를 작성했다.
- `ProductService`를 생성하고 `HashMap<String, Product>`에 휴대폰 상품 5개를 저장했다.
- `findAll()`로 전체 상품 목록을 반환하고 `find(String id)`로 특정 상품을 조회하도록 작성했다.
