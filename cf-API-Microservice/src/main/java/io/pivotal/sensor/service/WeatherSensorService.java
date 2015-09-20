package io.pivotal.sensor.service;

import io.pivotal.sensor.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherSensorService {

	List<Weather> findBySensorID(String sensorID);
	List<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime);
	List<Weather> findWeatherSensorReadingAfterDate(String sensorID, Date time);
	List<Weather> findWeatherSensorReadingBeforeDate(String sensorID, Date time);
	
}
