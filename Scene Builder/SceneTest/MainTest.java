package SceneTest;/**
 * Created by kcr12_000 on 16/3/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));

            primaryStage.setTitle("testing");
            primaryStage.setScene(new Scene(root, 200, 200));
            primaryStage.show();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}
