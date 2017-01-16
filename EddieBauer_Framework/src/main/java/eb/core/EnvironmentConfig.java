package eb.core;

public class EnvironmentConfig {
    private String hostName;
    private String dynAdminProductCatalog;
    private static EnvironmentConfig instance;
    private EnvironmentConfig(){
    }
    public static EnvironmentConfig getInstance(){
        if (instance == null){
            instance = new EnvironmentConfig();
        }
        return instance;
    }
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDynAdminProductCatalog() {
        return dynAdminProductCatalog;
    }

    public void setDynAdminProductCatalog(String dynAdminProductCatalog) {
        this.dynAdminProductCatalog = dynAdminProductCatalog;
    }

}
