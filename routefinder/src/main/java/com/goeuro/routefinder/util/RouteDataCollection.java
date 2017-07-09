package com.goeuro.routefinder.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RouteDataCollection {

	private Map<Integer, Map<Integer, List<Integer>>> dataMap = new HashMap<>();

	/**
	 * Update the routeDataCollection.
	 * 
	 * @param routeId
	 * @param stationId
	 * @param connStationList
	 */
	public void updateRouteDataCollection(final Integer routeId, final Integer stationId,
			final List<Integer> connStationList) {

		final Map<Integer, List<Integer>> connectedStationsMap = findConnStationsByStationId(stationId);

		Iterator<Integer> itr = connStationList.iterator();
		while (itr.hasNext()) {
			Integer connectedStationId = itr.next();
			if (!connectedStationsMap.containsKey(connectedStationId)) {
				connectedStationsMap.put(connectedStationId, new ArrayList<>());
			}
			connectedStationsMap.get(connectedStationId).add(routeId);

		}

	}

	/**
	 * To find connected stations to given stationId.
	 * 
	 * @param stationId
	 * @return
	 */
	private Map<Integer, List<Integer>> findConnStationsByStationId(final Integer stationId) {

		if (!dataMap.containsKey(stationId)) {
			dataMap.put(stationId, new HashMap<>());
		}

		return dataMap.get(stationId);
	}

	public boolean isRouteExistsFromDepartureStationId(final Integer deparStationId) {
		return dataMap.containsKey(deparStationId);
	}

	public boolean isStationsConnected(final Integer deparStationId, final Integer arrStationId) {
		if (dataMap.containsKey(deparStationId)) {
			return dataMap.get(deparStationId).containsKey(arrStationId);
		}

		return false;
	}

	/**
	 * Get list of Route Id for given departureStationId and arrivalStationId
	 *
	 * @param depStationId
	 * @param arrStationId
	 * @return List of route IDs
	 */
	public List<Integer> getConnectedRoutedIds(final Integer depStationId, final Integer arrStationId) {
		if (dataMap.containsKey(depStationId) && dataMap.get(depStationId).containsKey(arrStationId)) {

			return dataMap.get(depStationId).get(arrStationId);
		}

		return Collections.emptyList();

	}
}