package org.java.dev.configuration;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.java.dev.properties.Constant;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class FlywayConfiguration {
    private Flyway flyway;
    public FlywayConfiguration setup() throws IOException {

        String url = Constant.FLYWAY_CONNECTION_URL.getValue();
        String username = Constant.FLYWAY_USER.getValue();
        String password = Constant.FLYWAY_PASSWORD.getValue();

        Location migrations = new Location(Constant.FLYWAY_MIGRATION_SQL_DIR.getValue());

        flyway = Flyway.configure()
                .encoding(StandardCharsets.UTF_8)
                .locations(migrations)
                .dataSource(url, username, password)
                .loggers(Constant.FLYWAY_LOGGER.getValue())
                .sqlMigrationPrefix("V")
                .createSchemas(false)
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .placeholderReplacement(false)
                .failOnMissingLocations(true)
                .load();
        return this;
    }
    public void migrate() {
        flyway.migrate();
    }
}
