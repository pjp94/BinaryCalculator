package com.pancholi.binarycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.textInputOne)
  EditText textInputOne;
  @BindView(R.id.textInputTwo)
  EditText textInputTwo;
  @BindView(R.id.textOperator)
  TextView textOperator;
  @BindView(R.id.textResult)
  TextView textResult;

  boolean isOperationComplete = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    textInputOne.setInputType(InputType.TYPE_NULL);
    textInputTwo.setInputType(InputType.TYPE_NULL);
    textResult.setInputType(InputType.TYPE_NULL);
  }

  @OnClick(R.id.buttonZero)
  void pressZero() {
    enterBit(0);
  }

  @OnClick(R.id.buttonOne)
  void pressOne() {
    enterBit(1);
  }

  private void enterBit(int value) {
    if (textResult.getText().length() > 0 && isOperationComplete) {
      resetFields();
      textOperator.setText("");
    }

    if (textInputTwo.hasFocus()) {
      String currentValue = textInputTwo.getText().toString();
      String newValue = value + currentValue;
      textInputTwo.setText(newValue);
    } else {
      String currentValue = textInputOne.getText().toString();
      String newValue = value + currentValue;
      textInputOne.setText(newValue);
    }

    isOperationComplete = false;
  }

  private void resetFields() {
    clearAllText();
    textInputOne.setTextColor(getResources().getColor(R.color.color_accent));
    textInputTwo.setTextColor(getResources().getColor(R.color.color_accent));
  }

  @OnClick(R.id.buttonDelete)
  void delete() {
    if (textResult.getText().length() > 0) {
      clear();
    } else {
      deleteSingleBit(textInputOne.hasFocus() ? textInputOne : textInputTwo);
    }
  }

  private void deleteSingleBit(TextView inputField) {
    String currentValue = inputField.getText().toString();

    if (!currentValue.isEmpty()) {
      String newValue = currentValue.substring(1);
      inputField.setText(newValue);
    }
  }

  @OnLongClick(R.id.buttonDelete)
  boolean clear() {
    resetFields();
    textOperator.setText("");
    textInputOne.requestFocus();
    return true;
  }

  private void clearAllText() {
    textInputOne.setText("");
    textInputTwo.setText("");
    textResult.setText("");
  }

  @OnClick(R.id.buttonAdd)
  void add() {
    beginOperation("+");
  }

  @OnClick(R.id.buttonSubtract)
  void subtract() {
    beginOperation("-");
  }

  @OnClick(R.id.buttonMultiply)
  void multiply() {
    beginOperation("×");
  }

  @OnClick(R.id.buttonDivide)
  void divide() {
    beginOperation("÷");
  }

  @OnClick(R.id.buttonNot)
  void negate() {
    String inputValueOne = textInputOne.getText().toString();
    String inputValueTwo = textInputTwo.getText().toString();
    String resultValue = textResult.getText().toString();
    String error = getResources().getString(R.string.error);
    String valueToNegate;
    String newValue;

    if (!inputValueOne.isEmpty() && inputValueTwo.isEmpty() && !isOperationComplete) {
      valueToNegate = inputValueOne;
      textInputOne.setTextColor(getResources().getColor(R.color.text_inactive));
    } else if (inputValueOne.isEmpty() && !inputValueTwo.isEmpty() && !isOperationComplete) {
      valueToNegate = inputValueTwo;
      textInputTwo.setTextColor(getResources().getColor(R.color.text_inactive));
    } else if ((inputValueOne.isEmpty() && inputValueTwo.isEmpty() && !resultValue.isEmpty()) &&
               (!resultValue.isEmpty() && isOperationComplete)) {
      valueToNegate = resultValue;
    } else if (!inputValueOne.isEmpty() && !inputValueTwo.isEmpty()) {
      valueToNegate = error;
      textInputOne.setTextColor(getResources().getColor(R.color.text_inactive));
      textInputTwo.setTextColor(getResources().getColor(R.color.text_inactive));
    } else {
      valueToNegate = "";
    }

    textOperator.setText("~");

    newValue = !valueToNegate.equals(error) && !valueToNegate.isEmpty()
            ? BinaryOperations.negateValue(valueToNegate)
            : valueToNegate;

    textResult.setText(newValue);
    isOperationComplete = true;
  }

  @OnClick(R.id.buttonAnd)
  void and() {
    beginOperation("&");
  }

  @OnClick(R.id.buttonOr)
  void or() {
    beginOperation("|");
  }

  @OnClick(R.id.buttonXor)
  void xor() {
    beginOperation("^");
  }

  private void beginOperation(String operator) {
    String inputOne = textInputOne.getText().toString();
    String inputTwo = textInputTwo.getText().toString();

    switch (operator) {
      case "+":
      case "-":
      case "×":
      case "÷":
        textOperator.setText(operator);
        break;
      case "&":
        textOperator.setText(getResources().getString(R.string.and));
        break;
      case "|":
        textOperator.setText(getResources().getString(R.string.or));
        break;
      case "^":
        textOperator.setText(getResources().getString(R.string.xor));
        break;
    }

    String previousResult = textResult.getText().toString();

    if (!previousResult.isEmpty() &&
            !previousResult.equals(getResources().getString(R.string.error))) {
      resetFields();
      textInputOne.setText(previousResult);
      textInputTwo.requestFocus();
    } else if (!inputOne.isEmpty() && inputTwo.isEmpty()) {
      textInputTwo.requestFocus();
    } else  {
      textInputOne.requestFocus();
    }
  }

  @OnClick(R.id.buttonEquals)
  void equals() {
    String valueOne = textInputOne.getText().toString();
    String valueTwo = textInputTwo.getText().toString();

    if (!valueOne.isEmpty() && !valueTwo.isEmpty()) {
      textInputOne.setTextColor(getResources().getColor(R.color.text_inactive));
      textInputTwo.setTextColor(getResources().getColor(R.color.text_inactive));
      textInputOne.clearFocus();
      textInputTwo.clearFocus();

      String operator = textOperator.getText().toString();
      String newValue = BinaryOperations.completeOperation(valueOne, valueTwo, operator);

      textResult.setText(newValue);
      isOperationComplete = true;
    }
  }
}
