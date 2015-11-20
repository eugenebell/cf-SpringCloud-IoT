package io.pivotal.sensor.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.Weather;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

	//private WeatherSensorRepository weatherSensorRepository;

//	@Autowired
//	public void setWeatherSensorRepository(WeatherSensorRepository weatherSensorRepository) {
//		this.weatherSensorRepository = weatherSensorRepository;
//	}
	
	final String uri = "http://climate-microservice.cfapps.io/";
    
    RestTemplate restTemplate = new RestTemplate();
    
	//+"get-weather-by-sensorid/need-a-sensor-id"
	//+"get-all-weather-readings-by-sensorid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z"
	
	@Override
	public Iterable<Weather> findBySensorID(String sensorID) {
		//TODO API REST client
		return restTemplate.getForObject(uri + "get-weather-by-sensorid/" + sensorID, Iterable.class);//weatherSensorRepository.findBySensorID(sensorID);
	}

	@Override
	public Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
		//TODO API REST client
		return restTemplate.getForObject(uri + "get-all-weather-readings-by-sensorid/" + sensorID + "/between/" + startTime + "/" + endTime, Iterable.class);//weatherSensorRepository.findBySensorIDAndEventTimeBetween(sensorID, startTime, endTime);
	}

//	@Override
//	public List<Weather> findWeatherSensorReadingAfterDate(String sensorID, Date time) {
//		//TODO API REST client
//		return restTemplate.getForObject(uri + "get-all-users", (Class<? extends List<Weather>>)List.class);//weatherSensorRepository.findBySensorIDAndEventTimeIsAfter(sensorID, time);
//	}
//
//	@Override
//	public List<Weather> findWeatherSensorReadingBeforeDate(String sensorID, Date time) {
//		//TODO API REST client
//		return restTemplate.getForObject(uri + "get-all-users", (Class<? extends List<Weather>>)List.class);//weatherSensorRepository.findBySensorIDAndEventTimeIsBefore(sensorID, time);
//	}

}
