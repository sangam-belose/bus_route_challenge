/**
 * 
 */
package com.goeuro.routefinder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeuro.routefinder.exception.RouteFinderException;
import com.goeuro.routefinder.util.BusRouteBuilder;
import com.goeuro.routefinder.util.RouteDataCollection;

/**
 * @author sangamb
 *
 */
@Service
public class BusRouteServiceImpl implements BusRouteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusRouteServiceImpl.class);

	@Autowired
	private BusRouteBuilder BusRouteBuilder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.goeuro.routefinder.service.BusRouteService#isDirectBusRouteExist(int,
	 * int)
	 */
	@Override
	public boolean isDirectBusRouteExist(int deparStationId, int arrStationId)throws RouteFinderException {

		final RouteDataCollection routeDataCollection = BusRouteBuilder.getRouteDataCollection();
		LOGGER.info("routeDataCollection: " + routeDataCollection);

		if (routeDataCollection.isRouteExistsFromDepartureStationId(deparStationId)) {

			if (routeDataCollection.isStationsConnected(deparStationId, arrStationId)) {

				return true;
			}
		}

		return false;
	}

}
