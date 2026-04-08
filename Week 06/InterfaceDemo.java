public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface 기반 도형 클래스 테스트 ===\n");

        // InterRectangle 생성
        System.out.println("--- InterRectangle 생성 ---");
        InterRectangle rect1 = new InterRectangle(10, 15, 20, 30);
        InterRectangle rect2 = new InterRectangle();
        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println("InterRectangle 생성 수: " + InterRectangle.getTotalShapes());
        System.out.println();

        // InterTriangle 생성
        System.out.println("--- InterTriangle 생성 ---");
        InterTriangle tri1 = new InterTriangle(20, 25, 15);
        InterTriangle tri2 = new InterTriangle();
        System.out.println(tri1);
        System.out.println(tri2);
        System.out.println("InterTriangle 생성 수: " + InterTriangle.getTotalShapes());
        System.out.println();

        // InterCircle 생성
        System.out.println("--- InterCircle 생성 ---");
        InterCircle circle1 = new InterCircle(30, 35, 10);
        InterCircle circle2 = new InterCircle();
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println("InterCircle 생성 수: " + InterCircle.getTotalShapes());
        System.out.println();

        // 전체 도형 수
        int totalShapes = InterRectangle.getTotalShapes() + InterTriangle.getTotalShapes() + InterCircle.getTotalShapes();
        System.out.println("전체 생성된 Interface 도형 수: " + totalShapes);
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
        System.out.println("=== 최종 Interface 도형 상태 ===");
        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println(tri1);
        System.out.println(tri2);
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println();
        System.out.println("최종 전체 Interface 도형 수: " + totalShapes);
    }
}
