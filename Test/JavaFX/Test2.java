package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*w  ww  .  ja v a 2  s  . c  om*/
public class Test2 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Title");
		Group root = new Group();
		Scene scene = new Scene(root, 600, 330, Color.WHITE);

		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		final ImageView imv = new ImageView();
		final Image image2 = new Image(Test2.class.getResourceAsStream("D:\\System\\Documents\\JetBrains\\IdeaProjects\\CS202\\Lab 4 Part 2\\images\\bird.jpg"));
		imv.setImage(image2);

		final HBox pictureRegion = new HBox();

		pictureRegion.getChildren().add(imv);
		gridpane.add(pictureRegion, 1, 1);


		root.getChildren().add(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}