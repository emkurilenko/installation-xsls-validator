package com.kurilenko.xslsparser.service.fieldcell;

//todo USE ONE interface
public interface SheetCell {

  String getName();

  int getIndex();

  boolean isRequired();

  String regExp();
}
