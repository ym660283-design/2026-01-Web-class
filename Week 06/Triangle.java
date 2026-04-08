public class Triangle extends Shape {
    private int sideLength; // 정삼각형의 한 변의 길이

    public Triangle(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    public Triangle() {
        super();
        this.sideLength = (int) (Math.random() * MAX_SIZE) + 1;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    // move: 삼각형을 상하좌우로 이동
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("삼각형을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    // translate: 삼각형을 절대 좌표로 이동 (원점 기준)
    @Override
    public void translate(int tx, int ty) {
        int moveX = tx - this.x;
        int moveY = ty - this.y;
        this.x = tx;
        this.y = ty;
        System.out.println("삼각형을 기준점 (" + tx + ", " + ty + ")으로 옮겼습니다. (이동거리: " + moveX + ", " + moveY + ")");
    }

    // rotate: 삼각형을 회전시킴 (정삼각형이므로 120도 단위로 회전)
    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        System.out.println("삼각형을 " + angle + "도 회전했습니다. (현재 회전각: " + this.rotation + "도)");
    }

    @Override
    public String toString() {
        return String.format("Triangle[x=%d, y=%d, sideLength=%d, rotation=%.0f°]",
                x, y, sideLength, rotation);
    }
}
