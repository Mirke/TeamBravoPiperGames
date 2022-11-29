package teambravo.pipergames.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teambravo.pipergames.Controllers.PiperGamesController;

import java.io.IOException;

/**
 * <code>PiperGameMainView</code> is the Front-End Code for graphics.
 */
public class PiperGamesMainView extends Application {

    //---------------------------------------------------------------
    // Properties
    //---------------------------------------------------------------

    PiperGamesController piperGamesController;

    //---------------------------------------------------------------
    // Methods
    //---------------------------------------------------------------
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/teambravo/pipergames/piper-games-mainview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Piper Games");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}