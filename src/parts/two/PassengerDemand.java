package parts.two;

import java.util.List;

/**
 * PassengerDemand Class
 * The model of the Passenger Demand
 *
 * Attributes: line name after which the demand is modelled; list of stations;
 *              a double array of integers with all the demand levels
 */
public class PassengerDemand {

    private String lineName;

    private List<String> stations;

    private int[][] demandMatrix;

    private Object[][] demandMatrixObject;



    public PassengerDemand(List<String> stations, int[][] demandMatrix, Object[][] demandMatrixObject){

        this.stations = stations;

        this.demandMatrix = demandMatrix;

        this.lineName = (this.stations.get(0).toUpperCase() + "-" +
                this.stations.get(this.stations.size()-1).toUpperCase());

        this.demandMatrixObject = demandMatrixObject;

    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public int[][] getDemandMatrix() {
        return demandMatrix;
    }

    public void setDemandMatrix(int[][] demandMatrix) { this.demandMatrix = demandMatrix; }

    public Object[][] getDemandMatrixObject() { return demandMatrixObject; }

    public void setDemandMatrixObject(Object[][] demandMatrixObject) { this.demandMatrixObject = demandMatrixObject; }
}
