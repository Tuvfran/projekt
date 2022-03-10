package graphics;

/*
 * DENNA KLASSEN EXTENDAR HBOX OCH ANV�NDS F�R ATT SKAPA GAMEPANEL OCH L�GGA TILL PANELEN I GAMEFRAMEN
 */
import javafx.scene.layout.HBox;
import logics.GameModel;

public class GameFrame extends HBox {
	private GamePanel gp;

	public GameFrame(GameModel model, int width, int height) {
		gp = new GamePanel(model, width, height);
		this.getChildren().add(gp);

	}

	public void repaint() {
		gp.repaint();

	}
}
