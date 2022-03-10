package logics;
/*
 * DETTA �R KLASSEN F�R POWERUPEN SHIELD. 
 * DEN HAR KOLL P� DENS KOORDINATER, OM PLAYERN INTERSECTAT MED DEN OCH VILKEN IMAGE DEN HAR
 * OCH RITAR �VEN UT IMAGEN 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shield {
	private int xCoords;
	private int yCoords;
	private int size;
	private static Image shieldImage;
	private boolean isProtecting;
	private boolean hasBeenUsed;

	public Shield(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		this.isProtecting = false;
		this.hasBeenUsed = false;

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
		gc.drawImage(shieldImage, xCoords, yCoords, size, size);
	}

	public void update() {

	}

	public boolean intersect(Player player) {
		Rectangle2D theShield = new Rectangle2D(getXCoords(), getYCoords(), 100, 100);
		Rectangle2D thePlayer = new Rectangle2D(player.getXCoords(), player.getYCoords(), 100, 100);
		return theShield.intersects(thePlayer);
	}

	public void setIsProtecting(boolean isProtecting) {
		this.isProtecting = isProtecting;
	}

	public boolean getIsProtecting() {
		return isProtecting;
	}

	public boolean getHasBeenUsed() {
		return hasBeenUsed;
	}

	public void setHasBeenUsed(boolean hasBeenUsed) {
		this.hasBeenUsed = hasBeenUsed;

	}

	public static void setPic() {
		try {
			shieldImage = new Image(
					new FileInputStream("shield3.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}
