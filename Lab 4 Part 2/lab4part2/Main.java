package lab4part2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;
    Scene scene;
    Pane layout;
    Pane grid;


    public static void main(String[] args) {

        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {

        button = new Button();
        grid = new GridPane();
        layout = new StackPane();
        scene = new Scene(layout, 300, 300);
        layout.getChildren().add(button);

        primaryStage.setTitle("Niya");
        button.setText("Play game");
        button.setOnAction(event -> buttonEvent());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void buttonEvent() {

        button = new Button();

        button.setText("testing");

    }
}
