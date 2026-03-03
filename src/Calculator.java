import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        float num1;
        float num2;
        float result = 0;
        String oper;

        Scanner scanner = new Scanner(System.in);


        while(true) {

            System.out.println("=== Java 계산기 ===");

            while(true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }

            while(true) {
                System.out.print("연산자를 입력하세요 (+, -, *, /): ");
                oper = scanner.next();
                if(!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
                    System.out.println("올바른 연산자를 입력해주세요.");
                } else {
                    break;
                }
            }


            while(true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextInt();
                    if(oper.equals("/") && num2 == 0) {
                        System.out.println("0으로 나눌수 없기 때문에 다시 입력해주세요.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }

            switch(oper) {
                case "+":
                    result = num1+num2;
                    break;
                case "-":
                    result = num1-num2;
                    break;
                case "*":
                    result = num1*num2;
                    break;
                case "/":
                    result = num1/num2;
                    break;
            }

            System.out.println("결과: " + num1 + " " + oper + " " + num2 + " = " + result);

            while(true) {
                System.out.print("\n계속 계산하시겠습니까? (y/n): ");
                String answer =scanner.next();

                if(answer.equals("y")) {
                    System.out.println();
                    break;
                } else if(answer.equals("n")) {
                    System.out.println("계산기를 종료합니다.");
                    scanner.close();
                    return;
                } else {
                    System.out.println("y와 n 중 한개를 입력해주세요.");
                }
            }

        }


    }

}