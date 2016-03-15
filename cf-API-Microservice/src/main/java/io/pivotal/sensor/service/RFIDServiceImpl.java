package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

@Service
public class RFIDServiceImpl implements RFIDSensorService {
	
	//TODO Eureka
	//final String uri = "http://sensors-microservice.cfapps.io/";
	final String uri = "http://localhost:8888/";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	@Autowired
    RestTemplate restTemplate;	
    
	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllRfidEventsByRfid")
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		return restTemplate.getForObject(uri + "get-rfid-events-by-rfid/" + rfid, Iterable.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllRfid")
	public Iterable<RFID> findAllRfid() {
		return restTemplate.getForObject(uri + "get-all-rfids", Iterable.class);
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultRFID")
	public RFID findRFIDByUserId(Long userId) {
		return restTemplate.getForObject(uri + "get-rfid-by-user/" + userId, RFID.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllRfidEventsByRfidBetween")
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
		return restTemplate.getForObject(uri + "get-all-rfid-events-by-rfid/" + rfid + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}
	
	public Iterable<RFIDEvent> defaultFindAllRfidEventsByRfid(String rfid) {
        return new ArrayList<>();
    }
	
	public Iterable<RFIDEvent> defaultFindAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
        return new ArrayList<>();
    }
	
	public Iterable<RFIDEvent> defaultFindAllRfid() {
        return new ArrayList<>();
    }
	
	public RFID defaultRFID(Long userId) {
		RFID rfid = new RFID();
		rfid.setId(0L);
		rfid.setRfid("N/A for " + userId);
		rfid.setCreatedTime(new Date());
        return rfid;
    }
	
}
