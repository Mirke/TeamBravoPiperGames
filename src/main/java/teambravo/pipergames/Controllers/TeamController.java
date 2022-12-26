package teambravo.pipergames.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import teambravo.pipergames.Mikael.Team;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;


public class TeamController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> TEAM_OPTIONS = FXCollections.observableArrayList();
    private static ObservableList<String> GAME_OPTIONS = FXCollections.observableArrayList();


    @FXML private Button buttonRead;
    @FXML private Button buttonCreate;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button buttonStaff;
    @FXML private ListView listViewBox;
    @FXML private TextField addingTeamField;
    @FXML private Button addingTeamButton;




    private Stage stage;
    private Parent root;
    private Scene scene;

    public TeamController() {
    }

    @FXML
    void initialize() {



        addTeamsToListViewBox();



//        comboBox.setItems(TEAM_OPTIONS);
//        comboBox.getSelectionModel().select(0);
    }

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
        Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/TeamView.fxml"));
        stage = (Stage) addingTeamButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pushingCreateButton(ActionEvent e) throws IOException{
//        Team newTeam = new Team(textFieldTeamName.getText(), textFieldNickname.getText(), textFieldSecondPlayer.getText(), textFieldThirdPlayer.getText(), textFieldFourthPlayer.getText(), textFieldFifthPlayer.getText());
        //TEAM_OPTIONS.add(textFieldTeamName.getText());
//        createTeam(newTeam);

//        comboBox.getSelectionModel().selectLast();
        Parent root = FXMLLoader.load(getClass().getResource("/teambravo/pipergames/CreateTeamView.fxml"));
        stage = (Stage) buttonCreate.getScene().getWindow();

        //scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pushingReadButton(ActionEvent e) {
        int index = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
//                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
//                    index = team.getTeamID();
//                    break;
//                }
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

        Team team = readByID(index);
        if (team != null) {
//            textFieldTeamName.textProperty().set(team.getTeam_name());
//            textFieldNickname.textProperty().set(team.getFirst_nickname());
//            textFieldSecondPlayer.textProperty().set(team.getSecond_nickname());
//            textFieldThirdPlayer.textProperty().set(team.getThird_nickname());
//            textFieldFourthPlayer.textProperty().set(team.getFourth_nickname());
//            textFieldFifthPlayer.textProperty().set(team.getFifth_nickname());
//            textFieldGame.textProperty().set(team.getGame().getGame_name());
        }

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
//                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
//                    teamID = team.getTeamID();
//                    break;
//                }
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
//        team.setTeam_name(textFieldTeamName.getText());
//        team.setFirst_nickname(textFieldNickname.getText());
//        team.setSecond_nickname(textFieldSecondPlayer.getText());
//        team.setThird_nickname(textFieldThirdPlayer.getText());
//        team.setFourth_nickname(textFieldFourthPlayer.getText());
//        team.setFifth_nickname(textFieldFifthPlayer.getText());
        updateTeam(team);

//        TEAM_OPTIONS.set(comboBox.getSelectionModel().getSelectedIndex(), team.getTeam_name());
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
//                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
//                    teamID = team.getTeamID();
//                    break;
//                }
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
//        TEAM_OPTIONS.remove(comboBox.getSelectionModel().getSelectedIndex());

    }

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


    public void getAllTeamsPrinted() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
                System.out.println(team);
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
//            teamToUpdate.setTeam_name(team.getTeam_name());
//            teamToUpdate.setFirst_nickname(team.getFirst_nickname());
//            teamToUpdate.setSecond_nickname(team.getSecond_nickname());
//            teamToUpdate.setThird_nickname(team.getThird_nickname());
//            teamToUpdate.setFourth_nickname(team.getFourth_nickname());
//            teamToUpdate.setFifth_nickname(team.getFifth_nickname());
            entityManager.merge(teamToUpdate);
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

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return this.scene;
    }
}
