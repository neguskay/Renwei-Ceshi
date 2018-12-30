package parts.one;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainDetailsDb {

    private TrainDetailsFileReader trainDetailsFileReader;
    private TrainDetail trainDetail;

    private String fileToUploadPath;
    private List<String> trainDetailsUnsorted;
    private List<TrainDetail> trainDetailsSorted;
    //private Object TrainDetail;

    public TrainDetailsDb(String fileToUploadPath) throws IOException {

        System.out.println(fileToUploadPath);
        this.fileToUploadPath = fileToUploadPath;
        this.initTrainDetailsDb();


    }

    private void initTrainDetailsDb() throws IOException {
        this.trainDetailsFileReader = new TrainDetailsFileReader(this.fileToUploadPath);

        this.trainDetailsSorted = new ArrayList<>();
        setTrainDetailsSorted();
    }

    private void setTrainDetailsSorted() throws IOException {
        this.trainDetailsUnsorted = new ArrayList<>();
        this.trainDetailsUnsorted = trainDetailsFileReader.getDetailsUnsorted();

        for (int i = 1; i < trainDetailsFileReader.getDetailsUnsorted().size(); i++) {

            String dataset = this.trainDetailsUnsorted.get(i);
            String[] splitDataset = dataset.split("-");
            //System.out.println(splitDataset[0]);
            //System.out.println(splitDataset[1]);
            //System.out.println(splitDataset[2]);

            this.trainDetailsSorted.add(new TrainDetail(splitDataset[0], Integer.parseInt(splitDataset[1]),
                    Integer.parseInt(splitDataset[2])));


            //System.out.println(splitDataset.length);

        }

        System.out.println(this.trainDetailsSorted.get(0).getSpeed() + " KMPH");
        //System.out.println(this.trainDetailsSorted.);
    }

    public int getLowestSpeed(String trainType){
        ArrayList<Integer> speeds = new ArrayList();

        int lowestSpeed;

        //Loop through to find all speeds associated with the given train type
        for (int i = 0; i < this.trainDetailsSorted.size(); i++) {

            TrainDetail currentTrain = trainDetailsSorted.get(i);

            if(currentTrain.getType().equalsIgnoreCase(trainType)){
                speeds.add(currentTrain.getSpeed());

                System.out.println(speeds.size());
            }

        }

        //Sort list in ascending order of speed
        Collections.sort(speeds);
        lowestSpeed = speeds.get(0);

        return lowestSpeed;
    }

    public TrainDetail getHighestEnergy(String trainType){

        ArrayList<TrainDetail> trainTypeEnergy = new ArrayList();

        int highestEnergy;

        //Loop through to find all speeds associated with the given train type
        for (int i = 0; i < this.trainDetailsSorted.size(); i++) {

            TrainDetail currentTrain = trainDetailsSorted.get(i);

            if(currentTrain.getType().equalsIgnoreCase(trainType)){
                trainTypeEnergy.add(currentTrain);

                //System.out.println(speeds.size());
            }

        }
        Collections.sort(trainTypeEnergy, new Comparator<TrainDetail>() {
            @Override
            public int compare(TrainDetail o1, TrainDetail o2) {
                return o1.getEnergy() - o2.getEnergy();
            }
        });

        //Sort list in ascending order of speed
        TrainDetail highestSpeedSet = trainTypeEnergy.get(trainTypeEnergy.size()-1);
        //TrainDetail highestSpeedSet = trainTypeEnergy.get(0);

        return highestSpeedSet;

    }

    public boolean isDbContainsTrainType(String trainType){
        boolean isContainsTrainType = false;

        for(TrainDetail current: this.trainDetailsSorted) {
            if(current.getType().equalsIgnoreCase(trainType))

                isContainsTrainType = true;
                break;
        }

        return isContainsTrainType;
    }
}
