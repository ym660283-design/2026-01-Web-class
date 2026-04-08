public class ShapeDemo {
    public static void main(String[] args) {
        System.out.println("=== 도형 클래스 테스트 ===\n");

        // Rectangle 생성
        System.out.println("--- Rectangle 생성 ---");
        Rectangle rect1 = new Rectangle(10, 15, 20, 30);
        Rectangle rect2 = new Rectangle();
        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println();

        // Triangle 생성
        System.out.println("--- Triangle 생성 ---");
        Triangle tri1 = new Triangle(20, 25, 15);
        Triangle tri2 = new Triangle();
        System.out.println(tri1);
        System.out.println(tri2);
        System.out.println();

        // Circle 생성
        System.out.println("--- Circle 생성 ---");
        Circle circle1 = new Circle(30, 35, 10);
        Circle circle2 = new Circle();
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println();

        // 전체 도형 수
        System.out.println("전체 생성된 도형 수: " + Shape.getTotalShapes());
        System.out.println();

        // move 메서드 테스트
        System.out.println("--- move() 메서드 테스트 ---");
        rect1.move(5, 10);
        tri1.move(-3, 7);
        circle1.move(15, -5);
        System.out.println();

        // translate 메서드 테스트
        System.out.println("--- translate() 메서드 테스트 ---");
        rect2.translate(50, 50);
        tri2.translate(60, 70);
        circle2.translate(40, 45);
        System.out.println();

        // rotate 메서드 테스트
        System.out.println("--- rotate() 메서드 테스트 ---");
        rect1.rotate(90);
        tri1.rotate(120);
        circle1.rotate(45);
        System.out.println();

        // 최종 상태 출력
        System.out.println("=== 최종 도형 상태 ===");
        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println(tri1);
        System.out.println(tri2);
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println();
        System.out.println("최종 전체 도형 수: " + Shape.getTotalShapes());
    }
}
