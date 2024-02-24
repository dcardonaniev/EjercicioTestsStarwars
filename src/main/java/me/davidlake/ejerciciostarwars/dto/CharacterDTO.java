package me.davidlake.ejerciciostarwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private int height;
    @JsonProperty("mass")
    private int mass;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;
}
