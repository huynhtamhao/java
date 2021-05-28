package com.cleancode.bridepattern.testtruocthoinha.externalsystem;


import com.cleancode.common.utils.MessageUtil;
import com.cleancode.bridepattern.testtruocthoinha.httpmethod.ExternalMethodTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IJKSystemTest implements ExternalMethodTest {

    @Value("${ikj.ip:localhost}")
    private String hostName;

    @Value("${ikj.port:8082}")
    private String hostPort;

    @Override
    public String getConnectionErrorMessage() {
        return MessageUtil.getConnectionErrorMessage("error.connection.message");
    }

    @Override
    public String getHostName() {
        return this.hostName;
    }

    @Override
    public String getHostPort() {
        return this.hostPort;
    }
}
