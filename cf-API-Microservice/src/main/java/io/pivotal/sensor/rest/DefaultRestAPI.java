package io.pivotal.sensor.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample requests:
 * http://localhost:8080/get-weather-by-sensorid/need-a-sensor-id
 * http://localhost:8080/get-all-weather-readings-by-sensorid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z
 * 
 * @author belle
 *
 */
@RestController
public class DefaultRestAPI {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String defaultResponse() {
		return "Welcome to Arduino API </br></br> " 
				+"http://the-thing.cfapps.io/get-all-users </br></br>"
				+"http://the-thing.cfapps.io/get-all-rfids </br>"
				+"http://the-thing.cfapps.io/get-rfid-events-by-rfid/need-a-sensor-id </br>"
				+"http://the-thing.cfapps.io/get-rfid-by-user/1 </br>"
				+"http://the-thing.cfapps.io/get-all-rfid-events-by-rfid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br>"
				+"http://the-thing.cfapps.io/get-weather-by-sensorid/need-a-sensor-id </br>"
				+"http://the-thing.cfapps.io/get-all-weather-readings-by-sensorid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br></br>"
				+"http://the-thing.cfapps.io/get-all-tilt-switches </br>"
				+"http://the-thing.cfapps.io/get-tilt-switches-by-tiltId/need-a-sensor-id </br>"
				+"http://the-thing.cfapps.io/get-tilt-events-by-tiltId/need-a-sensor-id </br>"
				+"http://the-thing.cfapps.io/get-all-tilt-events-by-tiltId/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br></br>"
				+"</br> Coming soon..... </br>"
				+"http://the-thing.cfapps.io/get-all-gas-smoke-events-by-sensorid/09 </br>"
				+"http://the-thing.cfapps.io/get-all-gas-smoke-events-by-sensorid/12/between/2014-06-12T00:00:00.000Z/2014-11-12T00:00:00.000Z </br>";
							 
							 
	}

	
}
