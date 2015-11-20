package io.pivotal.sensor.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pivotal.sensor.dao.RFIDRepository;
import io.pivotal.sensor.dao.RFIDSensorRepository;
import io.pivotal.sensor.dao.UserRepository;
import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.User;

@Service
public class RFIDServiceImpl implements RFIDSensorService {

	private RFIDRepository rfidRepository;
	private RFIDSensorRepository rfidSensorRepository;
	private UserRepository userRepository;

	@Autowired
	public void setRfidSensorRepository(RFIDSensorRepository rfidSensorRepository) {
		this.rfidSensorRepository = rfidSensorRepository;
	}

	@Autowired
	public void setRfidRepository(RFIDRepository rfidRepository) {
		this.rfidRepository = rfidRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveRFIDEvent(RFIDEvent event) {
		rfidSensorRepository.save(event);
	}

	@Override
	public RFID findByRFID(String rfid) {
		return rfidRepository.findByRfid(rfid);
	}

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		return rfidSensorRepository.findByRfidRfid(rfid);
	}

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
		return rfidSensorRepository.findByRfidRfidAndEventTimeBetween(rfid, startTime, endTime);
	}

	@Override
	public Iterable<RFID> findAllRfid() {
		return rfidRepository.findAll();
	}

	@Override
	public RFID findRFIDByUserId(Long userId) {
		//return getDummyData13();
		User u = userRepository.findOne(userId);
		if (u != null) {
			return u.getRfid();
		} else {
			return null;
		}
	}
	

	
}
