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

    private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 08 Solutions");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static Stage getPrimary() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
