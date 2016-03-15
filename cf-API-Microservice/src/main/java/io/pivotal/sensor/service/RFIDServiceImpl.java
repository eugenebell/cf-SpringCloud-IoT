package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

@Service
public class RFIDServiceImpl implements RFIDSensorService {
	
	//TODO Eureka
	//final String uri = "http://sensors-microservice.cfapps.io/";
	final String uri = "http://localhost:8888/";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		
    RestTemplate restTemplate = new RestTemplate();	
    
	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		return restTemplate.getForObject(uri + "get-rfid-events-by-rfid/" + rfid, Iterable.class);
	}

	@Override
	public Iterable<RFID> findAllRfid() {
		return restTemplate.getForObject(uri + "get-all-rfids", Iterable.class);
	}

	@Override
	public RFID findRFIDByUserId(Long userId) {
		return restTemplate.getForObject(uri + "get-rfid-by-user/" + userId, RFID.class);
	}

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
		return restTemplate.getForObject(uri + "get-all-rfid-events-by-rfid/" + rfid + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}
	
}
