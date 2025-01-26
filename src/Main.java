import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение (например, 1 + 2):");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        input = input.trim();
        
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Некорректный формат математической операции");
        }

        String leftOperand = parts[0];
        String operator = parts[1];
        String rightOperand = parts[2];

        int a;
        int b;

        try {
            a = Integer.parseInt(leftOperand);
            b = Integer.parseInt(rightOperand);
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть числами от 1 до 10");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10");
        }

        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Некорректный оператор");
        }

        return String.valueOf(result);
    }
}
