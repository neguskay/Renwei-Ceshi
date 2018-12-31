package parts.three;

public class TrainJourney {

    private static final String DEFAULT_JOURNEY_STATUS_COMPLETE = "COMPLETE";
    private static final String DEFAULT_JOURNEY_STATUS_IN_PROGRESS = "IN PROGRESS";

    private String journeyId;
    private String trainId;
    private String startStaion;
    private String destinationStaion;
    private String driverName;
    private String journeyStatus;

    private TrainDelay trainDelay;

    public TrainJourney(){

    }
}
