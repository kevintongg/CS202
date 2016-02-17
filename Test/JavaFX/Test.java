package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test extends Application {

    Button button;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set title of window
        primaryStage.setTitle("Hello World!");

        // Creates new button
        button = new Button();
        // Sets button text
        button.setText("Click me");
        // Sets button action on click
        button.setOnAction(event -> button.setText("You have clicked me!"));

        Pane pane = new Pane();
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.radiusProperty().bind(pane.widthProperty().divide(5));
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getStylesheets().add("main.css");
        pane.getChildren().add(circle);



        // Creates the layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        // Creates the scene
        Scene scene = new Scene(pane, 300, 250);
        // Sets the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}