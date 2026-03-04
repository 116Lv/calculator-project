import java.util.*;

public class Calculator {

    List<Record> storedList = new ArrayList<>();

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        calc.runCalculator();
    }

    //계산하기
    public void runCalculator() {


        Scanner scanner = new Scanner(System.in);

        while(true) {
            double num1;
            String oper = "";
            double num2;
            double result;

            System.out.println("=== Java 계산기 ===");
            num1 = inputNumber(scanner, "첫", oper);
            oper = inputOperator(scanner, num1);
            if(oper.equals("sqrt")) {
                num2 = Double.NaN;
            } else {
                num2 = inputNumber(scanner, "두", oper);
            }
            result = processCalc(num1, oper, num2);

            storedList.add(new Record(num1, oper, num2, result));

            if(!askContinue(scanner)) {
                scanner.close();
                break;
            }
        }
    }

    //숫자 입력
    private double inputNumber(Scanner scanner, String message, String oper) {
        double num = 0;
        boolean valid = false;

        while(!valid) {
            try {
                System.out.print(message + " 번째 숫자를 입력하세요: ");
                num = scanner.nextDouble();
                if(!oper.isBlank() && ((oper.equals("%") || oper.equals("/")) && num == 0)) {
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
    private String inputOperator(Scanner scanner, double num1) {
        String oper = "";
        boolean valid = false;

        while(!valid) {
            if (num1 < 0){
                System.out.print("연산자를 입력하세요 (+, -, *, /, %, ^): ");
            } else {
                System.out.print("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt): ");
            }
            oper = scanner.next();
            if(!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/") && !oper.equals("%") && !oper.equals("^") && !oper.equals("sqrt")) {
                System.out.println("올바른 연산자를 입력해주세요.");
            } else if(num1 < 0 && oper.equals("sqrt")) {
                System.out.println("음수의 제곱근은 계산할수 없습니다. 올바른 연산자를 입력해주세요.");
            } else {
                valid = true;
            }
        }
        return oper;
    }

    //연산과정
    private double processCalc(double num1, String oper, double num2) {
        double result = 0;
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
            case "%":
                result = num1%num2;
                break;
            case "^":
                result = Math.pow(num1,num2);
                break;
            case "sqrt":
                result = Math.sqrt(num1);
                break;

        }
        if(oper.equals("sqrt")) {
            System.out.println("결과: " + num1 + " 의 제곱근 = " + result);
        } else {
            System.out.println("결과: " + num1 + " " + oper + " " + num2 + " = " + result);
        }
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
    double num1;
    String oper;
    double num2;
    double result;

    public Record(double num1, String oper, double num2, double result) {
        this.num1 = num1;
        this.oper = oper;
        this.num2 = num2;
        this.result = result;
    }
}