package io.pivotal.sensor.service;

import java.util.Date;

import io.pivotal.sensor.model.Weather;

public interface WeatherSensorService {

	Weather saveWeatherSensorReading(Weather weather);
//	List<Weather> findBySensorID(String sensorID);
//	Weather findWeatherSensorReading(String sensorID, Date startTime, Date endTime);
//	Weather findWeatherSensorReadingAfterDate(String sensorID, Date time);
//	Weather findWeatherSensorReadingBeforeDate(String sensorID, Date time);
	Iterable<Weather> findBySensorID(String sensorID);
	Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime);
//	List<Weather> findWeatherSensorReadingAfterDate(String sensorID, Date time);
//	List<Weather> findWeatherSensorReadingBeforeDate(String sensorID, Date time);
}
