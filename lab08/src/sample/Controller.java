package sample;

import java.io.*;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class Controller {
    private File currentFile;
    private String fileName;
    @FXML
    private ObservableList<StudentRecord> info;

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem newB;
    @FXML
    private MenuItem openB;
    @FXML
    private MenuItem saveB;
    @FXML
    private MenuItem saveAsB;
    @FXML
    private MenuItem exitB;

    @FXML
    private TableView display;
    @FXML
    private TableColumn stuID;
    @FXML
    private TableColumn mid;
    @FXML
    private TableColumn assi;
    @FXML
    private TableColumn ex;
    @FXML
    private  TableColumn mark;
    @FXML
    private TableColumn letter;

    @FXML
    private TextField studentID;
    @FXML
    private TextField assig;
    @FXML
    private  TextField midtermS;
    @FXML
    private TextField examS;

    @FXML
    private Button add;

    @FXML
    public void initialize() {
        stuID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        mid.setCellValueFactory(new PropertyValueFactory<>("Mid"));
        assi.setCellValueFactory(new PropertyValueFactory<>("Assi"));
        ex.setCellValueFactory(new PropertyValueFactory<>("exam"));
        mark.setCellValueFactory(new PropertyValueFactory<>("Final"));
        letter.setCellValueFactory(new PropertyValueFactory<>("letter"));

    }
    @FXML
    public void makeNew() {
        info.clear();
    }
    @FXML
    public void load() throws IOException {
        info = DataSource.getAllMarks(currentFile);
        display.setItems(info);
    }
    @FXML
    public void open() throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("."));
        Stage stage = sample.Main.getPrimary();
        currentFile=chooser.showOpenDialog(stage);
        fileName=currentFile.getName();
        load();
    }
    @FXML
    public void save() throws IOException {
        FileWriter saving = new FileWriter(currentFile);

        for (int i = 0; i < info.size(); i++) {
            saving.append(info.get(i).getID() + "," + info.get(i).getAssi() + "," + info.get(i).getMid() + "," + info.get(i).getExam());
            saving.append("\n");
        }
        saving.flush();
        saving.close();
    }
    @FXML
    public void saveAs() throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("."));
        Stage stage = sample.Main.getPrimary();
        currentFile=chooser.showSaveDialog(stage);
        fileName=currentFile.getName();
        save();
    }
    @FXML
    public void exit() {
        Platform.exit();
    }
    @FXML
    public void add() {
        info.add((new StudentRecord(studentID.getText(), assig.getText(), midtermS.getText(), examS.getText())));
        display.setItems(info);
        studentID.setText("");
        assig.setText("");
        midtermS.setText("");
        examS.setText("");
    }
}
