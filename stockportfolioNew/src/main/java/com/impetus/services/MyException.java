package com.impetus.services;



public class MyException extends RuntimeException {
	/**
	 * This class defines a custom exception which extends RuntimeException.
	 * 
	 * @author prachi.singh
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
	public MyException() {
		super();
	}

	// Constructor receives some kind of message that is saved in an instance
	// variable.
	public MyException(String message) {
		super(message);
	}

	// public method, callable by exception catcher. It returns the error
	// message.
	public String getMyException() {
		return super.getMessage();
	}

	public MyException(String message, Throwable ex) {
		super(message, ex);
	}
}
