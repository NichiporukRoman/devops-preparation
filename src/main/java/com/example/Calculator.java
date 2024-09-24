package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

// Calculator.java
public class Calculator {

    public float add(float a, float b) {
        return a + b;
    }

    public float subtract(float a, float b) {
        return a - b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }

    public float divide(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }

    public float calculate(String input) {
        String postfix = infixToPostfix(input);
        return evaluatePostfix(postfix);
    }

    private String infixToPostfix(String input) {
    StringBuilder postfix = new StringBuilder();
    Deque<Character> operatorStack = new ArrayDeque<>();

    for (char c : input.toCharArray()) {
        if (Character.isDigit(c)) {
            postfix.append(c).append(" ");
        } else if (isOperator(c)) {
            while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
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

private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

private int precedence(char operator) {
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

    private float evaluatePostfix(String postfix) {
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
                }
            } else {
                stack.push(Float.parseFloat(token));
            }
        }

        return stack.pop();
    }
}