package com.pancholi.binarycalculator;

public class BinaryOperations {

  static String completeOperation(String valueOne, String valueTwo, String operator) {
    String result;

    switch (operator) {
      case "+":
        result = addValues(valueOne, valueTwo);
        break;
      case "-":
        result = subtractValues(valueOne, valueTwo);
        break;
      case "×":
        result = multiplyValues(valueOne, valueTwo);
        break;
      case "÷":
        result = divideValues(valueOne, valueTwo);
        break;
      default:
        result = bitwiseOperations(valueOne, valueTwo, operator);
        break;
    }

    result = result.replaceAll("^0+", "");

    if (result.isEmpty()) {
      result = "0";
    }

    return result;
  }

  private static String addValues(String valueOne, String valueTwo) {
    long binaryOne = Long.parseLong(valueOne, 2);
    long binaryTwo = Long.parseLong(valueTwo, 2);

    return Long.toBinaryString(binaryOne + binaryTwo);
  }

  private static String subtractValues(String valueOne, String valueTwo) {
    long binaryOne = Long.parseLong(valueOne, 2);
    long binaryTwo = Long.parseLong(valueTwo, 2);
    long difference = binaryOne - binaryTwo;

    StringBuilder result = new StringBuilder();

    if (difference < 0) {
      result.append("-");
      difference *= -1;
    }

    return result.append(convertToBinary(difference)).toString();
  }

  private static String multiplyValues(String valueOne, String valueTwo) {
    long binaryOne = Long.parseLong(valueOne, 2);
    long binaryTwo = Long.parseLong(valueTwo, 2);

    return Long.toBinaryString(binaryOne * binaryTwo);
  }

  private static String divideValues(String valueOne, String valueTwo) {
    long binaryOne = Long.parseLong(valueOne, 2);
    long binaryTwo = Long.parseLong(valueTwo, 2);

    return Long.toBinaryString(binaryOne / binaryTwo);
  }

  private static String convertToBinary(long value) {
    StringBuilder binary = new StringBuilder();

    while (value > 0) {
      int remainder = (int)(value % 2);

      binary.append(remainder);
      value /= 2;
    }

    return binary.reverse().toString();
  }

  static String negateValue(String binary) {
    char[] values = binary.toCharArray();
    StringBuilder newValue = new StringBuilder();

    for (char value : values) {
      newValue.append(value == '0' ? 1 : 0);
    }

    String trimmedValue = newValue.toString().replaceAll("^0+", "");

    if (trimmedValue.isEmpty()) {
      trimmedValue = "0";
    }

    return trimmedValue;
  }

  private static String bitwiseOperations(String valueOne, String valueTwo, String operator) {
    int lengthOne = valueOne.length();
    int lengthTwo = valueTwo.length();
    int max = Math.max(lengthOne, lengthTwo);

    char[] bitsOne = fillBits(valueOne, max).toCharArray();
    char[] bitsTwo = fillBits(valueTwo, max).toCharArray();

    StringBuilder newValue = new StringBuilder();

    for (int i = 0; i < max; i++) {
      int bitOne = Integer.parseInt(String.valueOf(bitsOne[i]));
      int bitTwo = Integer.parseInt(String.valueOf(bitsTwo[i]));
      int newBit;

      switch (operator) {
        case "AND":
          newBit = bitOne * bitTwo;
          newValue.append(newBit);
          break;
        case "OR":
          newBit = bitOne == 0 && bitTwo == 0 ? 0 : 1;
          newValue.append(newBit);
          break;
        case "XOR":
          newBit = (bitOne == 1 && bitTwo == 0) ||
                  (bitOne == 0 && bitTwo == 1)
                  ? 1
                  : 0;
          newValue.append(newBit);
          break;
      }
    }

    return newValue.toString();
  }

  private static String fillBits(String value, int maxLength) {
    StringBuilder filledValue = new StringBuilder();
    int amountToFill = maxLength - value.length();

    for (int i = 0; i < amountToFill; i++) {
      filledValue.append(0);
    }

    return filledValue.append(value).toString();
  }
}
