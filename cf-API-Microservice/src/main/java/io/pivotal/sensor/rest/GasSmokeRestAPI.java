package io.pivotal.sensor.rest;

import io.pivotal.sensor.model.GasSmokeEvent;
import io.pivotal.sensor.service.GasSmokeSensorService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample requests:
 * http://localhost:8080/get-all-gas-smoke-events-by-sensorid/09
 * http://localhost:8080/get-all-gas-smoke-events-by-sensorid/12/between/2014-06-12T00:00:00.000Z/2014-11-12T00:00:00.000Z
 *  
 * @author belle
 *
 */
@RestController
public class GasSmokeRestAPI {

	@Autowired
	private GasSmokeSensorService gasSmokeSensorService;
	
	//TODO http://localhost:8080/get-all-gas-smoke-sensors
//	@RequestMapping(value="/get-all-gas-smoke-sensors", method=RequestMethod.GET)
//	public Iterable<RFID> getAllGasSmokeSensors() {	
//		
//	}
	
	//http://localhost:8080/get-rfid-events-by-gas-smoke-sensorid/0909200181
	@RequestMapping(value="/get-all-gas-smoke-events-by-sensorid/{gasSensorId}", method=RequestMethod.GET)
	public Iterable<GasSmokeEvent> getGasSmokeEventByGasSensorId(@PathVariable String gasSensorId) {
		return gasSmokeSensorService.findByGasSensorId(gasSensorId);
	}
	
	//Example http://localhost:8080/get-all-rfid-events-by-gas-smoke-sensorid/12/between/2014-06-12T00:00:00.000Z/2014-11-12T00:00:00.000Z
	@RequestMapping(value="/get-all-gas-smoke-events-by-sensorid/{gasSensorId}/between/{startDate}/{endDate}", method=RequestMethod.GET)
	public Iterable<GasSmokeEvent> getAllRFIDEventsByRfidBetween(@PathVariable String gasSensorId, 
			@PathVariable  @DateTimeFormat(iso = ISO.DATE) Date startDate,@PathVariable  @DateTimeFormat(iso = ISO.DATE) Date endDate) {	
		return gasSmokeSensorService.findByGasSensorIdAndEventTimeBetween(gasSensorId, startDate, endDate);
	}
	
	
}
