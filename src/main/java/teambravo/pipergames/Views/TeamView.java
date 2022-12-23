package teambravo.pipergames.Views;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teambravo.pipergames.Controllers.TeamController;

import java.io.IOException;
import java.sql.SQLException;

/**
 * <code>TeamView</code> - Used for showing the application view and how TeamView works. - It is the GUI
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 1.0.0
 */
public class TeamView extends Application {

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


