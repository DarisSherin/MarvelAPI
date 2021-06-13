package com.example.MarvelAPIApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Thumbnail {
	
	 @JsonProperty("extension")
	    private String extension;
	    @JsonProperty("path")
	    private String path;

	    public String getExtension() {
	        return extension;
	    }

	    public void setExtension(String extension) {
	        this.extension = extension;
	    }

	    public String getPath() {
	        return path;
	    }

	    public void setPath(String path) {
	        this.path = path;
	    }

	    public Thumbnail(String extension, String path) {
	        this.extension = extension;
	        this.path = path;
	    }

	    public Thumbnail(){}

}
