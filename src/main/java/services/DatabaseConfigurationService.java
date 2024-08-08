package services;
import config.DatabaseConfig;
public class DatabaseConfigurationService {

    public boolean findDbByCredentials(String dbHost, String dbPort, String dbUrl, String dbUser, String dbPassword) {
        System.out.println("public boolean findDbByCredentials(String dbHost, String dbPort, String dbUrl, String dbUser, String dbPassword)");
        boolean hostMatches = dbHost.equals(DatabaseConfig.getDbHost());
        boolean portMatches = dbPort.equals(DatabaseConfig.getDbPort());
        boolean urlMatches = dbUrl.equals(DatabaseConfig.getDbUrl());
        boolean userMatches = dbUser.equals(DatabaseConfig.getDbUser());
        boolean passwordMatches = dbPassword.equals(DatabaseConfig.getDbPassword());

        // Ritorna true se tutti i parametri corrispondono, altrimenti false
        return hostMatches && portMatches && urlMatches && userMatches && passwordMatches;
    }



}
