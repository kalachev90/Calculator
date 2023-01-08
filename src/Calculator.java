public class Calculator {
    public static String calc(String userInput) throws IllegalArgumentException {
        String[] arguments = userInput.split(" ");
        if (arguments.length != 3) throw new IllegalArgumentException("Введённое выражение не корректно. Завершение работы.");

        boolean isRoman = isRoman(arguments);

        int[] numbers;
        if (isRoman) {
            numbers = new int[]{Convert.romanToArabic(arguments[0]), Convert.romanToArabic(arguments[2])};
        } else {
            numbers = Convert.stringToInt(arguments);
        }
        int num1 = numbers[0], num2 = numbers[1];

        int result;
        switch (arguments[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Введена неподдерживаемая арифметическая операция, используйте только +, -, *, /");
        }

        if (isRoman) return Convert.arabicToRoman(result);
        else return String.valueOf(result);
    }

    static void check(int num) {
        if (num > 10 || num < 1)
            throw new IllegalArgumentException("Введённые числа не соответствуют условиям, используйте числа от 1 до 10 включительно. Завершение работы.");
    }

    private static boolean isRoman(String[] arguments) {
        try {
            Integer.parseInt(arguments[0]);
            Integer.parseInt(arguments[2]);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}