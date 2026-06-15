package com.calculator.v2;

public enum RomanNumber {

    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    private final int value;

    RomanNumber(int value) {
        this.value = value;
    }

    public static RomanNumber fromString(String value) throws Exception {
        return switch (value) {
            case "I" -> RomanNumber.I;
            case "II" -> RomanNumber.II;
            case "III" -> RomanNumber.III;
            case "IV" -> RomanNumber.IV;
            case "V" -> RomanNumber.V;
            case "VI" -> RomanNumber.VI;
            case "VII" -> RomanNumber.VII;
            case "VIII" -> RomanNumber.VIII;
            case "IX" -> RomanNumber.IX;
            case "X" -> RomanNumber.X;
            default -> throw new Exception();
        };
    }

    public static String toRoman(int value) throws Exception {
        if (value <= 0) {
            throw new Exception();
        }

        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return tens[value / 10] + ones[value % 10];
    }

    public int getValue() {
        return value;
    }
}
