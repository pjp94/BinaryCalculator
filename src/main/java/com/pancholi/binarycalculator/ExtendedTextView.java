package com.pancholi.binarycalculator;

import android.content.Context;
import android.util.AttributeSet;

public class ExtendedTextView
        extends android.support.v7.widget.AppCompatTextView
        implements TextField {

  public ExtendedTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void clear() {
    this.setText("");
  }
}
