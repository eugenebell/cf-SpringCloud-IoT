package io.pivotal.sensor.service;

import io.pivotal.sensor.model.GasSmokeEvent;

import java.util.Date;

public interface GasSmokeSensorService {

	GasSmokeEvent saveGasSmokeSensorEvent(GasSmokeEvent gasSmokeEvent);
	
	Iterable<GasSmokeEvent> findByGasSensorId(String gasSensorId);
	
	Iterable<GasSmokeEvent> findByGasSensorIdAndEventTimeBetween(String gasSensorId, Date startDate, Date endDate);
	
}
