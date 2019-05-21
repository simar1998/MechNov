package database;

import java.sql.Connection;

public class DatabaseConfig {

    public static Connection localMySQL;
    public static DatabaseConnector localConnector = new DatabaseConnector();

    public static Connection getLocalMySQLConn(){

        localConnector.setDatabaseName("cloud_engine");
        localConnector.setIp("localhost");
        localConnector.setUserName("cloud_engine");
        localConnector.setUserPassword("mechsoljavaapp123");
        localConnector.loadJDBCDriver();
        localMySQL = localConnector.getConnection();

        return  localMySQL;
    }
}
