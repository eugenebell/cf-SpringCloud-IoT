package io.pivotal.sensor.dao;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.sensor.model.TiltSwitch;


public interface TiltSwitchSensorRepository extends CrudRepository<TiltSwitch, Long> {//String> {

	TiltSwitch findByTiltSwitchId(String tiltSwicthId);
	
}
