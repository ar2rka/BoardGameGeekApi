package com.burlakaae.board_game_geek.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BoardGame {
    @Getter @Setter private int thing_id;
    @Getter @Setter private String thing_type;
    @Getter @Setter private String thing_name;
    @Getter @Setter private int year_published;
    @Getter @Setter private int min_players;
    @Getter @Setter private int max_players;
    @Getter @Setter private int playing_time;
    @Getter @Setter private int min_age;
}
