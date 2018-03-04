package br.com.jeporto.car.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jeporto.car.api.Car;
import br.com.jeporto.car.kafka.channel.KafkaConsumerChannel;

@EnableBinding(KafkaConsumerChannel.class)
@Service
public class KafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);
	private ObjectMapper jsonMapper;
	
	@Autowired
	public KafkaConsumerService(ObjectMapper jsonMapper) {
		this.jsonMapper = jsonMapper;
	}

	@StreamListener(target = KafkaConsumerChannel.INPUT)
	public void consumeCar(String message) {
		LOGGER.info("Receiving message from Kafka: {}", message);
		try {
			Car car = jsonMapper.readValue(message, Car.class);
			LOGGER.info("Message parsed to Car object: {}", car.toString());
		} catch (Exception e) {
			throw new RuntimeException("Error to parse message to Car object");
		}
	}
}
