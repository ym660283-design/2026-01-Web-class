public interface ShapeInterface {
    // 상수
    int MIN_COORD = 0;
    int MAX_COORD = 100;
    int MAX_SIZE = 50;

    // 추상 메서드
    void move(int dx, int dy);

    void translate(int tx, int ty);

    void rotate(double angle);

    // getter 메서드
    int getX();

    int getY();

    double getRotation();

    String toString();
}
