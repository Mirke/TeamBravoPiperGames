package teambravo.pipergames.Views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teambravo.pipergames.Controllers.PiperGamesController;

import javax.persistence.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * <code>PiperGameMainView</code> is the Front-End Code for graphics.
 */
public class PiperGamesMainView extends Application {

    //---------------------------------------------------------------
    // Properties
    //---------------------------------------------------------------
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    final ObservableList person = FXCollections.observableArrayList();

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

    public static void main(String[] args) throws SQLException {
        launch();
    }
}