package eb.core.dataObjects;

import org.apache.commons.lang3.StringUtils;

public enum Environment {
    QA1("qa1"), STAGE("stg3");

    private final String environmentName;

    Environment(final String envName) {
        environmentName = envName;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public static Environment getDefaultEnvironmentsByEnvName(final String envName) {
        if (StringUtils.isNotBlank(envName)) {
            for (final Environment env : Environment.values()) {
                if (env.getEnvironmentName().equalsIgnoreCase(envName)) {
                    return env;
                }
            }
        }
        return null;
    }

}
