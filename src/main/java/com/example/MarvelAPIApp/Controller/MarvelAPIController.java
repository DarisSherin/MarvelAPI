package com.example.MarvelAPIApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MarvelAPIApp.DTO.MarvelAPICharacterById;
import com.example.MarvelAPIApp.DTO.ResponseMarvel;
import com.example.MarvelAPIApp.Exception.CharacterException;
import com.example.MarvelAPIApp.Service.MarvelAPIService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
@RequestMapping("/marvelapi")
public class MarvelAPIController {
	 private static final Logger logger = LoggerFactory.getLogger(MarvelAPIController.class);
	
	   @Autowired
	    MarvelAPIService marvelService;

	 @GetMapping(value="/characters")
	 @ApiOperation(value="Get all Marvel Character IDs",notes="This API retrieves Marvel character IDs from Marvel API.")
	    public ResponseEntity<List<Integer>> getCharacters(){
		 logger.info("Controller to get Character IDs");
	        List<Integer> characterIds;

	        try{
	            characterIds=marvelService.getCharacters();
	            return new ResponseEntity<>(characterIds,HttpStatus.OK);
	        }catch(CharacterException e){
	            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	    }

	   
	    @ApiOperation(value="Get character information for the given character and translates if required",notes="This API retrieves Marvel character information" +
	            "from Marvel API and translates description if valid ISO-639-1 language code is given")
	    @GetMapping(value="/characters/{characterid}")
	    public ResponseEntity<MarvelAPICharacterById> getCharacterInformationById(@ApiParam(value="CharacterId",example = "123") @PathVariable("characterid") Integer characterid){
	    	logger.info("Controller to get Character details by Id");
	        ResponseMarvel responseMarvel;
	        responseMarvel=marvelService.getCharacterById(characterid);
	        return new ResponseEntity<>(responseMarvel.getMarvelAPICharacterById(),responseMarvel.getHttpStatus());
	    }

}
