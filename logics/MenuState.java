package logics;
/*
 * DETTA �R SPELETS MENY D�R MAN KAN V�LJA OLIKA VAL
 * MAN KAN SPELA ELLER AVSLUTA SPELET MED KLICK P� TANGENTBORDET OCH MAN KAN �VEN KOLLA SCORE MED MUSKLICK
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;


public class MenuState extends GameState {

	private String informationText;
	private Color bgColor;
	private Color fontColor;
	private PlayState playState;
	private ScoreState scoreState;
	private Button button;

	public MenuState(GameModel model) {
		super(model);
		playState = new PlayState(model);
		scoreState = new ScoreState(model);
		informationText = "BUBBLE TROUBLE\nPress Enter to Play\nEscape to exit";
		bgColor = Color.RED;
		fontColor = Color.ORANGE;
		button = new Button(810, 700, 150, 50, "High Scores");

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
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getText() + " i MenyState");

		if (key.getCode() == KeyCode.ENTER) {
			model.setScore(0);
			model.switchState(playState);

		} else if (key.getCode() == KeyCode.ESCAPE) {
			System.exit(0);

		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		drawBg(gc, bgColor);

		gc.setFill(fontColor);
		gc.setFont(new Font(70));
		gc.fillText(informationText, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
		button.draw(gc);
		playerMenu.draw(gc);

	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {
		int mx = (int) event.getX();
		int my = (int) event.getY();

		if (mx >= button.getX() && mx <= button.getX() + button.getWidth()) {

			if (my >= button.getY() && my <= button.getY() + button.getHeight()) {

				model.switchState(scoreState);

			}
		}
	}

}
