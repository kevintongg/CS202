package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test2 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    StackPane stackPane = new StackPane();
    Button button = new Button();

    stackPane.getChildren().add(button);

    primaryStage.setTitle("xd");
    primaryStage.setScene(new Scene(stackPane));
    primaryStage.show();


  }
}