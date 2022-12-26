package teambravo.pipergames.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import teambravo.pipergames.Karin.Player;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class PlayerController {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> OPTIONS = FXCollections.observableArrayList();

    @FXML
    public ComboBox comboBox;

    @FXML
    public TextField textFieldFirst_name;

    @FXML
    public TextField textFieldLast_name;

    @FXML
    public TextField textFieldNickname;

    @FXML
    public TextField textFieldGame;


    @FXML
    public Button readButton;

    @FXML
    public Button createButton;

    @FXML
    public Button updateButton;

    @FXML
    public Button deleteButton;

    @FXML
    public Label helloWorld;

    public PlayerController() {
    }

    // This method is called by the FXMLLoader when initialization is complete
    @FXML
    void initialize() {
        addPlayersToComboBox();
        comboBox.setItems(OPTIONS);
        comboBox.getSelectionModel().select(0);
    }


    public void pushingCreateButton(ActionEvent e) {
        Player newPlayer = new Player(textFieldFirst_name.getText(), textFieldLast_name.getText(), textFieldNickname.getText(), textFieldGame.getText());
        OPTIONS.add(textFieldNickname.getText());
        createPlayer(newPlayer);

        comboBox.getSelectionModel().selectLast();
    }

    public void pushingReadButton(ActionEvent e) {
        int index = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayerQuery = entityManager.createQuery("from Player", Player.class);
            List<Player> players = allPlayerQuery.getResultList();
            for (Player player : players) {
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), player.getNickname())) {
                    index = player.getPlayerID();
                    break;
                }
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

        Player player = readByID(index);
        if (player != null) {
            textFieldFirst_name.textProperty().set(player.getFirst_name());
            textFieldLast_name.textProperty().set(player.getLast_name());
            textFieldNickname.textProperty().set(player.getNickname());
            textFieldGame.textProperty().set(player.getGame());

        }

    }


    public void pushingUpdateButton(ActionEvent e) {
        int playerID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayerQuery = entityManager.createQuery("from Player", Player.class);
            List<Player> players = allPlayerQuery.getResultList();
            for (Player player : players) {
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), player.getNickname())) {
                    playerID = player.getPlayerID();
                    break;
                }
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

        Player player = readByID(playerID);
        player.setFirst_name(textFieldFirst_name.getText());
        player.setLast_name(textFieldLast_name.getText());
        player.setNickname(textFieldNickname.getText());
        player.setGame(textFieldGame.getText());
        updatePlayer(player);

        OPTIONS.set(comboBox.getSelectionModel().getSelectedIndex(), player.getNickname());
    }

    public void pushDeleteButton(ActionEvent e) {

        int playerID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayerQuery = entityManager.createQuery("from Player", Player.class);
            List<Player> players = allPlayerQuery.getResultList();
            for (Player player : players) {
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), player.getNickname())) {
                    playerID = player.getPlayerID();
                    break;
                }
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

        deletePlayerByID(playerID);
        OPTIONS.remove(comboBox.getSelectionModel().getSelectedIndex());

    }


    private void addInformationFirst_name(Player player) {

        textFieldFirst_name.setText(player.getFirst_name());
    }

    private void addInformationLast_name(Player player) {

        textFieldLast_name.setText(player.getLast_name());
    }

    private void addInformationNickname(Player player) {

        textFieldNickname.setText(player.getNickname());
    }


    private void addInformationGame( Player player) {
        textFieldGame.setText(player.getGame());
    }

    public void addPlayersToComboBox() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayerQuery = entityManager.createQuery("from Player", Player.class);
            List<Player> players = allPlayerQuery.getResultList();

            for (Player player : players) {
                OPTIONS.add(player.getNickname());
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


    public void getAllPlayersPrinted() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Player> allPlayerQuery = entityManager.createQuery("from Player", Player.class);
            List<Player> players = allPlayerQuery.getResultList();
            for (Player player : players) {
                System.out.println(player);
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

    public boolean createPlayer(Player player) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(player);
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

    public Player readByID(int playerID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Player player;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            player = entityManager.find(Player.class, playerID);
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
        return player;
    }


    public boolean updatePlayer(Player player) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Player playerToUpdate = entityManager.find(Player.class, player.getPlayerID());
            playerToUpdate.setFirst_name(player.getFirst_name());
            playerToUpdate.setLast_name(player.getLast_name());
            playerToUpdate.setNickname(player.getNickname());
            playerToUpdate.setGame(player.getGame());

            entityManager.merge(playerToUpdate);
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

    public boolean deletePlayerByID(int playerID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Player playerToBeRemoved = entityManager.find(Player.class, playerID);
            /* Call remove-method of the EntityManager on the rental-entity passed to the method to remove it
             from the managed objects.*/
            entityManager.remove(playerToBeRemoved);
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


}

