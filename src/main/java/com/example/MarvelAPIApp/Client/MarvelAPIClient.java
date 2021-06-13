package com.example.MarvelAPIApp.Client;

import com.example.MarvelAPIApp.Constant.Constants;

import com.example.MarvelAPIApp.DTO.MarvelAPICharacter;
import com.example.MarvelAPIApp.Exception.CharacterException;
import com.example.MarvelAPIApp.Util.DateUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MarvelAPIClient {
	
	private static final Logger logger = LoggerFactory.getLogger(MarvelAPIClient.class);
	
	  @Autowired
	    private RestTemplate restTemplate;

	    @Value("${marvel.url}")
	    private String characterAPIUrl;

	    @Value("${private.key}")
	    private String privateKey;

	    @Value("${public.key}")
	    private String publiceKey;

	    public List<MarvelAPICharacter> getCharacterDetails() throws CharacterException{

	        int limit = 100;
	        int offset = 0; 
	        boolean onSuccess = true;
	        List<MarvelAPICharacter> characterDetails = new ArrayList<>();
	        try {
	            while (onSuccess) {
	            	MarvelAPICharacter character = getCharacterDetailsByOffSetAndLimit(offset, limit);
	                if (character == null ||
	                        (character != null && character.getData() != null
	                                && character.getData().getCount() == 0)) {
	                    onSuccess = false;
	                } else {
	                    characterDetails.add(character);
	                }
	                offset = offset + limit;
	            }
	        } catch (Exception e) {
	            throw new CharacterException(e.getMessage());
	        }
	        return characterDetails;
	    }

	
	    public MarvelAPICharacter getCharacterDetailsById(Integer characterId) throws CharacterException{
	    	
	    	logger.info("RestClient call to set details of each chacater based on character Id");

	    	MarvelAPICharacter marvel=new MarvelAPICharacter();
	        HttpEntity<Object> requestEntity = new HttpEntity<>(null, getHttpHeader());

	        try{
	        	marvel =
	                    restTemplate.exchange(characterAPIUrl+ "/" + characterId + "?" +getApiHash(),
	                            HttpMethod.GET,requestEntity,new ParameterizedTypeReference<MarvelAPICharacter>() {
	                            }).getBody();

	        }catch(Exception e){
	           throw new CharacterException(e.getMessage());
	        }
	        return marvel;
	    }

	    private MarvelAPICharacter getCharacterDetailsByOffSetAndLimit(int offset, int limit) throws CharacterException{
	    	
	    	logger.info("RestClient call to display Characters Ids");

	    	MarvelAPICharacter marvel=null;
	        HttpEntity<Object> requestEntity = new HttpEntity<>(null, getHttpHeader());
	        try{

	        	marvel          =
	                    restTemplate.exchange(characterAPIUrl+ "?" + "limit=" + limit + "&offset=" + offset + "&" +getApiHash(),
	                            HttpMethod.GET,requestEntity,new ParameterizedTypeReference<MarvelAPICharacter>() {
	                            }).getBody();

	        }catch(Exception e){
	            throw new CharacterException(e.getMessage());
	        }
	        return marvel;
	    }

	    private HttpHeaders getHttpHeader() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        return headers;
	    }

	    private String getApiHash() {
	        String ts= DateUtils.convertDateToString(new Date(),Constants.DD_MM_YYYY_HH_MM_SS);
	        return "ts="+ts+"&apikey="+publiceKey+"&hash="+DigestUtils.md5Hex(ts+privateKey+publiceKey).toLowerCase();

	    }

	}

