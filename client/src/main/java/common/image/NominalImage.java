package common.image;

import common.NominalMaster;
import common.NominalObject;
import javafx.scene.image.Image;

public class NominalImage extends NominalObject {

    private int id;
    private Image image;

    public NominalImage(int id, Image image) {
        this.id = id;
        this.image = image;
    }

    @Override
    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

}
