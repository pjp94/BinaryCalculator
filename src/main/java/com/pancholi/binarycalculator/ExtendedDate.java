package com.pancholi.binarycalculator;

class ExtendedDate {

  private final String day;
  private final String date;
  private final String time;

  ExtendedDate(String day, String date, String time) {
    this.day = day;
    this.date = date;
    this.time = time;
  }

  String getDay() {
    return day;
  }

  String getDate() {
    return date;
  }

  String getTime() {
    return time;
  }
}
