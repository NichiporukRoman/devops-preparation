package com.example;

// CalculatorTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), 0.005);
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3), 0.005);
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3), 0.005);
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3), 0.005);
    }


    @Test
    public void testCalculate() {
        assertEquals(4, calculator.calculate("1+3"), 0.005);
        assertEquals(6, calculator.calculate("2*3"), 0.005);
        assertEquals(7, calculator.calculate("1+2*3"), 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
