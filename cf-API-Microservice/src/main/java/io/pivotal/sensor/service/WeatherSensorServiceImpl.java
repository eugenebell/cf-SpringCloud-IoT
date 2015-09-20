package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.WeatherSensorRepository;
import io.pivotal.sensor.model.Weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

	private WeatherSensorRepository weatherSensorRepository;

	@Autowired
	public void setWeatherSensorRepository(WeatherSensorRepository weatherSensorRepository) {
		this.weatherSensorRepository = weatherSensorRepository;
	}

	@Override
	public List<Weather> findBySensorID(String sensorID) {
//		return getDummyData();
		return weatherSensorRepository.findBySensorID(sensorID);
	}

	@Override
	public List<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
//		return getDummyData();
		return weatherSensorRepository.findBySensorIDAndEventTimeBetween(sensorID, startTime, endTime);
	}

	@Override
	public List<Weather> findWeatherSensorReadingAfterDate(String sensorID, Date time) {
		return weatherSensorRepository.findBySensorIDAndEventTimeIsAfter(sensorID, time);
	}

	@Override
	public List<Weather> findWeatherSensorReadingBeforeDate(String sensorID, Date time) {
//		return getDummyData();
		return weatherSensorRepository.findBySensorIDAndEventTimeIsBefore(sensorID, time);
	}

//	private List<Weather> getDummyData() {
//		List<Weather> ws = new ArrayList<Weather>();
//		Weather w1 = new Weather();
//		w1.setHumidity(15.0);
//		w1.setSensorID("201");
//		w1.setTemperature(23.4);
//		w1.setEventTime(new Date(1421160868284l));
//		ws.add(w1);
//		Weather w = new Weather();
//		w.setHumidity(15.2);
//		w.setSensorID("201");
//		w.setTemperature(23.2);
//		w.setEventTime(new Date(1421160828284l));
//		ws.add(w);
//		return ws;
//	}
}
