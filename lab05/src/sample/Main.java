package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        TableView tableView = new TableView();

        TableColumn<StudentRecord, String> column1 = new TableColumn<>("Student ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<StudentRecord, String> column2 = new TableColumn<>("Assignments");
        column2.setCellValueFactory(new PropertyValueFactory<>("Assi"));

        TableColumn<StudentRecord, String> column3 = new TableColumn<>("Midterm");
        column3.setCellValueFactory(new PropertyValueFactory<>("Mid"));

        TableColumn<StudentRecord, String> column4 = new TableColumn<>("Exam");
        column4.setCellValueFactory(new PropertyValueFactory<>("exam"));

        TableColumn<StudentRecord, String> column5 = new TableColumn<>("Final Mark");
        column5.setCellValueFactory(new PropertyValueFactory<>("Final"));

        TableColumn<StudentRecord, String> column6 = new TableColumn<>("Letter Grade");
        column6.setCellValueFactory(new PropertyValueFactory<>("letter"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);

        //tableView.getItems().add(new StudentRecord("100749102", 80.0f, 75.0f, 90.0f));
        tableView.setItems(DataSource.getAllMarks());


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 5");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
