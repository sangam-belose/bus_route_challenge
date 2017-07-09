/**
 * 
 */
package com.goeuro.routefinder.service;

import com.goeuro.routefinder.exception.RouteFinderException;

/**
 * @author sangamb
 *
 */
public interface BusRouteService {

	/**
	 * This method checks whether there is direct bus route exists between given
	 * stationIds.
	 * 
	 * @param deparStationId
	 * @param arrStationId
	 * @return
	 */
	public boolean isDirectBusRouteExist(int deparStationId, int arrStationId)throws RouteFinderException;
}
