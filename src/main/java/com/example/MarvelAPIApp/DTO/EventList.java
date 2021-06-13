package com.example.MarvelAPIApp.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class EventList {

	    @JsonProperty("available")
	    private Long available;
	    @JsonProperty("collectionURI")
	    private String collectionURI;
	    @JsonProperty("items")
	    private List<Item> items;
	    @JsonProperty("returned")
	    private Long returned;

	    public Long getAvailable() {
	        return available;
	    }

	    public void setAvailable(Long available) {
	        this.available = available;
	    }

	    public String getCollectionURI() {
	        return collectionURI;
	    }

	    public void setCollectionURI(String collectionURI) {
	        this.collectionURI = collectionURI;
	    }

	    public List<Item> getItems() {
	        return items;
	    }

	    public void setItems(List<Item> items) {
	        this.items = items;
	    }

	    public Long getReturned() {
	        return returned;
	    }

	    public void setReturned(Long returned) {
	        this.returned = returned;
	    }

}
