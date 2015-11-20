package io.pivotal.sensor.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.pivotal.sensor.model.GasSmokeEvent;

@Service
public class GasSmokeSensorServiceImpl implements GasSmokeSensorService {

//	@Autowired
//	private GasSmokeSensorRepository repository;

	@Override
	public GasSmokeEvent saveGasSmokeSensorEvent(GasSmokeEvent gasSmokeEvent) {
		return null;//repository.save(gasSmokeEvent);
	}

	@Override
	public Iterable<GasSmokeEvent> findByGasSensorId(String gasSensorId) {
		return null;//repository.findByGasSensorId(gasSensorId);
	}

	@Override
	public Iterable<GasSmokeEvent> findByGasSensorIdAndEventTimeBetween(String gasSensorId, Date startDate, Date endDate) {
		return null;//repository.findByGasSensorIdAndEventTimeBetween(gasSensorId, startDate, endDate);
	}
	
	

}
