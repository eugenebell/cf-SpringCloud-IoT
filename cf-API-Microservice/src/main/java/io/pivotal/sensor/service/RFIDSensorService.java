package io.pivotal.sensor.service;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

import java.util.Date;

public interface RFIDSensorService {

	Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid);
	
	Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime);
	
	Iterable<RFID> findAllRfid();
	
	RFID findRFIDByUserId(Long userId);
	
}
