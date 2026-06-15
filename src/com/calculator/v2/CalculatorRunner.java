package com.calculator.v2;

import java.util.Scanner;

public class CalculatorRunner {

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

        Operation operation = Operation.fromSymbol(operator);

        boolean leftIsRoman = isRoman(left);
        boolean rightIsRoman = isRoman(right);

        if (leftIsRoman != rightIsRoman) {
            throw new Exception();
        }

        int leftNumber;
        int rightNumber;

        if (leftIsRoman) {
            leftNumber = RomanNumber.fromString(left).getValue();
            rightNumber = RomanNumber.fromString(right).getValue();
        } else {
            leftNumber = Integer.parseInt(left);
            rightNumber = Integer.parseInt(right);
        }

        if (leftNumber < 1 || leftNumber > 10
                || rightNumber < 1 || rightNumber > 10) {
            throw new Exception();
        }

        int result = operation.calculate(leftNumber, rightNumber);

        if (leftIsRoman) {
            return RomanNumber.toRoman(result);
        }



        return String.valueOf(result);
    }

    private static boolean isRoman(String value) {
        try {
            RomanNumber.fromString(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
