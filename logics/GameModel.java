package logics;
/*
 * DENNA KLASSEN REPRESENTERAR DET STATET VI �R I JUST NU.
 * KLASSEN H�LLER KOLL P� VILKET STATE VI �R I MED HJ�LP AV METODEN SWITCHSTATE
 * KLASSEN H�LLER �VEN P� PO�NGEN F�R SPELET SOM SPELAS JUST NU
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameModel {
	private GameState currentState;
	private int score = 0;

	public GameModel() {
		this.currentState = new MenuState(this);

	}

	public void switchState(GameState nextState) {
		currentState.deactivate();
		currentState = nextState;
		currentState.activate();
	}

	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	public void mousePressed(MouseEvent event) {

		currentState.mousePressed(event);
	}

	public void update() {
		currentState.update();
	}

	public void draw(GraphicsContext gc) {
		currentState.draw(gc);
	}

	public void setState(GameState currentState) {
		this.currentState = currentState;
	}

	public GameState getState() {

		return currentState;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
