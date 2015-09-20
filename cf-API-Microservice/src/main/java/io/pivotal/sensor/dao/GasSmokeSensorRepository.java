package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.GasSmokeEvent;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GasSmokeSensorRepository extends MongoRepository<GasSmokeEvent, String> {

	Iterable<GasSmokeEvent> findByGasSensorId(String gasSensorId);
	
	Iterable<GasSmokeEvent> findByGasSensorIdAndEventTimeBetween(String gasSensorId, Date startDate, Date endDate);
	
}
