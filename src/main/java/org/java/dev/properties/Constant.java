package org.java.dev.properties;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public enum Constant {
    FLYWAY_CONNECTION_URL ("org.flywaydb.url"),
    FLYWAY_USER ("org.flywaydb.user"),
    FLYWAY_PASSWORD ("org.flywaydb.password"),
    FLYWAY_MIGRATION_SQL_DIR ("org.flywaydb.migration.sql.dir"),
    FLYWAY_LOGGER ("org.flywaydb.logger"),
    CONNECTION_URL ("com.h2.url"),
    CONNECTION_USERNAME ("com.h2.user"),
    CONNECTION_PASSWORD ("com.h2.password"),
    LOG_PATTERN ("log4j.conversion.pattern"),
    LOG_FILE ("log4j.appender.file"),
    LOG_LEVEL ("log4j.logger.level"),
    LOG_ENCODING ("log4j.logger.encoding");




@Getter
    private final String propertyName;

public String getValue() {
    return PropertyService.getProperty(this);
}

}
