package com.kurilenko.xslsparser.config.dispatcher;

import static io.netty.util.internal.ObjectUtil.checkNotNull;
import static java.util.stream.Collectors.toMap;

import com.kurilenko.xslsparser.InstallationParserType;
import com.kurilenko.xslsparser.service.parser.BaseInstallationXSLSValidator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstallationParserDispatcher implements Dispatcher<InstallationParserType,
    List<BaseInstallationXSLSValidator>> {

  private final Map<InstallationParserType, List<BaseInstallationXSLSValidator>> map;

  public InstallationParserDispatcher(List<BaseInstallationXSLSValidator> parsers) {
    this.map = parsers.stream().collect(Collectors.groupingBy(BaseInstallationXSLSValidator::installationType));
  }

  @Override
  public List<BaseInstallationXSLSValidator> getByName(InstallationParserType type) {
    return checkNotNull(map.get(type), "Cannot find InstallationParser for type = " + type);
  }
}
