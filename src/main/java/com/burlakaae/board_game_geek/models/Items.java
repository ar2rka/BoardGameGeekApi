package com.burlakaae.board_game_geek.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@JacksonXmlRootElement(localName = "items") public final class Items {
    @JacksonXmlProperty(localName = "termsofuse", isAttribute = true)
    @Getter @Setter private String termsofuse;
    @JacksonXmlElementWrapper(localName = "item", useWrapping = false)
    @Getter @Setter private Item[] item;

    @Override
    public String toString() {
        return "Items{" +
                "item=" + Arrays.toString(item) +
                '}';

    }
}
