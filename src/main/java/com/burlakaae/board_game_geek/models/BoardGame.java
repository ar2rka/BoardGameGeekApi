package com.burlakaae.board_game_geek.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BoardGame {

    @Getter @Setter private String thing_id;
    @Getter @Setter private String thing_type;
    @Getter @Setter private String thing_name;
    @Getter @Setter private String year_published;
    @Getter @Setter private String min_players;
    @Getter @Setter private String max_players;
    @Getter @Setter private String playing_time;
    @Getter @Setter private String min_age;

    @Override
    public String toString() {
        return String.format("Item {id %S, name %S, type %S, year published %S, min players %S, max players %S}",
               thing_id, thing_name, thing_type, year_published, min_players, max_players);
    }
}
