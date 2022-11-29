package teambravo.pipergames.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import teambravo.pipergames.View.PiperGameMainView;

/**
 * <code>PiperGameController</code> is a middle layer that connects Back-End with Front-End vise versa.
 */
public class PiperGameController {

    //---------------------------------------------------------------
    // Properties
    //---------------------------------------------------------------
    PiperGameMainView piperGameMainView;

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