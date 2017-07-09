package com.goeuro.routefinder.bean;

import java.util.Arrays;
import java.util.List;

/**
 * Error response bean to return error json in case of any exception.
 * 
 * @author Sangam Belose
 *
 */
public class RouteFinderErrorResponse {

	private int errorCode;
	private String message;
	private List<String> errors;

	public RouteFinderErrorResponse() {
		super();
	}

	public RouteFinderErrorResponse(int errorCode, String message, List<String> errors) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.errors = errors;
	}

	public RouteFinderErrorResponse(int errorCode, String message, String error) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
