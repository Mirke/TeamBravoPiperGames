package teambravo.pipergames.Mikael;

import teambravo.pipergames.Sharmin.Game;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamID;

    @Column
    private String team_name;
    @Column
    private String first_nickname;
    @Column
    private String second_nickname;
    @Column
    private String third_nickname;
    @Column
    private String fourth_nickname;
    @Column
    private String fifth_nickname;

    @ManyToOne
    @JoinColumn(name = "gameID")
    private Game game;

    public Team() {
    }

    public Team(String team_name, String first_nickname, String second_nickname, String third_nickname, String fourth_nickname, String fifth_nickname) {
        this.team_name = team_name;
        this.first_nickname = first_nickname;
        this.second_nickname = second_nickname;
        this.third_nickname = third_nickname;
        this.fourth_nickname = fourth_nickname;
        this.fifth_nickname = fifth_nickname;
    }

    public Team(String team_name, String first_nickname, String second_nickname, String third_nickname, String fourth_nickname, String fifth_nickname, Game game) {
        this.team_name = team_name;
        this.first_nickname = first_nickname;
        this.second_nickname = second_nickname;
        this.third_nickname = third_nickname;
        this.fourth_nickname = fourth_nickname;
        this.fifth_nickname = fifth_nickname;
        this.game = game;
    }

    public Team(int teamID, String team_name, String first_nickname, String second_nickname, String third_nickname, String fourth_nickname, String fifth_nickname, Game game) {
        this.teamID = teamID;
        this.team_name = team_name;
        this.first_nickname = first_nickname;
        this.second_nickname = second_nickname;
        this.third_nickname = third_nickname;
        this.fourth_nickname = fourth_nickname;
        this.fifth_nickname = fifth_nickname;
        this.game = game;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getFirst_nickname() {
        return first_nickname;
    }

    public void setFirst_nickname(String first_nickname) {
        this.first_nickname = first_nickname;
    }

    public String getSecond_nickname() {
        return second_nickname;
    }

    public void setSecond_nickname(String second_nickname) {
        this.second_nickname = second_nickname;
    }

    public String getThird_nickname() {
        return third_nickname;
    }

    public void setThird_nickname(String third_nickname) {
        this.third_nickname = third_nickname;
    }

    public String getFourth_nickname() {
        return fourth_nickname;
    }

    public void setFourth_nickname(String fourth_nickname) {
        this.fourth_nickname = fourth_nickname;
    }

    public String getFifth_nickname() {
        return fifth_nickname;
    }

    public void setFifth_nickname(String fifth_nickname) {
        this.fifth_nickname = fifth_nickname;
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
                "teamID=" + teamID +
                ", team_name='" + team_name + '\'' +
                ", first_nickname='" + first_nickname + '\'' +
                ", second_nickname='" + second_nickname + '\'' +
                ", third_nickname='" + third_nickname + '\'' +
                ", fourth_nickname='" + fourth_nickname + '\'' +
                ", fifth_nickname='" + fifth_nickname + '\'' +
                ", game=" + game +
                '}';
    }
}
