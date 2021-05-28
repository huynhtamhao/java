package com.cleancode.testtruocthoinha;

public interface ExternalMethodTest {

    String getHostIp();
    String getHostPort();
    String getConnectionErrorMessage();

    default PutMethodTest putMethod() {
        return new PutMethodTestImpl(this.getHostIp(), this.getHostPort(), this.getConnectionErrorMessage());
    }

    default PostMethodTest postMethod() {
        return new PostMethodTestImpl(this.getHostIp(), this.getHostPort(), this.getConnectionErrorMessage());
    }
}
