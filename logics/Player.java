package logics;
/*
 * DETTA �R KLASSEN F�R PLAYERN. 
 * DEN HAR KOLL P� DENS KOORDINATER, HUR SPELAREN R�R SIG, OM PLAYERN INTERSECTAT MED EN BOLL OCH VILKEN IMAGE DEN HAR
 * OCH RITAR �VEN UT IMAGEN 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public class Player {
	private int xCoords;
	private int yCoords;
	private int size;
	private int speed;
	private static Image playerImage;

	public Player(int xCoords, int yCoords, int size) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.size = size;
		speed = 14;

	}

	public boolean intersect1(Ball ball1) {
		Rectangle2D thePlayer = new Rectangle2D(getXCoords(), getYCoords(), 80, 90);
		Rectangle2D theBall = new Rectangle2D(ball1.getXCoords(), ball1.getYCoords(), ball1.getSize(), ball1.getSize());
		return thePlayer.intersects(theBall);
	}

	public boolean intersect2(RedBall ball2) {
		Rectangle2D thePlayer = new Rectangle2D(getXCoords(), getYCoords(), 80, 90);
		Rectangle2D theBall = new Rectangle2D(ball2.getXCoords(), ball2.getYCoords(), ball2.getSize(), ball2.getSize());
		return thePlayer.intersects(theBall);
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
		gc.drawImage(playerImage, xCoords, yCoords, size, size);
	}

	public void moveRight() {

		if (xCoords < 1500) {
			xCoords = xCoords + speed;

		}
	}

	public void moveLeft() {
		if (xCoords > 0) {
			xCoords = xCoords - speed;
		}
	}

	public void speedMoveRight() {

		if (xCoords < 1500) {
			xCoords = xCoords + (speed + 15);
		}
	}

	public void speedMoveLeft() {
		if (xCoords > 0) {
			xCoords = xCoords - (speed + 15);
		}
	}

	public boolean getSameCoords(Ball ball1) {
		return false;

	}

	public static void setPic() {
		try {
			playerImage = new Image(new FileInputStream(
					"bubble_trouble_guy.png"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
