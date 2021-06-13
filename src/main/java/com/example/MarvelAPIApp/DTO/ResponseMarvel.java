package com.example.MarvelAPIApp.DTO;

import org.springframework.http.HttpStatus;

public class ResponseMarvel {

	private MarvelAPICharacterById marvelAPICharacterById;
	private HttpStatus httpStatus;

	public MarvelAPICharacterById getMarvelAPICharacterById() {
		return marvelAPICharacterById;
	}

	public void setMarvelAPICharacterById(MarvelAPICharacterById marvelAPICharacterById) {
		this.marvelAPICharacterById = marvelAPICharacterById;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
