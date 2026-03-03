import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        String oper = "";

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=== Java 계산기 ===");

            System.out.println("첫번쨰 숫자를 입력하세요: ");
            num1 = scanner.nextInt();

            System.out.println("연산자를 입력하세요 (+, -, *, /): ");
            oper = scanner.next();

            System.out.println("두번쨰 숫자를 입력하세요: ");
            num2 = scanner.nextInt();

            System.out.println("계산기를 종료합니다.");

            break;  // 이렇게 break를 넣어놓지 않으면 scanner.close()에 도달할수 없는 에러가 발생해 일단 넣어놓음
        }

        scanner.close();

    }

}