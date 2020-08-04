package com.kurilenko.xslsparser;

import static java.util.Objects.nonNull;

import com.kurilenko.xslsparser.service.ExcelInstallationParser;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XslsParserApplicationTests {


  @Autowired
  private ExcelInstallationParser parser;

  @Test
  void contextLoads() throws IOException {
    InputStream is = null;

    try {
      is = getClass().getResourceAsStream("/Шаблон3 с заполнением_1.xlsx");
      parser.parseFile(is);

    }
    finally {
      if (nonNull(is)) {
        is.close();
      }
    }

  }

}
