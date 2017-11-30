package com.pancholi.binarycalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class XorTests {

  private static final String XOR = "XOR";

  @Test
  public void testXorA() {
    String binaryOne = "110101";
    String binaryTwo = "000011";
    String expected = "110110";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, XOR);

    assertEquals(expected, result);
  }

  @Test public void testXorB() {
    String binaryOne = "1001";
    String binaryTwo = "1001101";
    String expected = "1000100";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, XOR);

    assertEquals(expected, result);
  }
}
