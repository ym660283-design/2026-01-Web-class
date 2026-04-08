public class InterRectangle implements ShapeInterface {
    private static int totalShapes = 0;

    private int x;
    private int y;
    private int width;
    private int height;
    private double rotation;

    public InterRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = 0;
        totalShapes++;
    }

    public InterRectangle() {
        this.x = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.y = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.width = (int) (Math.random() * MAX_SIZE) + 1;
        this.height = (int) (Math.random() * MAX_SIZE) + 1;
        this.rotation = 0;
        totalShapes++;
    }

    public static int getTotalShapes() {
        return totalShapes;
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

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println("[Interface] 사각형을 (" + dx + ", " + dy + ")만큼 이동했습니다.");
    }

    @Override
    public void translate(int tx, int ty) {
        this.x = tx;
        this.y = ty;
        System.out.println("[Interface] 사각형을 (" + tx + ", " + ty + ")로 이동했습니다.");
    }

    @Override
    public void rotate(double angle) {
        this.rotation = (this.rotation + angle) % 360;
        if ((int) this.rotation % 180 == 90) {
            int temp = this.width;
            this.width = this.height;
            this.height = temp;
        }
        System.out.println("[Interface] 사각형을 " + angle + "도 회전했습니다. (현재 회전각: " + this.rotation + "도)");
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
        return String.format("InterRectangle[x=%d, y=%d, width=%d, height=%d, rotation=%.0f°]",
                x, y, width, height, rotation);
    }
}
