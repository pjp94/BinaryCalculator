package com.pancholi.binarycalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MultiplicationTests {

  private static final String MULTIPLY = "×";

  @Test
  public void testMultiplicationA() {
    String binaryOne = "100110";
    String binaryTwo = "11101";
    String expected = "10001001110";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, MULTIPLY);

    assertEquals(expected, result);
  }

  @Test
  public void testMultiplicationB() {
    String binaryOne = "111111111111111111";
    String binaryTwo = "1111111111111111111";
    String expected = "1111111111111111101000000000000000001";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, MULTIPLY);

    assertEquals(expected, result);
  }
}
