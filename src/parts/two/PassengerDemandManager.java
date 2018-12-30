package parts.two;

import utility.EasyIn;

import java.util.ArrayList;
import java.util.List;

public class PassengerDemandManager {

    private static final String DEFAULT_END_OF_INPUT_STATIONS = "N";
    private static final String DEFAULT_INTERSECT_COL_ROW = "NNNN";
    private static final String DEFAULT_MATRIX_NAME = "TRAIN--DEMAND";

    private static final int DEFAULT_DEMAND_MAX_NO_QUERY = 0;

    //private EasyIn inputScanner;

    private PassengerDemand passengerDemand;

    private List<String> inputStations;

    private int[][] inputDemandMatrix;

    private int queryThreshold;

    private boolean isThresholdSet;

    public PassengerDemandManager(){

        this.isThresholdSet = false;
        this.queryThreshold = DEFAULT_DEMAND_MAX_NO_QUERY;

        this.inputStations = new ArrayList<>();


    }

    public void initDemandManager(){


    }

    public void setInputStations(List<String> inputStations){

        this.inputStations = inputStations;

    }

    public void getStations(){
        this.inputStations.clear();
        this.inputStations.add(DEFAULT_MATRIX_NAME);

        System.out.print("How Many Stations are on the line?");

        System.out.print("What's the next station to add? If there are no more stations, enter " +
                DEFAULT_END_OF_INPUT_STATIONS);

        String stationToAdd = EasyIn.getString();

        while (!stationToAdd.equalsIgnoreCase(DEFAULT_END_OF_INPUT_STATIONS)){

            this.inputStations.add(stationToAdd);

            System.out.println();
            System.out.print("What's the next station to add? If there are no more stations, enter " +
                    DEFAULT_END_OF_INPUT_STATIONS);

            stationToAdd = EasyIn.getString();

        }

        if(stationToAdd.equalsIgnoreCase(DEFAULT_END_OF_INPUT_STATIONS)){
            System.out.println(this.inputStations.size());
            //Create new demand object
            this.passengerDemand = new PassengerDemand(this.inputStations, null, null);

            //Create a new Matrix
            //Fill the integer array
            //this.inputDemandMatrix = new int[this.inputStations.size()][this.inputStations.size()];
            this.inputDemandMatrix = this.getDemandMatrix();
            this.passengerDemand.setDemandMatrix(this.inputDemandMatrix);

            //Rebased//Git
            //Set the demand object matrix arrays
            this.passengerDemand.setDemandMatrixObject(this.setDemandMatrixObject());

            //Print the matrix
            this.printDemandMatrixObject();
            System.out.println();

            //Find the maximum demand and the station name(s)
            this.printMaxDemandStations(this.getMaxDemandStations(DEFAULT_DEMAND_MAX_NO_QUERY));
            System.out.println();


            //query min demand for analysis
            this.printMaxDemandStations(this.getMaxDemandStations(this.getQueryThreshold()));
            System.out.println();
        }

    }

    private int getQueryThreshold() {
        int queryMin;

        System.out.println("Enter a minimum demand amount for investigation");

        queryMin = EasyIn.getInt();

        while(queryMin<0){

            System.out.println("Enter a minimum demand amount for investigation");

            queryMin = EasyIn.getInt();
        }
        this.queryThreshold = queryMin;
        return queryMin;
    }

    public void printMaxDemandStations(List<String[]> maxDemandStations) {
        System.out.println();
        System.out.println("MAX DEMS");


        for (String[] station: maxDemandStations) {

            if(this.isThresholdSet && this.queryThreshold>0){

                System.out.println(station[0]+ " to "
                        + station[1]+ ": "+station[2]);

            } else {

                System.out.println("Maximum Demand is between "+ station[0]+ " to "
                        + station[1]+ "("+station[2]+")");

            }
        }
    }



    public int[][] getDemandMatrix(){
        String station1, station2;

        int currentDemand;


        int[][] currentDemandMatrix = new int[this.passengerDemand.getStations().size()-1]
                [this.passengerDemand.getStations().size()-1];

        for (int col = 0; col < currentDemandMatrix.length; col++) {

            station1 = this.passengerDemand.getStations().get(col+1);

            for (int row = 0; row < currentDemandMatrix.length; row++) {

                station2 = this.passengerDemand.getStations().get(row+1);

                System.out.println("Enter the passenger demand count between " + station1 + " and " + station2);
                System.out.println("Demand Count should be an integer number");

                currentDemand = EasyIn.getInt();

                currentDemandMatrix[col][row] = currentDemand;

            }
        }

        return currentDemandMatrix;
    }

    public Object[][] setDemandMatrixObject(){

        Object[][] currentMatrixObject = new Object[this.passengerDemand.getStations().size()]
                [this.passengerDemand.getStations().size()];

        currentMatrixObject[0][0] = DEFAULT_INTERSECT_COL_ROW;

        //Fill up the station names

        for (int col = 0; col < currentMatrixObject.length; col++) {

            for (int row = 0; row < currentMatrixObject[col].length; row++) {

                currentMatrixObject[0][row] = passengerDemand.getStations().get(row);
                currentMatrixObject[col][0] = passengerDemand.getStations().get(col);

            }

        }

        //Fill up the actual matrix
        for (int col = 1; col < passengerDemand.getStations().size(); col++) {

            //System.out.println();

            for (int row = 1; row < passengerDemand.getStations().size(); row++) {

                currentMatrixObject[col][row] = passengerDemand.getDemandMatrix()[col-1][row-1];

            }

        }

        return currentMatrixObject;
    }

    public void printDemandMatrixObject(){

        for (int col = 0; col < this.passengerDemand.getDemandMatrixObject().length; col++) {
            System.out.println();

            for (int row = 0; row <this.passengerDemand.getDemandMatrixObject()[col].length ; row++) {

                System.out.print(passengerDemand.getDemandMatrixObject()[col][row]+ "||");

            }

        }

    }

    public int getMaximumDemand(){
        int maxDemand = 0;

        for (int col = 0; col < this.passengerDemand.getDemandMatrix().length; col++) {
            for (int row = 0; row < this.passengerDemand.getDemandMatrix()[col].length; row++) {
                if(this.passengerDemand.getDemandMatrix()[col][row] >= maxDemand){

                    maxDemand = this.passengerDemand.getDemandMatrix()[col][row];

                }
            }

        }

        return maxDemand;
    }

    public List<String[]> getMaxDemandStations(int queryThreshold){
        List<String[]> maxDemandStations = new ArrayList<>();

        int maxDemand = getMaximumDemand();

        for (int col = 0; col < this.passengerDemand.getDemandMatrix().length; col++) {
            for (int row = 0; row < this.passengerDemand.getDemandMatrix()[col].length; row++) {

                String station1, station2, demand;

                if(queryThreshold == DEFAULT_DEMAND_MAX_NO_QUERY) {

                    if (this.passengerDemand.getDemandMatrix()[col][row] == maxDemand) {


                        station1 = this.passengerDemand.getStations().get(col + 1);
                        station2 = this.passengerDemand.getStations().get(row + 1);
                        demand = Integer.toString(this.passengerDemand.getDemandMatrix()[col][row]);

                        maxDemandStations.add(new String[]{station1, station2, demand});

                    }

                } else if(queryThreshold>0) {

                    this.isThresholdSet = true;

                    if (this.passengerDemand.getDemandMatrix()[col][row] > queryThreshold) {


                        station1 = this.passengerDemand.getStations().get(col + 1);
                        station2 = this.passengerDemand.getStations().get(row + 1);
                        demand = Integer.toString(this.passengerDemand.getDemandMatrix()[col][row]);

                        maxDemandStations.add(new String[]{station1, station2, demand});

                    }
                }
            }

        }

        return maxDemandStations;
    }
}
