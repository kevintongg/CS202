package JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test3 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    Pane pane = new Pane();
    HBox hBox = new HBox();
    Text text = new Text("JavaFX is hard fam");

    hBox.getChildren().add(text);
    hBox.setAlignment(Pos.CENTER);
    pane.getChildren().add(hBox);

    primaryStage.setTitle("le jabafx");
    primaryStage.setScene(new Scene(pane, 150, 50));
    primaryStage.show();

  }
}
