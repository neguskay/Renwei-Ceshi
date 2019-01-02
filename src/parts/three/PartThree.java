package parts.three;


import utility.EasyIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartThree {

    private static final String DEFAULT_FILEPATH_JOURNEY_DELAY =
            "/Users/negus/IDEA_Projects/InterviewProjects/CogTechEx/DriverAndDelayDetails.txt";

    private final JourneyDelayManager journeyDelayManager;


    public PartThree() throws IOException, SQLException, ClassNotFoundException {

        //this.filePath = this.getUserFilePath();
        this.journeyDelayManager = new JourneyDelayManager(this.getUserFilePath());

    }

    private String getUserFilePath() {
        String userInput;
        String userFilePath = "";

        System.out.println("Enter a file path OR enter 'no' to use the default path");

        userInput = EasyIn.getString();

        if(userInput.equalsIgnoreCase("no")){
             userFilePath = DEFAULT_FILEPATH_JOURNEY_DELAY;
        }

        while (!userInput.equalsIgnoreCase("no")&& userInput.equalsIgnoreCase("")){
            userInput = EasyIn.getString();
            userFilePath = userInput;
        }

        return userFilePath;
    }

}
