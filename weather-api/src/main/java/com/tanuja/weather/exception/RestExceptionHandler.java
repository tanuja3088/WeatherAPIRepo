package com.tanuja.weather.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Created by tguqa8 on 2017-10-25.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * Handle Exception. Happens when HttpStatusCodeException is thrown.
     *
     * @param ex
     * @return the ResponseEntity object
     */
    @ExceptionHandler({HttpStatusCodeException.class, JsonProcessingException.class})
    public ResponseEntity<ErrorResponse> HttpStatusCodeException(HttpStatusCodeException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Please contact WEATHER_API support team");
        logger.error("Error message " + ex.getMessage());
        return new ResponseEntity<>(error, ex.getStatusCode());
    }

    /**
     * Handle Exception. Happens when no mapping for exception is available.
     *
     * @param ex Exception
     * @return the ResponseEntity object
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Please contact WEATHER_API support team");
        logger.error("Error message " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
