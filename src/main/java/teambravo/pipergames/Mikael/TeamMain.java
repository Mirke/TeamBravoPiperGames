package teambravo.pipergames.Mikael;
import teambravo.pipergames.Controllers.TeamController;

import javax.persistence.*;

public class TeamMain {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    public static void main(String[] args) {
        TeamController teamController = new TeamController();

        //Team first_team = teamController.readByID(1);
        //System.out.println(first_team);

        //teamController.createTeam(new Team("Super Duper Men","Cole","Peter","Rope","Maggot","Ike"));
        //teamController.deleteTeamByID(11);

        //Team changeTenthTeam = new Team(10,"New cool team","rob","bob","zob","dob","hob");
        //teamController.updateTeam(changeTenthTeam);
        teamController.getAllTeamsPrinted();

    }
}
