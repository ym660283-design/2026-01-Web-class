# Week 10

---

## Date

2026-05-06

## Learning Summary

- Java Servlet과 JSP를 이용해 Product MVC 웹 애플리케이션을 구성했다.
- `ProductController`, `ProductService`, `Product` 클래스로 MVC 구조를 나누어 작성했다.
- `ProductController`에서 `action` 파라미터 값에 따라 상품 목록 화면과 상세 화면을 분기했다.
- `doGet()`에서 요청을 처리하고 `doPost()`는 `doGet()`을 호출하도록 구성해 GET/POST 요청을 같은 방식으로 처리했다.
- `ProductService`에서 상품 데이터를 관리하고, `findAll()`과 `find(String id)` 메소드로 전체 목록과 개별 상품을 조회했다.
- JSP 파일에서는 컨트롤러에서 전달받은 데이터를 화면에 출력했다.
- `productList.jsp`에서 상품 목록을 표 형식으로 출력하고, 상품 ID를 클릭하면 상세 페이지로 이동하도록 작성했다.
- `productInfo.jsp`에서 상품 상세 정보를 카드 형식으로 출력했다.
- Bootstrap 5 CDN을 JSP에 적용해 목록 화면과 상세 화면을 꾸몄다.
- Maven으로 프로젝트를 빌드해 `target/productmvc_10.war` 파일을 생성하고, XAMPP Tomcat 서버에서 동작을 확인했다.

## Product MVC Summary

Product MVC 실습에서는 Servlet Controller가 요청을 받고, Service가 데이터를 처리하며, JSP가 결과를 출력하는 MVC 흐름을 학습했다. `ProductController`는 `action=list`, `action=info`와 같은 요청 파라미터를 기준으로 화면을 분기하고, 필요한 데이터를 `request`에 저장한 뒤 JSP로 forwarding한다.

`ProductService`는 상품 데이터를 저장하고 조회하는 역할을 맡는다. 전체 상품 목록은 `findAll()`로 가져오고, 특정 상품은 `find(String id)`로 조회한다. JSP에서는 EL과 JSTL을 활용해 컨트롤러에서 전달받은 상품 정보를 화면에 출력했다.

Bootstrap을 적용해 기본 JSP 화면을 더 보기 좋게 구성했다. 상품 목록은 표 형태로, 상품 상세 정보는 카드 형태로 구성했으며 버튼, 배지, 알림, 레이아웃 관련 클래스를 사용했다.

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

빌드와 실행 확인:

```bash
mvn clean package
```

확인 주소:

```text
http://localhost:8080/productmvc_10/ProductController?action=list
http://localhost:8080/productmvc_10/ProductController?action=info&id=p101
```

---

## Date

2026-05-07

## Learning Summary

- 로컬에서 실행 중인 XAMPP MySQL 서버에 접속해 데이터베이스 목록을 조회했다.
- `SHOW DATABASES`, `SHOW TABLES`, `DESCRIBE` 명령을 사용해 데이터베이스, 테이블, 컬럼 구조를 확인했다.
- `mywebdb2` 데이터베이스에 `student1` 테이블을 생성했다.
- `student1` 테이블은 `id`, `name`, `univ`, `birthdate`, `email` 컬럼으로 구성했다.
- `id` 컬럼은 `INT AUTO_INCREMENT PRIMARY KEY`로 설정해 각 레코드를 구분하도록 했다.
- `INSERT INTO` 문을 사용해 학생 샘플 데이터를 추가했다.
- `ALTER TABLE ... MODIFY COLUMN ... AFTER ...` 문을 사용해 컬럼 위치를 변경했다.
- `ALTER TABLE ... CHANGE COLUMN ...` 문을 사용해 잘못 작성된 컬럼명 `brithdate`를 `birthdate`로 수정했다.
- `UPDATE` 문과 `CASE` 문을 사용해 각 레코드의 생년월일을 2000년부터 2010년 사이 날짜로 설정했다.
- `SELECT ... ORDER BY id` 문을 사용해 입력된 학생 레코드를 순서대로 조회했다.

## SQL Practice Summary

MySQL 실습에서는 데이터베이스와 테이블을 직접 관리하는 기본 흐름을 학습했다. 먼저 로컬 MySQL 서버에 접속해 데이터베이스를 확인하고, `mywebdb2` 안에 학생 정보를 저장할 `student1` 테이블을 만들었다. 이후 학생 이름, 대학교, 생년월일, 이메일 정보를 가진 샘플 데이터를 추가하고 조회했다.

테이블을 만든 뒤에도 컬럼 위치를 바꾸거나 컬럼명을 수정할 수 있다는 점을 확인했다. 특히 `birthdate` 컬럼을 `email` 앞쪽으로 배치하고, 오타가 있었던 컬럼명을 올바르게 변경하면서 `ALTER TABLE`의 사용법을 연습했다.

`student1` 테이블 구조:

```text
id         INT AUTO_INCREMENT PRIMARY KEY
name       VARCHAR(10)
univ       VARCHAR(40)
birthdate  DATE
email      VARCHAR(20)
```

조회한 주요 데이터:

```text
id  name    univ        birthdate   email
1   김민준  한남대학교  2001-03-14  kmj@m365.hnu.ac.kr
2   이서준  한남대학교  2003-07-22  lsj@m365.hnu.ac.kr
3   박도윤  한남대학교  2005-11-09  pdy@m365.hnu.ac.kr
4   정예준  한남대학교  2008-02-17  jyj@m365.hnu.ac.kr
5   최시우  한남대학교  2010-06-30  csw@m365.hnu.ac.kr
6   강하준  충남대학교  2000-09-12  khj@cnu.ac.kr
7   조지호  공주대학교  2002-04-05  cjh@kongju.ac.kr
8   윤주원  배재대학교  2004-12-21  yjw@pcu.ac.kr
9   장도현  목원대학교  2007-08-16  jdh@mokwon.ac.kr
10  임준우  대전대학교  2009-01-28  ljw@dju.ac.kr
```
