package io.pivotal.sensor.service;

import java.util.Date;

import io.pivotal.sensor.model.Weather;

public interface WeatherSensorService {

	Iterable<Weather> findBySensorID(String sensorID);
	Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime);
//	List<Weather> findWeatherSensorReadingAfterDate(String sensorID, Date time);
//	List<Weather> findWeatherSensorReadingBeforeDate(String sensorID, Date time);
	
}
