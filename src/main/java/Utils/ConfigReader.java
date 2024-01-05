package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties loadProperties() {
        Properties prop = new Properties();
        try {

            FileInputStream file = new FileInputStream(new File( "src/test/resources/config/config.properties"));
            try {
                prop.load(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return prop;
    }
}
