package parts.two;

public class PartTwo {


    private PassengerDemandManager passengerDemandManager;

    public PartTwo(){
        System.out.println("In Part Two...");

        this.passengerDemandManager = new PassengerDemandManager();

        this.passengerDemandManager.initDemandManager();
    }

}
