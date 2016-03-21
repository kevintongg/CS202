package SampleFinal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {

    Stage mainMenuStage;
    Stage attendanceStage;
    private Button[][] buttons = new Button[5][5];
    private int i;
    private int j;

    public static void main(String[] args) {
        launch(args);
    }

    public void mainMenu(Stage mainMenuStage) {

        StackPane menuStackPane = new StackPane();
        VBox buttonContainer = new VBox(10);
        Button importRoster = new Button("Import Roster");
        Button takeAttendance = new Button("Take Attendance");
        Button viewAttendance = new Button("View Attendance");

        buttonContainer.getChildren().addAll(importRoster, takeAttendance, viewAttendance);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(10));
        menuStackPane.getChildren().add(buttonContainer);

        Scene scene = new Scene(menuStackPane, 240, 120);

        mainMenuStage.setTitle("Main Menu");
        mainMenuStage.setScene(scene);
        mainMenuStage.show();

        importRoster.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Roster Import");
            File file = fileChooser.showOpenDialog(mainMenuStage);
            if (file != null) {
                Path path = Paths.get(file.toURI());
                Charset charset = Charset.forName("UTF-8");
                List<String> lines;
                try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                    lines = Files.readAllLines(path, charset);
                } catch (IOException e) {
                    System.err.format("IOException: %s%n", e);
                    return;
                }
                lines.forEach(System.out::println);
            }
        });

        takeAttendance.setOnAction(event -> {

            Stage newStage = new Stage();

            mainMenuStage.hide();
            courseChooser(newStage);

        });


    }

    public void courseChooser(Stage courseStage) {


        GridPane coursePane = new GridPane();
        VBox courses = new VBox(5);
        Button mathButton = new Button("Calculus");

        mathButton.setAlignment(Pos.CENTER);
        courses.getChildren().add(mathButton);
        coursePane.getChildren().add(courses);
        coursePane.setAlignment(Pos.CENTER);

        courseStage.setTitle("Course");
        courseStage.setScene(new Scene(coursePane));
        courseStage.show();

        mathButton.setOnAction(event -> {

            Stage attendance = new Stage();

            courseStage.close();
            calculusAttendance(attendance);


        });
    }

    public void calculusAttendance(Stage calculusStage) {

        Course calculus = new Course("Calculus");

        GridPane attendanceGrid = new GridPane();
        attendanceGrid.setPadding(new Insets(5));
        attendanceGrid.setHgap(2);
        attendanceGrid.setVgap(2);
        attendanceGrid.setAlignment(Pos.CENTER);

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new Button("Student Here");
                buttons[i][j].setPrefSize(100, 100);
                attendanceGrid.add(buttons[i][j], j, i + 2);
            }
        }

        calculusStage.setTitle(calculus.toString());
        calculusStage.setScene(new Scene(attendanceGrid));
        calculusStage.show();
    }

//
//    public void mainWindow(Stage attendanceStage) {
//
//        try {
//            Parent calculusAttendance = FXMLLoader.load(getClass().getResource("attendance.fxml"));
//            attendanceStage.setTitle("Attendance");
//            attendanceStage.setScene(new Scene(calculusAttendance));
//            attendanceStage.show();
//        } catch (IOException e) {
//            System.err.format("IOException: %s%n", e);
//        }
//    }

    @Override
    public void start(Stage primaryStage) {

        mainMenu(primaryStage);
    }

//        StackPane menuStackPane = new StackPane();
//        VBox buttonContainer = new VBox(10);
//        Button importRoster = new Button("Import Roster");
//        Button takeAttendance = new Button("Take Attendance");
//        Button viewAttendance = new Button("View Attendance");
//
//        buttonContainer.getChildren().addAll(importRoster, takeAttendance, viewAttendance);
//        buttonContainer.setAlignment(Pos.CENTER);
//        buttonContainer.setPadding(new Insets(10));
//        menuStackPane.getChildren().add(buttonContainer);
//
//        Scene scene = new Scene(menuStackPane, 240, 120);
//
//        primaryStage.setTitle("Main Menu");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//

//
//
//        changeButtonBackground();
//
//        Scene attendanceScene = new Scene(attendanceGrid, 500, 500);
//        attendanceStage.setTitle("Take Attendance");
//        attendanceStage.setScene(attendanceScene);
//        primaryStage.close();
//        attendanceStage.show();
//
//    }
//
//    );
//}

    public void changeButtonBackground() {

        for (i = 0; i < buttons.length; i++) {
            for (j = 0; j < buttons.length; j++) {
                buttons[i][j].setOnMouseClicked(event -> {
                    buttons[i][j].setStyle("-fx-background-color: green");
                });
            }
        }
    }


    public Stage getMainMenuStage() {
        return mainMenuStage;
    }

    public void setMainMenuStage(Stage mainMenuStage) {
        this.mainMenuStage = mainMenuStage;
    }

    public Stage getAttendanceStage() {
        return attendanceStage;
    }

    public void setAttendanceStage(Stage attendanceStage) {
        this.attendanceStage = attendanceStage;
    }
}
