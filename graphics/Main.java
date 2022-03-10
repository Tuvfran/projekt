package graphics;
/*
 * DETTA �R MAIN-KLASSEN 
 * DET �R H�R PROGRAMMET B�RJAR K�RAS
 * DEN SKAPAR EXEMPELVIS SCENEN, GAMEMODEL, GAMEFRAME OCH STARTAR MED SHOW
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logics.GameModel;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Bubble Trouble");
		primaryStage.setWidth(1600);
		primaryStage.setHeight(900);

		GameModel model = new GameModel();
		GameFrame frame = new GameFrame(model, 1600, 900);

		Scene mainScene = new Scene(frame);

		final double targetFps = 50.0;
		final double nanoPerUpdate = 1000000000.0 / targetFps;
		primaryStage.setScene(mainScene);

		mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				model.keyPressed(event);
			}
		});
		mainScene.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				model.mousePressed(event);
			}

		});

		new AnimationTimer() {
			long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if ((now - lastUpdate) > nanoPerUpdate) {
					model.update();
					frame.repaint();
					lastUpdate = now;
				}

			}

		}.start();

		primaryStage.show();

	}

}
