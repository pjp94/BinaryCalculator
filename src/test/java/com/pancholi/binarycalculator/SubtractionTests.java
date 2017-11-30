package com.pancholi.binarycalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SubtractionTests {

  private static final String SUBTRACT = "-";

  @Test
  public void testSubtractionA() {
    String binaryOne = "11011";
    String binaryTwo = "110";
    String expected = "10101";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, SUBTRACT);

    assertEquals(expected, result);
  }

  @Test
  public void testSubtractionB() {
    String binaryOne = "11";
    String binaryTwo = "1101";
    String expected = "-1010";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, SUBTRACT);

    assertEquals(expected, result);
  }
}
