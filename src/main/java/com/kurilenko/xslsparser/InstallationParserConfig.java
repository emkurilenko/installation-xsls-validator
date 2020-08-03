package com.kurilenko.xslsparser;

import static com.kurilenko.xslsparser.InstallationParserType.CONTROLLER;
import static com.kurilenko.xslsparser.InstallationParserType.LIGHT_FIXTURE;
import static com.kurilenko.xslsparser.InstallationParserType.MULTIRATE_METER;

import com.kurilenko.xslsparser.service.fieldcell.ControllerCellSheet;
import com.kurilenko.xslsparser.service.fieldcell.LightFixtureSheetCell;
import com.kurilenko.xslsparser.service.fieldcell.MultirateMeterCellSheet;
import com.kurilenko.xslsparser.service.parser.BaseInstallationXSLSValidator;
import com.kurilenko.xslsparser.service.parser.DefaultInstallationValueValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstallationParserConfig {

  @Bean
  public BaseInstallationXSLSValidator controllerInstallationValueCellValidator() {
    return new DefaultInstallationValueValidator(ControllerCellSheet.getAll(), CONTROLLER);
  }

  @Bean
  public BaseInstallationXSLSValidator multirateMeterInstallationValueCellValidator() {
    return new DefaultInstallationValueValidator(MultirateMeterCellSheet.getAll(), MULTIRATE_METER);
  }

  @Bean
  public BaseInstallationXSLSValidator lightFixtureInstallationValueCellValidator() {
    return new DefaultInstallationValueValidator(LightFixtureSheetCell.getAll(), LIGHT_FIXTURE);
  }

  @Bean
  public BaseInstallationXSLSValidator controllerInstallationHeaderNameValidator() {
    return new DefaultInstallationValueValidator(ControllerCellSheet.getAll(), CONTROLLER);
  }

  @Bean
  public BaseInstallationXSLSValidator multirateMeterInstallationHeaderNameValidator() {
    return new DefaultInstallationValueValidator(MultirateMeterCellSheet.getAll(), MULTIRATE_METER);
  }

  @Bean
  public BaseInstallationXSLSValidator lightFixtureInstallationHeaderNameValidator() {
    return new DefaultInstallationValueValidator(LightFixtureSheetCell.getAll(), LIGHT_FIXTURE);
  }

}
