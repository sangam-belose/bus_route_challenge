package com.goeuro.routefinder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeuro.routefinder.bean.RoutesResponseBean;
import com.goeuro.routefinder.exception.RouteFinderException;
import com.goeuro.routefinder.service.BusRouteService;

@RestController(value = "/")
public class RouteController {

	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private BusRouteService busRouteService;

	@RequestMapping(value = "/direct", method = RequestMethod.GET)
	public RoutesResponseBean getDirectBusRoute(@RequestParam(value = "dep_sid", required = true) int dep_sid,
			@RequestParam(value = "arr_sid", required = true) int arr_sid) throws RouteFinderException {
		
		logger.info("Routes Request : dep_sid=" + dep_sid + ", arr_sid=" + arr_sid);

		boolean isBusRootConnected = busRouteService.isDirectBusRouteExist(dep_sid, arr_sid);
		logger.info("isBusRootConnected = " + isBusRootConnected);
		return new RoutesResponseBean(dep_sid, arr_sid, isBusRootConnected);
	}
}
