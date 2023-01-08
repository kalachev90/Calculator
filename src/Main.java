import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        startCalculator();

        while (true) {
            System.out.println("Введите выражение с арабскими или римскими цифрами от 1 до 10 через пробел:");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                System.out.println("Программа завершена");
                break;
            }
            System.out.println("Релультат равен");
            System.out.println(Calculator.calc(userInput));
        }
    }
    private static void startCalculator() {
        System.out.println("Калькулятор выполняет операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b");
        System.out.println("Чтобы завершить программу введите exit");
    }
}