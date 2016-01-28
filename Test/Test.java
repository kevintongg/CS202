import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Test extends Application {

	Button button;

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Hello World!");

		button = new Button();
		button.setText("Click me");
		button.setOnAction(event -> JOptionPane.showMessageDialog(null, "I am anonymous"));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}