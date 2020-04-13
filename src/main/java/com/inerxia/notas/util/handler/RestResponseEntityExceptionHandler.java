package com.inerxia.notas.util.handler;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.inerxia.notas.exception.DataDuplicatedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOG = Logger.
			getLogger(RestResponseEntityExceptionHandler.class.getName());
	
	@ExceptionHandler(DataDuplicatedException.class)
    protected ResponseEntity<StandardResponse> handleEntityNotFound(
            HttpServletRequest request, DataDuplicatedException ex) {
		LOG.severe(request.getRequestURL().toString()+" / "+ex);
        return new ResponseEntity<>(new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()), HttpStatus.CONFLICT);
    }

}
