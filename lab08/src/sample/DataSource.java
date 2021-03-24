package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class DataSource {
    public static ObservableList<StudentRecord> getAllMarks(File file) throws IOException {
        ObservableList<StudentRecord> marks =FXCollections.observableArrayList();

        String current;
        BufferedReader br = new BufferedReader(new FileReader (file.getPath()));

        while ((current = br.readLine()) != null) {
            String[] info = current.split(",");
            marks.add(new StudentRecord(info[0],info[1],info[2],info[3]));
        };

        return marks;
    }

}