package Model;

import Model.TileLineBlock;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
 
public class TilePlaneBlock {
    private VBox tilePlaneObject;
    private TileLineBlock[] tileLinesObject;
    
    public TilePlaneBlock() {
        this.tilePlaneObject = new VBox(5);
        this.tileLinesObject = new TileLineBlock[6];
        for (int i = 0; i < 6; i++) {
            this.tileLinesObject[i] = new TileLineBlock();
            tilePlaneObject.getChildren().add(this.tileLinesObject[i].getTileLineObject());
        }
        tilePlaneObject.setAlignment(Pos.CENTER);
    }
    
    public VBox getTilePlaneObject() {
        return this.tilePlaneObject;
    }
     
    public TileLineBlock[] getTileLinesObject() {
        return this.tileLinesObject;
    }
}