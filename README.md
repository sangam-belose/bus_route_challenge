# bus_route_challenge

## Problem

We are adding a new bus provider to our system. In order to implement a very specific requirement of this bus provider our system needs to be able to filter direct connections. We have access to a weekly updated list of bus routes in form of a bus route data file. As this provider has a lot of long bus routes, we need to come up with a proper service to quickly answer if two given stations are connected by a bus route.

## Implementation:

Implementation is spring boot based microservice which will read the input data file from command line argument.

###### Implementation logical flow:

  1. Read the file in using Stream.
  2. Split the each line and seprate the 1st field as routeId and rest of the ids as stationId's.
  3. for each id in the stationId's iterate the loop to add the connected ids and route id.
  
  The data structue used in this process to load the route data file in the memory is as below:
  ````
     Map<Integer, Map<Integer, List<Integer>>> dataMap = new HashMap<>();
  ````
   	Map<{stationId}, Map<{connectedStationId}, {list of route id's by which they are connected}>>
  

###### Assumptions:
- The stations are connected in the forward direction.
- The Application/Server will be restarted manually if the input data file changes.

###### Tech Stack:
- Spring Boot
- Java 8

###### Other Notes
- The filepath is passed as command line argument (--busroute.filepath={actual file path}).
- Logs are printed on the console can be configured externally using logback.
- Exception and validation messages can be further enhancened for internationalization.

