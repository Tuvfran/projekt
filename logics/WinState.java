package logics;
/*
 * DENNA KLASSEN �R STATEN MAN KOMMER TILL OM MAN HAR VUNNIT SPELET
 * DEN VISAR TYDLIGT ATT MAN HAR VUNNIT OCH F�RKLARAR HUR MAN TAR SIG TILLBAKA TILL MENYN
 */

import static constants.Constants.SCREEN_HEIGHT;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WinState extends GameState {
	private String winText;
	private String informationText;
	private Color bgColor;
	private Color fontColor;

	public WinState(GameModel model) {
		super(model);
		winText = "YOU WON!\n";
		informationText = "Press ESCAPE to return to the Menu";
		bgColor = Color.HOTPINK;
		fontColor = Color.GOLD;
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model));

		}

	}

	@Override
	public void draw(GraphicsContext gc) {
		drawBg(gc, bgColor);

		gc.setFill(fontColor);
		gc.setFont(new Font(70));
		gc.fillText(winText, 520, SCREEN_HEIGHT / 2);
		gc.fillText(informationText, 100, 550);

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent key) {
		// TODO Auto-generated method stub

	}

}
