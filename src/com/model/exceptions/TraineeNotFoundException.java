package com.model.exceptions;

public class TraineeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 5869289220781395308L;

	public TraineeNotFoundException(String message) {
		super(message);
	}
}