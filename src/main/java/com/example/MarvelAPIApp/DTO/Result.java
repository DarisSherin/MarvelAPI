package com.example.MarvelAPIApp.DTO;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Result {

    @JsonProperty("comics")
    private ComicsList comics;
    @JsonProperty("description")
    private String description;
    @JsonProperty("events")
    private EventList events;
    @JsonProperty("id")
    private int id;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("series")
    private SeriesList series;
    @JsonProperty("stories")
    private Stories stories;
    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("urls")
    private List<Url> urls;
	public ComicsList getComics() {
		return comics;
	}
	public void setComics(ComicsList comics) {
		this.comics = comics;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EventList getEvents() {
		return events;
	}
	public void setEvents(EventList events) {
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
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
	public SeriesList getSeries() {
		return series;
	}
	public void setSeries(SeriesList series) {
		this.series = series;
	}
	public Stories getStories() {
		return stories;
	}
	public void setStories(Stories stories) {
		this.stories = stories;
	}
	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}
	public List<Url> getUrls() {
		return urls;
	}
	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}


}
