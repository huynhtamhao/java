package com.cleancode.testtruocthoinha;


import com.cleancode.common.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ABCSystemTest implements ExternalMethodTest {

    @Value("${cleancode.bridepattern.ip:localhost}")
    private String abcSysIp;

    @Value("${cleancode.bridepattern.port:8082}")
    private String abcSysPort;

    @Override
    public String getConnectionErrorMessage() {
        return MessageUtil.getConnectionErrorMessage("error.connection.message");
    }

    @Override
    public String getHostIp() {
        return this.abcSysIp;
    }

    @Override
    public String getHostPort() {
        return this.abcSysPort;
    }
}
