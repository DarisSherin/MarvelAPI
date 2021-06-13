package com.example.MarvelAPIApp.Client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MarvelAPIApp.Configuration.CacheAnnotation;
import com.example.MarvelAPIApp.DTO.MarvelAPICharacter;
import com.example.MarvelAPIApp.Exception.CharacterException;

@Component
public class MarvelDetails {


	    @Autowired
	    MarvelAPIClient marvelClient;

	    @CacheAnnotation
	    public List<MarvelAPICharacter> getMarvelDetails(Date currentDate) throws CharacterException {
	        return marvelClient.getCharacterDetails() ;
	    }

}
