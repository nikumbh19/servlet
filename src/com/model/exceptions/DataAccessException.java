package com.model.exceptions;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = -6744787853244433429L;

	public DataAccessException(Throwable cause) {
		super(cause);
	}
}