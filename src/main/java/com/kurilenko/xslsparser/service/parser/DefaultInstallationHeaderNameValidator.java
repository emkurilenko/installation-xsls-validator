package com.kurilenko.xslsparser.service.parser;

import static com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType.HEADER_NAME_VALIDATOR;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType;
import com.kurilenko.xslsparser.service.fieldcell.SheetCell;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@RequiredArgsConstructor
public class DefaultInstallationHeaderNameValidator extends AbstractInstallationXSLSValidator implements
    BaseInstallationXSLSValidator {

  private final List<SheetCell> cells;
  private final InstallationParserType installationType;

  @Override
  public Boolean validate(Sheet sheet) {

    int nameRowIndex = 1;
    Row row = sheet.getRow(nameRowIndex);

    cells.forEach(item -> {
      Cell cell = row.getCell(item.getIndex());
      String value = dataFormatter.formatCellValue(cell);
      if (!item.getName().equals(value)) {
        setForegroundColor(cell, IndexedColors.RED1);
      }
    });

    return true;
  }

  @Override
  public InstallationParserType installationType() {
    return installationType;
  }

  @Override
  public InstallationXSLSFileValidatorType validatorType() {
    return HEADER_NAME_VALIDATOR;
  }
}
