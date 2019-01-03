package parts.one;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainDetailsFileReader {

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private String filePath;

    private List<String> detailsUnsorted;

    public TrainDetailsFileReader(String filePath) throws IOException {

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

        String[] data = this.detailsUnsorted.toArray(new String[]{});

    }

    public List<String> getDetailsUnsorted(){
        return this.detailsUnsorted;
    }

}
