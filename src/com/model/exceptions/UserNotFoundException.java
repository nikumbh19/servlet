package com.model.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 5869289220781395308L;

	public UserNotFoundException(String message) {
		super(message);
	}
}