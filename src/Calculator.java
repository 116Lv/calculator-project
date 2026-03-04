import java.util.*;

public class Calculator {

    List<Record> storedList = new ArrayList<>();

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        calc.runCalculator();
    }

    //계산하기
    public void runCalculator() {

        float num1;
        String oper = "";
        float num2;
        float result;

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("=== Java 계산기 ===");
            num1 = inputNumber(scanner, "첫", oper);
            oper = inputOperator(scanner);
            num2 = inputNumber(scanner, "두", oper);
            result = processCalc(num1, oper, num2);

            storedList.add(new Record(num1, oper, num2, result));

            if(!askContinue(scanner)) {
                scanner.close();
                break;
            }
        }
    }

    //숫자 입력
    private float inputNumber(Scanner scanner, String message, String oper) {
        float num = 0;
        boolean valid = false;

        while(!valid) {
            try {
                System.out.print(message + " 번째 숫자를 입력하세요: ");
                num = scanner.nextFloat();
                if(!oper.isBlank() && (oper.equals("/") && num == 0)) {
                    System.out.println("0으로 나눌수 없기 때문에 다시 입력해주세요.");
                    continue;
                }
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
        return num;
    }

    //연산자 입력
    private String inputOperator(Scanner scanner) {
        String oper = "";
        boolean valid = false;

        while(!valid) {
            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            oper = scanner.next();
            if(!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
                System.out.println("올바른 연산자를 입력해주세요.");
            } else {
                valid = true;
            }
        }
        return oper;
    }

    //연산과정
    private float processCalc(float num1, String oper, float num2) {
        float result = 0;
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
        return result;
    }

    //추가 계산여부 질의
    private boolean askContinue(Scanner scanner) {

        while(true) {
            System.out.print("\n계속 계산하시겠습니까? (y/n): ");
            String answer =scanner.next();

            if(answer.equals("y")) {
                System.out.println();
                return true;
            } else if(answer.equals("n")) {
                System.out.println("계산기를 종료합니다.");
                return false;
            } else {
                System.out.println("y와 n 중 한개를 입력해주세요.");
            }
        }

    }

}

//연산기록 보관객체
class Record {
    float num1;
    String oper;
    float num2;
    float result;

    public Record(float num1, String oper, float num2, float result) {
        this.num1 = num1;
        this.oper = oper;
        this.num2 = num2;
        this.result = result;
    }
}