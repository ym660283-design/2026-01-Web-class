public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public Circle() {
        super();
        this.radius = (int) (Math.random() * MAX_SIZE) + 1;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // move: 원을 지정된 거리만큼 이동
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("원을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    // translate: 원의 중심을 새로운 좌표로 설정
    @Override
    public void translate(int tx, int ty) {
        int distance = (int) Math.sqrt((tx - this.x) * (tx - this.x) + (ty - this.y) * (ty - this.y));
        this.x = tx;
        this.y = ty;
        System.out.println("원의 중심을 (" + tx + ", " + ty + ")으로 이동했습니다. (거리: " + distance + ")");
    }

    // rotate: 원은 회전해도 모양이 동일하므로 회전각만 증가
    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        System.out.println("원을 " + angle + "도 회전했습니다. (원은 회전해도 모양이 같습니다. 회전각: " + this.rotation + "도)");
    }

    @Override
    public String toString() {
        return String.format("Circle[x=%d, y=%d, radius=%d, rotation=%.0f°]",
                x, y, radius, rotation);
    }
}
