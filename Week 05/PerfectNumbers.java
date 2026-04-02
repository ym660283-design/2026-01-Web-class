public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("2000 이하의 완전수 및 약수 목록");
        for (int number = 2; number <= 2000; number++) {
            int sum = 0;
            for (int divisor = 1; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    sum += divisor;
                }
            }
            if (sum == number) {
                System.out.println(number + " 는 완전수입니다.");
                System.out.print("약수: ");
                for (int divisor = 1; divisor <= number; divisor++) {
                    if (number % divisor == 0) {
                        System.out.print(divisor + " ");
                    }
                }
                System.out.println("\n");
            }
        }
    }
}
