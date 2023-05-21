import org.java.dev.configuration.FlywayConfiguration;
import org.java.dev.configuration.LoggingConfiguration;
import org.java.dev.properties.Constant;
import org.java.dev.properties.PropertyService;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        new LoggingConfiguration();
        new FlywayConfiguration().setup();

    }

}
