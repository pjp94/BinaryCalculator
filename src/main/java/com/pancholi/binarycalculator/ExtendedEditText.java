package com.pancholi.binarycalculator;

import android.content.Context;
import android.util.AttributeSet;

public class ExtendedEditText
        extends android.support.v7.widget.AppCompatEditText
        implements TextField {

  public ExtendedEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void clear() {
    this.setText("");
  }
}
