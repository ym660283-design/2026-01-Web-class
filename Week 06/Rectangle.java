public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        super();
        this.width = (int) (Math.random() * MAX_SIZE) + 1;
        this.height = (int) (Math.random() * MAX_SIZE) + 1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // move: 사각형을 지정된 거리만큼 이동 (좌표 변경)
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("사각형을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    // translate: 사각형을 절대 좌표로 이동
    @Override
    public void translate(int tx, int ty) {
        this.x = tx;
        this.y = ty;
        System.out.println("사각형을 (" + tx + ", " + ty + ")로 이동했습니다.");
    }

    // rotate: 사각형의 너비와 높이를 교환하여 회전 효과 표현
    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        // 90도 또는 270도 회전 시 너비와 높이 교환
        if ((int) this.rotation % 180 == 90) {
            int temp = this.width;
            this.width = this.height;
            this.height = temp;
        }
        System.out.println("사각형을 " + angle + "도 회전했습니다. (현재 회전각: " + this.rotation + "도)");
    }

    @Override
    public String toString() {
        return String.format("Rectangle[x=%d, y=%d, width=%d, height=%d, rotation=%.0f°]",
                x, y, width, height, rotation);
    }
}
