package parts.one;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainDetailsReader {

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private String filePath;

    private List<String> detailsUnsorted;

    public TrainDetailsReader(String filePath) throws IOException {

        this.filePath = filePath;

        this.initReader();

    }

    private void initReader() throws IOException {
        this.fileReader = new FileReader(this.filePath);

        BufferedReader bufferedReader = new BufferedReader(this.fileReader);

        this.detailsUnsorted = new ArrayList<String>();

        String line;

        while((line = bufferedReader.readLine()) != null) {

            this.detailsUnsorted.add(line);
            //System.out.println(lines);
        }

        bufferedReader.close();

        System.out.println(this.detailsUnsorted);
        System.out.println(this.detailsUnsorted.size());

        // If you want to convert to a String[]
        String[] data = this.detailsUnsorted.toArray(new String[]{});

    }

    public List<String> getDetailsUnsorted(){
        return this.detailsUnsorted;
    }

}
