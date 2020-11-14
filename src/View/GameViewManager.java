package View;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameViewManager {
    private BorderPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private final GridPane gameInfo = new GridPane();

    private static final int PREF_WIDTH = 480;
    private static final int PREF_HEIGHT = 600;

    private Stage menuStage;
    private String colorID;

    public GameViewManager() {
        initializeStage();
        createKeyListener();
    }

    //Event handler to controller A,D key press
    //This will help
    private void createKeyListener() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.D) {

                } else if (keyEvent.getCode() == KeyCode.A) {

                }

            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }

    private void initializeStage() {
        gamePane = new BorderPane();
        gameScene = new Scene(gamePane, PREF_WIDTH, PREF_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuStage, String selectedColor, String playerName) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        setText(selectedColor, playerName);
        gameStage.show();
    }

    private void setText(String color, String name) {
        Label ballColor = new Label("Ball color:  " + color);
        Label playerName = new Label("Player's name: " + name);

        Label message = new Label("Main game goes here.");

        gameInfo.add(ballColor, 0, 1);
        gameInfo.add(playerName, 1, 1);

        gameInfo.setHgap(20);
        gameInfo.setVgap(10);

        gamePane.setTop(gameInfo);
        gamePane.setCenter(message);
    }


}
