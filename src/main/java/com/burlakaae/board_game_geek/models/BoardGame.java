package com.burlakaae.board_game_geek.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JacksonXmlRootElement(localName = "items")
public class BoardGame {
    @JacksonXmlElementWrapper(localName = "item")
    @JacksonXmlProperty(localName = "thumbnail")
    @Getter @Setter private String thumbnail;
//    @Getter @Setter private int thing_id;
//    @Getter @Setter private String thing_type;
//    @Getter @Setter private String thing_name;
//    @Getter @Setter private int year_published;
//    @Getter @Setter private int min_players;
//    @Getter @Setter private int max_players;
//    @Getter @Setter private int playing_time;
//    @Getter @Setter private int min_age;

    @Override
    public String toString() {
        return String.format("Item desc: nail %S",
        //return String.format("Item desc: nail %S, id %d, name %S, type %S, year published %d, min players %d, max players %d",
                thumbnail);
               // thumbnail, thing_id, thing_type, thing_name, year_published, min_players, max_players);
    }
}
