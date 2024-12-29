package org.skypro.Coursework2.Java.COR.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoQuestionsAvailableException extends RuntimeException {

    public NoQuestionsAvailableException(String message) {
        super(message);
    }
}
