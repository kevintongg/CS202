package lab4part3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lab4part3.Images.getImages;
import static lab4part3.Tile.getTileTypes;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    private static void mainMenu(Stage primaryStage) {

        StackPane mainMenuStackPane = new StackPane();
        Button playGame = new Button("_Play Game");
        Button viewSave = new Button("_View Saved Game");
        Button exit = new Button("_Exit");
        BorderPane mainMenu = new BorderPane();
        VBox mainMenuOptions = new VBox(15);
        ImageView mainMenuImage = new ImageView("../Lab 4 Part 3/images/niya.jpg");
        ImageView rainbow = new ImageView("images/rainbow.png");
        Text mainMenuText = new Text("Welcome to Niya!");
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("_File");
        MenuItem exitMenu = new MenuItem("_Exit");

        addImages();

        menu.getItems().addAll(exitMenu);
        menuBar.getMenus().add(menu);

        mainMenu.setId("main-menu");
        mainMenuText.setId("welcome");

        BorderPane.setAlignment(mainMenuText, Pos.CENTER);
        mainMenuText.setTextAlignment(TextAlignment.CENTER);
        mainMenuOptions.setAlignment(Pos.CENTER);
        mainMenuOptions.getChildren().addAll(playGame, viewSave, exit);
        mainMenuImage.minHeight(450);
        mainMenu.setTop(mainMenuText);
        mainMenu.setCenter(mainMenuImage);
        mainMenu.setBottom(mainMenuOptions);
        mainMenu.getStylesheets().add("css/menu.css");

        StackPane.setAlignment(menuBar, Pos.TOP_CENTER);

        mainMenuStackPane.getChildren().addAll(rainbow, mainMenu, menuBar);

        Scene mainMenuScene = new Scene(mainMenuStackPane, 400, 480);
        mainMenuScene.getStylesheets().addAll("http://fonts.googleapis.com/css?family=Droid+Sans", "css/buttons.css", "css/menu.css", "css/main.css");
        primaryStage.setTitle("Niya");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

        exitMenu.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

        exit.setOnAction(e -> Platform.exit());

        exitMenu.setOnAction(e -> Platform.exit());

        playGame.setOnAction(e -> {

            Stage secondaryStage = new Stage();

            primaryStage.hide();
            mainGame(secondaryStage);

        });

        viewSave.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                Path path = Paths.get(file.toURI());
                Charset charset = Charset.forName("US-ASCII");
                List<String> lines;
                try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                    lines = Files.readAllLines(path, charset);
                } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                    return;
                }
                lines.forEach(System.out::println);
            }
        });

        playGame.setMnemonicParsing(true);
        viewSave.setMnemonicParsing(true);
        exit.setMnemonicParsing(true);
        menu.setMnemonicParsing(true);
        exitMenu.setMnemonicParsing(true);

    }

    private static void mainGame(Stage primaryStage) {

        BorderPane mainGame = new BorderPane();
        VBox moveText = new VBox(20);
        HBox current = new HBox(10);
        TilePane boardTiles = new TilePane();
        ImageView blackPiece = new ImageView("images/black.gif");
        Text currentPlayer = new Text("Current Player: BLACK");
        Turn player = Turn.RED;
        MenuBar menuBar = new MenuBar();
        MenuItem mainMenu = new MenuItem("_Main Menu");
        Menu menu = new Menu("_File");
        MenuItem exit = new MenuItem("_Exit");

        boardTiles.setPadding(new Insets(15));
        boardTiles.setVgap(3);
        boardTiles.setHgap(3);
        boardTiles.setPrefColumns(4);

        menu.getItems().addAll(mainMenu, exit);
        menuBar.getMenus().add(menu);

        moveText.setId("left-pane");
        current.setId("current-top-pane");
        blackPiece.setId("piece");
        currentPlayer.setId("current-player-text");
        mainGame.setId("game-window");

        moveText.setAlignment(Pos.CENTER);

        current.setAlignment(Pos.CENTER);
        current.getChildren().add(currentPlayer);

        mainGame.setTop(menuBar);
        mainGame.setCenter(boardTiles);
        moveText.getChildren().addAll(current, blackPiece, printMoves(getMoves().getMoves()));
        mainGame.setLeft(moveText);


        List<Tile> gameTiles = new ArrayList<>();
        List<HBox> hBoxes = new ArrayList<>();
        HBox tiles;

        Tile.addTiles();

        do {
            Collections.shuffle(getTileTypes());
            Tile gameTile = new Tile(getTileTypes().get(0), getTileTypes().get(1));
            boolean duplicate = false;
            for (Tile existingTile : gameTiles) {
                if (existingTile.equals(gameTile)) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            } else {
                gameTiles.add(gameTile);
            }
        } while (gameTiles.size() < 16);

        for(Tile tile: gameTiles) {
            Image imageOne = new Image("images/" + tile.getIconOne().toString().toLowerCase() + ".jpg");
            Image imageTwo = new Image("images/" + tile.getIconTwo().toString().toLowerCase() + ".jpg");
            ImageView imageViewOne = new ImageView(imageOne);
            ImageView imageViewTwo = new ImageView(imageTwo);
            tiles = new HBox(imageViewOne, imageViewTwo);
            hBoxes.add(tiles);
            boardTiles.getChildren().add(tiles);
        }

//        do {
//            Collections.shuffle(getImages());
//            ImageView imageViewOne = new ImageView(getImages().get(0));
//            ImageView imageViewTwo = new ImageView(getImages().get(1));
//            tiles = new HBox(imageViewOne, imageViewTwo);
//            hBoxes.add(tiles);
//            boardTiles.getChildren().add(tiles);
//        } while (hBoxes.size() < 16);

//        tiles.setOnMouseClicked(e -> {
//            final Circle red = new Circle(30);
//            tiles.getChildren().add(red);
//        });

		if (player == Turn.RED) {

			player = Turn.BLACK;
		} else {
			player = Turn.RED;
		}


        // 1180x470 magic resolution for perfect fit in window
        Scene scene = new Scene(mainGame, 1180, 470);
        scene.getStylesheets().addAll("css/icons.css", "css/main.css");
        primaryStage.setTitle("Game of Niya");
        primaryStage.setScene(scene);
        primaryStage.show();

        mainMenu.setOnAction(e -> {

            Stage main = new Stage();

            primaryStage.close();
            mainMenu(main);

        });

        exit.setOnAction(e -> Platform.exit());

        mainMenu.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        exit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

        menu.setMnemonicParsing(true);
        mainMenu.setMnemonicParsing(true);
        exit.setMnemonicParsing(true);

    }

    private static VBox printMoves(List<String> movesText) {

        VBox movesPane = new VBox(15);
        Text playerText = new Text("Player Moves");

        movesPane.setAlignment(Pos.CENTER);
        movesPane.setSpacing(10);
        movesPane.setId("moves-pane");

        movesPane.getChildren().add(playerText);

        movesText.forEach(e -> {

            Text textToDisplay = new Text(e);
            VBox.setMargin(textToDisplay, new Insets(10));
            movesPane.getChildren().add(textToDisplay);

        });

        return movesPane;

    }

    private static Moves getMoves() {

        Moves moves = new Moves("Player Moves");

        moves.getMoves().add("Red: 0,2 — Computer/Leaf");
        moves.getMoves().add("Black: 0,2 — Computer/Leaf");
        moves.getMoves().add("Black: 0,2 — Computer/Leaf");
        moves.getMoves().add("Black: 0,2 — Computer/Leaf");

        return moves;
    }

    private static void addImages() {


        Images images = new Images();

        Image bird = new Image("images/bird.jpg");
        Image cloud = new Image("images/cloud.jpg");
        Image computer = new Image("images/computer.jpg");
        Image dragon = new Image("images/dragon.jpg");
        Image flower = new Image("images/flower.jpg");
        Image leaves = new Image("images/leaves.jpg");
        Image sun = new Image("images/sun.jpg");
        Image tiger = new Image("images/tiger.jpg");

        images.getImages().add(bird);
        images.getImages().add(cloud);
        images.getImages().add(computer);
        images.getImages().add(dragon);
        images.getImages().add(flower);
        images.getImages().add(leaves);
        images.getImages().add(sun);
        images.getImages().add(tiger);

    }

    public void start(Stage primaryStage) {

        mainMenu(primaryStage);

    }

    public enum Turn {
        BLACK, RED
    }
}
