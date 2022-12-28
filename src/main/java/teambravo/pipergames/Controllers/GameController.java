package teambravo.pipergames.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import teambravo.pipergames.Sharmin.Game;
import javax.persistence.*;
import java.io.IOException;
import java.util.List;



public class GameController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> OPTIONS = FXCollections.observableArrayList();
    @FXML
    public TextField textFieldTeamName;
    @FXML
    public TextField textFieldFirstPlayer;
    @FXML
    public TextField textFieldSecondPlayer;
    @FXML
    public TextField textFieldThirdPlayer;
    @FXML
    public TextField textFieldFourthPlayer;
    @FXML
    public TextField textFieldFifthPlayer;
    @FXML
    public Button buttonGame;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    void initialize() {
    }

    public void runGameView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/piper-games-mainview.fxml"));
        stage = (Stage) buttonGame.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pushingCreateButton(ActionEvent e) {

    }

    public void pushingReadButton(ActionEvent e) {
        int index = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();
            for (Game game : games) {

            }
            transaction.commit();
        } catch (Exception x) {
            if (transaction != null) {
                transaction.rollback();
            }
            x.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void pushingUpdateButton(ActionEvent e) {
        int gameID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();
            for (Game game : games) {
            }

            transaction.commit();
        } catch (Exception x) {
            if (transaction != null) {
                transaction.rollback();
            }
            x.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void pushingDeleteButton(ActionEvent e) {
        int gameID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();
            for (Game game : games) {
            }
            transaction.commit();
        } catch (Exception x) {
            if (transaction != null) {
                transaction.rollback();
            }
            x.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void getAllGamesPrinted() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();
            for (Game game : games) {
                System.out.println(game);
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

    public void addGamesToComboBox() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGameQuery = entityManager.createQuery("from Game", Game.class);
            List<Game> games = allGameQuery.getResultList();
            for (Game game : games) {
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


    public boolean createGame(Game game) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(game);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccess = false;

        } finally {
            entityManager.close();
        }
        return isSuccess;
    }

    public Game readByID(int ID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Game game;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            game = entityManager.find(Game.class, ID);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            entityManager.close();
            return null;
        }
        entityManager.close();
        return game;
    }


    public boolean updateGame(Game game) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Game gameToUpdate = entityManager.find(Game.class, game.getGameID());
            entityManager.merge(gameToUpdate);
            // Commit the changes
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccess = false;
        } finally {
            entityManager.close();
        }
        return isSuccess;
    }

    public boolean deleteGameByID(int ID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Game gameToBeRemoved = entityManager.find(Game.class, ID);
            // Call remove-method of the EntityManager on the rental-entity passed to the method to remove it
            // from the managed objects.
            entityManager.remove(gameToBeRemoved);
            // Call flush-method of the EntityManager to write changes to the database.
            entityManager.flush();
            // Commit the changes
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccess = false;

        } finally {
            entityManager.close();
        }
        return isSuccess;
    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return this.scene;
    }
}

