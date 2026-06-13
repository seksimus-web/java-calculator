package com.calculator;

import java.util.Scanner;

/**
 * 1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и
 * деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну
 * строку (смотри пример)! Решения, в которых каждое число и арифмитеческая
 * операция передаются с новой строки считаются неверными.
 * 2. Калькулятор умеет работать как с арабскими (1,2,3,4,5 ... ), так и с римскими
 * (I,II,III,IV,V ... ) числами.
 * 3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
 * На выходе числа не ограничиваются по величине и могут быть любыми.
 * 4. Калькулятор умеет работать только с целыми числами.
 * 5. Калькулятор умеет работать только с арабскими или римскими цифрами
 * одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен
 * выбросить исключение и прекратить свою работу.
 * 6. При вводе римских чисел, ответ должен быть выведен римскими цифрами,
 * соответственно, при вводе арабских - ответ ожидается арабскими.
 * 7. При вводе пользователем неподходящих чисел приложение выбрасывает
 * исключение и завершает свою работу.
 * 8. При вводе пользователем строки, не соответствующей одной из вышеописанных
 * арифметических операций, приложение выбрасывает исключение и завершает
 * свою работу.
 * 9. Результатом операции деления является целое число, остаток отбрасывается.
 * 10. Результатом работы калькулятора с арабскими числами могут быть отрицательные
 * числа и ноль. Результатом работы калькулятора с римскими числами могут быть
 * только положительные числа, если результат работы меньше единицы,
 * выбрасывается исключение
 */

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = calc(input);

        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new Exception();
        }

        String left = parts[0];
        String operator = parts[1];
        String right = parts[2];

        boolean leftIsRoman = isRoman(left);
        boolean rightIsRoman = isRoman(right);
        boolean leftIsArabic = isArabic(left);
        boolean rightIsArabic = isArabic(right);

        if (leftIsRoman != rightIsRoman) {
                throw new Exception();
        }

        if (!leftIsRoman && !rightIsRoman && (!leftIsArabic || !rightIsArabic)) {
            throw new Exception();
        }

        if (!isOperator(operator)) {
            throw new Exception();
        }


        if (leftIsArabic && rightIsArabic) {
            int leftNumber = Integer.parseInt(left);
            int rightNumber = Integer.parseInt(right);
            int result = calculator(leftNumber, rightNumber, operator);

            return String.valueOf(result);
        }

        int leftNumber = romanToInt(left);
        int rightNumber = romanToInt(right);
        int result = calculator(leftNumber, rightNumber, operator);

        if (result <= 0) {
            throw new Exception();
        }

        return intToRoman(result);

    }


    private static boolean isRoman(String value) {
        return value.equals("I")
                || value.equals("II")
                || value.equals("III")
                || value.equals("IV")
                || value.equals("V")
                || value.equals("VI")
                || value.equals("VII")
                || value.equals("VIII")
                || value.equals("IX")
                || value.equals("X");
    }

    private static boolean isArabic(String value) {
        return value.equals("1")
                || value.equals("2")
                || value.equals("3")
                || value.equals("4")
                || value.equals("5")
                || value.equals("6")
                || value.equals("7")
                || value.equals("8")
                || value.equals("9")
                || value.equals("10");
    }

    private static boolean isOperator(String value) {
        return value.equals("+")
                || value.equals("-")
                || value.equals("/")
                || value.equals("*");
    }

    private static int calculator(int leftNumber, int rightNumber, String operator) throws Exception {
        return switch (operator) {
            case "+" -> leftNumber + rightNumber;
            case "-" -> leftNumber - rightNumber;
            case "*" -> leftNumber * rightNumber;
            case "/" -> leftNumber / rightNumber;
            default -> throw new Exception();
        };
    }
    private static int romanToInt(String value) throws Exception {
        return switch (value) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception();
        };
    }

    private static String intToRoman(int value) throws Exception {
        if (value <= 0) {
            throw new Exception();
        }

        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return tens[value / 10] + ones[value % 10];
    }
}
