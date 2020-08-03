package com.kurilenko.xslsparser.service.parser;

import static com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType.PARENT_VALIDATOR;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType;
import org.apache.poi.ss.usermodel.Sheet;

public class DefaultInstallationParentValidator extends AbstractInstallationXSLSValidator implements
    BaseInstallationXSLSValidator {

  @Override
  public void validate(Sheet sheet) {

  }

  @Override
  public InstallationParserType installationType() {
    return null;
  }

  @Override
  public InstallationXSLSFileValidatorType validatorType() {
    return PARENT_VALIDATOR;
  }
}
