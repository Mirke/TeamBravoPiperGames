module teambravo.pipergames {
    requires javafx.controls;
    requires javafx.fxml;

    exports teambravo.pipergames.View;
    opens teambravo.pipergames.View to javafx.fxml;
    exports teambravo.pipergames.Controller;
    opens teambravo.pipergames.Controller to javafx.fxml;
}