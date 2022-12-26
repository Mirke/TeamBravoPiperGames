package teambravo.pipergames.Karin;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "playerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerID;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "game")
    private String game;

    public Player() {
    }

    public Player(int playerID, String first_name, String last_name, String nickname, String game) {
        this.playerID = playerID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.game = game;
    }

    public Player(String first_name, String last_name, String nickname, String game) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.game = game;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}

