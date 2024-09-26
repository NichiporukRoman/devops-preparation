package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

// Calculator.java
public class Calculator {

    /**
     * Returns summ of two numbers.
     * @param  a first value in summ
     * @param  b second value in summ
     * @return   summ of two numbers
     */
    public float add(final float a, final float b) {
        return a + b;
    }

    /**
     * Returns difference of two numbers.
     * @param  a first value in subtraction
     * @param  b second value in subtraction
     * @return   difference of two numbers
     */
    public float subtract(final float a, final float b) {
        return a - b;
    }

    /**
     * Returns product of two numbers.
     * @param  a first value in product
     * @param  b second value in product
     * @return   product of two numbers
     */
    public float multiply(final float a, final float b) {
        return a * b;
    }

    /**
     * Returns division of two numbers.
     * @param  a first value in division
     * @param  b second value in division
     * @return   division of two numbers
     */
    public float divide(final float a, final float b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }

    /**
     * Returns evaluated example.
     * @param  input math example that we need to solve
     * @return       answer that we get from solving example
     */
    public float calculate(final String input) {
        String postfix = infixToPostfix(input);
        return evaluatePostfix(postfix);
    }

    private String infixToPostfix(final String input) {
    StringBuilder postfix = new StringBuilder();
    Deque<Character> operatorStack = new ArrayDeque<>();

    for (char c : input.toCharArray()) {
        if (Character.isDigit(c)) {
            postfix.append(c).append(" ");
        } else if (isOperator(c)) {
            while (!operatorStack.isEmpty()
            && precedence(operatorStack.peek()) >= precedence(c)) {
                postfix.append(operatorStack.pop()).append(" ");
            }
            operatorStack.push(c);
        } else if (c == '(') {
            operatorStack.push(c);
        } else if (c == ')') {
            while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                postfix.append(operatorStack.pop()).append(" ");
            }
            operatorStack.pop(); // Discard the '('
        }
    }

    while (!operatorStack.isEmpty()) {
        postfix.append(operatorStack.pop()).append(" ");
    }

    return postfix.toString().trim();
}

private boolean isOperator(final char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

private int precedence(final char operator) {
    switch (operator) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}

    private float evaluatePostfix(final String postfix) {
        Deque<Float> stack = new ArrayDeque<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.matches("[+\\-*/]")) {
                float b = stack.pop();
                float a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(add(a, b));
                        break;
                    case "-":
                        stack.push(subtract(a, b));
                        break;
                    case "*":
                        stack.push(multiply(a, b));
                        break;
                    case "/":
                        stack.push(divide(a, b));
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Float.parseFloat(token));
            }
        }

        return stack.pop();
    }
}
