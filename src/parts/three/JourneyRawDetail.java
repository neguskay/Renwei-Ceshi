package parts.three;

public class JourneyRawDetail {
    String trainId, currentStation, departureTimeActual, driverName, lateness;

    public JourneyRawDetail(String trainId, String currentStation,
                            String departureTimeActual, String driverName, String lateness){

        this.trainId = trainId;
        this.currentStation = currentStation;
        this.departureTimeActual = departureTimeActual;
        this.driverName = driverName;
        this.lateness = lateness;

    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(String currentStation) {
        this.currentStation = currentStation;
    }

    public String getDepartureTimeActual() {
        return departureTimeActual;
    }

    public void setDepartureTimeActual(String departureTimeActual) {
        this.departureTimeActual = departureTimeActual;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLateness() {
        return lateness;
    }

    public void setLateness(String lateness) {
        this.lateness = lateness;
    }
}
