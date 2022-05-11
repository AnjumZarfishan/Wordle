package Controller;

import Model.StatusWorlde;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

 
public class TileBlock {

    private static final int WIDTHObject = 62;
    private static final int HEIGHTObject = 62;
    private static final Font FONTObject = Font.font("Verdana", FontWeight.BOLD, 32);;
    private String letterObject;
    private StatusWorlde statusObject;
    private Label labelObject;
    private Rectangle rectangleObject;
    private StackPane stackpaneObject;
    
    public TileBlock() {
        this.letterObject = "";
        this.statusObject = StatusWorlde.EMPTYBLOCK;
        this.rectangleObject = new Rectangle(WIDTHObject, HEIGHTObject);
        this.labelObject = new Label(letterObject);
        this.labelObject.setFont(FONTObject);
        this.rectangleObject.setFill(Color.TRANSPARENT);
        this.rectangleObject.setStroke(Color.LIGHTGRAY);
        this.rectangleObject.setStrokeWidth(2);
        this.stackpaneObject = new StackPane();
        stackpaneObject.getChildren().addAll(this.rectangleObject, this.labelObject);
    }
    
    public String getLetterObject() {
        return this.letterObject;
    }
    
    public void setLetterObject(String letterObject) {
        this.letterObject = letterObject;
        this.labelObject.setText(letterObject);
    }
    
    public StatusWorlde getStatusObject() {
        return this.statusObject;
    }
  
    public void setStatusObject(StatusWorlde statusObject) {
        this.statusObject = statusObject;
        switch (this.statusObject) {
        case EMPTYBLOCK:
            this.rectangleObject.setFill(Color.TRANSPARENT);
            this.labelObject.setTextFill(Color.BLACK);
            this.rectangleObject.setStroke(Color.LIGHTGRAY);
            break;
        case CORRECTBLOCK:
            this.rectangleObject.setFill(Color.LIMEGREEN);
            this.labelObject.setTextFill(Color.WHITE);
            this.rectangleObject.setStroke(Color.TRANSPARENT);
            break;
        case WRONGBLOCK:
            this.rectangleObject.setFill(Color.GRAY);
            this.labelObject.setTextFill(Color.WHITE);
            this.rectangleObject.setStroke(Color.TRANSPARENT);
            break;
        case SIMILARBLOCK:
            this.rectangleObject.setFill(Color.KHAKI);
            this.labelObject.setTextFill(Color.WHITE);
            this.rectangleObject.setStroke(Color.TRANSPARENT);
            break;
        case FILLBLOCK:
            this.rectangleObject.setFill(Color.TRANSPARENT);
            this.rectangleObject.setStroke(Color.DIMGRAY);
            this.labelObject.setTextFill(Color.BLACK);
            break;
        default:
        }
    }
     
    public Label getLabelObject() {
        return this.labelObject;
    }
  
    public Rectangle getRectangleObject() {
        return this.rectangleObject;
    }
     
    public StackPane getStackPane() {
        return this.stackpaneObject;
    }
}