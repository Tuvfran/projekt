package logics;
/*
 * DETTA �R KLASSEN F�R FIENDEN BOMB. 
 * DEN HAR KOLL P� DENS KOORDINATER, OM PLAYERN INTERSECTAT MED DEN OCH VILKEN IMAGE DEN HAR
 * OCH RITAR �VEN UT IMAGEN 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb {
	private int xCoords;
	private int yCoords;
	private int size;
	private static Image bombImage;

	public Bomb(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;

	}

	public int getXCoords() {
		return xCoords;
	}

	public void setXCoords(int xCoords) {
		this.xCoords = xCoords;
	}

	public int getYCoords() {
		return yCoords;
	}

	public void setYCoords(int yCoords) {
		this.yCoords = yCoords;
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(bombImage, xCoords, yCoords, size, size);
	}

	public void update() {

	}

	public boolean intersect(Player player) {
		Rectangle2D theBomb = new Rectangle2D(getXCoords(), getYCoords(), 100, 100);
		Rectangle2D thePlayer = new Rectangle2D(player.getXCoords(), player.getYCoords(), 100, 100);
		return theBomb.intersects(thePlayer);
	}

	public static void setPic() {
		try {
			bombImage = new Image(
					new FileInputStream("bomb1.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
