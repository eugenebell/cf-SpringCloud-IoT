package io.pivotal.sensor.dao;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.sensor.model.RFID;


public interface RFIDRepository extends CrudRepository<RFID, String> {

	RFID findByRfid(String rfid);
	
}
