public abstract class Shape {
    public static final int MIN_COORD = 0;
    public static final int MAX_COORD = 100;
    public static final int MAX_SIZE = 50;

    private static int totalShapes = 0;

    protected int x;
    protected int y;
    protected double rotation; // 회전 각도 (도 단위)

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.rotation = 0;
        totalShapes++;
    }

    public Shape() {
        this.x = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.y = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.rotation = 0;
        totalShapes++;
    }

    public static int getTotalShapes() {
        return totalShapes;
    }

    // 추상 메서드들
    public abstract void move(int dx, int dy);

    public abstract void translate(int tx, int ty);

    public abstract void rotate(double angle);

    @Override
    public abstract String toString();

    // getter/setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation % 360;
    }
}
