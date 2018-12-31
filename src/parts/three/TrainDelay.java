package parts.three;

import java.time.LocalDateTime;

public class TrainDelay {

    private static final String DEFAULT_JOURNEY_STATUS_COMPLETE = "COMPLETE";
    private static final String DEFAULT_JOURNEY_STATUS_IN_PROGRESS = "IN PROGRESS";

    private int latenessInSeconds;

    private String delayId;
    private String trainId;
    private String delayStaion;

    private LocalDateTime scheduledDepartTime;
    private LocalDateTime actualDepartTime;


    public TrainDelay(){
        this.latenessInSeconds = 0;
    }


}
