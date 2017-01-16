package eb.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static Properties globalConfig;

    public static Properties loadProperties(String path) throws IOException {
        Properties result = new Properties();
        result.load(new FileInputStream(path));
        return result;
    }

    public static void readAllProperties(String path) throws Exception {
        try {
            globalConfig = loadProperties(path);
        } catch (IOException e) {
            throw new Exception("Error while reading properties");
        }

    }

    public static String getProperty(String path, String key) throws Exception {
        readAllProperties(path);
        if (globalConfig.containsKey(key)) {
            return globalConfig.getProperty(key);
        }
       throw new Exception("Property: '" + key + "' was NOT found");
    }
}
