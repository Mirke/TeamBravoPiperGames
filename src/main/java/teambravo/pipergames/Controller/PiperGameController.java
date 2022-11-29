package teambravo.pipergames.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import teambravo.pipergames.View.PiperGameMainView;

public class PiperGameController {

    PiperGameMainView piperGameMainView;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}