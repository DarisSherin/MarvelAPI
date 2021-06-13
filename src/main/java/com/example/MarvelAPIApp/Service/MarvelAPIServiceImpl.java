package com.example.MarvelAPIApp.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.MarvelAPIApp.Client.MarvelAPIClient;
import com.example.MarvelAPIApp.Client.MarvelDetails;
import com.example.MarvelAPIApp.DTO.MarvelAPICharacter;
import com.example.MarvelAPIApp.DTO.MarvelAPICharacterById;
import com.example.MarvelAPIApp.DTO.ResponseMarvel;
import com.example.MarvelAPIApp.Exception.CharacterException;
import com.example.MarvelAPIApp.Model.MarvelAPIModel;

@Service
public class MarvelAPIServiceImpl implements MarvelAPIService {
	
	private static final Logger logger = LoggerFactory.getLogger(MarvelAPIServiceImpl.class);

	@Autowired
	MarvelDetails marvelDetails;

	@Autowired
	MarvelAPIClient marvelAPIClient;

	@Override
	public List<Integer> getCharacters() {
		
		logger.info("Service layer to process the request for displaying Character Ids");
		try {
			List<MarvelAPICharacter> characterDetails = marvelDetails.getMarvelDetails(new Date());

			if (characterDetails != null) {
				List<List<Integer>> allCharacters = characterDetails.stream().map(
						ch -> ch.getData().getResults().stream().map(ids -> ids.getId()).collect(Collectors.toList()))
						.collect(Collectors.toList());
				return allCharacters.stream().reduce(new ArrayList<>(), (l1, l2) -> {
					l1.addAll(l2);
					return l1;
				});
			}
		} catch (Exception e) {
			throw new CharacterException(e.getMessage());
		}
		return new ArrayList<>();

	}

	@Override
	public ResponseMarvel getCharacterById(Integer characterId) throws CharacterException {
		
		logger.info("Service layer to process the request for setting Character details with given Id");

		MarvelAPICharacterById marvelCharacterById = new MarvelAPICharacterById();
		MarvelAPICharacter marvelCharacter;
		ResponseMarvel responseMarvel = new ResponseMarvel();

		try {

			marvelCharacter = marvelAPIClient.getCharacterDetailsById(characterId);
			if (marvelCharacter != null && marvelCharacter.getData() != null
					&& marvelCharacter.getData().getResults() != null) {
				marvelCharacterById.setId(marvelCharacter.getData().getResults().stream().findFirst().get().getId());
				marvelCharacterById
						.setName(marvelCharacter.getData().getResults().stream().findFirst().get().getName());
				marvelCharacterById.setDescription(
						marvelCharacter.getData().getResults().stream().findFirst().get().getDescription());
				marvelCharacterById
						.setThumbnail(marvelCharacter.getData().getResults().stream().findFirst().get().getThumbnail());
			}
		} catch (CharacterException e) {
			responseMarvel.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		responseMarvel.setMarvelAPICharacterById(marvelCharacterById);
		responseMarvel.setHttpStatus(HttpStatus.OK);
		return responseMarvel;
	}


}
