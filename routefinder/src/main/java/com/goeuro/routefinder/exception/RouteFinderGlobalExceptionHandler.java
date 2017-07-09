/**
 * 
 */
package com.goeuro.routefinder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.goeuro.routefinder.bean.RouteFinderErrorResponse;

/**
 * @author sangamb
 *
 */
@ControllerAdvice
@Order(value = 2)
public class RouteFinderGlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RouteFinderGlobalExceptionHandler.class);

	@ExceptionHandler({ RouteFinderException.class, Exception.class })

	public ResponseEntity<RouteFinderErrorResponse> exceptionHandler(Exception ex) {

		// printing every exception in logger file.
		LOGGER.error("Global Exception occured:", ex);

		RouteFinderErrorResponse error = new RouteFinderErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), "Error in processing request. Try again later!");

		return new ResponseEntity<RouteFinderErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
