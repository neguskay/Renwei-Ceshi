package parts.three.db;

import java.sql.*;

public class DbConnectionManager {

    private Connection dbConnection;



    public DbConnectionManager(String dbUrl, String dbUsername, String dbPassword)
            throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(dbUrl,dbUsername, dbPassword);

        //this.resultSet = this.statement.executeQuery(query);

        //this.dbConnection.close();

    }


    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }


}
