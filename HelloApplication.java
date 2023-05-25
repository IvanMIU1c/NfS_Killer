package com.example.racergame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene sceneMainMenu = new Scene(fxmlLoader1.load(), 1100, 800);
        Pane pane = new Pane();
        Scene sceneLvl = new Scene(pane, 1100, 800);
        Button btnPlay = (Button) sceneMainMenu.lookup("#play");
        Button btnExit = (Button) sceneMainMenu.lookup("#exit");
        btnPlay.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneLvl);
            GameLauncher.launch(sceneLvl, pane);
        });

        btnExit.setOnMouseClicked(mouseEvent -> stage.close());
        stage.setScene(sceneMainMenu);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}