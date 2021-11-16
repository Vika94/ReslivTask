package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    public static Properties getConfigProperties() {
        return getProperties("config");
    }

    private static Properties getProperties(String name) {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(name + ".properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}