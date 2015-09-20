package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.RFIDEventSensorRepository;
import io.pivotal.sensor.dao.RFIDSensorRepository;
import io.pivotal.sensor.dao.UserRepository;
import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.User;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RFIDServiceImpl implements RFIDSensorService {

	private RFIDEventSensorRepository rfidEventRepository;
	private RFIDSensorRepository rfidRepository;
	private UserRepository userRepository;

	@Autowired
	public void setRfidEventRepository(RFIDEventSensorRepository rfidEventRepository) {
		this.rfidEventRepository = rfidEventRepository;
	}

	@Autowired
	public void setRfidRepository(RFIDSensorRepository rfidRepository) {
		this.rfidRepository = rfidRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		// r.setRfidEvents(rs);
//		return returnDummyRfidEvents();
		return rfidEventRepository.findByRfidRfid(rfid);
	}

	@Override
	public Iterable<RFID> findAllRfid() {
//		return getDummyData12();
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

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
//		System.out.println(startTime + " --- " + endTime);
//		return returnDummyRfidEvents();
		return rfidEventRepository.findByRfidRfidAndEventTimeBetween(rfid, startTime, endTime);
	}


//	private List<RFIDEvent> returnDummyRfidEvents() {
//		List<RFIDEvent> rs = new ArrayList<RFIDEvent>();
//		RFID r = new RFID();
//		r.setActive(true);
//		r.setRfid("101010");
//		r.setCreatedTime(new Date(1421160868284l));
//		System.out.println(System.currentTimeMillis());
//		r.setId(1l);
//
//		// e1.setRfid(r);
//		RFIDEvent e1 = new RFIDEvent();
//		e1.setId(1l);
//		e1.setEventTime(new Date(1421160868284l));
//		rs.add(e1);
//		RFIDEvent e5 = new RFIDEvent();
//		e5.setId(2l);
//		e5.setEventTime(new Date(1421160858284l));
//		rs.add(e5);
//		RFIDEvent e4 = new RFIDEvent();
//		e4.setId(3l);
//		e4.setEventTime(new Date(1421160848284l));
//		rs.add(e4);
//		RFIDEvent e3 = new RFIDEvent();
//		e3.setId(4l);
//		e3.setEventTime(new Date(1421160838284l));
//		rs.add(e3);
//		RFIDEvent e = new RFIDEvent();
//		e.setId(5l);
//		e.setEventTime(new Date(1421160828284l));
//		rs.add(e);
//		RFIDEvent e2 = new RFIDEvent();
//		e2.setId(6l);
//		e2.setEventTime(new Date(1421160818284l));
//		rs.add(e2);
//		return rs;
//	}
//	
//	private RFID getDummyData13() {
//		RFID r = new RFID();
//		r.setActive(true);
//		r.setRfid("7101010");
//		r.setCreatedTime(new Date(1421160828284l));
//		r.setId(7l);
//		return r;
//	}
//
//	private Iterable<RFID> getDummyData12() {
//		List<RFID> rs = new ArrayList<RFID>();
//		RFID r1 = new RFID();
//		r1.setActive(false);
//		r1.setRfid("2101010");
//		r1.setCreatedTime(new Date(1421160768284l));
//		r1.setId(2l);
//		rs.add(r1);
//
//		RFID r2 = new RFID();
//		r2.setActive(true);
//		r2.setRfid("3101010");
//		r2.setCreatedTime(new Date(1421160668284l));
//		r2.setId(3l);
//		rs.add(r2);
//
//		RFID r3 = new RFID();
//		r3.setActive(true);
//		r3.setRfid("4101010");
//		r3.setCreatedTime(new Date(1421160568284l));
//		r3.setId(4l);
//		rs.add(r3);
//
//		RFID r4 = new RFID();
//		r4.setActive(true);
//		r4.setRfid("5101010");
//		r4.setCreatedTime(new Date(1421160468284l));
//		r4.setId(5l);
//		rs.add(r4);
//
//		RFID r5 = new RFID();
//		r5.setActive(true);
//		r5.setRfid("6101010");
//		r5.setCreatedTime(new Date(1421160368284l));
//		r5.setId(6l);
//		rs.add(r5);
//
//		RFID r = new RFID();
//		r.setActive(true);
//		r.setRfid("7101010");
//		r.setCreatedTime(new Date(1421160828284l));
//		r.setId(7l);
//		rs.add(r);
//
//		return rs;
//	}
	
}
