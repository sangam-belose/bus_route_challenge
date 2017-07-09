package com.goeuro.routefinder;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.goeuro.routefinder.util.BusRouteBuilder;

/**
 * Application initializer class.
 * 
 * @author sangamb
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.goeuro.routefinder")
public class AppExecutor implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppExecutor.class);

	@Autowired
	private BusRouteBuilder busRouteBuilder;

	public static void main(String[] args) {
		if (args.length < 0) {
			LOGGER.error("Route Data file not found. Please restart with correct Route data file");
		}
		SpringApplication.run(AppExecutor.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));

		for (String name : args.getOptionNames()) {
			LOGGER.info("arg-" + name + "=" + args.getOptionValues(name));
		}

		List<String> routeDataFilePath = args.getOptionValues("busroute.filepath");
		if (!routeDataFilePath.isEmpty()) {
			LOGGER.info("Bus Route file path: " + routeDataFilePath.get(0));

			busRouteBuilder.loadRouteDataFile(routeDataFilePath.get(0));
		} else {
			LOGGER.error("Please pass the bus route file as cmd line argument --routeFile.path");
		}
	}
}
