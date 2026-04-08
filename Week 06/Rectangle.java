import java.util.Random;

public class Rectangle {
    public static final int MIN_COORD = 0;
    public static final int MAX_COORD = 100;
    public static final int MAX_SIZE = 50;

    private static int totalRectangles = 0;

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        totalRectangles++;
    }

    public Rectangle() {
        Random random = new Random();
        this.x = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.y = (int) (Math.random() * (MAX_COORD - MIN_COORD + 1)) + MIN_COORD;
        this.width = random.nextInt(MAX_SIZE) + 1;
        this.height = random.nextInt(MAX_SIZE) + 1;
        totalRectangles++;
    }

    public static int getTotalRectangles() {
        return totalRectangles;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[x=%d, y=%d, width=%d, height=%d]", x, y, width, height);
    }
}
