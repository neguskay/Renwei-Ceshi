package main;

import parts.one.PartOne;
import parts.two.PassengerDemandManager;
import utility.EasyIn;

import java.io.IOException;

public class Main {

    private static final String DEFAULT_MESSAGE_WELCOME_1 = "WELCOME TO THE TRAIN APPLICATION";
    private static final String DEFAULT_MESSAGE_WELCOME_PART_COMMAND = "ENTER THE PART NUMBER E.G. 1, 2, 3 AND ETC.";
    private static final String DEFAULT_MESSAGE_WELCOME_IVALID_PART = "INVALID PART NUMBER";

    public static void main(String[] args) throws IOException {

        System.out.println(DEFAULT_MESSAGE_WELCOME_1);
        System.out.println(DEFAULT_MESSAGE_WELCOME_PART_COMMAND);
        int partEntered = EasyIn.getInt();

        if(partEntered == 1){
            new PartOne();
        }else if(partEntered == 2){
            new PassengerDemandManager().getStations();
        }else{

            while ((partEntered<1)||(partEntered>3)){
                System.out.print(DEFAULT_MESSAGE_WELCOME_IVALID_PART);
                partEntered = EasyIn.getInt();

            }

        }




    }
}
