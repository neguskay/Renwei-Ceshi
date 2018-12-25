package parts.two;

import utility.EasyIn;

import java.util.ArrayList;
import java.util.List;

public class PassengerDemandManager {

    private static final String DEFAULT_END_OF_INPUT_STATIONS = "N";

    //private EasyIn inputScanner;

    private PassengerDemand passengerDemand;

    private List<String> inputStations;
    private int[][] inputDemandMatrix;


    public PassengerDemandManager(){

        this.inputStations = new ArrayList<>();


    }

    public void initDemandManager(){


    }

    public void setInputStations(List<String> inputStations){

        this.inputStations = inputStations;

    }

    public void getUserInputStations(){
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

            //Create new demand object
            this.passengerDemand = new PassengerDemand(this.inputStations, null);

            //Create a new Matrix
            this.inputDemandMatrix = new int[this.inputStations.size()][this.inputStations.size()];

            //Fill the integer array


            //Print the matrix
            //Find the maximum demand and the station name(s)
            //query min demand for analysis

        }

    }


}
