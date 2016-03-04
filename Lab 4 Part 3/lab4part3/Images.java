package lab4part3;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Images {

    List<Image> images = new ArrayList<>();

    public void Images(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
