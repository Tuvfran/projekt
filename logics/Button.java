package logics;
/*
 * DETTA �R KLASSEN SOM BYGGER UPP KNAPPARNA I SPELET.
 * DEN TAR IN POSITION, BREDD OCH L�NGD OCH VAD SOM SKA ST� P� KNAPPEN.
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Button {

	private int x, y;
	private int width, height;
	private String label;

	public Button(int x, int y, int width, int height, String label) {

		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.label = label;

	}

	public void draw(GraphicsContext gc) {

		gc.setFill(Color.BLACK);
		gc.setFont(new Font(50));
		gc.fillText(label, x, y + height - 10);

	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public double getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public String getLabel() {
		return this.label;
	}

}
