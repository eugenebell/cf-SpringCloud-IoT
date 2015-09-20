package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.RFID;

import org.springframework.data.repository.CrudRepository;


public interface RFIDSensorRepository extends CrudRepository<RFID, Long> {


	//Iterable<RFIDEvent> findByRfid(String rfid);
	
	
}
