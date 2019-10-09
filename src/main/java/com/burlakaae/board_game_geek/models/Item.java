package com.burlakaae.board_game_geek.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

public final class Item {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @Setter @Getter private String id;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    @Setter @Getter private String type;
    @JacksonXmlProperty(localName = "thumbnail")
    @Setter @Getter private String thumbnail;
    @JacksonXmlProperty(localName = "image")
    @Setter @Getter private String image;
    @JacksonXmlProperty(localName = "name")
    @Setter @Getter private String name;
    @JacksonXmlProperty(localName = "sortindex", isAttribute = true)
    @Setter @Getter private String sortIndex;
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    @Setter @Getter private String value;
    @JacksonXmlProperty(localName = "yearpublished")
    @Setter @Getter private String yearPublished;
    @JacksonXmlProperty(localName = "minplayers")
    @Setter @Getter private String minPlayers;
    @JacksonXmlProperty(localName = "maxplayers")
    @Setter @Getter private String maxPlayers;
    @JacksonXmlProperty(localName = "poll")
    @Setter @Getter private String poll;

    public Item() {
    }

    public Item(String id, String thumbnail) {
        this.id = id;
        this.thumbnail = thumbnail;
    }

    @Override public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}