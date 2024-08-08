package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "C:/Users/domenico/IdeaProjects/turing3/src/config.properties"; // Assicurati che il percorso sia corretto
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    private static String dbPort;
    private static String dbHost;

    static {
        System.out.println("static block in DatabaseConfig:Loading database configuration...");
        loadConfig();
    }

    private static void loadConfig() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
            dbUrl = props.getProperty("db.url");
            dbUser = props.getProperty("db.user");
            dbPassword = props.getProperty("db.password");
            dbHost = props.getProperty("db.host");
            dbPort = props.getProperty("db.port"); // Assicurati che queste chiavi corrispondano a quelle nel tuo file config.properties
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unable to load database configurations: " + ex.getMessage());
        }
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static String getDbHost() {
        return dbHost;
    }
}
