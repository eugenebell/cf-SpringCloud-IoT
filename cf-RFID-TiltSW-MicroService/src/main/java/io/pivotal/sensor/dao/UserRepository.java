package io.pivotal.sensor.dao;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.sensor.model.User;


public interface UserRepository extends CrudRepository<User, Long> {


	//User findByUseRfidRfid(String rfid);
	
	
}
