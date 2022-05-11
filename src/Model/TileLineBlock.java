package Model;

import Controller.TileBlock;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
 
public class TileLineBlock {
    private HBox tileLineObject;
    private TileBlock[] tilesObject;
 
    public TileLineBlock() {
        this.tileLineObject = new HBox(4);
        this.tilesObject = new TileBlock[5];
        for (int i = 0; i < 5; i++) {
            this.tilesObject[i] = new TileBlock();
            tileLineObject.getChildren().add(this.tilesObject[i].getStackPane());
        }
        tileLineObject.setAlignment(Pos.CENTER);
    }
     
    public HBox getTileLineObject() {
        return this.tileLineObject;
    }
    
    public TileBlock[] getTilesObject() {
        return this.tilesObject;
    }
}