package com.kurilenko.xslsparser.service.fieldcell;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LightFixtureSheetCell implements SheetCell {

  STATUS("Статус", 0, "^.{1,128}$", true),
  NAME("Наименование", 1, "^.{1,128}$", true),
  IDENTIFIER("Идентификатор", 2, "^.{1,128}$", true),
  EQUIPMENT_TYPE("Тип оборудования", 3, "^.{1,128}$", false),
  LAMP_TYPE("Тип светильника", 4, "^.{1,128}$", false),
  MODEL_MARK("Модель\\ марка", 5, "^.{1,128}$", false),
  PROCEDURE_SUPPLIER("Производитель", 6, "^.{1,128}$", false),
  PARENT_IDENTIFIER("Идентификатор родителя", 7, "^.{1,128}$", false),
  PARENT_TYPE("Тип родителя", 8, "^.{1,128}$", false),
  UTILITY_POLE_IDENTIFIER("Идентификатор опоры", 9, "^.{1,128}$", false),
  WORKING_TEMPERATURE_RANGE("Диапазон рабочей температуры", 10, "^.{1,128}$", false),
  POWER_CONSUMPTION("Потребляемая мощность", 11, "^.{1,128}$", true),
  WORKING_VOLTAGE_RANGE("Диапазон рабочего напряжения", 12, "^.{1,128}$", false),
  LIGHT_OUTPUT("Световой поток", 13, "^.{1,128}$", false),
  COLOUR_TEMPERATURE("Цветовая температура", 14, "^.{1,128}$", false),
  COLOUR_RENDERING_INDEX("Индекс цветопередачи", 15, "^.{1,128}$", false),
  LAMP_EFFICIENCY("Эффективность светильника", 16, "^.{1,128}$", false),
  SCATTERING_ANGLE("Угол рассеивания", 17, "^.{1,128}$", false),
  LIGHT_INTENSITY_DISTRIBUTION_CURVE_TYPE("Тип КСС", 18, "^.{1,128}$", false),
  FLICKER_PERCENT("Коэффициент пульсации", 19, "^.{1,128}$", false),
  START_DATE("Дата начала эксплуатации", 20, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", true),
  ORGANIZATION("Эксплуатирующая организация", 21, "^.{1,128}$", false),
  OWNER("Собственник", 22, "^.{1,128}$", false),
  GUARANTEE_PERIOD("Гарантийный срок", 23, "^.{1,128}$", false),
  LIFE_TIME("Срок службы", 24, "^.{1,128}$", true),
  PROJECT("Проект", 25, "^.{1,128}$", false),
  LATITUDE("Географическая широта", 26, "^(-?\\d+(\\.\\d+)?).\\s*(-?\\d+(\\.\\d+)?)$", true),
  LONGITUDE("Географическая долгота", 27, "^(-?\\d+(\\.\\d+)?).\\s*(-?\\d+(\\.\\d+)?)$", true),
  REGION("Регион", 28, "^.{1,128}$", false),
  CITY("Город", 29, "^.{1,128}$", false),
  LIGHTING_CATEGORY("Категория объекта освещения", 30, "^.{1,128}$", false),
  IMPORTANCE("Важность объекта", 31, "^.{1,128}$", false),
  WORK_MODE("Режим работы", 32, "^.{1,128}$", false),
  LAMP_INSTALLATION_HEIGHT("Высота установки светильника в метрах", 33, "^.{1,128}$", false),
  OVERHANG_HEIGHT("Свес световой точки в метрах", 34, "^.{1,128}$", false),
  LAMP_ANGLE("Наклон световой точки в градусах", 35, "^.{1,128}$", false),
  OVERHANG_LENGTH("Длина консоли в метрах", 36, "^.{1,128}$", false),
  UTILITY_POLE_LAMP_POSITION("Позиция светильника в плане на опоре в градусах", 37, "^.{1,128}$", false),
  INSPECTION_DATE("Дата осмотра", 38, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  BYPASS_DATE("Дата объезда", 39, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  MAINTENANCE_DATE("Дата технического обслуживания", 40,
      "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  REPAIR_DATE("Дата ремонта", 41, "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  CAPITAL_REPAIR_DATE("Дата капитального ремонта", 42,
      "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false),
  GUARANTEE_EXPIRATION_DATE("Дата окончания гарантии", 43,
      "^(([1-9])|(1[0-2]|0[1-9]))/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$", false);

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
    return List.of(LightFixtureSheetCell.values());
  }


}
