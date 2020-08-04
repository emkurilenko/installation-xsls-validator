package com.kurilenko.xslsparser.service;

import static com.kurilenko.xslsparser.InstallationParserType.LIGHT_FIXTURE;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.config.dispatcher.Dispatcher;
import com.kurilenko.xslsparser.service.parser.BaseInstallationXSLSValidator;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExcelInstallationParser {

  private final Dispatcher<InstallationParserType, List<BaseInstallationXSLSValidator>> installationParserDispatcher;

  public void parseFile(InputStream file) {

    try (Workbook workbook = new XSSFWorkbook(file)) {
      for (Sheet sheet : workbook) {
        String sheetName = sheet.getSheetName();

        if (List.of(/*CONTROLLER.getName(), MULTIRATE_METER.getName(), */LIGHT_FIXTURE.getName()).contains(sheetName)) {
          InstallationParserType type = InstallationParserType.findByName(sheetName);
          installationParserDispatcher.getByName(type).forEach(validator -> validator.validate(sheet));
        }
      }

      try (OutputStream outputStream = new FileOutputStream(UUID.randomUUID() + ".xlsx")) {
        workbook.write(outputStream);
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

}
