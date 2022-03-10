package logics;
/*
 * DETTA �R KLASSEN F�R POWERUPEN SPEED. 
 * DEN HAR KOLL P� DENS KOORDINATER, OM PLAYERN INTERSECTAT MED DEN OCH VILKEN IMAGE DEN HAR
 * OCH RITAR �VEN UT IMAGEN 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Speed {
	private int xCoords;
	private int yCoords;
	private int size;
	private static Image speedImage;
	private boolean isSpeeding;

	public Speed(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		this.isSpeeding = false;

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
		gc.drawImage(speedImage, xCoords, yCoords, size, size);
	}

	public void update() {

	}

	public boolean intersect(Player player) {
		Rectangle2D theSpeed = new Rectangle2D(getXCoords(), getYCoords(), 100, 100);
		Rectangle2D thePlayer = new Rectangle2D(player.getXCoords(), player.getYCoords(), 100, 100);
		return theSpeed.intersects(thePlayer);
	}

	public void setIsSpeeding(boolean isSpeeding) {
		this.isSpeeding = isSpeeding;
	}

	public boolean getIsSpeeding() {
		return isSpeeding;
	}

	public static void setPic() {
		try {
			speedImage = new Image(
					new FileInputStream("speed7.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}


