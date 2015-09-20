package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.TiltSwitchEventSensorRepository;
import io.pivotal.sensor.dao.TiltSwitchSensorRepository;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiltSwitchServiceImpl implements TiltSwitchSensorService {

	private TiltSwitchEventSensorRepository tiltSwitchEventRepository;
	private TiltSwitchSensorRepository tiltSwitchSensorRepository;
	
	@Autowired
	public void setTiltSwitchEventRepository(TiltSwitchEventSensorRepository tiltSwitchEventRepository) {
		this.tiltSwitchEventRepository = tiltSwitchEventRepository;
	}

	@Autowired
	public void setTiltSwitchSensorRepository(TiltSwitchSensorRepository tiltSwitchSensorRepository) {
		this.tiltSwitchSensorRepository = tiltSwitchSensorRepository;
	}

	@Override
	public Iterable<TiltSwitch> getAllTiltSwitches() {
		// return getDummyData3();
		return tiltSwitchSensorRepository.findAll();
	}

	@Override
	public TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		// return getDummyData2();
		return tiltSwitchSensorRepository.findByTiltSwitchId(tiltSwitchId);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(
			String tiltSwitchId) {
		// return getDummyData();
		return tiltSwitchEventRepository.findByTiltSwitchTiltSwitchId(tiltSwitchId);
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate) {
		// return getDummyData();
		return tiltSwitchEventRepository.findByTiltSwitchTiltSwitchIdAndEventTimeBetween(tiltSwitchId, startDate, endDate);
	}

//	private Iterable<TiltSwitch> getDummyData3() {
//		List<TiltSwitch> rs = new ArrayList<TiltSwitch>();
//		TiltSwitch r1 = new TiltSwitch();
//		r1.setTiltSwitchId("332201010");
//		r1.setCreatedTime(new Date(1421160868284l));
//		r1.setId(1l);
//		rs.add(r1);
//
//		TiltSwitch r = new TiltSwitch();
//		r.setTiltSwitchId("101010");
//		r.setCreatedTime(new Date(1421160848284l));
//		r.setId(1l);
//		rs.add(r);
//		return rs;
//	}
//
//	private List<TiltSwitchEvent> getDummyData() {
//		TiltSwitch ts = new TiltSwitch();
//		ts.setTiltSwitchId("332201010");
//		ts.setCreatedTime(new Date(1421160868284l));
//		ts.setId(1l);
//
//		List<TiltSwitchEvent> rs = new ArrayList<TiltSwitchEvent>();
//		TiltSwitchEvent r12 = new TiltSwitchEvent();
//		r12.setOpen(true);
//		r12.setEventTime(new Date(1421160868284l));
//		r12.setId(1l);
//		r12.setTiltSwitch(ts);
//		rs.add(r12);
//		TiltSwitchEvent r13 = new TiltSwitchEvent();
//		r13.setOpen(true);
//		r13.setEventTime(new Date(1421160868284l));
//		r13.setId(1l);
//		r13.setTiltSwitch(ts);
//		rs.add(r13);
//		TiltSwitchEvent r14 = new TiltSwitchEvent();
//		r14.setOpen(true);
//		r14.setEventTime(new Date(1421160868284l));
//		r14.setId(1l);
//		r14.setTiltSwitch(ts);
//		rs.add(r14);
//		TiltSwitchEvent r15 = new TiltSwitchEvent();
//		r15.setOpen(true);
//		r15.setEventTime(new Date(1421160868284l));
//		r15.setId(1l);
//		r15.setTiltSwitch(ts);
//		rs.add(r15);
//		TiltSwitchEvent r16 = new TiltSwitchEvent();
//		r16.setOpen(true);
//		r16.setEventTime(new Date(1421160868284l));
//		r16.setId(1l);
//		r16.setTiltSwitch(ts);
//		rs.add(r16);
//		TiltSwitchEvent r1 = new TiltSwitchEvent();
//		r1.setOpen(true);
//		r1.setEventTime(new Date(1421160868284l));
//		r1.setId(1l);
//		r1.setTiltSwitch(ts);
//		rs.add(r1);
//		return rs;
//	}
//
//	private TiltSwitch getDummyData2() {
//		TiltSwitch r1 = new TiltSwitch();
//		r1.setTiltSwitchId("332201010");
//		r1.setCreatedTime(new Date(1421160868284l));
//		r1.setId(1l);
//		return r1;
//	}

}
