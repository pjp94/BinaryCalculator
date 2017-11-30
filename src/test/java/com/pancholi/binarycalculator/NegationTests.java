package com.pancholi.binarycalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NegationTests {

  @Test
  public void testNegationA() {
    String binary = "100101";
    String expected = "11010";
    String result = BinaryOperations.negateValue(binary);

    assertEquals(expected, result);
  }

  @Test
  public void testNegationB() {
    String binary = "11111111";
    String expected = "0";
    String result = BinaryOperations.negateValue(binary);

    assertEquals(expected, result);
  }

  @Test
  public void testNegationC() {
    String binary = "00000000";
    String expected = "11111111";
    String result = BinaryOperations.negateValue(binary);

    assertEquals(expected, result);
  }
}
