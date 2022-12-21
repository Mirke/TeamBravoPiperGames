package teambravo.pipergames.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import teambravo.pipergames.Mikael.Team;
import teambravo.pipergames.Sharmin.Game;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class TeamController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    private static ObservableList<String> TEAM_OPTIONS = FXCollections.observableArrayList();
    private static ObservableList<String> GAME_OPTIONS = FXCollections.observableArrayList();

    @FXML
    public ComboBox comboBox;

    @FXML
    public TextField textFieldTeamName;

    @FXML
    public TextField textFieldNickname;

    @FXML
    public TextField textFieldSecondPlayer;

    @FXML
    public TextField textFieldThirdPlayer;

    @FXML
    public TextField textFieldFourthPlayer;

    @FXML
    public TextField textFieldFifthPlayer;

    @FXML
    public Button readButton;

    @FXML
    public Button createButton;

    @FXML
    public Button updateButton;

    @FXML
    public Button deleteButton;

    @FXML
    public TextField textFieldGame;

    public TeamController() {
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        addTeamsToComboBox();
        comboBox.setItems(TEAM_OPTIONS);
        comboBox.getSelectionModel().select(0);
        //testCode();
    }

    private void testCode() {
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


    public void pushingCreateButton(ActionEvent e) {
        Team newTeam = new Team(textFieldTeamName.getText(), textFieldNickname.getText(), textFieldSecondPlayer.getText(), textFieldThirdPlayer.getText(), textFieldFourthPlayer.getText(), textFieldFifthPlayer.getText());
        TEAM_OPTIONS.add(textFieldTeamName.getText());
        createTeam(newTeam);

        comboBox.getSelectionModel().selectLast();
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
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
                    index = team.getTeamID();
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

        Team team = readByID(index);
        if(team != null) {
            textFieldTeamName.textProperty().set(team.getTeam_name());
            textFieldNickname.textProperty().set(team.getFirst_nickname());
            textFieldSecondPlayer.textProperty().set(team.getSecond_nickname());
            textFieldThirdPlayer.textProperty().set(team.getThird_nickname());
            textFieldFourthPlayer.textProperty().set(team.getFourth_nickname());
            textFieldFifthPlayer.textProperty().set(team.getFifth_nickname());
            textFieldGame.textProperty().set(team.getGame().getGame_name());
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
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
                    teamID = team.getTeamID();
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

        Team team = readByID(teamID);
        team.setTeam_name(textFieldTeamName.getText());
        team.setFirst_nickname(textFieldNickname.getText());
        team.setSecond_nickname(textFieldSecondPlayer.getText());
        team.setThird_nickname(textFieldThirdPlayer.getText());
        team.setFourth_nickname(textFieldFourthPlayer.getText());
        team.setFifth_nickname(textFieldFifthPlayer.getText());
        updateTeam(team);

        TEAM_OPTIONS.set(comboBox.getSelectionModel().getSelectedIndex(),team.getTeam_name());
    }

    public void pushDeleteButton(ActionEvent e){

        int teamID = 0;
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Team> allTeamQuery = entityManager.createQuery("from Team", Team.class);
            List<Team> teams = allTeamQuery.getResultList();
            for (Team team : teams) {
                if (Objects.equals(comboBox.getSelectionModel().getSelectedItem().toString(), team.getTeam_name())) {
                    teamID = team.getTeamID();
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

        deleteTeamByID(teamID);
        TEAM_OPTIONS.remove(comboBox.getSelectionModel().getSelectedIndex());

    }

    private void addInformationTeamName(Team team) {
        textFieldTeamName.setText(team.getTeam_name());
    }

    private void addInformationNickname(Team team) {
        textFieldNickname.setText(team.getFirst_nickname());
    }

    private void addInformationSecondNickname(Team team) {
        textFieldSecondPlayer.setText(team.getSecond_nickname());
    }

    private void addInformationThirdNickname(Team team) {
        textFieldThirdPlayer.setText(team.getThird_nickname());
    }

    private void addInformationFourthNickname(Team team) {
        textFieldFourthPlayer.setText(team.getFourth_nickname());
    }

    private void addInformationFifthNickname(Team team) {
        textFieldFifthPlayer.setText(team.getFifth_nickname());
    }

    public void addTeamsToComboBox() {
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
            teamToUpdate.setTeam_name(team.getTeam_name());
            teamToUpdate.setFirst_nickname(team.getFirst_nickname());
            teamToUpdate.setSecond_nickname(team.getSecond_nickname());
            teamToUpdate.setThird_nickname(team.getThird_nickname());
            teamToUpdate.setFourth_nickname(team.getFourth_nickname());
            teamToUpdate.setFifth_nickname(team.getFifth_nickname());
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
            // Call remove-method of the EntityManager on the rental-entity passed to the method to remove it
            // from the managed objects.
            entityManager.remove(teamToBeRemoved);
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
