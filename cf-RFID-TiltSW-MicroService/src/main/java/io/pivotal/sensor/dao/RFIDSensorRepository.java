package io.pivotal.sensor.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.sensor.model.RFIDEvent;


public interface RFIDSensorRepository extends CrudRepository<RFIDEvent, Long> { //String> {

	Iterable<RFIDEvent> findByRfidRfid(String rfid);
	Iterable<RFIDEvent> findByRfidRfidAndEventTimeBetween(String rfid, Date startDate, Date endDate);
	
}
