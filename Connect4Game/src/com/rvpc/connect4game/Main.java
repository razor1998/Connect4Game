package com.rvpc.connect4game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public MenuBar createMenu()
    {
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> {
            controller.resetGame();
            controller.resetPanel();
        });
        SeparatorMenuItem sep = new SeparatorMenuItem();
        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> {
            controller.resetGame();
            controller.resetPanel();
        });
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Quit");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame, sep, resetGame, separatorMenuItem, exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem info = new MenuItem("Information");
        info.setOnAction(event -> info());
        SeparatorMenuItem sept = new SeparatorMenuItem();
        MenuItem aboutGame = new MenuItem("About Connect4");
        aboutGame.setOnAction(event -> aboutConnect4());
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(info, sept, aboutGame, separator, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }

    private void info() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("Information");
        alertDialog.setHeaderText("Steps To Play Game");
        alertDialog.setContentText("Step 1. Enter two Player Names.\nStep 2. Click Set Names to begin.\nStep 3. For New Game/Reset navigate\n\t\tFile > New Game/Reset.\nStep 4. To Quit navigate File > Quit.\nEnjoy Game.");
        alertDialog.show();
    }

    private void aboutMe() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About the Developer");
        alertDialog.setHeaderText("Ravi Bhalwal");
        alertDialog.setContentText("I love to play around with code and create games. " +
                "Connect 4 is one of them. In free time " +
                "I like to spend time with nears and dears.\ndev@ : rvpcsite@gmail.com");
        alertDialog.show();
    }

    private void aboutConnect4() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About Connect Four");
        alertDialog.setHeaderText("How To Play?");
        alertDialog.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alertDialog.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
