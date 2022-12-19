package teambravo.pipergames.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teambravo.pipergames.Controllers.TeamController;

import java.io.IOException;
import java.sql.SQLException;

public class PiperGamesTeamView extends Application {

    TeamController teamController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/teambravo/pipergames/TeamView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 580);
        stage.setTitle("Piper Games");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}


