package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

@Service
public class TiltSwitchServiceImpl implements TiltSwitchSensorService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TiltSwitchServiceImpl.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;	
	
	private String getURL() {
		InstanceInfo ii = discoveryClient.getNextServerFromEureka("rfid-switch-ms", false);
		LOG.debug("Home Page Url :" + ii.getHomePageUrl());
		LOG.debug("Host Name :" + ii.getHostName());
		LOG.debug("VIP Address :" + ii.getVIPAddress());
		LOG.debug("IP Addr :" + ii.getIPAddr());
		LOG.debug("Port :" + ii.getPort());
		LOG.debug("App Name:" + ii.getAppName());
		LOG.debug("Status Page Url :" + ii.getStatusPageUrl());
		LOG.debug("Secure Port :" + ii.getSecurePort());
		return ii.getHomePageUrl();
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultGetAllTiltSwitches")
	public Iterable<TiltSwitch> getAllTiltSwitches() {
		return restTemplate.getForObject(getURL() + "get-all-tilt-switches", Iterable.class);
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultGetTiltSwitchByTiltSwitchID")
	public TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		return restTemplate.getForObject(getURL() + "get-tilt-switches-by-tiltId/" + tiltSwitchId, TiltSwitch.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultGetAllTiltSwitchEventsByTiltSwitchID")
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId) {
		return restTemplate.getForObject(getURL() + "get-tilt-events-by-tiltId/" + tiltSwitchId, Iterable.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultGetAllTiltSwitchEventsByTiltSwitchIDBetween")
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate) {
		return restTemplate.getForObject(getURL() + "get-all-tilt-events-by-tiltId/" + tiltSwitchId + "/between/" + sdf.format(startDate) + "/" + sdf.format(endDate), Iterable.class);
	}
	
	public Iterable<TiltSwitch> defaultGetAllTiltSwitches() {
        return new ArrayList<>();
    }

	public Iterable<TiltSwitch> defaultGetAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate) {
        return new ArrayList<>();
    }

	public Iterable<TiltSwitch> defaultGetAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId) {
        return new ArrayList<>();
    }
	
	public TiltSwitch defaultGetTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		TiltSwitch ts = new TiltSwitch();
		ts.setId(0L);
		ts.setTiltSwitchId("N/A for " + tiltSwitchId);
		ts.setCreatedTime(new Date());
        return ts;
    }

}
