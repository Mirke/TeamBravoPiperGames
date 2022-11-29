module teambravo.pipergames {
    requires javafx.controls;
    requires javafx.fxml;

    exports teambravo.pipergames.Views;
    opens teambravo.pipergames.Views to javafx.fxml;
    exports teambravo.pipergames.Controllers;
    opens teambravo.pipergames.Controllers to javafx.fxml;
}