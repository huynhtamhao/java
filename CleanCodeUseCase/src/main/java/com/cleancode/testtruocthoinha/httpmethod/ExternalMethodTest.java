package com.cleancode.testtruocthoinha.httpmethod;

public interface ExternalMethodTest {

    String getHostName();
    String getHostPort();
    String getConnectionErrorMessage();

    default PutMethodTest putMethod() {
        return new PutMethodTestImpl(this.getHostName(), this.getHostPort(), this.getConnectionErrorMessage());
    }

    default PostMethodTest postMethod() {
        return new PostMethodTestImpl(this.getHostName(), this.getHostPort(), this.getConnectionErrorMessage());
    }
}
