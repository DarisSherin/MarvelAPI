package com.example.MarvelAPIApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Item {

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
