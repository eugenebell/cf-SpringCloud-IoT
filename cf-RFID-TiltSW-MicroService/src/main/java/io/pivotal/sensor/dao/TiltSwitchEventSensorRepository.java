package io.pivotal.sensor.dao;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.sensor.model.TiltSwitchEvent;


public interface TiltSwitchEventSensorRepository extends CrudRepository<TiltSwitchEvent, Long> {

	
	Iterable<TiltSwitchEvent> findByTiltSwitchTiltSwitchId(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> findByTiltSwitchTiltSwitchIdAndEventTimeBetween(String tiltSwitchId, Date startDate, Date endDate);
	
}
