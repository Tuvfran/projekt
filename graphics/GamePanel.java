package graphics;
/*
 * DENNA KALSSEN �R V�RT CANVAS SOM ANV�NDS I ALLA STATES
 * H�R SKAPAS �VEN GAMEMODEL SOM SKICKAS TILL ALLA STATES
 */

import javafx.scene.canvas.Canvas;
import logics.GameModel;

public class GamePanel extends Canvas {

	private GameModel model;

	public GamePanel(GameModel model, int width, int height) {
		this.model = model;
		this.setWidth(width);
		this.setHeight(height);

	}

	public void repaint() {
		model.draw(getGraphicsContext2D());
	}

}
