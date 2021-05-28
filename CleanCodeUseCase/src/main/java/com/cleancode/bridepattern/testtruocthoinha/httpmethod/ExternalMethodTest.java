package com.cleancode.bridepattern.testtruocthoinha.httpmethod;

public interface ExternalMethodTest {

    String getHostName();
    String getHostPort();
    String getConnectionErrorMessage();

    default PutMethodTest putMethod() {
        return new PutMethodTest(this.getHostName(), this.getHostPort(), this.getConnectionErrorMessage());
    }

    default PostMethodTest postMethod() {
        return new PostMethodTest(this.getHostName(), this.getHostPort(), this.getConnectionErrorMessage());
    }
}
