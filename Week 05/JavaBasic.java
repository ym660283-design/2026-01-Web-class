public class JavaBasic {
    public static void main(String[] args) {
        // 기본 변수 생성
        int age = 21;
        double score = 88.5;
        boolean enrolled = true;
        char grade = 'A';
        String name = "김용민";

        // 문자열 배열 생성
        String[] subjects = {"Java", "HTML", "CSS", "JSP"};

        // 결과 출력
        System.out.println("=== Java 기본 변수 및 문자열 배열 예제 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("수강 여부: " + enrolled);
        System.out.println("성적: " + score);
        System.out.println("학점: " + grade);
        System.out.println();
        System.out.println("수강 과목 목록:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }

        // 배열 내용을 하나의 문자열로 합쳐서 출력
        String subjectList = String.join(", ", subjects);
        System.out.println();
        System.out.println("문자열 배열을 한 줄로 표현: " + subjectList);
    }
}
