package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    public List<String[]> read(String file){
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        }catch(FileNotFoundException e){
            //TODO Auto-generated catch block
            System.out.println("File is not Founded");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Could not Read File");
            throw new RuntimeException(e);
        }
        return data;
    }

}
