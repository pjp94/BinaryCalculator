package com.pancholi.binarycalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class OrTests {

  private static final String OR = "OR";

  @Test
  public void testOrA() {
    String binaryOne = "1101010";
    String binaryTwo = "0110110";
    String expected = "1111110";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, OR);

    assertEquals(expected, result);
  }

  @Test
  public void testOrB() {
    String binaryOne = "01101000";
    String binaryTwo = "00001111";
    String expected = "1101111";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, OR);

    assertEquals(expected, result);
  }

  @Test
  public void testOrC() {
    String binaryOne = "00000000";
    String binaryTwo = "00000000";
    String expected = "0";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, OR);

    assertEquals(expected, result);
  }

  @Test
  public void testOrD() {
    String binaryOne = "11111111";
    String binaryTwo = "00000000";
    String expected = "11111111";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, OR);

    assertEquals(expected, result);
  }
}
