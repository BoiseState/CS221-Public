import java.awt.Color;

/**
 * Square extends Rectangle and is more highly specific - width and height are the same.
 */
public class Square extends Rectangle {

	/**
	 * constructor actually requires FEWER args than parent Rectangle because only one dimension is needed
	 */
	public Square(int anchorX, int anchorY, int dimension, Color color) {
		super(anchorX, anchorY, dimension, dimension, color); //dimension is passed to super() for both width and height
	}

	@Override
	public String toString() {
		return String.format("Square: x:%d, y:%d, width:%d, height:%d, color:%s",
			anchorX, anchorY, width, height, color.toString());
	}

}
