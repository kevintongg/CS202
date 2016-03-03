import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Test extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		MenuItem menuItem = new MenuItem("Exit");

		final Menu menu = new Menu("File");
		menu.getItems().add(menuItem);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(menu);


		menuItem.setOnAction(e -> Platform.exit());

		primaryStage.setTitle("Menu sample");
		Group root = new Group();


		Scene scene = new Scene(root, 300, 250);

		root.getChildren().add(menuBar);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}