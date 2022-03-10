package logics;
/*
 * DENNA KLASSEN �R BANA TV� I SPELET.
 * DEN INNEH�LLER SPELAREN, POWERUPEN SPEED OCH FIENDEN I FORM AV R�DA BOLLAR.
 * DEN TAR EXEMPELVIS HAND OM EVENTUELLA KLICK P� TANGENTBORDET
 * OCH SKICKAR VIDARE EN TILL OLIKA STATES BEROENDE P� OM MAN KLARAR BANAN ELLER INTE
 */

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayStateTwo extends GameState {
	private String informationText;
	private Color bgColor;
	private Color fontColor;
	private ArrayList<Arrow> arrows = new ArrayList<>();
	boolean ballHit = false;
	private GameOverState gameOverState;
	private WinState winState;

	public PlayStateTwo(GameModel model) {
		super(model);
		informationText = "LEVEL 2!\nPress SPACE to fire arrows at the balls\nPress Escape to return to the Menu";
		bgColor = Color.GOLD;
		fontColor = Color.GREEN;
		gameOverState = new GameOverState(model);
		winState = new WinState(model);

	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model));
		} else if (key.getCode() == KeyCode.RIGHT) {
			if (speed.getIsSpeeding() == true) {
				player.speedMoveRight();
			} else {
				player.moveRight();
			}
		} else if (key.getCode() == KeyCode.LEFT) {
			if (speed.getIsSpeeding() == true) {
				player.speedMoveLeft();
			} else {
				player.moveLeft();
			}
		} else if (key.getCode() == KeyCode.SPACE) {
			arrows.add(new Arrow(player.getXCoords(), player.getYCoords(), 100));
		}

	}

	@Override
	public void draw(GraphicsContext gc) {
		drawBg(gc, bgColor);

		gc.setFill(fontColor);
		gc.setFont(new Font(30));
		gc.fillText(informationText, SCREEN_WIDTH / 3, SCREEN_HEIGHT / 3);

		for (Arrow arrow : arrows) {
			arrow.draw(gc);
		}
		player.draw(gc);

		if (ball2.getHasBeenHit() == false) {
			ball2.draw(gc);
		} else {
			if (ball3.getHasBeenHit() == false) {
				ball3.draw(gc);
			}
			if (ball4.getHasBeenHit() == false) {
				ball4.draw(gc);
			}
		}
		if (speed.getIsSpeeding() == false) {
			speed.draw(gc);
		}
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update() {
		checkIntersectPB();
		checkIntersectBA();
		checkLevelFinished();
		checkIntersectSpeedP();

		if (ball2.getHasBeenHit() == false) {
			ball2.update();
		} else {
			if (ball3.getHasBeenHit() == false) {
				ball3.update();
			}
			if (ball4.getHasBeenHit() == false) {
				ball4.update();
			}
		}

		for (Arrow arrow : arrows) {
			arrow.update();
		}
		speed.update();
	}

	public void checkIntersectPB() {
		if (player.intersect2(ball2) || player.intersect2(ball3) || player.intersect2(ball4)) {
			model.setState(gameOverState);
		}

	}

	public void checkIntersectSpeedP() {
		if (speed.intersect(player)) {
			speed.setIsSpeeding(true);
			speed.setYCoords(0);
		}
	}

	public void checkLevelFinished() {
		if (ball2.getHasBeenHit() == true && ball3.getHasBeenHit() == true && ball4.getHasBeenHit() == true) {
			model.setScore(15);
			model.switchState(winState);
		}
	}

	public void checkIntersectBA() {
		for (Arrow arrow : arrows) {
			if (ball2.intersect(arrow)) {
				ball2.destroy();
				ball2.setHasBeenHit(true);
			}
			if (ball3.intersect(arrow)) {
				ball3.destroy();
				ball3.setHasBeenHit(true);
			}
			if (ball4.intersect(arrow)) {
				ball4.destroy();
				ball4.setHasBeenHit(true);

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent key) {
		// TODO Auto-generated method stub

	}
}

