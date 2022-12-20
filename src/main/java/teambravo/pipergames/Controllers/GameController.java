package teambravo.pipergames.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import teambravo.pipergames.Mikael.Team;
import teambravo.pipergames.Sharmin.Game;

import javax.persistence.*;
import java.util.List;

public class GameController {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> OPTIONS = FXCollections.observableArrayList();

    @FXML
    public ComboBox comboBox;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        addGamesToComboBox();
        comboBox.setItems(OPTIONS);
        comboBox.getSelectionModel().select(0);
    }
    public void addGamesToComboBox() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();

            for (Game game: games) {
                OPTIONS.add(game.getGame_name());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }


}
