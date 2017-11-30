package com.pancholi.binarycalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionTests {

  private static final String ADD = "+";

  @Test
  public void testAdditionA() {
    String binaryOne = "1101";
    String binaryTwo = "10111";
    String expected = "100100";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, ADD);

    assertEquals(expected, result);
  }

  @Test
  public void testAdditionB() {
    String binaryOne = "101011";
    String binaryTwo = "1001011";
    String expected = "1110110";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, ADD);

    assertEquals(expected, result);
  }

  @Test
  public void testAdditionC() {
    String binaryOne = "11111111";
    String binaryTwo = "11111111";
    String expected = "111111110";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, ADD);

    assertEquals(expected, result);
  }

  @Test
  public void testAdditionD() {
    String binaryOne = "101011010101010";
    String binaryTwo = "1101010101";
    String expected = "101100111111111";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, ADD);

    assertEquals(expected, result);
  }
}
