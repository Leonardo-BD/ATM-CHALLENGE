package br.com.ibm.challenge.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException {

	private final HttpStatus httpStatus;

    public GeneralException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public static boolean returnFalseOrException(boolean throwException, GeneralException exception) {
        if (throwException) {
            throw exception;
        } else {
            return false;
        }
    }
}
