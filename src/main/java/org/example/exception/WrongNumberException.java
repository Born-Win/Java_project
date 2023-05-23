package org.example.exception;

public class WrongNumberException extends Exception{

    private  static final String INPUT_NOT_VALID_MESSAGE = "Please, chose number between %d and %d";

    public WrongNumberException(int min, int max){
        super(String.format(INPUT_NOT_VALID_MESSAGE, min, max));
    }

}
