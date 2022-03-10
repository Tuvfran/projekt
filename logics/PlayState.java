package logics;
/*
 * DENNA KLASSEN �R BANA ETT I SPELET.
 * DEN INNEH�LLER SPELAREN, POWERUPEN SHIELD OCH FIENDER I FORM AV EN GUL BOLL OCH EN BOMB.
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

public class PlayState extends GameState {

	private String informationText;
	private Color bgColor;
	private Color fontColor;
	private ArrayList<Arrow> arrows = new ArrayList<>();
	boolean ballHit = false;

	private GameOverState gameOverState;

	public PlayState(GameModel model) {
		super(model);

		gameOverState = new GameOverState(model);
		informationText = "LEVEL 1!\nPress SPACE to fire arrows at the balls\nPress ESCAPE to return to the Menu ";
		bgColor = Color.LIGHTBLUE;
		fontColor = Color.BLUE;

	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model));
		} else if (key.getCode() == KeyCode.RIGHT) {
			player.moveRight();
		} else if (key.getCode() == KeyCode.LEFT) {
			player.moveLeft();
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

		bomb.draw(gc);

		if (ballHit == false) {
			ball1.draw(gc);
		}
		if (shield.getIsProtecting() == false && shield.getHasBeenUsed() == false) {
			shield.draw(gc);
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
		checkIntersectSP();
		checkIntersectBombP();
		if (ballHit == false) {
			ball1.update();
		}

		for (Arrow arrow : arrows) {
			arrow.update();
		}
		shield.update();

		bomb.update();

	}

	public void checkIntersectPB() {
		if (player.intersect1(ball1)) {
			if (shield.getIsProtecting() == true) {
				shield.setIsProtecting(false);
				shield.setHasBeenUsed(true);
				ball1.setXCoords(700);
				ball1.setYCoords(200);
			} else {
				model.setScore(0);
				ball1.setHasBeenHit(false);
				model.switchState(gameOverState);
			}
		}

	}

	public void checkIntersectSP() {
		if (shield.intersect(player)) {
			shield.setIsProtecting(true);
			shield.setYCoords(0);
		}
	}

	public void checkIntersectBombP() {
		if (bomb.intersect(player)) {
			model.setScore(0);
			model.switchState(gameOverState);
		}
	}

	public void checkLevelFinished() {
		if (ball1.getHasBeenHit() == true) {
			model.setScore(5);
			model.switchState(new PlayStateTwo(model));

		}
	}

	public void checkIntersectBA() {
		for (Arrow arrow : arrows) {
			if (ball1.intersect(arrow)) {
				ballHit = true;
				ball1.destroy();
				ball1.setHasBeenHit(true);

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent key) {
		// TODO Auto-generated method stub

	}

}
