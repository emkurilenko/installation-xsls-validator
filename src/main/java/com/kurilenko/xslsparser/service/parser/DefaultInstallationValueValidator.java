package com.kurilenko.xslsparser.service.parser;

import static com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType.VALUE_CELL_VALIDATOR;
import static java.util.Optional.ofNullable;
import static org.apache.poi.ss.usermodel.CellType.BLANK;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.config.dispatcher.InstallationXSLSFileValidatorType;
import com.kurilenko.xslsparser.service.fieldcell.SheetCell;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


@RequiredArgsConstructor
public class DefaultInstallationValueValidator extends AbstractInstallationXSLSValidator implements
    BaseInstallationXSLSValidator {

  private final List<SheetCell> cells;
  private final InstallationParserType installationType;

  @Override
  public void validate(Sheet sheet) {

    int currentRowIndex = 2;
    int rowsAmount = sheet.getPhysicalNumberOfRows();

    while (currentRowIndex < rowsAmount) {
      Row currentRow = sheet.getRow(currentRowIndex);
      if (Objects.nonNull(currentRow)) {
        cells.forEach(item -> {
          Cell cell = ofNullable(currentRow.getCell(item.getIndex()))
              .orElseGet(() -> currentRow.createCell(item.getIndex(), BLANK));
          String value = dataFormatter.formatCellValue(cell);

          if (item.isRequired()) {
            if (value.isEmpty() || !value.matches(item.regExp())) {
              setForegroundColor(cell, IndexedColors.RED1);
            }
          }
          if (!value.isEmpty() && !value.matches(item.regExp())) {

            if(item.getName().equals("Дата начала эксплуатации")){
              System.out.println("qwerty");
            }

            setForegroundColor(cell, IndexedColors.RED1);
          }
        });
      }
      else {
        Row newRow = sheet.createRow(currentRowIndex);
        setForegroundColor(newRow, IndexedColors.RED1);
      }
      currentRowIndex++;
    }

  }

  @Override
  public InstallationParserType installationType() {
    return installationType;
  }

  @Override
  public InstallationXSLSFileValidatorType validatorType() {
    return VALUE_CELL_VALIDATOR;
  }
}
