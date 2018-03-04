package br.com.jeporto.car.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.jeporto.car.api.Car;
import br.com.jeporto.car.kafka.channel.KafkaProducerChannel;

@Service
public class KafkaProducerService {

	private KafkaProducerChannel producerChannel;
	
	@Autowired
	public KafkaProducerService(KafkaProducerChannel producerChannel) {
		this.producerChannel = producerChannel;
	}

	public void sendCar(Car car) {
		Message<Car> message = MessageBuilder.withPayload(car).build();
		producerChannel.output().send(message);
	}
}
