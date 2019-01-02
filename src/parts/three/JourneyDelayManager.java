package parts.three;

import parts.three.db.DbConnectionManager;
import parts.three.db.DbDefaults;
import utility.EasyIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class JourneyDelayManager {


    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList<JourneyRawDetail> delayDetailsRaw;

    private DbConnectionManager dbConnectionManager;
    private Connection dbConnection;

    public JourneyDelayManager(String filePath) throws IOException, SQLException, ClassNotFoundException {

        this.initReader(filePath);

        this.initDbConnection();

        this.initDbTables();

        //this.initDbDelayTable();


    }


    private void initReader(String filePath) throws IOException {
        this.fileReader = new FileReader(filePath);

        this.bufferedReader = new BufferedReader(this.fileReader);

        this.delayDetailsRaw = new ArrayList<>();

        String line;
        String[] rawLineSplit;

        while((line = this.bufferedReader.readLine()) != null) {

            //Problematic Line
            rawLineSplit = line.split(Pattern.quote("|"));

            JourneyRawDetail nextDetail = new JourneyRawDetail(rawLineSplit[0],
                    rawLineSplit[1], rawLineSplit[2],rawLineSplit[3],rawLineSplit[4]);


            this.delayDetailsRaw.add(nextDetail);
            //System.out.println(lines);
        }

        bufferedReader.close();

        System.out.println(this.delayDetailsRaw);
        System.out.println(this.delayDetailsRaw.size());

        // If you want to convert to a String[]
        //String[] data = this.delayDetailsRaw.toArray(new String[]{});
    }

    private void initDbConnection() throws SQLException, ClassNotFoundException {
        String dbName, userName, password, dbUrl, portNumber;

        dbName = DbDefaults.DEFAULT_DB_SCHEMA_NAME;
        userName = DbDefaults.DEFAULT_DB_USERNAME;
        password = DbDefaults.DEFAULT_DB_PASSWORD;
        portNumber = DbDefaults.DEFAULT_DB_PORT_NUMBER;

        System.out.println("Would you like to alter the db config?");

        if(EasyIn.getString().equalsIgnoreCase("Y")){
            System.out.println("Please Enter the details for the DB");
            dbName = this.getUserDbDetails("Schema Name");
            userName = this.getUserDbDetails("User Name");
            password = this.getUserDbDetails("Password");
            portNumber = this.getUserDbDetails("Port Number");
        }



        dbUrl = "jdbc:mysql://localhost:"+portNumber+"/"+dbName+"?useSSL=false";

        this.dbConnectionManager = new DbConnectionManager(dbUrl, userName, password);
        this.dbConnection = this.dbConnectionManager.getDbConnection();

    }

    private void initDbTables() throws SQLException {
        //Added all Journey Objects to the journey table in db
        this.initDbJourneyTable();

        //Add all Delay Objects to the delay table in the db
        this.initDbDelayTable();
    }

    private void initDbJourneyTable() throws SQLException {
        //int count = 1;

        PreparedStatement preparedStatement =
                this.dbConnection.prepareStatement(DbDefaults.DEFAULT_SQL_QUERY_INSERT_JOURNEYS);


        for (JourneyRawDetail nextDetail: this.delayDetailsRaw) {

            //preparedStatement.setInt(1,count);
            preparedStatement.setString(1, nextDetail.trainId);
            preparedStatement.setString(2, DbDefaults.DEFAULT_STATION_NOT_FOUND);
            preparedStatement.setString(3, DbDefaults.DEFAULT_STATION_NOT_FOUND);
            preparedStatement.setString(4, nextDetail.driverName);

            if(nextDetail.lateness.equalsIgnoreCase(DbDefaults.DEFAULT_JOURNEY_NA)) {

                preparedStatement.setString(5, DbDefaults.DEFAULT_JOURNEY_COMPLETED);

            } else {
                preparedStatement.setString(5, DbDefaults.DEFAULT_JOURNEY_IN_PROGRESS);
            }

            preparedStatement.execute();

            //count++;
        }

    }

    private void initDbDelayTable() throws SQLException {
        //int count = 1;

        PreparedStatement preparedStatement =
                this.dbConnection.prepareStatement(DbDefaults.DEFAULT_SQL_QUERY_INSERT_DELAYS);

        for (JourneyRawDetail nextDetail: this.delayDetailsRaw) {

            //preparedStatement.setInt(1, count);
            preparedStatement.setString(1, nextDetail.trainId);
            preparedStatement.setString(2, nextDetail.currentStation);
            preparedStatement.setString(3, nextDetail.departureTimeActual);
            preparedStatement.setString(4, nextDetail.lateness);

            preparedStatement.execute();

            //count++;
        }

    }

    private void clearAllDbTables(){

    }

    private String getUserDbDetails(String keyWord){
        System.out.println("Please Enter your mySQL Database " + keyWord + " :");
        return EasyIn.getString();
    }

}
