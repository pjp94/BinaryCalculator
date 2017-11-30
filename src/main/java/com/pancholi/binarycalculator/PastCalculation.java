package com.pancholi.binarycalculator;

import java.util.Locale;

class PastCalculation {

  private final ExtendedDate dateTime;
  private final Calculation calculation;

  PastCalculation(String dateTime, Calculation calculation) {
    this.dateTime = formatDateTime(dateTime);
    this.calculation = calculation;
  }

  private ExtendedDate formatDateTime(String dateTime) {
    String[] values = dateTime.split(" ");

    String day = values[0];
    String date = String.format(Locale.getDefault(), "%s %s, %s", values[1], values[2], values[5]);
    String time = formatTime(values[3]);

    return new ExtendedDate(day, date, time);
  }

  private String formatTime(String time) {
    String[] values = time.split(":");
    int hour = Integer.parseInt(values[0]);
    int minutes = Integer.parseInt(values[1]);

    if (hour > 12) {
      hour = hour - 12;
    }

    return String.format(Locale.getDefault(), "%d:%d", hour, minutes);
  }

  ExtendedDate getDateTime() {
    return dateTime;
  }

  Calculation getCalculation() {
    return calculation;
  }
}
