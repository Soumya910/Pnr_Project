package com.pnr.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PnrNotFoundException extends RuntimeException{
	
	public PnrNotFoundException(String exception) {
	    super(exception);
	  }
	
	

}
