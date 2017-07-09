
package com.goeuro.routefinder.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sangam Belose
 *
 */
public class RouteFinderException extends Exception {

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
	private List<String> exceptionList = new ArrayList<String>();

	public RouteFinderException() {
		super();
	}

	public RouteFinderException(String message) {
		super(message);
	}

	public RouteFinderException(Exception cause) {
		super(cause);
	}

	public RouteFinderException(String message, Throwable cause) {
		super(message, cause);
	}

	public RouteFinderException(Throwable cause) {
		super(cause);
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public void setExceptionList(List<String> allErrors) {
		exceptionList.addAll(allErrors);

	}

	public List<String> getExceptionList() {
		return exceptionList;
	}

}
