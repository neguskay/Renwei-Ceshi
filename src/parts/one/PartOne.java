package parts.one;

import utility.EasyIn;

import java.io.IOException;

public class PartOne {

    private static final String DEFAULT_TRAIN_DETAILS_FILE_PATH =
            "/Users/negus/IDEA_Projects/InterviewProjects/CogTechEx/TrainDetails.txt";
    private static final String DEFAULT_QUESTION_TRAIN_NAME = "Please Enter A Valid Train Type To Investigate";
    private static final String DEFAULT_ERROR_INVALID_TRAIN_TYPE = "No Details Found";
    private static final String DEFAULT_SPEED_UNIT = " KMPH";
    private static final String DEFAULT_ENERGY_UNIT = " KWH";

    private TrainDetailsManager trainDetailsManager;


    public PartOne() throws IOException {

        this.printPartOneWelcome();

        this.trainDetailsManager = new TrainDetailsManager(DEFAULT_TRAIN_DETAILS_FILE_PATH);

        this.runUserQueries(this.getUserQueryTrain());

    }


    public void runUserQueries(String userQueryTrain) throws IOException {

        TrainDetail queryResult;

        if(trainDetailsManager.isDbContainsTrainType(userQueryTrain)){

            System.out.println("Train Type : "+ userQueryTrain);

            System.out.println("Lowest Speed : " + this.trainDetailsManager.getLowestSpeed(userQueryTrain)
                    + DEFAULT_SPEED_UNIT);

            queryResult = this.trainDetailsManager.getHighestEnergy(userQueryTrain);

            System.out.println("Highest Consumption : " + queryResult.getEnergy() +DEFAULT_ENERGY_UNIT);
            System.out.println("Speed at Highest Energy Consumption : " + queryResult.getSpeed() + DEFAULT_SPEED_UNIT);


        } else {

            System.out.println(DEFAULT_ERROR_INVALID_TRAIN_TYPE);
        }

    }

    private String getUserQueryTrain(){
        System.out.println(DEFAULT_QUESTION_TRAIN_NAME);
        return EasyIn.getString();
    }

    private void printPartOneWelcome(){
        System.out.println("IN PART ONE...");
    }

    private void printInvalidTrainTypeMessage(){

        System.out.println("No details found");
    }


}
