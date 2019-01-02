package parts.three.db;

public class DbDefaults {

    public static final String DEFAULT_DB_USERNAME = "root";
    public static final String DEFAULT_DB_PASSWORD = "";
    public static final String DEFAULT_DB_DRIVER_URL = "jdbc:mysql://localhost:3306/renwei-ceshi?useSSL=false";
    public static final String DEFAULT_DB_SCHEMA_NAME = "renwei_ceshi_db";
    public static final String DEFAULT_DB_PORT_NUMBER = "3306";

    public static final String DEFAULT_STATION_NOT_FOUND = "NOT FOUND";

    public static final String DEFAULT_JOURNEY_NA = "NA";
    public static final String DEFAULT_JOURNEY_COMPLETED = "COMPLETED";
    public static final String DEFAULT_JOURNEY_IN_PROGRESS = "IN PROGRESS";

    //Select statements
    public static final String DEFAULT_SQL_QUERY_GET_ALL_DELAYS = "SELECT * FROM train_delay_details";

    public static final String DEFAULT_SQL_QUERY_GET_ALL_JOURNEYS= "SELECT * FROM train_driver_details";


    //Insert Statements
    public static final String DEFAULT_SQL_QUERY_INSERT_DELAYS=
            " insert into train_delay_details (train_id, station, departure_time, lateness) " +
            "values (?, ?, ?, ?)";

    public static final String DEFAULT_SQL_QUERY_INSERT_JOURNEYS=
            "insert into train_driver_details (train_id, start_station, destination_station, driver_name, journey_status) " +
            "values (?, ?, ?, ?, ?)";


}
