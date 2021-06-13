package com.example.MarvelAPIApp.Service;

import java.util.List;

import com.example.MarvelAPIApp.DTO.ResponseMarvel;
import com.example.MarvelAPIApp.Exception.CharacterException;


public interface MarvelAPIService {
	
	 List<Integer> getCharacters() throws CharacterException;
	 ResponseMarvel getCharacterById(Integer characterId);

}
