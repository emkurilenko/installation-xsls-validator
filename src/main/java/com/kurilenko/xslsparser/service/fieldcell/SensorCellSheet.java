package com.kurilenko.xslsparser.service.fieldcell;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SensorCellSheet implements SheetCell {

  STATUS("Статус", 0, "^.{1,128}$", true),
  NAME("Наименование", 1, "^.{1,128}$", true),
  IDENTIFIER("Идентификатор", 2, "^.{1,128}$", true),
  EQUIPMENT_TYPE("Тип оборудования", 3, "^.{1,128}$", true),
  VERSION_API("Версия API", 4, "^.{1,128}$", false),
  START_DATE("Дата начала эксплуатации", 9, "^.{1,128}$", false), //todo use another regExp
  ORGANIZATION("Эксплуатирующая организация", 10, "^.{1,128}$", false),
  OWNER("Собственник", 11, "", false);

  private final String name;

  private final int index;

  private final String regExp;

  private final boolean isRequired;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getIndex() {
    return index;
  }

  @Override
  public boolean isRequired() {
    return isRequired;
  }

  @Override
  public String regExp() {
    return regExp;
  }

  public static List<SensorCellSheet> getAll() {
    return List.of(SensorCellSheet.values());
  }

}
