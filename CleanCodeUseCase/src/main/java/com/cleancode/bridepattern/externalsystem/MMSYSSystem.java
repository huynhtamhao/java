package com.cleancode.bridepattern.externalsystem;

import com.cleancode.common.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MMSYSSystem extends ExternalSystem {

    @Value("${fanatic.material-system.ip:localhost}")
    private String materialSysIp;

    @Value("${fanatic.material-system.port:8083}")
    private String materialSysPort;

    @Override
    String getConnectionErrorMessage() {
        return MessageUtil.getConnectionErrorMessage("error.material.system.connect");
    }

    @Override
    String getHostIp() {
        return null;
    }

    @Override
    String getHostPort() {
        return null;
    }
}
