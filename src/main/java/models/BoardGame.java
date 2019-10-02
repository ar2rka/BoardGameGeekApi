package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "boardgame")
public class BoardGame {

    @Id
    private int thing_id;
    private String thing_type;
    private String thing_name;
    private int year_published;
    private int min_players;
    private int max_players;
    private int playing_time;
    private int min_age;

    public BoardGame() {
    }

    public BoardGame(String thing_name, String thing_type) {
        this.thing_type = thing_type;
        this.thing_name = thing_name;
    }

    public String getName() {
        return thing_name;
    }

    public void setName(String name) {
        this.thing_name = name;
    }

//    @Override
//    public String toString() {
//        return "models.User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}