import java.util.List;
public class Convert {
    public static int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int result = 0;

        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanNumbers symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException("Введенные числа разных типов, используйте один тип вводимых значений. Завершение работы.");
        }

        Calculator.check(result);

        return result;
    }

    public static String arabicToRoman(int num) {

        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        if (num <= 0) throw new IllegalArgumentException("В римской системе нет отрицательных чисел и нуля");

        while ((num > 0) && (i < romanNumbers.size())) {
            RomanNumbers currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= num) {
                sb.append(currentSymbol.name());
                num -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    static int[] stringToInt(String[] values) {

        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[2]);
        Calculator.check(num1);
        Calculator.check(num2);

        try {
            return new int[]{Integer.parseInt(values[0]), Integer.parseInt(values[2])};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ввод неподходящих чисел. Завершение работы.");
        }

    }
}
