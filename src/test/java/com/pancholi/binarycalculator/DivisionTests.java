package com.pancholi.binarycalculator;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DivisionTests {

  private static final String DIVIDE = "÷";

  @Test
  public void testDivisionA() {
    String binaryOne = "111010";
    String binaryTwo = "11010";
    String expected = "10";
    String result = BinaryOperations.completeOperation(binaryOne, binaryTwo, DIVIDE);

    assertEquals(expected, result);
  }
}
