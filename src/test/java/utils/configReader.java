package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    private static Properties properties;
    static  {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testData/config.properties");
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("Failed to load configuration file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
