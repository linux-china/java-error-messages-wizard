package org.mvnsearch.errors;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

public class AppErrorCodeLoggerTest {
    private static final AppErrorCodeLogger log = new AppErrorCodeLogger(LoggerFactory.getLogger(AppErrorCodeLoggerTest.class));

    @Test
    public void testErrorMessage() {
        System.out.println(AppErrorCodeLogger.errorMessage("APP-100-400","korin_heardi@bye.aqi"));
    }
    @Test
    public void testPrintErrorMessage() {
        log.info("APP-100-400", "demo@example.com");
    }

    @Test
    public void testMessageFormat() {
        final FormattingTuple tuple = MessageFormatter.format("Hi {}", "good");
        System.out.println(tuple.getMessage());
    }
}
