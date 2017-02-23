package lab4part2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

  public static void main(String[] args) {

    launch(args);

  }

  public static Moves getMoves() {

    Moves moves = new Moves("Player Moves");

    moves.getMoves().add("Red: 0,2 — Computer/Leaf");
    moves.getMoves().add("Black: 0,2 — Computer/Leaf");
    moves.getMoves().add("Black: 0,2 — Computer/Leaf");
    moves.getMoves().add("Black: 0,2 — Computer/Leaf");

    return moves;
  }

  public static VBox getBottomInsideText(String titleString, List<String> bottomText) {

    VBox insideBottom = new VBox();
    insideBottom.setPadding(new Insets(10));
    insideBottom.setSpacing(10);
    insideBottom.setId("inside-bottom");
    insideBottom.setMinWidth(200);

    Text title = new Text(titleString);

    insideBottom.getChildren().addAll(title);

    bottomText.forEach(event -> {
      Text textToDisplay = new Text(event);
      VBox.setMargin(textToDisplay, new Insets(10));
      insideBottom.getChildren().addAll(textToDisplay);
    });

    return insideBottom;

  }

  public void start(Stage primaryStage) {


    BorderPane window = new BorderPane();
    HBox bottom = new HBox();
    GridPane grid = new GridPane();
    Image bird = new Image("images/bird.jpg");
    Image cloud = new Image("images/cloud.jpg");
    Image computer = new Image("images/computer.jpg");
    Image dragon = new Image("images/dragon.jpg");
    Image flower = new Image("images/flower.jpg");
    Image leaves = new Image("images/leaves.jpg");
    Image sun = new Image("images/sun.jpg");
    Image tiger = new Image("images/tiger.jpg");
    Image black = new Image("images/black.gif");
    Image red = new Image("images/red.png");
    ImageView blackPiece = new ImageView(black);
    ImageView redPiece = new ImageView(red);
    ImageView birdIcon = new ImageView(bird);
    ImageView cloudIcon = new ImageView(cloud);
    ImageView computerIcon = new ImageView(computer);
    ImageView dragonIcon = new ImageView(dragon);
    ImageView flowerIcon = new ImageView(flower);
    ImageView leavesIcon = new ImageView(leaves);
    ImageView sunIcon = new ImageView(sun);
    ImageView tigerIcon = new ImageView(tiger);
    Text currentPlayer = new Text("Current Player: BLACK");


    window.setId("main");

    bottom.setId("bottom-bar");
    bottom.setPadding(new Insets(25));
    bottom.setMinHeight(100);
    bottom.setMinWidth(150);
    bottom.setSpacing(10);

    blackPiece.setFitHeight(50);
    blackPiece.setFitWidth(50);
    redPiece.setFitHeight(50);
    redPiece.setFitWidth(50);
    birdIcon.setFitHeight(50);
    birdIcon.setFitWidth(50);
    cloudIcon.setFitHeight(50);
    cloudIcon.setFitWidth(50);
    computerIcon.setFitHeight(50);
    computerIcon.setFitWidth(50);
    dragonIcon.setFitHeight(50);
    dragonIcon.setFitWidth(50);
    flowerIcon.setFitHeight(50);
    flowerIcon.setFitWidth(50);
    leavesIcon.setFitHeight(50);
    leavesIcon.setFitWidth(50);
    sunIcon.setFitHeight(50);
    sunIcon.setFitWidth(50);
    tigerIcon.setFitHeight(50);
    tigerIcon.setFitWidth(50);

    grid.setGridLinesVisible(true);
    grid.add(birdIcon, 0, 0);
    grid.add(cloudIcon, 1, 0);
    grid.add(blackPiece, 0, 2);

    bottom.getChildren().addAll(currentPlayer, blackPiece, getBottomInsideText("Player Moves", getMoves().getMoves()));

    window.setBottom(bottom);
    window.setCenter(grid);

    Scene scene = new Scene(window, 960, 540);
    scene.getStylesheets().addAll("css/main.css", "https://fonts.googleapis.com/css?family=Open+Sans");
    primaryStage.setTitle("Niya");
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}