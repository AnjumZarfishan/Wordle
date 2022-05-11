package Application;

import Model.WordsModel;
import View.UpdateGameView;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
 
public class Wordle extends Application {
    @Override
    public void start(Stage primaryStage) {
        UpdateGameView updateGameObject = new UpdateGameView();
        Scene sceneObject = new Scene(updateGameObject.getVBoxObject(), 650, 700);
        updateGameObject.startGame(primaryStage);
        primaryStage.setScene(sceneObject);
        primaryStage.show();
        updateGameObject.getResetButtonObject().setFocusTraversable(false);
        updateGameObject.getInstuctionButtonObject().setFocusTraversable(false);
        sceneObject.addEventFilter(KeyEvent.KEY_PRESSED,
                (KeyEvent e) -> {
                    updateGameObject.handleKeyPressed(e);
                });
        updateGameObject.getInstuctionButtonObject().setOnAction(
                ae -> updateGameObject.showInstructions()
        );
        updateGameObject.getResetButtonObject().setOnAction(
                ae -> updateGameObject.resetGameOption()
        );
    }
    
     public static void main(String[] args) throws FileNotFoundException {
      WordsModel.ReadFile();
      launch();
    }
}