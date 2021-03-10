package com.javafx.connect4game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
		GridPane rootGridPane = loader.load();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		controller = loader.getController();
		controller.createPlayground();

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		primaryStage.setTitle("Connect Four");
		primaryStage.setScene(new Scene(rootGridPane, 300, 275));
		primaryStage.setResizable(true);
		primaryStage.show();
	}

	public MenuBar createMenu() {
		Menu fileMenu = new Menu("File");

		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(actionEvent -> {
			controller.resetGame();
		});

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction(actionEvent -> {
			controller.resetGame();
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

		Menu helpMenu = new Menu("Help");

		MenuItem aboutGame = new MenuItem("About Connect4");
		aboutGame.setOnAction(actionEvent -> aboutConnect4());

		SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();

		MenuItem aboutMe = new MenuItem("About me");
		aboutMe.setOnAction(actionEvent -> aboutMe());
		helpMenu.getItems().addAll(aboutGame, separatorMenuItem1, aboutMe);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About the Developer");
		alert.setHeaderText("Jasvinder Singh");
		alert.setContentText("I love to play around with codes and create games.Connect four is the most loveable game played between two friends.");
		alert.show();
	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connnect Four");
		alert.setHeaderText("How to play");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
		alert.show();
	}

	private void reset() {
		//todo
	}


	public static void main(String[] args) {
		launch(args);
	}
}
