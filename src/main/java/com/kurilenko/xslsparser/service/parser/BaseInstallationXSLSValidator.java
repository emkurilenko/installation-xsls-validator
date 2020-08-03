package com.kurilenko.xslsparser.service.parser;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType;
import org.apache.poi.ss.usermodel.Sheet;

public interface BaseInstallationXSLSValidator {

  void validate(Sheet sheet);

  InstallationParserType installationType();

  InstallationXSLSFileValidatorType validatorType();

}
