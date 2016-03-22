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

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

@Service
public class RFIDServiceImpl implements RFIDSensorService {

	private static final Logger LOG = LoggerFactory.getLogger(RFIDServiceImpl.class);
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
	@HystrixCommand(fallbackMethod = "defaultFindAllRfidEventsByRfid")
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		return restTemplate.getForObject(getURL() + "get-rfid-events-by-rfid/" + rfid, Iterable.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllRfid")
	public Iterable<RFID> findAllRfid() {
		return restTemplate.getForObject(getURL() + "get-all-rfids", Iterable.class);
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultRFID")
	public RFID findRFIDByUserId(Long userId) {
		return restTemplate.getForObject(getURL() + "get-rfid-by-user/" + userId, RFID.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllRfidEventsByRfidBetween")
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
		return restTemplate.getForObject(getURL() + "get-all-rfid-events-by-rfid/" + rfid + "/between/" + sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}

	public Iterable<RFIDEvent> defaultFindAllRfidEventsByRfid(String rfid) {
		return new ArrayList<>();
	}

	public Iterable<RFIDEvent> defaultFindAllRfidEventsByRfidBetween(String rfid, Date startTime, Date endTime) {
		return new ArrayList<>();
	}

	public Iterable<RFIDEvent> defaultFindAllRfid() {
		return new ArrayList<>();
	}

	public RFID defaultRFID(Long userId) {
		RFID rfid = new RFID();
		rfid.setId(0L);
		rfid.setRfid("N/A for " + userId);
		rfid.setCreatedTime(new Date());
		return rfid;
	}

}
