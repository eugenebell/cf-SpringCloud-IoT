package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.TiltSwitch;

import org.springframework.data.repository.CrudRepository;


public interface TiltSwitchSensorRepository extends CrudRepository<TiltSwitch, Long> {

	TiltSwitch findByTiltSwitchId(String tiltSwitchId);
	
}
