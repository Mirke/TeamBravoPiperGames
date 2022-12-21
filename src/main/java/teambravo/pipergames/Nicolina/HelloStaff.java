package teambravo.pipergames.Nicolina;

import javafx.scene.control.Menu;
import teambravo.pipergames.Controllers.StaffController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class HelloStaff {
    public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    }
