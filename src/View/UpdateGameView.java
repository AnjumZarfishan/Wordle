package View;

import Controller.WordHandler;
import Model.TilePlaneBlock;
import Model.StatusWorlde;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.animation.RotateTransition;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Alert;
import javafx.animation.TranslateTransition;
import javafx.scene.text.TextAlignment;
 
public class UpdateGameView {
    private int currentRowObject;
    private int currentColumnObject;
    private Text statusTextObject;
    private TilePlaneBlock tilePlaneObject;
    private VBox vboxObject;
    private Text gameNameObject ;
    private Button resetButtonObject;
    private Button instructionButtonObject;
    private String currentWordObject;
    private String enteredWordObject;
    private boolean winGameObject;
    
    public UpdateGameView() {
        this.currentRowObject = 0;
        this.currentColumnObject = 0;
        this.statusTextObject = new Text("Try guessing a word!");
        this.tilePlaneObject = new TilePlaneBlock();
        this.vboxObject = new VBox(50);
        this.gameNameObject = new Text("Wordle");
        this.resetButtonObject = new Button("Reset");
        this.instructionButtonObject = new Button("Instructions");
        this.currentWordObject = WordHandler.randomWordGenerater();
        this.enteredWordObject = "";
        this.winGameObject = false;
    }
   
    public void startGame(Stage primaryStage) {
        this.vboxObject.setAlignment(Pos.CENTER);
        Font fontObject = Font.font("Verdana", FontWeight.BOLD, 40);
        this.gameNameObject.setFont(fontObject);
        this.vboxObject.getChildren().addAll(this.gameNameObject, this.tilePlaneObject.getTilePlaneObject());
        HBox hboxObject = new HBox(10);
        hboxObject.getChildren().addAll(this.statusTextObject, this.resetButtonObject, this.instructionButtonObject);
        hboxObject.setAlignment(Pos.CENTER);
        this.vboxObject.getChildren().add(hboxObject);
    }
     
    public void loseGameText() {
        this.statusTextObject.setText(String.format("Game over. The word was %s.", this.currentWordObject));
    }
    
    public void winGameText() {
        this.statusTextObject.setText("Congratulations! You’ve guessed the word!");
    }
    
    public void resetGameOption() {
        statusTextObject.setText("Try guessing a word!");
        currentWordObject = WordHandler.randomWordGenerater();
        this.winGameObject = false;
        this.currentColumnObject = 0;
        this.currentRowObject = 0;
        this.enteredWordObject = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                tilePlaneObject.getTileLinesObject()[i].getTilesObject()[j].setLetterObject("");
                tilePlaneObject.getTileLinesObject()[i].getTilesObject()[j].setStatusObject(StatusWorlde.EMPTYBLOCK);
            }
        }
    }
    
    public void handleKeyPressed(KeyEvent keyEvent) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> lettersList = new ArrayList<>(Arrays.asList(letters));

        if (lettersList.contains(keyEvent.getText())) {
            if (currentColumnObject < 5 && currentRowObject < 6 && !winGameObject) {
                this.enteredWordObject += keyEvent.getText();
                this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[currentColumnObject].setLetterObject(
                    keyEvent.getText().toUpperCase());
                this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[currentColumnObject].setStatusObject(StatusWorlde.FILLBLOCK);
                ScaleTransition scaleTransition = new ScaleTransition();
                scaleTransition.setDuration(Duration.millis(50));
                scaleTransition.setNode(this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[currentColumnObject].getRectangleObject());
                scaleTransition.setByY(0.1);
                scaleTransition.setByX(0.1);
                scaleTransition.setCycleCount(2);
                scaleTransition.setAutoReverse(true);
                scaleTransition.play();
                currentColumnObject++;
            }
        } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            if (currentColumnObject > 0) {
                this.enteredWordObject = this.enteredWordObject.substring(0, this.enteredWordObject.length() - 1);
                currentColumnObject--;
                this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[currentColumnObject].setLetterObject("");
                this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[currentColumnObject].setStatusObject(StatusWorlde.EMPTYBLOCK);
            }
        } else if (keyEvent.getCode() == KeyCode.ENTER) {
            if (currentColumnObject < 5 && currentRowObject < 6 && !winGameObject) {
                TranslateTransition translateTransition = new TranslateTransition();
                translateTransition.setDuration(Duration.millis(50));
                translateTransition.setNode(this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTileLineObject());
                translateTransition.setByX(5);
                translateTransition.setCycleCount(6);
                translateTransition.setAutoReverse(true);
                translateTransition.play();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Not enough Letters. Guess again.");
                alert.showAndWait();
                statusTextObject.setText("Not enough Letters. Guess again.");
            } else if (currentRowObject < 6 && !winGameObject) {
                flipTileBlock();
                this.winGameObject = true;
                statusTextObject.setText("Keep guessing.");
                for (int i = 0; i < 5; i++) {
                    if (this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[i].getStatusObject() != StatusWorlde.CORRECTBLOCK) {
                        this.winGameObject = false;
                    }
                }
                if (this.winGameObject) {
                    winGameText();
                    for (int i = 0; i < 5; i++) {
                        TranslateTransition translateTransition1 = new TranslateTransition();
                        translateTransition1.setNode(this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[i].getStackPane());
                        translateTransition1.setByY(-15);
                        translateTransition1.setCycleCount(2);
                        translateTransition1.setAutoReverse(true);
                        translateTransition1.setDuration(Duration.millis(500));
                        translateTransition1.play();
                    }
                }
                this.enteredWordObject = "";
                currentRowObject++;
                currentColumnObject = 0;
                if (this.currentRowObject == 6) {
                    loseGameText();
                }
            }
        }
    }
     
    public void flipTileBlock() {
        for (int i = 0; i < 5; i++) {
            RotateTransition rtObject = new RotateTransition();
            rtObject.setNode(this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[i].getStackPane());
            rtObject.setAxis(Rotate.X_AXIS);
            rtObject.setCycleCount(2);
            rtObject.setDuration(Duration.millis(500));
            rtObject.setByAngle(90);
            rtObject.setAutoReverse(true);
            rtObject.play();
            this.tilePlaneObject.getTileLinesObject()[currentRowObject].getTilesObject()[i].setStatusObject(
                WordHandler.checkIndexWorld(this.enteredWordObject, i));
        }
    }
    
    public void showInstructions() {
        Text textObject = new Text("Hello, welcome to Wordle.");
        textObject.setTextAlignment(TextAlignment.RIGHT);
        Text text2Object = new Text("\nGuess the Wordle in six tries.");
        text2Object.setTextAlignment(TextAlignment.CENTER);
        Text text3Object = new Text("\nEach guess must be a valid five-letter word.");
        text3Object.setTextAlignment(TextAlignment.CENTER);
        Text text4Object = new Text("\nHit the enter button to submit.");
        text4Object.setTextAlignment(TextAlignment.CENTER);
        Text text5Object = new Text("\nAfter each guess, the color of the tiles will");
        text5Object.setTextAlignment(TextAlignment.CENTER);
        VBox vbox2Object = new VBox(textObject, text2Object, text3Object, text4Object, text5Object);
        vbox2Object.setAlignment(Pos.CENTER);
        Scene instructionObject = new Scene(vbox2Object, 350, 300);
        Stage stageObject = new Stage();
        stageObject.setTitle("Instructions Wordle");
        stageObject.setScene(instructionObject);
        stageObject.show();
    }
    
    public TilePlaneBlock getTilePlaneObject() {
        return this.tilePlaneObject;
    }
    
    public int getRowObject() {
        return this.currentRowObject;
    }
     
    public int getColumnObject() {
        return this.currentColumnObject;
    }
    
    public VBox getVBoxObject() {
        return this.vboxObject;
    }
    
    public String getCurrentWordObject() {
        return this.currentWordObject;
    }
    
    public Button getInstuctionButtonObject() {
        return this.instructionButtonObject;
    }
     
    public Button getResetButtonObject() {
        return this.resetButtonObject;
    }
}