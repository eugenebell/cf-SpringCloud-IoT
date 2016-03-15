package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.Weather;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	//TODO Eureka
//	final String uri = "http://climate-microservice.cfapps.io/";
	final String uri = "http://localhost:8889/";
	//TODO inject
    RestTemplate restTemplate = new RestTemplate();

	@Override
	public Iterable<Weather> findBySensorID(String sensorID) {
		return restTemplate.getForObject(uri + "get-weather-by-sensorid/" + sensorID, Iterable.class);
	}

	@Override
	public Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
		String s = uri + "get-all-weather-readings-by-sensorid/" + sensorID + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime);
		System.out.println("-------------------------"+s);
		return restTemplate.getForObject(uri + "get-all-weather-readings-by-sensorid/" + sensorID + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}

}
