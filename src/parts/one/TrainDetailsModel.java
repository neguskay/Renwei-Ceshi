package parts.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainDetailsModel {

    private String type;

    private int speed, energy;



    public TrainDetailsModel(String type, int speed, int energy) {

        this.type = type;
        this.speed = speed;
        this.energy = energy;

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }




}
