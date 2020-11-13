import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class MainMenu extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Main Menu");

        //Layout
        BorderPane root = new BorderPane();
        AnchorPane navigationArea = new AnchorPane();
        VBox menuContent = new VBox(20);
        GridPane ballOptions = new GridPane();

        //Layout properties
        root.setPadding(new Insets(30));
        ballOptions.setHgap(20);
        ballOptions.setVgap(10);
        menuContent.setAlignment(Pos.CENTER);
        ballOptions.setAlignment(Pos.CENTER);

        //Nodes
        TextField playerName = new TextField();
        Label selectColor = new Label("Select ball color");
        Label playerNameLbl = new Label("Player's name");
        Circle color1 = new Circle();
        Circle color2 = new Circle();
        Circle color3 = new Circle();

        Button play_btn = new Button("Play");
        Button close_btn = new Button("Exit");

        //Nodes' css selector
        play_btn.getStyleClass().add("green");
        close_btn.getStyleClass().add("green");
        playerName.getStyleClass().add("playerNameTxt");
        color1.setId("color1");
        color2.setId("color2");
        color3.setId("color3");


        //Nodes' properties
        playerName.setPrefWidth(200);
        playerName.setMaxWidth(200);
        color1.setRadius(15);
        color2.setRadius(15);
        color3.setRadius(15);
        color1.setFill(Color.RED);
        color2.setFill(Color.GREEN);
        color3.setFill(Color.BLUE);


        //Nodes' controller
        //play_btn.setOnAction(e->window.setScene());

        // Add buttons to holder
        navigationArea.getChildren().add(play_btn);
        navigationArea.getChildren().add(close_btn);

        // Delete top left
        AnchorPane.setTopAnchor(close_btn, 0.0);
        AnchorPane.setLeftAnchor(close_btn, 0.0);


        // Back bottom right
        AnchorPane.setBottomAnchor(play_btn, 0.0);
        AnchorPane.setRightAnchor(play_btn, 0.0);

        //Menu content
        menuContent.getChildren().addAll(playerNameLbl, playerName, selectColor, ballOptions);
        ballOptions.add(color1, 0,1);
        ballOptions.add(color2, 1,1);
        ballOptions.add(color3, 2,1);

        root.setCenter(menuContent);
        root.setBottom(navigationArea);

        //Adding to stage
        Scene scene = new Scene(root, 480, 600);
        scene.getStylesheets().add("style/style.css");
        window.setScene(scene);
        window.show();

    }
}
