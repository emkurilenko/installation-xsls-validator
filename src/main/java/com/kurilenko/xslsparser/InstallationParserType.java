package com.kurilenko.xslsparser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InstallationParserType {

  CONTROLLER("Контроллеры", "Контроллер"),
  MULTIRATE_METER("Многотарифные счетчики", "Многотарифный счетчик"),
  LIGHT_FIXTURE("Светильники", "Светильник"),
  SENSOR("Датчик", "Датчик");

  private final String name;
  private final String type;

  public static InstallationParserType findByName(String value) {
    return Stream.of(InstallationParserType.values())
                 .filter(item -> item.name.equals(value))
                 .findFirst()
                 .orElseThrow();
  }

  public static List<String> getAllName() {
    return Stream.of(InstallationParserType.values())
                 .map(InstallationParserType::getType)
                 .collect(Collectors.toList());
  }
}
