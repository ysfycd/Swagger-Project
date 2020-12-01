package com.yusufyucedag.swagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFounException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	public NotFounException(String message) {
		super(message);
	}

}
