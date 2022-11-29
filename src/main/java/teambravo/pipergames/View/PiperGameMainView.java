package teambravo.pipergames.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teambravo.pipergames.Controller.PiperGameController;

import java.io.IOException;

/**
 * <code>PiperGameMainView</code> is the Front-End Code for graphics.
 */
public class PiperGameMainView extends Application {

    //---------------------------------------------------------------
    // Properties
    //---------------------------------------------------------------

    PiperGameController piperGameController;

    //---------------------------------------------------------------
    // Methods
    //---------------------------------------------------------------
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/teambravo/pipergames/piper-game-mainview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Piper Games");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}