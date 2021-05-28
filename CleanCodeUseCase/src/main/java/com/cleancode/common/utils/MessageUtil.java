package com.cleancode.common.utils;

import com.cleancode.common.constants.MessageConstant;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class MessageUtil {

    private MessageUtil() {
        throw new IllegalStateException("Utility class");
    }

    @Autowired
    private static MessageSource messageSource;

    public static String getConnectionErrorMessage(String connectionErrorMessageCode) {
        return messageSource.getMessage(connectionErrorMessageCode, null,
            MessageConstant.CONNECTION_ERROR_USER_SYSTEM, Locale.getDefault());
    }
}
