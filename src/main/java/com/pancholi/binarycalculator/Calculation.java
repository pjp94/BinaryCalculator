package com.pancholi.binarycalculator;

class Calculation {

  private final String inputOne;
  private final String inputTwo;
  private final String result;
  private final String operator;

  Calculation(String inputOne, String inputTwo, String result, String operator) {
    this.inputOne = inputOne;
    this.inputTwo = inputTwo;
    this.result = result;
    this.operator = operator;
  }

  String getInputOne() {
    return inputOne;
  }

  String getInputTwo() {
    return inputTwo;
  }

  String getResult() {
    return result;
  }

  String getOperator() {
    return operator;
  }
}
