package com.kurilenko.xslsparser.service.fieldcell;

import com.kurilenko.xslsparser.InstallationParserType;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ControllerCellSheet implements SheetCell {

  STATUS("Статус", 0, "^.{1,128}$", true),
  NAME("Наименование", 1, "^.{1,128}$", true),
  IDENTIFIER("Идентификатор", 2, "^.{1,128}$", true),
  EQUIPMENT_TYPE("Тип оборудования", 3, "^.{1,128}$", true),
  MODEL_MARK("Модель\\ марка", 4, "^.{1,128}$", false),
  PROCEDURE_SUPPLIER("Производитель \\ Поставщик", 5, "^.{1,128}$", false),
  PARENT_IDENTIFIER("Идентификатор родителя", 6, "^.{1,128}$", false),
  PARENT_TYPE("Тип родителя", 7, String.join("|", InstallationParserType.getAllName()), false),
  WORKING_TEMPERATURE_RANGE("Диапазон рабочей температуры", 8, "^.{1,128}$", false),
  WORKING_VOLTAGE_RANGE("Диапазон рабочего напряжения", 9, "^.{1,128}$", false),
  POWER_CONSUMPTION("Потребляемая мощность", 10, "^.{1,128}$", true),
  START_DATE("Дата начала эксплуатации", 11, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", true),
  ORGANIZATION("Эксплуатирующая организация", 12, "^.{1,128}$", false),
  OWNER("Собственник", 13, "^.{1,128}$", false),
  GUARANTEE_PERIOD("Гарантийный срок", 14, "^.{1,128}$", false),
  LIFE_TIME("Срок службы", 15, "^.{1,128}$", true),
  PROJECT("Проект", 16, "^.{1,128}$", false),
  LATITUDE("Географическая широта", 17, "^(-?\\d+(\\.\\d+)?).\\s*(-?\\d+(\\.\\d+)?)$", true),
  LONGITUDE("Географическая долгота", 18, "^(-?\\d+(\\.\\d+)?).\\s*(-?\\d+(\\.\\d+)?)$", true),
  INSPECTION_DATE("Дата осмотра", 19, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  BYPASS_DATE("Дата объезда", 20, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  MAINTENANCE_DATE("Дата технического обслуживания", 21,
      "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  REPAIR_DATE("Дата ремонта", 22, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  GUARANTEE_EXPIRATION_DATE("Дата окончания гарантии", 23,
      "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$",
      false);
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

  public static List<SheetCell> getAll() {
    return List.of(ControllerCellSheet.values());
  }

}
