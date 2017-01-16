package eb.core;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesProcessor {

    public static String getCommonFolderPath()  {
        try {
            return new File(".").getCanonicalPath();
        } catch (IOException e) {
            return ".." + File.separator;
        }
    }

    public static String getResourcesDir(){
        return getCommonFolderPath() + File.separator + "selenium";
    }

    public static String getConfigurationFolderPath(){
            return getResourcesDir() + File.separator + "config/eb/";
    }
}
