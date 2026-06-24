package main.java.config;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Properties properties =
            new Properties();

    static {

        try(InputStream input =
                    ApplicationConfig.class
                            .getClassLoader()
                            .getResourceAsStream(
                                    "application.properties")) {

            if(input != null) {
                properties.load(input);
            }

        } catch(Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}