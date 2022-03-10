package logics;
/*
 * DETTA �R SUPERKLASSEN TILL ALLA KLASSER SOM �R STATES
 * DEN SKAPAR ALLA OBJECTEN OCH S�TTER DERAS BILEDER SOM SEDAN KOMMER SYNAS P� CANVASET I DE OLIKA BANORNA
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public abstract class GameState {
	protected GameModel model;
	protected Player player;
	protected Player playerMenu;
	protected Arrow arrow;
	protected Ball ball1;
	protected Ball ballScore;
	protected RedBall ball2;
	protected RedBall ball2Score;
	protected RedBall ball3;
	protected RedBall ball4;
	protected Shield shield;
	protected Speed speed;
	protected Bomb bomb;

	public GameState(GameModel model) {
		this.model = model;

		RedBall.setPic();
		Player.setPic();
		Arrow.setPic();
		Shield.setPic();
		Ball.setPic();
		Speed.setPic();
		Bomb.setPic();

		player = new Player((SCREEN_WIDTH / 2) - 60, 760, 100);
		playerMenu = new Player(60, 200, 620);
		arrow = new Arrow(player.getXCoords(), player.getYCoords(), 100);
		ball1 = new Ball((SCREEN_WIDTH / 3) - 60, 300, 100);
		ballScore = new Ball(800, 200, 300);
		ball2 = new RedBall((SCREEN_WIDTH / 4) - 60, 200, 200);
		ball2Score = new RedBall(1100, 400, 400);
		ball3 = new RedBall((SCREEN_WIDTH / 2) - 60, 200, 60);
		ball4 = new RedBall((SCREEN_WIDTH / 5) - 100, 200, 60);
		shield = new Shield(100, 780, 85);
		speed = new Speed(1400, 780, 85);
		bomb = new Bomb(1100, 780, 85);

	}

	public abstract void keyPressed(KeyEvent key);

	public abstract void mousePressed(MouseEvent key);

	public abstract void draw(GraphicsContext gc);

	public void drawBg(GraphicsContext gc, Color color) {
		gc.setFill(color);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

	}

	public abstract void activate();

	public abstract void deactivate();

	protected abstract void update();

}
