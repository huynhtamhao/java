package com.cleancode.bridepattern.testtruocthoinha.httpmethod;

public abstract class DefaultMethodTest implements MethodTest {

    protected String hostName;
    protected String hostPort;
    protected String connectionErrorMessage;

    DefaultMethodTest(String hostName, String hostPort, String connectionErrorMessage) {
        this.hostName = hostName;
        this.hostPort = hostPort;
        this.connectionErrorMessage = connectionErrorMessage;
    }
}
