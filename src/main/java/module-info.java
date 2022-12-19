module teambravo.pipergames {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires hibernate.entitymanager;
    requires org.hibernate.orm.core;

    exports teambravo.pipergames.Views;
    opens teambravo.pipergames.Views to javafx.fxml, org.hibernate.orm.core;
    exports teambravo.pipergames.Controllers;
    opens teambravo.pipergames.Controllers to javafx.fxml, org.hibernate.orm.core;
    exports teambravo.pipergames.Mikael;
    opens teambravo.pipergames.Mikael to javafx.fxml, org.hibernate.orm.core;

}