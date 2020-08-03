package com.kurilenko.xslsparser.service.parser;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class AbstractInstallationXSLSValidator {

  protected DataFormatter dataFormatter = new DataFormatter();

  protected void setForegroundColor(Cell cell, IndexedColors color) {
    CellStyle newCellStyle = cell.getSheet().getWorkbook().createCellStyle();
    newCellStyle.cloneStyleFrom(cell.getCellStyle());
    newCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    newCellStyle.setFillForegroundColor(color.getIndex());
    cell.setCellStyle(newCellStyle);
  }

  protected void setForegroundColor(Row row, IndexedColors color) {
    CellStyle newRowStyle = row.getSheet().getWorkbook().createCellStyle();
    newRowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    newRowStyle.setFillForegroundColor(color.getIndex());
    row.setRowStyle(newRowStyle);
  }
}
