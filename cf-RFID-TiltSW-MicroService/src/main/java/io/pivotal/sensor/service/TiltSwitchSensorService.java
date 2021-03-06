package io.pivotal.sensor.service;

import java.util.Date;

import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

public interface TiltSwitchSensorService {

	void saveTiltSwitchEvent(TiltSwitchEvent event);
	
	TiltSwitch getTileSwitchByTiltSwitchID(String tiltSwitchId);

	Iterable<TiltSwitch> getAllTiltSwitches();
	
	TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate);

}
