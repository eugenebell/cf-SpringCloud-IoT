package com.example;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IoTMesageSimulatorApplication implements CommandLineRunner {

	final static String queueName = "arduino-weather-queue";
	final static String queueNameGas = "arduino-gas-smoke-queue";
	private String queueNameRFID = "arduino-rfid-event-queue";
	//@Value ("${rabbit.queue.name.tilt}")
	private String queueNameTilt = "arduino-tilt-event-queue";
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Bean
	Queue queue() {
		return new Queue(queueName, true);
	}
	@Bean
	Queue queueRFID() {
		return new Queue(queueNameRFID, true);
	}
	
	@Bean
	Queue queueTilt() {
		return new Queue(queueNameTilt, true);
	}
	@Bean
	Binding bindingRFID(Queue queueRFID, TopicExchange exchangeRFID) {
		return BindingBuilder.bind(queueRFID).to(exchangeRFID).with("arduino-rfid");
	}
	
	@Bean
	Binding bindingTilt(Queue queueTilt, TopicExchange exchangeTilt) {
		return BindingBuilder.bind(queueTilt).to(exchangeTilt).with("arduino-tilt-exchange");
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("arduino-iot-exchange", true, false);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(IoTMesageSimulatorApplication.class, args);
	}
	/**
	 * Weather:
need-a-sensor-id,21.00,44.00


Tilt switch
need-a-sensor-id,0

RFID
,cb6e5e74
,b3dabaa9
	 */
	@Override
    public void run(String... args) throws Exception {
		for (int i = 0; i < 3; i++) {
	        System.out.println("Waiting one seconds...");
	        Thread.sleep(1000);
	        System.out.println("Sending message...");
	        rabbitTemplate.convertAndSend(queueName, "need-a-sensor-id,21.00,44.00".getBytes());
		}
		Thread.sleep(1000);
		rabbitTemplate.convertAndSend(queueNameTilt, "need-a-sensor-id,0".getBytes());
		Thread.sleep(1000);
		rabbitTemplate.convertAndSend(queueNameRFID, "need-a-sensor-id,cb6e5e74".getBytes());
		Thread.sleep(1000);
		rabbitTemplate.convertAndSend(queueNameRFID, "need-a-sensor-id,b3dabaa9".getBytes());
		Thread.sleep(1000);
		rabbitTemplate.convertAndSend(queueNameTilt, "need-a-sensor-id,1".getBytes());
    }
}
