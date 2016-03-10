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
import javafx.scene.paint.Color;
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

import static lab4part3.Tile.getTileTypes;

public class Main extends Application {

	static Circle redCircle = new Circle();
	static Circle blackCircle = new Circle();
	//	final URL resource = getClass().getResource("sounds/01_Cloud.ogg");
	// AudioClip isn't working for me, throws a NullPointerException
//	final AudioClip clip = new AudioClip(resource.toString());
	PlayerTurn playerTurn = new PlayerTurn();
	StackPane tileStackPane;
	HBox uniqueTiles;
	VBox moveText;
	Button gameButton = new Button();
	Text currentPlayer;
	HBox current;

	public static void main(String[] args) {

		launch(args);

	}

	private static void mainMenu(Stage primaryStage) {

		Main main = new Main();

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
			main.mainGame(secondaryStage);

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


		Image bird = new Image("images/bird.jpg");
		Image cloud = new Image("images/cloud.jpg");
		Image computer = new Image("images/computer.jpg");
		Image dragon = new Image("images/dragon.jpg");
		Image flower = new Image("images/flower.jpg");
		Image leaves = new Image("images/leaves.jpg");
		Image sun = new Image("images/sun.jpg");
		Image tiger = new Image("images/tiger.jpg");

		Images.getImages().add(bird);
		Images.getImages().add(cloud);
		Images.getImages().add(computer);
		Images.getImages().add(dragon);
		Images.getImages().add(flower);
		Images.getImages().add(leaves);
		Images.getImages().add(sun);
		Images.getImages().add(tiger);

	}

	public Text getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Text currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Button getGameButton() {
		return gameButton;
	}

	public void setGameButton(Button gameButton) {
		this.gameButton = gameButton;
	}

	public StackPane getTileStackPane() {
		return tileStackPane;
	}

	public void setTileStackPane(StackPane tileStackPane) {
		this.tileStackPane = tileStackPane;
	}

	public VBox getMoveText() {
		return moveText;
	}

	public void setMoveText(VBox moveText) {
		this.moveText = moveText;
	}

	private void mainGame(Stage primaryStage) {

		GUIUtils guiUtils = new GUIUtils();

		BorderPane mainGame = new BorderPane();
		TilePane tilePane = new TilePane();
		StackPane gameStackPane = new StackPane();
		VBox moveText = new VBox(20);
		HBox current = new HBox(10);
		Text currentPlayer = new Text("Current Player: BLACK");
		Image black = new Image("images/black.gif");
		Image red = new Image("images/red.png");
		ImageView blackPiece = new ImageView("images/black.gif");
		ImageView redPiece = new ImageView("images/red.png");


		redCircle.setFill(Color.RED);
		blackCircle.setFill(Color.BLACK);

		MenuBar menuBar = new MenuBar();
		MenuItem mainMenu = new MenuItem("_Main Menu");
		Menu menu = new Menu("_File");
		MenuItem exit = new MenuItem("_Exit");

		tilePane.setPadding(new Insets(15));
		tilePane.setVgap(3);
		tilePane.setHgap(3);
		tilePane.setPrefColumns(4);

		menu.getItems().addAll(mainMenu, exit);
		menuBar.getMenus().add(menu);

		moveText.setId("left-pane");
		current.setId("current-top-pane");
		blackPiece.setId("piece");
		currentPlayer.setId("current-player-text");
		mainGame.setId("game-window");

		moveText.setAlignment(Pos.CENTER);

		current.setAlignment(Pos.CENTER);
		current.setMinSize(25, 25);
		current.getChildren().add(currentPlayer);

		mainGame.setTop(menuBar);
		mainGame.setCenter(gameStackPane);
		mainGame.setLeft(moveText);


		List<Tile> gameTiles = new ArrayList<>();


		Tile.addTiles();


		// Ensuring unique tiles
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

		gameStackPane.getChildren().add(tilePane);

		// Creating images based on the unique tiles
		for (Tile tile : gameTiles) {
			tileStackPane = new StackPane();
			Image imageOne = new Image("images/" + tile.getIconOne().toString().toLowerCase() + ".jpg");
			Image imageTwo = new Image("images/" + tile.getIconTwo().toString().toLowerCase() + ".jpg");
			ImageView imageViewOne = new ImageView(imageOne);
			ImageView imageViewTwo = new ImageView(imageTwo);
			uniqueTiles = new HBox(imageViewOne, imageViewTwo);
			gameButton = new Button("Play Piece");
			tileStackPane.getChildren().addAll(uniqueTiles, gameButton);
			tilePane.getChildren().add(tileStackPane);
		}


//		gameButton.setOnAction(event -> {
//			if (!blackPlayer) {
//				System.out.println("Piece added");
//				tileStackPane.getChildren().add(redCircle);
//				blackPlayer = true;
//			} else {
//				tileStackPane.getChildren().add(blackCircle);
//				blackPlayer = false;
//			}
//		});


		// 1180x470 magic resolution for perfect fit in window
		Scene scene = new Scene(mainGame, 1180, 470);
		scene.getStylesheets().addAll("css/icons.css", "css/main.css");
		primaryStage.setTitle("Game of Niya");
		primaryStage.setScene(scene);
		primaryStage.show();

		do {
			if (GUIUtils.getPlayer() == PlayerMove.Turn.RED) {
				currentPlayer.setText("Current Player: RED");
				moveText.getChildren().addAll(current, redPiece);
			} else {
				currentPlayer.setText("Current Player: BLACK");
				moveText.getChildren().addAll(current, blackPiece);
			}

			guiUtils.utils();
		} while (guiUtils.isWin());

		mainMenu.setOnAction(e -> {

			Stage main = new Stage();

			primaryStage.close();
			mainMenu(main);

		});

		// AudioClip not working
//		gameButton.setOnAction(event -> {
//			clip.play(1.0);
//		});

		exit.setOnAction(e -> Platform.exit());

		mainMenu.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		exit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

		menu.setMnemonicParsing(true);
		mainMenu.setMnemonicParsing(true);

		exit.setMnemonicParsing(true);

	}

	public void start(Stage primaryStage) {

		mainMenu(primaryStage);

	}

	static class PlayerTurn {

		private Turn player = Turn.RED;

		public PlayerTurn() {

		}

		public Turn getPlayer() {
			return player;
		}

		public void setPlayer(Turn player) {
			this.player = player;
		}

		public enum Turn {
			BLACK, RED
		}

	}

	static class GUIUtils {

		private static PlayerMove playerMove = new PlayerMove();
		private static PlayerMove.Turn player = PlayerMove.Turn.RED;
		Main main = new Main();
		boolean win;

		public static PlayerMove getPlayerMove() {
			return playerMove;
		}

		public static void setPlayerMove(PlayerMove playerMove) {
			GUIUtils.playerMove = playerMove;
		}

		public static PlayerMove.Turn getPlayer() {
			return player;
		}

		public static void setPlayer(PlayerMove.Turn player) {
			GUIUtils.player = player;
		}

		public void whosTurn() {

		}

		public void utils() {

			// This does not seem to be working
			main.getGameButton().setOnAction(event -> {
				if (player == PlayerMove.Turn.RED) {
					System.out.println("Piece added");
					main.getTileStackPane().getChildren().add(redCircle);
					player = PlayerMove.Turn.BLACK;
				} else {
					main.getTileStackPane().getChildren().add(blackCircle);
					player = PlayerMove.Turn.RED;
				}
			});

			System.out.println(player);
		}

		public boolean isWin() {
			return win;
		}

		public void setWin(boolean win) {
			this.win = win;
		}
	}

}

