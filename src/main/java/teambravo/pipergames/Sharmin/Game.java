package teambravo.pipergames.Sharmin;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameID;

    @Column
    private String game_name;

    @Column
    private String team_name;

    @Column
    private String first_player;
    @Column
    private String second_player;

    @Column
    private String third_player;

    @Column
    private String fourth_player;

    @Column
    private String fifth_player;

    public Game() {
    }

    public Game(int gameID, String game_name, String team_name, String first_player, String second_player,
                String third_player, String fourth_player, String fifth_player) {
        this.gameID = gameID;
        this.game_name = game_name;
        this.team_name = team_name;
        this.first_player = first_player;
        this.second_player = second_player;
        this.third_player = third_player;
        this.fourth_player = fourth_player;
        this.fifth_player = fifth_player;
    }

    public Game(String game_name, String team_name, String first_player, String second_player, String third_player,
                String fourth_player, String fifth_player) {
        this.game_name = game_name;
        this.team_name = team_name;
        this.first_player = first_player;
        this.second_player = second_player;
        this.third_player = third_player;
        this.fourth_player = fourth_player;
        this.fifth_player = fifth_player;

    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getFirst_player() {
        return first_player;
    }

    public void setFirst_player(String first_player) {
        this.first_player = first_player;
    }

    public String getSecond_player() {
        return second_player;
    }

    public void setSecond_player(String second_player) {
        this.second_player = second_player;
    }

    public String getThird_player() {
        return third_player;
    }

    public void setThird_player(String third_player) {
        this.third_player = third_player;
    }

    public String getFourth_player() {
        return fourth_player;
    }

    public void setFourth_player(String fourth_player) {
        this.fourth_player = fourth_player;
    }

    public String getFifth_player() {
        return fifth_player;
    }

    public void setFifth_player(String fifth_player) {
        this.fifth_player = fifth_player;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", game_name='" + game_name + '\'' +
                ", first_player='" + first_player + '\'' +
                ", second_player='" + second_player + '\'' +
                ", third_player='" + third_player + '\'' +
                ", fourth_player='" + fourth_player + '\'' +
                ", fifth_player='" + fifth_player + '\'' +
                '}';
    }
}

