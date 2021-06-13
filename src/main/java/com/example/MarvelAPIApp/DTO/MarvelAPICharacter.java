package com.example.MarvelAPIApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarvelAPICharacter {

	    @JsonProperty("code")
	    private Long code;
	    @JsonProperty("status")
	    private String status;
	    @JsonProperty("data")
	    private Data data;
	    
	    public MarvelAPICharacter(Long code, String status) {
	        this.code = code;
	        this.status = status;
	    }

	    public MarvelAPICharacter(){}

	    public Long getCode() {
	        return code;
	    }

	    public void setCode(Long code) {
	        this.code = code;
	    }
	    
	    public Data getData() {
	        return data;
	    }

	    public void setData(Data data) {
	        this.data = data;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
