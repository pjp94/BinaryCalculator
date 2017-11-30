package com.pancholi.binarycalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AndTests {

  private static final String AND = "AND";

  @Test
  public void testAndA() {
    String binaryOne = "110101";
    String binaryTwo = "10010";
    String expected = "10000";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, AND);

    assertEquals(expected, result);
  }

  @Test
  public void testAndB() {
    String binaryOne = "1111001";
    String binaryTwo = "11010111";
    String expected = "1010001";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, AND);

    assertEquals(expected, result);
  }

  @Test
  public void testAndC() {
    String binaryOne = "10101010";
    String binaryTwo = "1010101";
    String expected = "0";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, AND);

    assertEquals(expected, result);
  }
}
