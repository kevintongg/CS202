package lab4part3;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Images {

	private static List<Image> images = new ArrayList<>();
	private Image imageOne;
	private Image imageTwo;

	public Images() {

	}

	public Images(Image imageOne, Image imageTwo) {
		this.imageOne = imageOne;
		this.imageTwo = imageTwo;
	}

	public static List<Image> getImages() {
		return images;
	}

	public static void setImages(List<Image> images) {
		Images.images = images;
	}

	public Image getImageOne() {
		return imageOne;
	}

	public void setImageOne(Image imageOne) {
		this.imageOne = imageOne;
	}

	public Image getImageTwo() {
		return imageTwo;
	}

	public void setImageTwo(Image imageTwo) {
		this.imageTwo = imageTwo;
	}
}
