package org.sid.springbootcrudmongodb.Exception;

import org.sid.springbootcrudmongodb.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//annotation to handle Exception Globaly
@ControllerAdvice
public class ExceptionHandler {
    //handle specifique Exceptions
    @ExceptionHandler
    public ResponseEntity<?> handleCustomException(CustomException e, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
    }
    //handle Global Exception
}
