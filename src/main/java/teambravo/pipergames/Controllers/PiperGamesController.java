package teambravo.pipergames.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import teambravo.pipergames.Views.PiperGamesMainView;

/**
 * <code>PiperGameController</code> is a middle layer that connects Back-End with Front-End vise versa.
 */
public class PiperGamesController {

    //---------------------------------------------------------------
    // Properties
    //---------------------------------------------------------------
    PiperGamesMainView piperGamesMainView;

    @FXML
    private Label welcomeText;

    //---------------------------------------------------------------
    // Event Handlers
    //---------------------------------------------------------------
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}