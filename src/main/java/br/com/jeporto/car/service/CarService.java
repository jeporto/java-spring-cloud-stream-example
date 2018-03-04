package br.com.jeporto.car.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeporto.car.api.Car;
import br.com.jeporto.car.kafka.KafkaProducerService;

@Service
public class CarService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);
	
	private KafkaProducerService producerService;
	
	@Autowired
	public CarService(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	public void save(Car car) {
		LOGGER.info("Sending Car to Kafka: {}", car);
		producerService.sendCar(car);
	}


}
