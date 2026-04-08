public class InterTriangle implements ShapeInterface {
    private static int totalShapes = 0;

    private int x;
    private int y;
    private int sideLength;
    private double rotation;

    public InterTriangle(int x, int y, int sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
        this.rotation = 0;
        totalShapes++;
    }

    public InterTriangle() {
        this.x = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.y = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.sideLength = (int) (Math.random() * MAX_SIZE) + 1;
        this.rotation = 0;
        totalShapes++;
    }

    public static int getTotalShapes() {
        return totalShapes;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("[Interface] 삼각형을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    @Override
    public void translate(int tx, int ty) {
        int moveX = tx - this.x;
        int moveY = ty - this.y;
        this.x = tx;
        this.y = ty;
        System.out.println("[Interface] 삼각형을 기준점 (" + tx + ", " + ty + ")으로 옮겼습니다. (이동거리: " + moveX + ", " + moveY + ")");
    }

    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        System.out.println("[Interface] 삼각형을 " + angle + "도 회전했습니다. (현재 회전각: " + this.rotation + "도)");
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
        return String.format("InterTriangle[x=%d, y=%d, sideLength=%d, rotation=%.0f°]",
                x, y, sideLength, rotation);
    }
}
