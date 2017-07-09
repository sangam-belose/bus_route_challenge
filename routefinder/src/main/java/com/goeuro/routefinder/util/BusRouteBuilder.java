package com.goeuro.routefinder.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Utility Class to read and load route datafile in memory.
 * 
 * @author sangamb
 *
 */
@Component
public class BusRouteBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusRouteBuilder.class);
	@Autowired
	private RouteDataCollection routeDataCollection;

	public static final String DELIMITTER = "\\s+";

	/**
	 * This method read the routes data from file and build the
	 * routeDataCollection.
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public void loadRouteDataFile(String filePath) throws IOException {

		LOGGER.info("filePath: " + filePath);
		List<String> lines = Files.lines(Paths.get(filePath)).map(line -> line.trim()).collect(Collectors.toList());

		lines.stream().map(content -> content.split(DELIMITTER)).map(BusRouteBuilder::transformStringArrayToList)
				.forEach(routeList -> buildBusRouteCollection(routeList, routeDataCollection));

	}

	public RouteDataCollection getRouteDataCollection() {
		return routeDataCollection;
	}

	/**
	 * This Method update the stationId list into the routeData.
	 * 
	 * @param delimitedIds
	 *            list of stationIds on each line.(first field is route id)
	 * @param routeData
	 */
	private static void buildBusRouteCollection(final List<Integer> delimitedIds, final RouteDataCollection routeData) {

		final Integer routeId = Integer.valueOf(delimitedIds.get(0));

		final List<Integer> routeStationIds = delimitedIds.subList(1, delimitedIds.size());

		IntStream.range(0, routeStationIds.size())
				.forEach(index -> updateConnectedStationForEachStationId(index, routeStationIds, routeId, routeData));
	}

	private static void updateConnectedStationForEachStationId(final int index, final List<Integer> routeStationIds,
			final Integer routeId, final RouteDataCollection routeDataCollection) {
		final Integer currentStationId = routeStationIds.get(index);
		final List<Integer> connectedStationIds = routeStationIds.subList(index + 1, routeStationIds.size());
		routeDataCollection.updateRouteDataCollection(routeId, currentStationId, connectedStationIds);
	}

	/**
	 * Utility method to transform String array to List
	 * 
	 * @param routes
	 * @return
	 */
	private static List<Integer> transformStringArrayToList(String[] routes) {
		List<Integer> routeList = Arrays.stream(routes).map(value -> Integer.valueOf(value))
				.collect(Collectors.toList());
		return routeList;
	}

}
