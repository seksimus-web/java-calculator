package com.calculator.v2;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;


    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operation fromSymbol(String symbol) throws Exception {
        return switch (symbol) {
            case "+" -> Operation.ADD;
            case "-" -> Operation.SUBTRACT;
            case "*" -> Operation.MULTIPLY;
            case "/" -> Operation.DIVIDE;
            default -> throw new Exception();
        };
    }

    public int calculate(int left, int right) throws Exception {
        return switch (this) {
            case ADD -> left + right;
            case SUBTRACT -> left - right;
            case MULTIPLY -> left * right;
            case DIVIDE -> left / right;
        };
    }
}
