package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

import static java.awt.Font.*;
import static javafx.scene.text.Font.font;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 4");

//        Creating layout gridpane
        GridPane myGrid = new GridPane();
        myGrid.setAlignment(Pos.CENTER);
        myGrid.setHgap(10);
        myGrid.setVgap(10);
        myGrid.setPadding(new Insets(25, 25, 25, 25));

// -- labels
        Label lbUserName = new Label("Username:");
        Label lbPassword = new Label("Password:");
        Label lbFullName = new Label("Full Name:");
        Label lbEmail = new Label("E-Mail:");
        Label lbPhone = new Label("Phone #:");
        Label lbDOB = new Label("Date of Birth:");
// -- inputs
        TextField txUserName = new TextField();
        PasswordField psPassword = new PasswordField();
        TextField txFullName = new TextField();
        TextField txEmail = new TextField();
        TextField txPhone = new TextField();
        DatePicker datePicker = new DatePicker();
//        -- Button
        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
//        -- link
        final Text actionTarget = new Text();



//        Add the components onto the myGrid pane
        myGrid.add(lbUserName, 0,1);
        myGrid.add(txUserName, 1,1);
        myGrid.add(lbPassword, 0,2);
        myGrid.add(psPassword, 1,2);
        myGrid.add(lbFullName, 0,3);
        myGrid.add(txFullName, 1,3);
        myGrid.add(lbEmail, 0,4);
        myGrid.add(txEmail, 1,4);
        myGrid.add(lbPhone, 0,5);
        myGrid.add(txPhone, 1,5);
        myGrid.add(lbDOB, 0,6);
        myGrid.add(datePicker, 1,6);
        myGrid.add(hbBtn, 1, 7);
        myGrid.add(actionTarget, 1, 8);

//        Setting the btn event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(txUserName.getText());
                System.out.println(psPassword.getText());
                System.out.println(txFullName.getText());
                System.out.println(txEmail.getText());
                System.out.println(txPhone.getText());
                System.out.println(datePicker.getValue());
            }
        });


//        Creating myScene with custom layout
        Scene myScene = new Scene(myGrid, 300,275);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
