package io.pivotal.sensor.service;

import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

import java.util.Date;

public interface TiltSwitchSensorService {

	Iterable<TiltSwitch> getAllTiltSwitches();
	
	TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate);
}
