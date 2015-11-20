package io.pivotal.sensor.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

@Service
public class TiltSwitchServiceImpl implements TiltSwitchSensorService {

//	private TiltSwitchEventSensorRepository tiltSwitchEventRepository;
//	private TiltSwitchSensorRepository tiltSwitchSensorRepository;
	
//	@Autowired
//	public void setTiltSwitchEventRepository(TiltSwitchEventSensorRepository tiltSwitchEventRepository) {
//		this.tiltSwitchEventRepository = tiltSwitchEventRepository;
//	}
//
//	@Autowired
//	public void setTiltSwitchSensorRepository(TiltSwitchSensorRepository tiltSwitchSensorRepository) {
//		this.tiltSwitchSensorRepository = tiltSwitchSensorRepository;
//	}
	final String uri = "http://sensors-microservice.cfapps.io/";
    
    RestTemplate restTemplate = new RestTemplate();
    
	//+"get-all-tilt-switches"
	//+"get-tilt-switches-by-tiltId/need-a-sensor-id"
	//+"get-tilt-events-by-tiltId/need-a-sensor-id"
	//+"get-all-tilt-events-by-tiltId/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z"
	
	@Override
	public Iterable<TiltSwitch> getAllTiltSwitches() {
		// return getDummyData3();
		return restTemplate.getForObject(uri + "get-all-tilt-switches", Iterable.class);//tiltSwitchSensorRepository.findAll();
	}

	@Override
	public TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		// return getDummyData2();
		return restTemplate.getForObject(uri + "get-tilt-switches-by-tiltId/" + tiltSwitchId, TiltSwitch.class);//tiltSwitchSensorRepository.findByTiltSwitchId(tiltSwitchId);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId) {
		// return getDummyData();
		return restTemplate.getForObject(uri + "get-tilt-events-by-tiltId/" + tiltSwitchId, Iterable.class);//tiltSwitchEventRepository.findByTiltSwitchTiltSwitchId(tiltSwitchId);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate) {
		// return getDummyData();
		return restTemplate.getForObject(uri + "get-all-tilt-events-by-tiltId/" + tiltSwitchId + "/between/" + startDate + "/" + endDate, Iterable.class);//tiltSwitchEventRepository.findByTiltSwitchTiltSwitchIdAndEventTimeBetween(tiltSwitchId, startDate, endDate);
	}


}
