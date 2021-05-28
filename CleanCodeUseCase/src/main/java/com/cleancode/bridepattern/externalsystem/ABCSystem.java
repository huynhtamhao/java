package com.cleancode.bridepattern.externalsystem;


import com.cleancode.common.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Value;

public class ABCSystem extends ExternalSystem {

  @Value("${cleancode.bridepattern.ip:localhost}")
  private String abcSysIp;

  @Value("${cleancode.bridepattern.port:8082}")
  private String abcSysPort;

  @Override
  String getConnectionErrorMessage() {
    return MessageUtil.getConnectionErrorMessage("error.connection");
  }

  @Override
  String getHostIp() {
    return this.abcSysIp;
  }

  @Override
  String getHostPort() {
    return this.abcSysPort;
  }
}
