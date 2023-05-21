package org.java.dev.configuration;

import org.apache.log4j.*;
import org.java.dev.properties.Constant;

import java.util.Properties;

public class LoggingConfiguration {

    private static final Properties PROPERTIES = new Properties();

    static {

        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern(Constant.LOG_PATTERN.getValue());

        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.setEncoding(Constant.LOG_ENCODING.getValue());
        consoleAppender.activateOptions();

        DailyRollingFileAppender rollingFileAppender = new DailyRollingFileAppender();
        rollingFileAppender.setEncoding(Constant.LOG_ENCODING.getValue());
        rollingFileAppender.setFile(Constant.LOG_FILE.getValue());
        rollingFileAppender.setLayout(layout);
        rollingFileAppender.setDatePattern("'.'yyyy-MM-dd");
        rollingFileAppender.activateOptions();

        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.toLevel(Constant.LOG_LEVEL.getValue()));
        rootLogger.removeAllAppenders();
        rootLogger.addAppender(consoleAppender);
        rootLogger.addAppender(rollingFileAppender);
    }
}

