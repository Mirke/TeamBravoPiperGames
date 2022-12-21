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

    public Game(int gameID, String game_name) {
        this.gameID = gameID;
        this.game_name = game_name;
    }

    public Game(String game_name) {
        this.game_name = game_name;
    }

    public Game() {

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

    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", game_name='" + game_name + '\'' +
                '}';
    }
}
