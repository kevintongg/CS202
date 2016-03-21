package JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        VBox vBox = new VBox(5);

        Button button1 = new Button("Button");
        Button button2 = new Button("Button");

        vBox.getChildren().addAll(button1, button2);
        vBox.setAlignment(Pos.CENTER);
        pane.getChildren().add(vBox);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Window");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
