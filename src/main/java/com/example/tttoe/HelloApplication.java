package com.example.tttoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private InfoCenter infoCenter;
    private TileBoard tileBoard;
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        initLayout(root);
        stage.setScene(scene);
        stage.show();
    }

    private void initLayout(BorderPane root) {
        initInfoCenter(root);
        initTileBoard(root);
    }

    private void initInfoCenter(BorderPane root) {
        infoCenter = new InfoCenter();
        infoCenter.setStartButtonOnAction(startNewGame());
        root.getChildren().add(infoCenter.getStackPane());
    }

    //This method updates the messages for the start of a game
    private EventHandler<ActionEvent> startNewGame(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                infoCenter.hideStartButton();
                infoCenter.updateMessage("Player X's turn");
                tileBoard.startNewGame();
            }
        };
    }
    private void initTileBoard(BorderPane root) {
        tileBoard = new TileBoard(infoCenter);
        root.getChildren().add(tileBoard.getStackPane());
    }

    public static void main(String[] args) {
        launch();
    }
}