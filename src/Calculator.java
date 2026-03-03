import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        int num1;
        int num2;
        float result;
        String oper;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java 계산기 ===");

        while(true) {

            try {
                System.out.print("첫 번째 숫자: ");
                num1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            System.out.print("연산자: ");
            oper = scanner.next();

            try {
                System.out.print("두 번째 숫자: ");
                num2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            switch(oper) {
                case "+":
                    result = num1+num2;
                    System.out.println("결과: " + result);
                    break;
                case "-":
                    result = num1-num2;
                    System.out.println("결과: " + result);
                    break;
                case "*":
                    result = num1*num2;
                    System.out.println("결과: " + result);
                    break;
                case "/":
                    result = num1/num2;
                    System.out.println("결과: " + result);
                    break;
            }

            break;  // 이렇게 break를 넣어놓지 않으면 scanner.close()에 도달할수 없는 에러가 발생해 일단 넣어놓음
        }

        /*System.out.println("계산기를 종료합니다.");*/

        scanner.close();

    }

}