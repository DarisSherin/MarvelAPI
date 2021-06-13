package com.example.MarvelAPIAppController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.MarvelAPIApp.Controller.MarvelAPIController;
import com.example.MarvelAPIApp.DTO.MarvelAPICharacterById;
import com.example.MarvelAPIApp.DTO.ResponseMarvel;
import com.example.MarvelAPIApp.DTO.Thumbnail;
import com.example.MarvelAPIApp.Exception.CharacterException;
import com.example.MarvelAPIApp.Service.MarvelAPIService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MarvelAPIController.class)
public class MarvelAPIControllerTest {

	 @Autowired
	 private MockMvc mockMvc;
	 
	 @MockBean
     MarvelAPIService marvelService;
	 
	 static List<Integer> characterIds=new ArrayList<>();
	 
	 static List<MarvelAPICharacterById> marvelCharacterByIdList;
	 
	 static MarvelAPICharacterById marvelCharacterById;
	 
	 
	 @BeforeEach
	    public  void setup(){

		 marvelCharacterById=new MarvelAPICharacterById();
		 marvelCharacterById.setId(1010875);
		 marvelCharacterById.setName("X-Ray (James Darnell)");
		 marvelCharacterById.setDescription("James Darnell, along with his sister, was among the small group led by engineer Simon Utrecht to simulate the crash that gave the Fantastic Four their powers, and has remained with the U-Foes ever since.");
		 marvelCharacterById.setThumbnail(new Thumbnail("jpg","http://i.annihil.us/u/prod/marvel/i/mg/f/40/4c0035a250615"));

	        characterIds.add(1011281);
	        characterIds.add(1009717);
	        characterIds.add(1010995);
	        characterIds.add(1010729);

	        marvelCharacterByIdList=new ArrayList<>();
	        marvelCharacterByIdList.add(marvelCharacterById);
	 }  
	      
	        @Test
	        public void testAllCharacterId() throws Exception{

	            Mockito.when(marvelService.getCharacters()).thenReturn(characterIds);

	            this.mockMvc
	                    .perform(get("/marvelapi/characters")
	                            .with(httpBasic("user","password")))
	                    .andDo(print())
	                    .andExpect(status().isOk());

	        }


	        @Test
	        public void testAllCharacterIdForException() throws Exception{

	            Mockito.when(marvelService.getCharacters()).thenThrow(CharacterException.class);

	            this.mockMvc
	                    .perform(get("/marvelapi/characters")
	                            .with(httpBasic("user","password")))
	                    .andDo(print())
	                    .andExpect(status().isInternalServerError());

	        }


	        @Test
	        public void testCharacterByIdSearch() throws Exception{

	            ResponseMarvel responseMarvel=new ResponseMarvel();
	            responseMarvel.setHttpStatus(HttpStatus.OK);
	            responseMarvel.setMarvelAPICharacterById(marvelCharacterById);

	            Mockito.when(marvelService.getCharacterById(1010875)).thenReturn(responseMarvel);

	            this.mockMvc
	                    .perform(get("/marvelapi/characters/1010875")
	                            .with(httpBasic("user","password")))
	                    .andDo(print())
	                    .andExpect(status().isOk())
	                    .andExpect(jsonPath("id").value("1010875"))
	                    .andExpect(jsonPath("name").value("X-Ray (James Darnell)"));

	        }

	        
}
