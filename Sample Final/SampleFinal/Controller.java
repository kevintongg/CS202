package SampleFinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    Main main = new Main();

    @FXML
    private Button rosterImport;

    @FXML
    private Button viewAttendance;

    @FXML
    private Button takeAttendance;

    @FXML
    private Button student1;

    @FXML
    private Button student2;

    @FXML
    private Button student3;

    @FXML
    private Button student4;

    @FXML
    private Button student5;

    @FXML
    private Button student6;

    @FXML
    private Button student7;

    @FXML
    private Button student8;

    @FXML
    private Button student9;

    @FXML
    private Button student10;

    @FXML
    private Button student11;

    @FXML
    private Button student12;


    @FXML
    public void initialize() {

        takeAttendance.setOnAction(event -> {
            takeAttendance.setText("HELLO");
        });

        rosterImport.setOnAction(event -> {

            Stage stage = new Stage();

            main.getMainMenuStage().close();
        });

        student1.setOnAction(event -> {
            student1.setText("HELLO");
        });

    }

    public void takeAttendanceButton(ActionEvent event) {

    }

}
