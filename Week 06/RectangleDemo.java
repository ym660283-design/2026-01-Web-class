public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(10, 15, 20, 30);
        Rectangle rect2 = new Rectangle();
        Rectangle rect3 = new Rectangle();

        System.out.println("=== 생성된 사각형 정보 ===");
        System.out.println("직접 생성된 사각형: " + rect1);
        System.out.println("랜덤 생성된 사각형 1: " + rect2);
        System.out.println("랜덤 생성된 사각형 2: " + rect3);
        System.out.println();
        System.out.println("전체 도형 수: " + Shape.getTotalShapes());
    }
}
