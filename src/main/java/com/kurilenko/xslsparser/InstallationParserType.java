package com.kurilenko.xslsparser;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InstallationParserType {

  CONTROLLER("Контроллеры"),
  MULTIRATE_METER("Многотарифные счетчики"),
  LIGHT_FIXTURE("Светильники"),
  SENSOR("Датчик");

  private final String name;

  public static InstallationParserType findByName(String value) {
    return Stream.of(InstallationParserType.values())
                 .filter(item -> item.name.equals(value))
                 .findFirst()
                 .orElseThrow();
  }

}
