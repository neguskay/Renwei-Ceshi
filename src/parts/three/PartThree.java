package parts.three;


import utility.EasyIn;
import java.io.IOException;
import java.sql.SQLException;


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

        System.out.println("Enter a file path OR enter 'N' to use the default path");

        userInput = EasyIn.getString();

        if(userInput.equalsIgnoreCase("N")){
             userFilePath = DEFAULT_FILEPATH_JOURNEY_DELAY;
        }

        while (!userInput.equalsIgnoreCase("N")&& userInput.equalsIgnoreCase("")){
            userInput = EasyIn.getString();
            userFilePath = userInput;
        }

        return userFilePath;
    }

}
