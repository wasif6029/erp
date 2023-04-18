package com.brainstation23.erp.exception.custom.custom;

import com.brainstation23.erp.exception.custom.custom.AlreadyExistsException;
import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}
