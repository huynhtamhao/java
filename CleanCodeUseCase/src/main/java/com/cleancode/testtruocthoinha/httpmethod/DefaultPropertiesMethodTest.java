package com.cleancode.testtruocthoinha.httpmethod;

public class DefaultPropertiesMethodTest {

    protected String hostName;
    protected String hostPort;
    protected String connectionErrorMessage;

    DefaultPropertiesMethodTest(String hostName, String hostPort, String connectionErrorMessage) {
        this.hostName = hostName;
        this.hostPort = hostPort;
        this.connectionErrorMessage = connectionErrorMessage;
    }
}
