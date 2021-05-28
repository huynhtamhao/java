package com.cleancode.common.errors;

public class LogicException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3662364177497963046L;
    
    public LogicException() {
        super();
    }
    
    public LogicException(String msg) {
        super(msg);
    }
}
