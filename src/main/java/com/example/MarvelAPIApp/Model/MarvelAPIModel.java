package com.example.MarvelAPIApp.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class MarvelAPIModel implements Serializable{
	
	 private static final long serialVersionUID = 8466580944866736089L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    public long id;
	    public Integer characterId;
	    public String name;
	    public String description;
	    public String thumbnailPath;
	    public String extension;

	   
	    public Date searchTimestamp;

	    
	    public Integer getCharacterId() {
	        return characterId;
	    }

	    public void setCharacterId(Integer characterId) {
	        this.characterId = characterId;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getThumbnailPath() {
	        return thumbnailPath;
	    }

	    public void setThumbnailPath(String thumbnailPath) {
	        this.thumbnailPath = thumbnailPath;
	    }

	    public String getExtension() {
	        return extension;
	    }

	    public void setExtension(String extension) {
	        this.extension = extension;
	    }

	    public Date getSearchTimestamp() {
	        return searchTimestamp;
	    }

	    public void setSearchTimestamp(Date searchTimestamp) {
	        this.searchTimestamp = searchTimestamp;
	    }

}
