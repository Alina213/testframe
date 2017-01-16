package eb.core;

import eb.core.dataObjects.Country;
import eb.core.dataObjects.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentConfigProvider {
    public static final String ENVIRONMENT_NAME_PROPERTY_KEY = "eb.env";
    public static final String COUNTRY_NAME_PROPERTY_KEY = "eb.country";
    public static final String INPUT_TESTDATA_KEY = "eb.path";
    private static final String ENVS = "/environments/";
    private static final String PROPERTY_FILE_NAME = "environment.properties";

    public static EnvironmentConfig provide() {
        final String propertyFilePath = formEnvironmentPropertyFilePath(PROPERTY_FILE_NAME);
        final Properties envProperties = new Properties();
        try {
            envProperties.load(new FileInputStream(new File(PropertiesProcessor.getConfigurationFolderPath() + propertyFilePath)));
        } catch (Exception e) {
            throw new RuntimeException("File is not found" + e);
        }
        return fromProperties(envProperties);
    }

    public static EnvironmentConfig fromProperties(final Properties properties) {
        final EnvironmentConfig environmentConfig = EnvironmentConfig.getInstance();
        environmentConfig.setHostName(properties.getProperty(obtainCountryName()));
        environmentConfig.setDynAdminProductCatalog(properties.getProperty("dynAdminComponentProductCatalog"));
        return environmentConfig;
    }

    public static String formEnvironmentPropertyFilePath(final String fileName) {
        final StringBuilder builder = new StringBuilder();
        String envName = obtainEnvName();
        builder.append(ENVS).append(envName).append("/").append(envName).append("-").append(fileName);
        return builder.toString();
    }

    public static String obtainEnvName() {
        return Environment.getDefaultEnvironmentsByEnvName(System.getProperty(ENVIRONMENT_NAME_PROPERTY_KEY)).getEnvironmentName();
    }

    public static String obtainCountryName() {
        return Country.getCountryByName(System.getProperty(COUNTRY_NAME_PROPERTY_KEY)).getCountryName();
    }

    public static String obtainInputDataPathValue() {
        return System.getProperty(INPUT_TESTDATA_KEY);
    }
}
