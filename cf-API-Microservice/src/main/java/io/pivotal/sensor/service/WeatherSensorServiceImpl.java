package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.Weather;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	//TODO Eureka
//	final String uri = "http://climate-microservice.cfapps.io/";
	final String uri = "http://localhost:8889/";

	@Autowired
    RestTemplate restTemplate;	

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindBySensorID")
	public Iterable<Weather> findBySensorID(String sensorID) {
		return restTemplate.getForObject(uri + "get-weather-by-sensorid/" + sensorID, Iterable.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindWeatherSensorReadingBetween")
	public Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
		return restTemplate.getForObject(uri + "get-all-weather-readings-by-sensorid/" + sensorID + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}

	public Iterable<Weather> defaultFindBySensorID(String sensorID) {
		return new ArrayList<Weather>();
    }
	
	public Iterable<Weather> defaultFindWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
        return new ArrayList<Weather>();
    }
}
