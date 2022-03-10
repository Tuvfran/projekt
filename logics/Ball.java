package logics;
/*
 * DETTA �R KLASSEN F�R FIENDEN YELLOWBALL. 
 * DEN HAR KOLL P� DENS KOORDINATER OCH R�RELSE, OM ARROWN INTERSECTAT MED DEN OCH VILKEN IMAGE DEN HAR
 * OCH RITAR �VEN UT IMAGEN 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Ball {
	private int xCoords;
	private int yCoords;
	private int size;
	private int xSpeed;
	private int ySpeed;
	private static Image ballImage;
	private Boolean hasBeenHit;

	public Ball(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		xSpeed = 20;
		ySpeed = 5;
		this.hasBeenHit = false;

	}

	public boolean intersect(Arrow arrow) {
		Rectangle2D theArrow = new Rectangle2D(arrow.getXCoords(), arrow.getYCoords(), 70, 100);
		Rectangle2D theBall = new Rectangle2D(getXCoords(), getYCoords(), size, size);
		return theArrow.intersects(theBall);

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
		gc.drawImage(ballImage, xCoords, yCoords, size, size);

	}

	public void update() {

		xCoords = xCoords + xSpeed;
		yCoords = yCoords + ySpeed;

		if (yCoords > SCREEN_HEIGHT - 140 || yCoords < 0) {
			ySpeed = ySpeed * -1;

		} else if (xCoords > SCREEN_WIDTH - 140 || xCoords < 0) {
			xSpeed = xSpeed * -1;

		}

	}

	public void destroy() {
		this.yCoords = 0;
	}

	public void setHasBeenHit(boolean hasBeenHit) {
		this.hasBeenHit = hasBeenHit;
	}

	public boolean getHasBeenHit() {
		return hasBeenHit;
	}

	public static void setPic() {

		try {
			ballImage = new Image(
					new FileInputStream("yellowBall7.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
