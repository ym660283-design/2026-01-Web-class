import java.util.Scanner;

public class MultiplesScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");

        if (!scanner.hasNextInt()) {
            System.out.println("정수를 입력해야 합니다.");
            scanner.close();
            return;
        }

        int limit = scanner.nextInt();
        scanner.close();

        System.out.println("입력값보다 작은 2부터 9까지의 배수:");
        for (int i = 2; i <= 9; i++) {
            System.out.print(i + "의 배수: ");
            boolean found = false;
            for (int multiple = i; multiple < limit; multiple += i) {
                System.out.print(multiple + " ");
                found = true;
            }
            if (!found) {
                System.out.print("없음");
            }
            System.out.println();
        }
    }
}
