/*

 Nominal Application
 Image

*/

package common.image;

import common.NominalMaster;
import common.NominalObject;
import javafx.scene.image.Image;

public class NominalImage extends NominalObject {
    // Atributes
    private int id;
    private Image image;

    /**
     *
     * @param id image id
     * @param image the image
     */
    public NominalImage(int id, Image image) {
        this.id = id;
        this.image = image;
    }

    // GETTERS
    @Override
    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

}
