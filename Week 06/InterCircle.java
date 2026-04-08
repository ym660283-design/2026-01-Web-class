public class InterCircle implements ShapeInterface {
    private static int totalShapes = 0;

    private int x;
    private int y;
    private int radius;
    private double rotation;

    public InterCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.rotation = 0;
        totalShapes++;
    }

    public InterCircle() {
        this.x = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.y = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.radius = (int) (Math.random() * MAX_SIZE) + 1;
        this.rotation = 0;
        totalShapes++;
    }

    public static int getTotalShapes() {
        return totalShapes;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("[Interface] 원을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    @Override
    public void translate(int tx, int ty) {
        int distance = (int) Math.sqrt((tx - this.x) * (tx - this.x) + (ty - this.y) * (ty - this.y));
        this.x = tx;
        this.y = ty;
        System.out.println("[Interface] 원의 중심을 (" + tx + ", " + ty + ")으로 이동했습니다. (거리: " + distance + ")");
    }

    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        System.out.println("[Interface] 원을 " + angle + "도 회전했습니다. (원은 회전해도 모양이 같습니다. 회전각: " + this.rotation + "도)");
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public double getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return String.format("InterCircle[x=%d, y=%d, radius=%d, rotation=%.0f°]",
                x, y, radius, rotation);
    }
}
