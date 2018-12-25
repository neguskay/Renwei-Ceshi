package parts.one;

import java.io.IOException;

public class PartOne {

    private static final String DEFAULT_TRAIN_DETAILS_FILE_PATH =
            "/Users/negus/IDEA_Projects/InterviewProjects/CogTechEx/TrainDetails.txt";


    public void init() throws IOException {

        //TrainDetailsReader trainDetailsReader = new TrainDetailsReader(DEFAULT_TRAIN_DETAILS_FILE_PATH);

        TrainDetailsDb trainDetailsDb = new TrainDetailsDb(DEFAULT_TRAIN_DETAILS_FILE_PATH);

        printQuestion();

        System.out.println(trainDetailsDb.isDbContainsTrainType("156A"));
        System.out.println(trainDetailsDb.getHighestEnergy("156A").getEnergy());
        System.out.println("The lowest is : " + trainDetailsDb.getLowestSpeed("156A"));
    }

    private void printQuestion(){
        System.out.println("Please Enter A Valid Train Type To Investigate");
    }

    private void printErrorMessage(){

    }

    private void printInvalidTrainTypeMessage(){

        System.out.println("No details found");
    }


}
