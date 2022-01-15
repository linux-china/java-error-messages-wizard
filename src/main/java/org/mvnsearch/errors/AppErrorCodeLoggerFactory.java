package org.mvnsearch.errors;

import org.slf4j.LoggerFactory;

public class AppErrorCodeLoggerFactory {
    public static AppErrorCodeLogger getLogger(Class<?> clazz) {
        return new AppErrorCodeLogger(LoggerFactory.getLogger(clazz));
    }

    public static AppErrorCodeLogger getLogger(String name) {
        return new AppErrorCodeLogger(LoggerFactory.getLogger(name));
    }

}
