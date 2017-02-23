package FinalExam;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FinalExam extends Application {

  final String csvFile = "data/food.csv";
  Button[][] buttons = new Button[4][4];
  String[] data = new String[20];

  public static void main(String[] args) {
    launch(args);
  }


  public void mainMenu(Stage mainMenuStage) {

    StackPane mainMenuPane = new StackPane();
    VBox mainMenuButtonContainer = new VBox(5);
    Button importRecipe = new Button("Import Recipe");
    Button buyIngredients = new Button("Buy Ingredients");

    mainMenuButtonContainer.getChildren().addAll(importRecipe, buyIngredients);
    mainMenuPane.getChildren().add(mainMenuButtonContainer);
    mainMenuButtonContainer.setAlignment(Pos.CENTER);

    mainMenuPane.setId("main-menu");
    mainMenuPane.getStylesheets().add("css/menu.css");
    Scene mainMenuScene = new Scene(mainMenuPane, 100, 100);
    mainMenuStage.setTitle("Main Menu");
    mainMenuStage.setScene(mainMenuScene);
    mainMenuStage.show();

    importRecipe.setOnMouseClicked(event -> {

            /*
            *
            * Able to get file choose to work, but cannot
            * parse CSV file into my GridPane
            *
            * */

      FileChooser fileChooser = new FileChooser();
      FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
      fileChooser.getExtensionFilters().add(extensionFilter);
      fileChooser.setTitle("Recipe Import");

      String defaultDirectory = System.getProperty("user.home");
      File userDirectory = new File(defaultDirectory);
      if (!userDirectory.canRead()) {
        userDirectory = new File("c:/");
      }
      fileChooser.setInitialDirectory(userDirectory);
      File file = fileChooser.showOpenDialog(null);

      if (file != null) {
        Path path = Paths.get(file.toURI());
        Charset charset = Charset.forName("UTF-8");
        List<String> lines;
        BufferedReader bufferedReader;
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
          lines = Files.readAllLines(path, charset);
          bufferedReader = reader;
        } catch (IOException e) {
          System.err.format("IOException: %s%n", e);
          return;
        }
        lines.forEach(System.out::println);

                /*
                *
                * My attempt at adding the read CSV file
                * into an array
                *
                * */

        for (int k = 0; k < lines.size(); k++) {
          data[k] = lines.get(k);
        }
      }
      mainMenuStage.show();
    });

    buyIngredients.setOnMouseClicked(event -> {

      Stage newStage = new Stage();

      mainMenuStage.close();
      buyIngredientsWindow(newStage);
    });

  }

  public void buyIngredientsWindow(Stage buyIngredientsStage) {

    GridPane ingredientsGrid = new GridPane();
    ingredientsGrid.setPadding(new Insets(5));
    ingredientsGrid.setHgap(2);
    ingredientsGrid.setVgap(2);
    ingredientsGrid.setAlignment(Pos.CENTER);

    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons.length; j++) {
        buttons[i][j] = new Button("Recipe");
        buttons[i][j].setPrefSize(100, 100);
        ingredientsGrid.add(buttons[i][j], j, i + 2);
        ingredientsGrid.getChildren().remove(4, 4);
      }
    }

        /*
        *
        *                   ^
        * Trying to remove the sixteenth button
        *                   v
        *
        * */

    ingredientsGrid.getChildren().remove(4, 4);
    ingredientsGrid.getStylesheets().add("css/main.css");
    Scene scene = new Scene(ingredientsGrid);
    buyIngredientsStage.setScene(scene);
    buyIngredientsStage.show();

  }

  @Override
  public void start(Stage initialStage) {

    mainMenu(initialStage);

  }
}
