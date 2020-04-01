package com.burlakaae.board_game_geek.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

//TODO необязательно маркать ломбоком каждое поле, getter/setter аннотации можно повесить и на класс
//TODO для всех модельных классов принято сразу переопределять equals и hashCode. Это тоже можно сделать ломбоком
//TODO финализировать классы в джаве из-за особенностей спринга - плохая практика. Спринг под капотом постоянно всё
// проксирует, т.е. неявно создаёт классы-наследники от  твоих

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
