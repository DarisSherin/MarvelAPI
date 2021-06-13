package com.example.MarvelAPIApp.Exception;

import java.io.Serializable;

public class CharacterException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
    public CharacterException(String message){
        super(message);
    }

}