package teambravo.pipergames.Mikael;

import teambravo.pipergames.Sharmin.Game;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TeamID;

    @Column
    private String team_name;

    @ManyToOne
    @JoinColumn(name = "Game_gameID")
    private Game game;

    public Team() {
    }

    public Team(int teamID, String team_name) {
        TeamID = teamID;
        this.team_name = team_name;
    }

    public Team(String team_name) {
        this.team_name = team_name;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Team{" +
                "TeamID=" + TeamID +
                ", team_name='" + team_name + '\'' +
                ", game=" + game +
                '}';
    }
}
