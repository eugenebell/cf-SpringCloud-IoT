package io.pivotal.sensor.service;

import java.util.Date;

import io.pivotal.sensor.dao.GasSmokeSensorRepository;
import io.pivotal.sensor.model.GasSmokeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasSmokeSensorServiceImpl implements GasSmokeSensorService {

	@Autowired
	private GasSmokeSensorRepository repository;

	@Override
	public GasSmokeEvent saveGasSmokeSensorEvent(GasSmokeEvent gasSmokeEvent) {
		return repository.save(gasSmokeEvent);
	}

	@Override
	public Iterable<GasSmokeEvent> findByGasSensorId(String gasSensorId) {
		return repository.findByGasSensorId(gasSensorId);
	}

	@Override
	public Iterable<GasSmokeEvent> findByGasSensorIdAndEventTimeBetween(String gasSensorId, Date startDate, Date endDate) {
		return repository.findByGasSensorIdAndEventTimeBetween(gasSensorId, startDate, endDate);
	}
	
	

}
