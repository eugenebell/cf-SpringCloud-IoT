package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.TiltSwitchEvent;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;


public interface TiltSwitchEventSensorRepository extends CrudRepository<TiltSwitchEvent, Long> {

	

	Iterable<TiltSwitchEvent> findByTiltSwitchTiltSwitchId(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> findByTiltSwitchTiltSwitchIdAndEventTimeBetween(String tiltSwitchId, Date startDate, Date endDate);
	
}
