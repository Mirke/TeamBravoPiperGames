package teambravo.pipergames.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import teambravo.pipergames.Mikael.ConnectToDatabase;
import teambravo.pipergames.Mikael.Team;
import javax.persistence.*;
import java.io.IOException;
import java.util.List;



public class TeamController {

    // ----------------------------------------------------------------------------------------------------------------
    // PROPERTIES
    // ----------------------------------------------------------------------------------------------------------------

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> TEAM_OPTIONS = FXCollections.observableArrayList();
    private static ObservableList<String> GAME_OPTIONS = FXCollections.observableArrayList();
    private static ObservableList<String> PLAYER_OPTIONS = FXCollections.observableArrayList();
    private ConnectToDatabase connectToDatabase = new ConnectToDatabase();

    @FXML private Button buttonRead;
    @FXML private Button buttonCreate;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button buttonStaff;
    @FXML private Button addingTeamButton;
    @FXML private ListView listViewBoxTeams;
    @FXML private ListView listViewBoxPlayers;
    @FXML private TextField addingTeamField;

    private Stage stage;
    private Parent root;
    private Scene scene;


    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------

    public TeamController() {
    }

    // ----------------------------------------------------------------------------------------------------------------
    // VIEWS
    // ----------------------------------------------------------------------------------------------------------------

    public void runStaffView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/piper-games-mainview.fxml"));
        stage = (Stage) buttonStaff.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pushingAddingTeamButton(ActionEvent e)throws IOException{
        String teamName = addingTeamField.getText();
        createTeam(new Team(teamName));
        TEAM_OPTIONS.clear();
        Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/TeamView.fxml"));
        stage = (Stage) addingTeamButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pushingCreateButton(ActionEvent e){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/CreateTeamView.fxml"));
            stage = (Stage) buttonCreate.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(IOException error){
            error.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    // BUTTON EVENTS FOR CONTROLLING DATABASE - HAS JAVAFX
    // ----------------------------------------------------------------------------------------------------------------
    public void pushingReadButton(ActionEvent e) {
        TEAM_OPTIONS.clear();
        addTeamsToListViewBox();
        listViewBoxTeams.setItems(TEAM_OPTIONS);
        listViewBoxTeams.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(listViewBoxTeams.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void pushingUpdateButton(ActionEvent e) {
        int teamID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
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
        Team team = readByID(teamID);
        updateTeam(team);

    }

    public void pushDeleteButton(ActionEvent e) {
        int teamID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
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

        deleteTeamByID(teamID);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // SETUP HELPER METHODS
    // ----------------------------------------------------------------------------------------------------------------

    public void addTeamsToListViewBox() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
                TEAM_OPTIONS.add(team.getTeam_name());
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

    // ----------------------------------------------------------------------------------------------------------------
    //  DATABASE MANIPULATION METHODS - NO JAVAFX
    // ----------------------------------------------------------------------------------------------------------------

    public boolean createTeam(Team team) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(team);
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

    public Team readByID(int ID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Team team;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            team = entityManager.find(Team.class, ID);
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
        return team;
    }


    public boolean updateTeam(Team team) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Team teamToUpdate = entityManager.find(Team.class, team.getTeamID());
            entityManager.merge(teamToUpdate);
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

    public boolean deleteTeamByID(int ID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Team teamToBeRemoved = entityManager.find(Team.class, ID);
            entityManager.remove(teamToBeRemoved);
            entityManager.flush();
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

    // ----------------------------------------------------------------------------------------------------------------
    // SETTERS & GETTERS
    // ----------------------------------------------------------------------------------------------------------------

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return this.scene;
    }
}
