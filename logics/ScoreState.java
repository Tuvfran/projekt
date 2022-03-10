package logics;
/*
 * DENNA KLASSEN �R EN STATE SOM MAN KOMMER MAN TILL OM MAN KLICKAR P� KNAPPEN "HIGHSCORE" I MENYN
 * DEN VISAR DINA PO�NG OCH VISAR HIGHSCORE
 */
import java.io.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreState extends GameState {

	private String informationText;
	private Color bgColor;
	private Color fontColor;

	public ScoreState(GameModel model) {
		super(model);
		informationText = "Press ESCAPE to return to the menu";
		bgColor = Color.CORAL;
		fontColor = Color.WHITE;
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
		gc.setFont(new Font(50));
		gc.fillText(informationText, 250, 820);
		gc.fillText("Highscore:", 250, 320);

		try {
			InputStream is = new FileInputStream("highscore.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String s;
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			gc.fillText(sb.toString(), 550, 320);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		gc.fillText("Your score: ", 250, 400);
		gc.fillText(Integer.toString(model.getScore()), 550, 402);
		ballScore.draw(gc);
		ball2Score.draw(gc);

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
