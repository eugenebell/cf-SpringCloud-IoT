package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

@Service
public class TiltSwitchServiceImpl implements TiltSwitchSensorService {
	
	//TODO Eureka
//	final String uri = "http://sensors-microservice.cfapps.io/";
	final String uri = "http://localhost:8888/";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	//TODO inject
    RestTemplate restTemplate = new RestTemplate();

	@Override
	public Iterable<TiltSwitch> getAllTiltSwitches() {
		return restTemplate.getForObject(uri + "get-all-tilt-switches", Iterable.class);
	}

	@Override
	public TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		return restTemplate.getForObject(uri + "get-tilt-switches-by-tiltId/" + tiltSwitchId, TiltSwitch.class);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId) {
		return restTemplate.getForObject(uri + "get-tilt-events-by-tiltId/" + tiltSwitchId, Iterable.class);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate) {
		return restTemplate.getForObject(uri + "get-all-tilt-events-by-tiltId/" + tiltSwitchId + "/between/" + sdf.format(startDate) + "/" + sdf.format(endDate), Iterable.class);
	}

}
