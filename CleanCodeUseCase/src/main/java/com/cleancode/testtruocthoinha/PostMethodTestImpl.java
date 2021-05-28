package com.cleancode.testtruocthoinha;

public class PostMethodTestImpl implements PostMethodTest {

    private final String hostName;
    private final String hostPort;
    private final String connectionErrorMessage;

    PostMethodTestImpl(String hostName, String hostPort, String connectionErrorMessage) {
        this.hostName = hostName;
        this.hostPort = hostPort;
        this.connectionErrorMessage = connectionErrorMessage;
    }
}
