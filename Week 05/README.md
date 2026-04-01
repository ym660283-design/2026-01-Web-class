# Week 05 학습 정리

## 오늘 날짜

- 2026-04-01

## 오늘 학습한 JSP 파일 요약

### `test.jsp`

- JSP 페이지의 기본 구조를 작성했다.
- `page` 지시자를 사용해 언어와 인코딩을 설정했다.
- HTML 안에서 JSP 파일이 어떻게 구성되는지 확인했다.

### `test2.jsp`

- `test.jsp`와 비슷한 형식으로 기본 구조를 한 번 더 연습했다.
- JSP 문서의 틀인 `html`, `head`, `body` 구조를 복습했다.

### `test3.jsp`

- JSP 핵심 문법을 한 페이지에 정리했다.
- 선언문 `<%! ... %>`으로 `getGrade()` 메서드를 만들었다.
- 스크립틀릿 `<% ... %>`으로 변수와 시간을 처리했다.
- 표현식 `<%= ... %>`으로 이름, 점수, 학점을 출력했다.
- JSP가 동적인 웹 페이지를 만드는 데 사용된다는 점을 확인했다.

## 코드 스니펫 작성 요약

- VS Code에서는 `.vscode/jsp.json.code-snippets` 파일과 `.vscode/xml.json.code-snippets` 파일에 스니펫을 저장할 수 있다.
- 스니펫을 사용하면 자주 쓰는 코드를 짧은 명령어로 빠르게 입력할 수 있다.
- 기본 구성 요소는 `scope`, `prefix`, `body`, `description` 이다.
- `prefix`는 호출할 단축어이고, `body`는 실제로 삽입될 코드이다.
- `$1`, `$2`, `$0` 같은 탭 스톱을 이용하면 입력 위치를 편하게 이동할 수 있다.

### JSP 스니펫 예시

```json
{
  "JSP Base Template": {
    "scope": "jsp",
    "prefix": "jspbase",
    "body": [
      "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>",
      "<!DOCTYPE html>",
      "<html>",
      "<head>",
      "    <meta charset=\"UTF-8\">",
      "    <title>${1:JSP Page}</title>",
      "</head>",
      "<body>",
      "    $0",
      "</body>",
      "</html>"
    ],
    "description": "JSP 기본 템플릿"
  }
}
```

## 정리

- 오늘은 JSP 기본 구조와 핵심 문법을 연습했다.
- `test3.jsp`를 통해 선언문, 스크립틀릿, 표현식을 직접 확인했다.
- 코드 스니펫을 이용하면 JSP와 XML 파일을 더 빠르게 작성할 수 있다.
